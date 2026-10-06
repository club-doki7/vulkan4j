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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingShaderGroupCreateInfoKHR.html"><code>VkRayTracingShaderGroupCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRayTracingShaderGroupCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRayTracingShaderGroupTypeKHR type; // @link substring="VkRayTracingShaderGroupTypeKHR" target="VkRayTracingShaderGroupTypeKHR" @link substring="type" target="#type"
///     uint32_t generalShader; // @link substring="generalShader" target="#generalShader"
///     uint32_t closestHitShader; // @link substring="closestHitShader" target="#closestHitShader"
///     uint32_t anyHitShader; // @link substring="anyHitShader" target="#anyHitShader"
///     uint32_t intersectionShader; // @link substring="intersectionShader" target="#intersectionShader"
///     void const* pShaderGroupCaptureReplayHandle; // optional // @link substring="pShaderGroupCaptureReplayHandle" target="#pShaderGroupCaptureReplayHandle"
/// } VkRayTracingShaderGroupCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RAY_TRACING_SHADER_GROUP_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkRayTracingShaderGroupCreateInfoKHR#allocate(Arena)}, {@link VkRayTracingShaderGroupCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRayTracingShaderGroupCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingShaderGroupCreateInfoKHR.html"><code>VkRayTracingShaderGroupCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRayTracingShaderGroupCreateInfoKHR(@NotNull MemorySegment segment) implements IVkRayTracingShaderGroupCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRayTracingShaderGroupCreateInfoKHR.html"><code>VkRayTracingShaderGroupCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRayTracingShaderGroupCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRayTracingShaderGroupCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRayTracingShaderGroupCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRayTracingShaderGroupCreateInfoKHR, Iterable<VkRayTracingShaderGroupCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkRayTracingShaderGroupCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRayTracingShaderGroupCreateInfoKHR at(long index) {
            return new VkRayTracingShaderGroupCreateInfoKHR(segment.asSlice(index * VkRayTracingShaderGroupCreateInfoKHR.BYTES, VkRayTracingShaderGroupCreateInfoKHR.BYTES));
        }

        public VkRayTracingShaderGroupCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkRayTracingShaderGroupCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRayTracingShaderGroupCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkRayTracingShaderGroupCreateInfoKHR.BYTES, VkRayTracingShaderGroupCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRayTracingShaderGroupCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRayTracingShaderGroupCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRayTracingShaderGroupCreateInfoKHR.BYTES,
                (end - start) * VkRayTracingShaderGroupCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRayTracingShaderGroupCreateInfoKHR.BYTES));
        }

        public VkRayTracingShaderGroupCreateInfoKHR[] toArray() {
            VkRayTracingShaderGroupCreateInfoKHR[] ret = new VkRayTracingShaderGroupCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRayTracingShaderGroupCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRayTracingShaderGroupCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRayTracingShaderGroupCreateInfoKHR.BYTES;
            }

            @Override
            public VkRayTracingShaderGroupCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRayTracingShaderGroupCreateInfoKHR ret = new VkRayTracingShaderGroupCreateInfoKHR(segment.asSlice(0, VkRayTracingShaderGroupCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkRayTracingShaderGroupCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRayTracingShaderGroupCreateInfoKHR allocate(Arena arena) {
        VkRayTracingShaderGroupCreateInfoKHR ret = new VkRayTracingShaderGroupCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RAY_TRACING_SHADER_GROUP_CREATE_INFO_KHR);
        return ret;
    }

    public static VkRayTracingShaderGroupCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRayTracingShaderGroupCreateInfoKHR.Ptr ret = new VkRayTracingShaderGroupCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RAY_TRACING_SHADER_GROUP_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkRayTracingShaderGroupCreateInfoKHR clone(Arena arena, VkRayTracingShaderGroupCreateInfoKHR src) {
        VkRayTracingShaderGroupCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RAY_TRACING_SHADER_GROUP_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRayTracingShaderGroupCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRayTracingShaderGroupCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRayTracingShaderGroupCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkRayTracingShaderGroupTypeKHR.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkRayTracingShaderGroupCreateInfoKHR type(@EnumType(VkRayTracingShaderGroupTypeKHR.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Unsigned int generalShader() {
        return segment.get(LAYOUT$generalShader, OFFSET$generalShader);
    }

    public VkRayTracingShaderGroupCreateInfoKHR generalShader(@Unsigned int value) {
        segment.set(LAYOUT$generalShader, OFFSET$generalShader, value);
        return this;
    }

    public @Unsigned int closestHitShader() {
        return segment.get(LAYOUT$closestHitShader, OFFSET$closestHitShader);
    }

    public VkRayTracingShaderGroupCreateInfoKHR closestHitShader(@Unsigned int value) {
        segment.set(LAYOUT$closestHitShader, OFFSET$closestHitShader, value);
        return this;
    }

    public @Unsigned int anyHitShader() {
        return segment.get(LAYOUT$anyHitShader, OFFSET$anyHitShader);
    }

    public VkRayTracingShaderGroupCreateInfoKHR anyHitShader(@Unsigned int value) {
        segment.set(LAYOUT$anyHitShader, OFFSET$anyHitShader, value);
        return this;
    }

    public @Unsigned int intersectionShader() {
        return segment.get(LAYOUT$intersectionShader, OFFSET$intersectionShader);
    }

    public VkRayTracingShaderGroupCreateInfoKHR intersectionShader(@Unsigned int value) {
        segment.set(LAYOUT$intersectionShader, OFFSET$intersectionShader, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pShaderGroupCaptureReplayHandle() {
        return segment.get(LAYOUT$pShaderGroupCaptureReplayHandle, OFFSET$pShaderGroupCaptureReplayHandle);
    }

    public VkRayTracingShaderGroupCreateInfoKHR pShaderGroupCaptureReplayHandle(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pShaderGroupCaptureReplayHandle, OFFSET$pShaderGroupCaptureReplayHandle, value);
        return this;
    }

    public VkRayTracingShaderGroupCreateInfoKHR pShaderGroupCaptureReplayHandle(@Nullable IPointer pointer) {
        pShaderGroupCaptureReplayHandle(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("generalShader"),
        ValueLayout.JAVA_INT.withName("closestHitShader"),
        ValueLayout.JAVA_INT.withName("anyHitShader"),
        ValueLayout.JAVA_INT.withName("intersectionShader"),
        ValueLayout.ADDRESS.withName("pShaderGroupCaptureReplayHandle")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$generalShader = PathElement.groupElement("generalShader");
    public static final PathElement PATH$closestHitShader = PathElement.groupElement("closestHitShader");
    public static final PathElement PATH$anyHitShader = PathElement.groupElement("anyHitShader");
    public static final PathElement PATH$intersectionShader = PathElement.groupElement("intersectionShader");
    public static final PathElement PATH$pShaderGroupCaptureReplayHandle = PathElement.groupElement("pShaderGroupCaptureReplayHandle");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$generalShader = (OfInt) LAYOUT.select(PATH$generalShader);
    public static final OfInt LAYOUT$closestHitShader = (OfInt) LAYOUT.select(PATH$closestHitShader);
    public static final OfInt LAYOUT$anyHitShader = (OfInt) LAYOUT.select(PATH$anyHitShader);
    public static final OfInt LAYOUT$intersectionShader = (OfInt) LAYOUT.select(PATH$intersectionShader);
    public static final AddressLayout LAYOUT$pShaderGroupCaptureReplayHandle = (AddressLayout) LAYOUT.select(PATH$pShaderGroupCaptureReplayHandle);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$generalShader = LAYOUT$generalShader.byteSize();
    public static final long SIZE$closestHitShader = LAYOUT$closestHitShader.byteSize();
    public static final long SIZE$anyHitShader = LAYOUT$anyHitShader.byteSize();
    public static final long SIZE$intersectionShader = LAYOUT$intersectionShader.byteSize();
    public static final long SIZE$pShaderGroupCaptureReplayHandle = LAYOUT$pShaderGroupCaptureReplayHandle.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$generalShader = LAYOUT.byteOffset(PATH$generalShader);
    public static final long OFFSET$closestHitShader = LAYOUT.byteOffset(PATH$closestHitShader);
    public static final long OFFSET$anyHitShader = LAYOUT.byteOffset(PATH$anyHitShader);
    public static final long OFFSET$intersectionShader = LAYOUT.byteOffset(PATH$intersectionShader);
    public static final long OFFSET$pShaderGroupCaptureReplayHandle = LAYOUT.byteOffset(PATH$pShaderGroupCaptureReplayHandle);
}
