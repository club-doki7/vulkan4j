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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.html"><code>VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 multiviewPerViewViewports; // @link substring="multiviewPerViewViewports" target="#multiviewPerViewViewports"
/// } VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MULTIVIEW_PER_VIEW_VIEWPORTS_FEATURES_QCOM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM#allocate(Arena)}, {@link VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.html"><code>VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.html"><code>VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM, Iterable<VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM at(long index) {
            return new VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM(segment.asSlice(index * VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES, VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES));
        }

        public VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES, VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES,
                (end - start) * VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES));
        }

        public VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM[] toArray() {
            VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM[] ret = new VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES;
            }

            @Override
            public VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM ret = new VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM(segment.asSlice(0, VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM allocate(Arena arena) {
        VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM ret = new VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PER_VIEW_VIEWPORTS_FEATURES_QCOM);
        return ret;
    }

    public static VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.Ptr ret = new VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PER_VIEW_VIEWPORTS_FEATURES_QCOM);
        }
        return ret;
    }

    public static VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM clone(Arena arena, VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM src) {
        VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PER_VIEW_VIEWPORTS_FEATURES_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int multiviewPerViewViewports() {
        return segment.get(LAYOUT$multiviewPerViewViewports, OFFSET$multiviewPerViewViewports);
    }

    public VkPhysicalDeviceMultiviewPerViewViewportsFeaturesQCOM multiviewPerViewViewports(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$multiviewPerViewViewports, OFFSET$multiviewPerViewViewports, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("multiviewPerViewViewports")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$multiviewPerViewViewports = PathElement.groupElement("multiviewPerViewViewports");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$multiviewPerViewViewports = (OfInt) LAYOUT.select(PATH$multiviewPerViewViewports);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$multiviewPerViewViewports = LAYOUT$multiviewPerViewViewports.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$multiviewPerViewViewports = LAYOUT.byteOffset(PATH$multiviewPerViewViewports);
}
