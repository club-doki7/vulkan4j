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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceImageSubresourceInfo.html"><code>VkDeviceImageSubresourceInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceImageSubresourceInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImageCreateInfo const* pCreateInfo; // @link substring="VkImageCreateInfo" target="VkImageCreateInfo" @link substring="pCreateInfo" target="#pCreateInfo"
///     VkImageSubresource2 const* pSubresource; // @link substring="VkImageSubresource2" target="VkImageSubresource2" @link substring="pSubresource" target="#pSubresource"
/// } VkDeviceImageSubresourceInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_IMAGE_SUBRESOURCE_INFO`
///
/// The {@code allocate} ({@link VkDeviceImageSubresourceInfo#allocate(Arena)}, {@link VkDeviceImageSubresourceInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceImageSubresourceInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceImageSubresourceInfo.html"><code>VkDeviceImageSubresourceInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceImageSubresourceInfo(@NotNull MemorySegment segment) implements IVkDeviceImageSubresourceInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceImageSubresourceInfo.html"><code>VkDeviceImageSubresourceInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceImageSubresourceInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceImageSubresourceInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceImageSubresourceInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceImageSubresourceInfo, Iterable<VkDeviceImageSubresourceInfo> {
        public long size() {
            return segment.byteSize() / VkDeviceImageSubresourceInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceImageSubresourceInfo at(long index) {
            return new VkDeviceImageSubresourceInfo(segment.asSlice(index * VkDeviceImageSubresourceInfo.BYTES, VkDeviceImageSubresourceInfo.BYTES));
        }

        public VkDeviceImageSubresourceInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceImageSubresourceInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceImageSubresourceInfo value) {
            MemorySegment s = segment.asSlice(index * VkDeviceImageSubresourceInfo.BYTES, VkDeviceImageSubresourceInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceImageSubresourceInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceImageSubresourceInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceImageSubresourceInfo.BYTES,
                (end - start) * VkDeviceImageSubresourceInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceImageSubresourceInfo.BYTES));
        }

        public VkDeviceImageSubresourceInfo[] toArray() {
            VkDeviceImageSubresourceInfo[] ret = new VkDeviceImageSubresourceInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceImageSubresourceInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceImageSubresourceInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceImageSubresourceInfo.BYTES;
            }

            @Override
            public VkDeviceImageSubresourceInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceImageSubresourceInfo ret = new VkDeviceImageSubresourceInfo(segment.asSlice(0, VkDeviceImageSubresourceInfo.BYTES));
                segment = segment.asSlice(VkDeviceImageSubresourceInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceImageSubresourceInfo allocate(Arena arena) {
        VkDeviceImageSubresourceInfo ret = new VkDeviceImageSubresourceInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_IMAGE_SUBRESOURCE_INFO);
        return ret;
    }

    public static VkDeviceImageSubresourceInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceImageSubresourceInfo.Ptr ret = new VkDeviceImageSubresourceInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_IMAGE_SUBRESOURCE_INFO);
        }
        return ret;
    }

    public static VkDeviceImageSubresourceInfo clone(Arena arena, VkDeviceImageSubresourceInfo src) {
        VkDeviceImageSubresourceInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_IMAGE_SUBRESOURCE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceImageSubresourceInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceImageSubresourceInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceImageSubresourceInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkDeviceImageSubresourceInfo pCreateInfo(@Nullable IVkImageCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCreateInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkImageCreateInfo.Ptr pCreateInfo(int assumedCount) {
        MemorySegment s = pCreateInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkImageCreateInfo.BYTES);
        return new VkImageCreateInfo.Ptr(s);
    }

    public @Nullable VkImageCreateInfo pCreateInfo() {
        MemorySegment s = pCreateInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageCreateInfo(s);
    }

    public @Pointer(target=VkImageCreateInfo.class) @NotNull MemorySegment pCreateInfoRaw() {
        return segment.get(LAYOUT$pCreateInfo, OFFSET$pCreateInfo);
    }

    public void pCreateInfoRaw(@Pointer(target=VkImageCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCreateInfo, OFFSET$pCreateInfo, value);
    }

    public VkDeviceImageSubresourceInfo pSubresource(@Nullable IVkImageSubresource2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSubresourceRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkImageSubresource2.Ptr pSubresource(int assumedCount) {
        MemorySegment s = pSubresourceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkImageSubresource2.BYTES);
        return new VkImageSubresource2.Ptr(s);
    }

    public @Nullable VkImageSubresource2 pSubresource() {
        MemorySegment s = pSubresourceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageSubresource2(s);
    }

    public @Pointer(target=VkImageSubresource2.class) @NotNull MemorySegment pSubresourceRaw() {
        return segment.get(LAYOUT$pSubresource, OFFSET$pSubresource);
    }

    public void pSubresourceRaw(@Pointer(target=VkImageSubresource2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSubresource, OFFSET$pSubresource, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(VkImageCreateInfo.LAYOUT).withName("pCreateInfo"),
        ValueLayout.ADDRESS.withTargetLayout(VkImageSubresource2.LAYOUT).withName("pSubresource")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pCreateInfo = PathElement.groupElement("pCreateInfo");
    public static final PathElement PATH$pSubresource = PathElement.groupElement("pSubresource");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pCreateInfo = (AddressLayout) LAYOUT.select(PATH$pCreateInfo);
    public static final AddressLayout LAYOUT$pSubresource = (AddressLayout) LAYOUT.select(PATH$pSubresource);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pCreateInfo = LAYOUT$pCreateInfo.byteSize();
    public static final long SIZE$pSubresource = LAYOUT$pSubresource.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pCreateInfo = LAYOUT.byteOffset(PATH$pCreateInfo);
    public static final long OFFSET$pSubresource = LAYOUT.byteOffset(PATH$pSubresource);
}
