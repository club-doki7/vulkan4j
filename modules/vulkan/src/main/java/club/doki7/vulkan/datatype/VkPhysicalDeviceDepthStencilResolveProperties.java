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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDepthStencilResolveProperties.html"><code>VkPhysicalDeviceDepthStencilResolveProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDepthStencilResolveProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkResolveModeFlags supportedDepthResolveModes; // @link substring="VkResolveModeFlags" target="VkResolveModeFlags" @link substring="supportedDepthResolveModes" target="#supportedDepthResolveModes"
///     VkResolveModeFlags supportedStencilResolveModes; // @link substring="VkResolveModeFlags" target="VkResolveModeFlags" @link substring="supportedStencilResolveModes" target="#supportedStencilResolveModes"
///     VkBool32 independentResolveNone; // @link substring="independentResolveNone" target="#independentResolveNone"
///     VkBool32 independentResolve; // @link substring="independentResolve" target="#independentResolve"
/// } VkPhysicalDeviceDepthStencilResolveProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDepthStencilResolveProperties#allocate(Arena)}, {@link VkPhysicalDeviceDepthStencilResolveProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDepthStencilResolveProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDepthStencilResolveProperties.html"><code>VkPhysicalDeviceDepthStencilResolveProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDepthStencilResolveProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDepthStencilResolveProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDepthStencilResolveProperties.html"><code>VkPhysicalDeviceDepthStencilResolveProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDepthStencilResolveProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDepthStencilResolveProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDepthStencilResolveProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDepthStencilResolveProperties, Iterable<VkPhysicalDeviceDepthStencilResolveProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDepthStencilResolveProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDepthStencilResolveProperties at(long index) {
            return new VkPhysicalDeviceDepthStencilResolveProperties(segment.asSlice(index * VkPhysicalDeviceDepthStencilResolveProperties.BYTES, VkPhysicalDeviceDepthStencilResolveProperties.BYTES));
        }

        public VkPhysicalDeviceDepthStencilResolveProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDepthStencilResolveProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDepthStencilResolveProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDepthStencilResolveProperties.BYTES, VkPhysicalDeviceDepthStencilResolveProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDepthStencilResolveProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDepthStencilResolveProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDepthStencilResolveProperties.BYTES,
                (end - start) * VkPhysicalDeviceDepthStencilResolveProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDepthStencilResolveProperties.BYTES));
        }

        public VkPhysicalDeviceDepthStencilResolveProperties[] toArray() {
            VkPhysicalDeviceDepthStencilResolveProperties[] ret = new VkPhysicalDeviceDepthStencilResolveProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDepthStencilResolveProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDepthStencilResolveProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDepthStencilResolveProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceDepthStencilResolveProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDepthStencilResolveProperties ret = new VkPhysicalDeviceDepthStencilResolveProperties(segment.asSlice(0, VkPhysicalDeviceDepthStencilResolveProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDepthStencilResolveProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDepthStencilResolveProperties allocate(Arena arena) {
        VkPhysicalDeviceDepthStencilResolveProperties ret = new VkPhysicalDeviceDepthStencilResolveProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceDepthStencilResolveProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDepthStencilResolveProperties.Ptr ret = new VkPhysicalDeviceDepthStencilResolveProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceDepthStencilResolveProperties clone(Arena arena, VkPhysicalDeviceDepthStencilResolveProperties src) {
        VkPhysicalDeviceDepthStencilResolveProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDepthStencilResolveProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDepthStencilResolveProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDepthStencilResolveProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkResolveModeFlags.class) int supportedDepthResolveModes() {
        return segment.get(LAYOUT$supportedDepthResolveModes, OFFSET$supportedDepthResolveModes);
    }

    public VkPhysicalDeviceDepthStencilResolveProperties supportedDepthResolveModes(@Bitmask(VkResolveModeFlags.class) int value) {
        segment.set(LAYOUT$supportedDepthResolveModes, OFFSET$supportedDepthResolveModes, value);
        return this;
    }

    public @Bitmask(VkResolveModeFlags.class) int supportedStencilResolveModes() {
        return segment.get(LAYOUT$supportedStencilResolveModes, OFFSET$supportedStencilResolveModes);
    }

    public VkPhysicalDeviceDepthStencilResolveProperties supportedStencilResolveModes(@Bitmask(VkResolveModeFlags.class) int value) {
        segment.set(LAYOUT$supportedStencilResolveModes, OFFSET$supportedStencilResolveModes, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int independentResolveNone() {
        return segment.get(LAYOUT$independentResolveNone, OFFSET$independentResolveNone);
    }

    public VkPhysicalDeviceDepthStencilResolveProperties independentResolveNone(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$independentResolveNone, OFFSET$independentResolveNone, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int independentResolve() {
        return segment.get(LAYOUT$independentResolve, OFFSET$independentResolve);
    }

    public VkPhysicalDeviceDepthStencilResolveProperties independentResolve(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$independentResolve, OFFSET$independentResolve, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("supportedDepthResolveModes"),
        ValueLayout.JAVA_INT.withName("supportedStencilResolveModes"),
        ValueLayout.JAVA_INT.withName("independentResolveNone"),
        ValueLayout.JAVA_INT.withName("independentResolve")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$supportedDepthResolveModes = PathElement.groupElement("supportedDepthResolveModes");
    public static final PathElement PATH$supportedStencilResolveModes = PathElement.groupElement("supportedStencilResolveModes");
    public static final PathElement PATH$independentResolveNone = PathElement.groupElement("independentResolveNone");
    public static final PathElement PATH$independentResolve = PathElement.groupElement("independentResolve");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$supportedDepthResolveModes = (OfInt) LAYOUT.select(PATH$supportedDepthResolveModes);
    public static final OfInt LAYOUT$supportedStencilResolveModes = (OfInt) LAYOUT.select(PATH$supportedStencilResolveModes);
    public static final OfInt LAYOUT$independentResolveNone = (OfInt) LAYOUT.select(PATH$independentResolveNone);
    public static final OfInt LAYOUT$independentResolve = (OfInt) LAYOUT.select(PATH$independentResolve);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$supportedDepthResolveModes = LAYOUT$supportedDepthResolveModes.byteSize();
    public static final long SIZE$supportedStencilResolveModes = LAYOUT$supportedStencilResolveModes.byteSize();
    public static final long SIZE$independentResolveNone = LAYOUT$independentResolveNone.byteSize();
    public static final long SIZE$independentResolve = LAYOUT$independentResolve.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$supportedDepthResolveModes = LAYOUT.byteOffset(PATH$supportedDepthResolveModes);
    public static final long OFFSET$supportedStencilResolveModes = LAYOUT.byteOffset(PATH$supportedStencilResolveModes);
    public static final long OFFSET$independentResolveNone = LAYOUT.byteOffset(PATH$independentResolveNone);
    public static final long OFFSET$independentResolve = LAYOUT.byteOffset(PATH$independentResolve);
}
