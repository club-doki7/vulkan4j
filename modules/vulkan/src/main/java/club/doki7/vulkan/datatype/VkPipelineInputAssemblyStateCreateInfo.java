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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineInputAssemblyStateCreateInfo.html"><code>VkPipelineInputAssemblyStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineInputAssemblyStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineInputAssemblyStateCreateFlags flags; // optional // @link substring="VkPipelineInputAssemblyStateCreateFlags" target="VkPipelineInputAssemblyStateCreateFlags" @link substring="flags" target="#flags"
///     VkPrimitiveTopology topology; // @link substring="VkPrimitiveTopology" target="VkPrimitiveTopology" @link substring="topology" target="#topology"
///     VkBool32 primitiveRestartEnable; // @link substring="primitiveRestartEnable" target="#primitiveRestartEnable"
/// } VkPipelineInputAssemblyStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineInputAssemblyStateCreateInfo#allocate(Arena)}, {@link VkPipelineInputAssemblyStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineInputAssemblyStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineInputAssemblyStateCreateInfo.html"><code>VkPipelineInputAssemblyStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineInputAssemblyStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineInputAssemblyStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineInputAssemblyStateCreateInfo.html"><code>VkPipelineInputAssemblyStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineInputAssemblyStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineInputAssemblyStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineInputAssemblyStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineInputAssemblyStateCreateInfo, Iterable<VkPipelineInputAssemblyStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineInputAssemblyStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineInputAssemblyStateCreateInfo at(long index) {
            return new VkPipelineInputAssemblyStateCreateInfo(segment.asSlice(index * VkPipelineInputAssemblyStateCreateInfo.BYTES, VkPipelineInputAssemblyStateCreateInfo.BYTES));
        }

        public VkPipelineInputAssemblyStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineInputAssemblyStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineInputAssemblyStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineInputAssemblyStateCreateInfo.BYTES, VkPipelineInputAssemblyStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineInputAssemblyStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineInputAssemblyStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineInputAssemblyStateCreateInfo.BYTES,
                (end - start) * VkPipelineInputAssemblyStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineInputAssemblyStateCreateInfo.BYTES));
        }

        public VkPipelineInputAssemblyStateCreateInfo[] toArray() {
            VkPipelineInputAssemblyStateCreateInfo[] ret = new VkPipelineInputAssemblyStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineInputAssemblyStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineInputAssemblyStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineInputAssemblyStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineInputAssemblyStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineInputAssemblyStateCreateInfo ret = new VkPipelineInputAssemblyStateCreateInfo(segment.asSlice(0, VkPipelineInputAssemblyStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineInputAssemblyStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineInputAssemblyStateCreateInfo allocate(Arena arena) {
        VkPipelineInputAssemblyStateCreateInfo ret = new VkPipelineInputAssemblyStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineInputAssemblyStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineInputAssemblyStateCreateInfo.Ptr ret = new VkPipelineInputAssemblyStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineInputAssemblyStateCreateInfo clone(Arena arena, VkPipelineInputAssemblyStateCreateInfo src) {
        VkPipelineInputAssemblyStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineInputAssemblyStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineInputAssemblyStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineInputAssemblyStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineInputAssemblyStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineInputAssemblyStateCreateInfo flags(@Bitmask(VkPipelineInputAssemblyStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkPrimitiveTopology.class) int topology() {
        return segment.get(LAYOUT$topology, OFFSET$topology);
    }

    public VkPipelineInputAssemblyStateCreateInfo topology(@EnumType(VkPrimitiveTopology.class) int value) {
        segment.set(LAYOUT$topology, OFFSET$topology, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int primitiveRestartEnable() {
        return segment.get(LAYOUT$primitiveRestartEnable, OFFSET$primitiveRestartEnable);
    }

    public VkPipelineInputAssemblyStateCreateInfo primitiveRestartEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$primitiveRestartEnable, OFFSET$primitiveRestartEnable, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("topology"),
        ValueLayout.JAVA_INT.withName("primitiveRestartEnable")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$topology = PathElement.groupElement("topology");
    public static final PathElement PATH$primitiveRestartEnable = PathElement.groupElement("primitiveRestartEnable");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$topology = (OfInt) LAYOUT.select(PATH$topology);
    public static final OfInt LAYOUT$primitiveRestartEnable = (OfInt) LAYOUT.select(PATH$primitiveRestartEnable);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$topology = LAYOUT$topology.byteSize();
    public static final long SIZE$primitiveRestartEnable = LAYOUT$primitiveRestartEnable.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$topology = LAYOUT.byteOffset(PATH$topology);
    public static final long OFFSET$primitiveRestartEnable = LAYOUT.byteOffset(PATH$primitiveRestartEnable);
}
