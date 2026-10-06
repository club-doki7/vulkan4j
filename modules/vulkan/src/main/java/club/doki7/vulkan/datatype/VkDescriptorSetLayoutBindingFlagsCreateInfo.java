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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetLayoutBindingFlagsCreateInfo.html"><code>VkDescriptorSetLayoutBindingFlagsCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorSetLayoutBindingFlagsCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t bindingCount; // optional // @link substring="bindingCount" target="#bindingCount"
///     VkDescriptorBindingFlags const* pBindingFlags; // optional // @link substring="VkDescriptorBindingFlags" target="VkDescriptorBindingFlags" @link substring="pBindingFlags" target="#pBindingFlags"
/// } VkDescriptorSetLayoutBindingFlagsCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO`
///
/// The {@code allocate} ({@link VkDescriptorSetLayoutBindingFlagsCreateInfo#allocate(Arena)}, {@link VkDescriptorSetLayoutBindingFlagsCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDescriptorSetLayoutBindingFlagsCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetLayoutBindingFlagsCreateInfo.html"><code>VkDescriptorSetLayoutBindingFlagsCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorSetLayoutBindingFlagsCreateInfo(@NotNull MemorySegment segment) implements IVkDescriptorSetLayoutBindingFlagsCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetLayoutBindingFlagsCreateInfo.html"><code>VkDescriptorSetLayoutBindingFlagsCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorSetLayoutBindingFlagsCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorSetLayoutBindingFlagsCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorSetLayoutBindingFlagsCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorSetLayoutBindingFlagsCreateInfo, Iterable<VkDescriptorSetLayoutBindingFlagsCreateInfo> {
        public long size() {
            return segment.byteSize() / VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorSetLayoutBindingFlagsCreateInfo at(long index) {
            return new VkDescriptorSetLayoutBindingFlagsCreateInfo(segment.asSlice(index * VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES, VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES));
        }

        public VkDescriptorSetLayoutBindingFlagsCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorSetLayoutBindingFlagsCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorSetLayoutBindingFlagsCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES, VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES,
                (end - start) * VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES));
        }

        public VkDescriptorSetLayoutBindingFlagsCreateInfo[] toArray() {
            VkDescriptorSetLayoutBindingFlagsCreateInfo[] ret = new VkDescriptorSetLayoutBindingFlagsCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorSetLayoutBindingFlagsCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorSetLayoutBindingFlagsCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES;
            }

            @Override
            public VkDescriptorSetLayoutBindingFlagsCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorSetLayoutBindingFlagsCreateInfo ret = new VkDescriptorSetLayoutBindingFlagsCreateInfo(segment.asSlice(0, VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES));
                segment = segment.asSlice(VkDescriptorSetLayoutBindingFlagsCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorSetLayoutBindingFlagsCreateInfo allocate(Arena arena) {
        VkDescriptorSetLayoutBindingFlagsCreateInfo ret = new VkDescriptorSetLayoutBindingFlagsCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO);
        return ret;
    }

    public static VkDescriptorSetLayoutBindingFlagsCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDescriptorSetLayoutBindingFlagsCreateInfo.Ptr ret = new VkDescriptorSetLayoutBindingFlagsCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO);
        }
        return ret;
    }

    public static VkDescriptorSetLayoutBindingFlagsCreateInfo clone(Arena arena, VkDescriptorSetLayoutBindingFlagsCreateInfo src) {
        VkDescriptorSetLayoutBindingFlagsCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDescriptorSetLayoutBindingFlagsCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDescriptorSetLayoutBindingFlagsCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDescriptorSetLayoutBindingFlagsCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int bindingCount() {
        return segment.get(LAYOUT$bindingCount, OFFSET$bindingCount);
    }

    public VkDescriptorSetLayoutBindingFlagsCreateInfo bindingCount(@Unsigned int value) {
        segment.set(LAYOUT$bindingCount, OFFSET$bindingCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @Bitmask(VkDescriptorBindingFlags.class) IntPtr pBindingFlags() {
        MemorySegment s = pBindingFlagsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkDescriptorSetLayoutBindingFlagsCreateInfo pBindingFlags(@Nullable @Bitmask(VkDescriptorBindingFlags.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBindingFlagsRaw(s);
        return this;
    }

    public @Pointer(target=VkDescriptorBindingFlags.class) @NotNull MemorySegment pBindingFlagsRaw() {
        return segment.get(LAYOUT$pBindingFlags, OFFSET$pBindingFlags);
    }

    public void pBindingFlagsRaw(@Pointer(target=VkDescriptorBindingFlags.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBindingFlags, OFFSET$pBindingFlags, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("bindingCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pBindingFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$bindingCount = PathElement.groupElement("bindingCount");
    public static final PathElement PATH$pBindingFlags = PathElement.groupElement("pBindingFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$bindingCount = (OfInt) LAYOUT.select(PATH$bindingCount);
    public static final AddressLayout LAYOUT$pBindingFlags = (AddressLayout) LAYOUT.select(PATH$pBindingFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$bindingCount = LAYOUT$bindingCount.byteSize();
    public static final long SIZE$pBindingFlags = LAYOUT$pBindingFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$bindingCount = LAYOUT.byteOffset(PATH$bindingCount);
    public static final long OFFSET$pBindingFlags = LAYOUT.byteOffset(PATH$pBindingFlags);
}
