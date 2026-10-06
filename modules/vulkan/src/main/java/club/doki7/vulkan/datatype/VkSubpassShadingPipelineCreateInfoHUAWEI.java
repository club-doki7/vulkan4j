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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassShadingPipelineCreateInfoHUAWEI.html"><code>VkSubpassShadingPipelineCreateInfoHUAWEI</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSubpassShadingPipelineCreateInfoHUAWEI {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRenderPass renderPass; // @link substring="VkRenderPass" target="VkRenderPass" @link substring="renderPass" target="#renderPass"
///     uint32_t subpass; // @link substring="subpass" target="#subpass"
/// } VkSubpassShadingPipelineCreateInfoHUAWEI;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SUBPASS_SHADING_PIPELINE_CREATE_INFO_HUAWEI`
///
/// The {@code allocate} ({@link VkSubpassShadingPipelineCreateInfoHUAWEI#allocate(Arena)}, {@link VkSubpassShadingPipelineCreateInfoHUAWEI#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSubpassShadingPipelineCreateInfoHUAWEI#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassShadingPipelineCreateInfoHUAWEI.html"><code>VkSubpassShadingPipelineCreateInfoHUAWEI</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSubpassShadingPipelineCreateInfoHUAWEI(@NotNull MemorySegment segment) implements IVkSubpassShadingPipelineCreateInfoHUAWEI {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassShadingPipelineCreateInfoHUAWEI.html"><code>VkSubpassShadingPipelineCreateInfoHUAWEI</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSubpassShadingPipelineCreateInfoHUAWEI}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSubpassShadingPipelineCreateInfoHUAWEI to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSubpassShadingPipelineCreateInfoHUAWEI.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSubpassShadingPipelineCreateInfoHUAWEI, Iterable<VkSubpassShadingPipelineCreateInfoHUAWEI> {
        public long size() {
            return segment.byteSize() / VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSubpassShadingPipelineCreateInfoHUAWEI at(long index) {
            return new VkSubpassShadingPipelineCreateInfoHUAWEI(segment.asSlice(index * VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES, VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES));
        }

        public VkSubpassShadingPipelineCreateInfoHUAWEI.Ptr at(long index, @NotNull Consumer<@NotNull VkSubpassShadingPipelineCreateInfoHUAWEI> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSubpassShadingPipelineCreateInfoHUAWEI value) {
            MemorySegment s = segment.asSlice(index * VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES, VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES,
                (end - start) * VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES));
        }

        public VkSubpassShadingPipelineCreateInfoHUAWEI[] toArray() {
            VkSubpassShadingPipelineCreateInfoHUAWEI[] ret = new VkSubpassShadingPipelineCreateInfoHUAWEI[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSubpassShadingPipelineCreateInfoHUAWEI> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSubpassShadingPipelineCreateInfoHUAWEI> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES;
            }

            @Override
            public VkSubpassShadingPipelineCreateInfoHUAWEI next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSubpassShadingPipelineCreateInfoHUAWEI ret = new VkSubpassShadingPipelineCreateInfoHUAWEI(segment.asSlice(0, VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES));
                segment = segment.asSlice(VkSubpassShadingPipelineCreateInfoHUAWEI.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSubpassShadingPipelineCreateInfoHUAWEI allocate(Arena arena) {
        VkSubpassShadingPipelineCreateInfoHUAWEI ret = new VkSubpassShadingPipelineCreateInfoHUAWEI(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SUBPASS_SHADING_PIPELINE_CREATE_INFO_HUAWEI);
        return ret;
    }

    public static VkSubpassShadingPipelineCreateInfoHUAWEI.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSubpassShadingPipelineCreateInfoHUAWEI.Ptr ret = new VkSubpassShadingPipelineCreateInfoHUAWEI.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SUBPASS_SHADING_PIPELINE_CREATE_INFO_HUAWEI);
        }
        return ret;
    }

    public static VkSubpassShadingPipelineCreateInfoHUAWEI clone(Arena arena, VkSubpassShadingPipelineCreateInfoHUAWEI src) {
        VkSubpassShadingPipelineCreateInfoHUAWEI ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SUBPASS_SHADING_PIPELINE_CREATE_INFO_HUAWEI);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSubpassShadingPipelineCreateInfoHUAWEI sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSubpassShadingPipelineCreateInfoHUAWEI pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSubpassShadingPipelineCreateInfoHUAWEI pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkRenderPass renderPass() {
        MemorySegment s = segment.asSlice(OFFSET$renderPass, SIZE$renderPass);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderPass(s);
    }

    public VkSubpassShadingPipelineCreateInfoHUAWEI renderPass(@Nullable VkRenderPass value) {
        segment.set(LAYOUT$renderPass, OFFSET$renderPass, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int subpass() {
        return segment.get(LAYOUT$subpass, OFFSET$subpass);
    }

    public VkSubpassShadingPipelineCreateInfoHUAWEI subpass(@Unsigned int value) {
        segment.set(LAYOUT$subpass, OFFSET$subpass, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("renderPass"),
        ValueLayout.JAVA_INT.withName("subpass")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$renderPass = PathElement.groupElement("renderPass");
    public static final PathElement PATH$subpass = PathElement.groupElement("subpass");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$renderPass = (AddressLayout) LAYOUT.select(PATH$renderPass);
    public static final OfInt LAYOUT$subpass = (OfInt) LAYOUT.select(PATH$subpass);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$renderPass = LAYOUT$renderPass.byteSize();
    public static final long SIZE$subpass = LAYOUT$subpass.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$renderPass = LAYOUT.byteOffset(PATH$renderPass);
    public static final long OFFSET$subpass = LAYOUT.byteOffset(PATH$subpass);
}
