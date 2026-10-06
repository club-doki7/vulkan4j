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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDependency2.html"><code>VkSubpassDependency2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSubpassDependency2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t srcSubpass; // @link substring="srcSubpass" target="#srcSubpass"
///     uint32_t dstSubpass; // @link substring="dstSubpass" target="#dstSubpass"
///     VkPipelineStageFlags srcStageMask; // optional // @link substring="VkPipelineStageFlags" target="VkPipelineStageFlags" @link substring="srcStageMask" target="#srcStageMask"
///     VkPipelineStageFlags dstStageMask; // optional // @link substring="VkPipelineStageFlags" target="VkPipelineStageFlags" @link substring="dstStageMask" target="#dstStageMask"
///     VkAccessFlags srcAccessMask; // optional // @link substring="VkAccessFlags" target="VkAccessFlags" @link substring="srcAccessMask" target="#srcAccessMask"
///     VkAccessFlags dstAccessMask; // optional // @link substring="VkAccessFlags" target="VkAccessFlags" @link substring="dstAccessMask" target="#dstAccessMask"
///     VkDependencyFlags dependencyFlags; // optional // @link substring="VkDependencyFlags" target="VkDependencyFlags" @link substring="dependencyFlags" target="#dependencyFlags"
///     int32_t viewOffset; // @link substring="viewOffset" target="#viewOffset"
/// } VkSubpassDependency2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SUBPASS_DEPENDENCY_2`
///
/// The {@code allocate} ({@link VkSubpassDependency2#allocate(Arena)}, {@link VkSubpassDependency2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSubpassDependency2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDependency2.html"><code>VkSubpassDependency2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSubpassDependency2(@NotNull MemorySegment segment) implements IVkSubpassDependency2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDependency2.html"><code>VkSubpassDependency2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSubpassDependency2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSubpassDependency2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSubpassDependency2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSubpassDependency2, Iterable<VkSubpassDependency2> {
        public long size() {
            return segment.byteSize() / VkSubpassDependency2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSubpassDependency2 at(long index) {
            return new VkSubpassDependency2(segment.asSlice(index * VkSubpassDependency2.BYTES, VkSubpassDependency2.BYTES));
        }

        public VkSubpassDependency2.Ptr at(long index, @NotNull Consumer<@NotNull VkSubpassDependency2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSubpassDependency2 value) {
            MemorySegment s = segment.asSlice(index * VkSubpassDependency2.BYTES, VkSubpassDependency2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSubpassDependency2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSubpassDependency2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSubpassDependency2.BYTES,
                (end - start) * VkSubpassDependency2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSubpassDependency2.BYTES));
        }

        public VkSubpassDependency2[] toArray() {
            VkSubpassDependency2[] ret = new VkSubpassDependency2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSubpassDependency2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSubpassDependency2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSubpassDependency2.BYTES;
            }

            @Override
            public VkSubpassDependency2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSubpassDependency2 ret = new VkSubpassDependency2(segment.asSlice(0, VkSubpassDependency2.BYTES));
                segment = segment.asSlice(VkSubpassDependency2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSubpassDependency2 allocate(Arena arena) {
        VkSubpassDependency2 ret = new VkSubpassDependency2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SUBPASS_DEPENDENCY_2);
        return ret;
    }

    public static VkSubpassDependency2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSubpassDependency2.Ptr ret = new VkSubpassDependency2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SUBPASS_DEPENDENCY_2);
        }
        return ret;
    }

    public static VkSubpassDependency2 clone(Arena arena, VkSubpassDependency2 src) {
        VkSubpassDependency2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SUBPASS_DEPENDENCY_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSubpassDependency2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSubpassDependency2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSubpassDependency2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int srcSubpass() {
        return segment.get(LAYOUT$srcSubpass, OFFSET$srcSubpass);
    }

    public VkSubpassDependency2 srcSubpass(@Unsigned int value) {
        segment.set(LAYOUT$srcSubpass, OFFSET$srcSubpass, value);
        return this;
    }

    public @Unsigned int dstSubpass() {
        return segment.get(LAYOUT$dstSubpass, OFFSET$dstSubpass);
    }

    public VkSubpassDependency2 dstSubpass(@Unsigned int value) {
        segment.set(LAYOUT$dstSubpass, OFFSET$dstSubpass, value);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags.class) int srcStageMask() {
        return segment.get(LAYOUT$srcStageMask, OFFSET$srcStageMask);
    }

    public VkSubpassDependency2 srcStageMask(@Bitmask(VkPipelineStageFlags.class) int value) {
        segment.set(LAYOUT$srcStageMask, OFFSET$srcStageMask, value);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags.class) int dstStageMask() {
        return segment.get(LAYOUT$dstStageMask, OFFSET$dstStageMask);
    }

    public VkSubpassDependency2 dstStageMask(@Bitmask(VkPipelineStageFlags.class) int value) {
        segment.set(LAYOUT$dstStageMask, OFFSET$dstStageMask, value);
        return this;
    }

    public @Bitmask(VkAccessFlags.class) int srcAccessMask() {
        return segment.get(LAYOUT$srcAccessMask, OFFSET$srcAccessMask);
    }

    public VkSubpassDependency2 srcAccessMask(@Bitmask(VkAccessFlags.class) int value) {
        segment.set(LAYOUT$srcAccessMask, OFFSET$srcAccessMask, value);
        return this;
    }

    public @Bitmask(VkAccessFlags.class) int dstAccessMask() {
        return segment.get(LAYOUT$dstAccessMask, OFFSET$dstAccessMask);
    }

    public VkSubpassDependency2 dstAccessMask(@Bitmask(VkAccessFlags.class) int value) {
        segment.set(LAYOUT$dstAccessMask, OFFSET$dstAccessMask, value);
        return this;
    }

    public @Bitmask(VkDependencyFlags.class) int dependencyFlags() {
        return segment.get(LAYOUT$dependencyFlags, OFFSET$dependencyFlags);
    }

    public VkSubpassDependency2 dependencyFlags(@Bitmask(VkDependencyFlags.class) int value) {
        segment.set(LAYOUT$dependencyFlags, OFFSET$dependencyFlags, value);
        return this;
    }

    public int viewOffset() {
        return segment.get(LAYOUT$viewOffset, OFFSET$viewOffset);
    }

    public VkSubpassDependency2 viewOffset(int value) {
        segment.set(LAYOUT$viewOffset, OFFSET$viewOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("srcSubpass"),
        ValueLayout.JAVA_INT.withName("dstSubpass"),
        ValueLayout.JAVA_INT.withName("srcStageMask"),
        ValueLayout.JAVA_INT.withName("dstStageMask"),
        ValueLayout.JAVA_INT.withName("srcAccessMask"),
        ValueLayout.JAVA_INT.withName("dstAccessMask"),
        ValueLayout.JAVA_INT.withName("dependencyFlags"),
        ValueLayout.JAVA_INT.withName("viewOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcSubpass = PathElement.groupElement("srcSubpass");
    public static final PathElement PATH$dstSubpass = PathElement.groupElement("dstSubpass");
    public static final PathElement PATH$srcStageMask = PathElement.groupElement("srcStageMask");
    public static final PathElement PATH$dstStageMask = PathElement.groupElement("dstStageMask");
    public static final PathElement PATH$srcAccessMask = PathElement.groupElement("srcAccessMask");
    public static final PathElement PATH$dstAccessMask = PathElement.groupElement("dstAccessMask");
    public static final PathElement PATH$dependencyFlags = PathElement.groupElement("dependencyFlags");
    public static final PathElement PATH$viewOffset = PathElement.groupElement("viewOffset");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$srcSubpass = (OfInt) LAYOUT.select(PATH$srcSubpass);
    public static final OfInt LAYOUT$dstSubpass = (OfInt) LAYOUT.select(PATH$dstSubpass);
    public static final OfInt LAYOUT$srcStageMask = (OfInt) LAYOUT.select(PATH$srcStageMask);
    public static final OfInt LAYOUT$dstStageMask = (OfInt) LAYOUT.select(PATH$dstStageMask);
    public static final OfInt LAYOUT$srcAccessMask = (OfInt) LAYOUT.select(PATH$srcAccessMask);
    public static final OfInt LAYOUT$dstAccessMask = (OfInt) LAYOUT.select(PATH$dstAccessMask);
    public static final OfInt LAYOUT$dependencyFlags = (OfInt) LAYOUT.select(PATH$dependencyFlags);
    public static final OfInt LAYOUT$viewOffset = (OfInt) LAYOUT.select(PATH$viewOffset);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcSubpass = LAYOUT$srcSubpass.byteSize();
    public static final long SIZE$dstSubpass = LAYOUT$dstSubpass.byteSize();
    public static final long SIZE$srcStageMask = LAYOUT$srcStageMask.byteSize();
    public static final long SIZE$dstStageMask = LAYOUT$dstStageMask.byteSize();
    public static final long SIZE$srcAccessMask = LAYOUT$srcAccessMask.byteSize();
    public static final long SIZE$dstAccessMask = LAYOUT$dstAccessMask.byteSize();
    public static final long SIZE$dependencyFlags = LAYOUT$dependencyFlags.byteSize();
    public static final long SIZE$viewOffset = LAYOUT$viewOffset.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcSubpass = LAYOUT.byteOffset(PATH$srcSubpass);
    public static final long OFFSET$dstSubpass = LAYOUT.byteOffset(PATH$dstSubpass);
    public static final long OFFSET$srcStageMask = LAYOUT.byteOffset(PATH$srcStageMask);
    public static final long OFFSET$dstStageMask = LAYOUT.byteOffset(PATH$dstStageMask);
    public static final long OFFSET$srcAccessMask = LAYOUT.byteOffset(PATH$srcAccessMask);
    public static final long OFFSET$dstAccessMask = LAYOUT.byteOffset(PATH$dstAccessMask);
    public static final long OFFSET$dependencyFlags = LAYOUT.byteOffset(PATH$dependencyFlags);
    public static final long OFFSET$viewOffset = LAYOUT.byteOffset(PATH$viewOffset);
}
