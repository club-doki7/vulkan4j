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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.html"><code>VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 workgroupMemoryExplicitLayout; // @link substring="workgroupMemoryExplicitLayout" target="#workgroupMemoryExplicitLayout"
///     VkBool32 workgroupMemoryExplicitLayoutScalarBlockLayout; // @link substring="workgroupMemoryExplicitLayoutScalarBlockLayout" target="#workgroupMemoryExplicitLayoutScalarBlockLayout"
///     VkBool32 workgroupMemoryExplicitLayout8BitAccess; // @link substring="workgroupMemoryExplicitLayout8BitAccess" target="#workgroupMemoryExplicitLayout8BitAccess"
///     VkBool32 workgroupMemoryExplicitLayout16BitAccess; // @link substring="workgroupMemoryExplicitLayout16BitAccess" target="#workgroupMemoryExplicitLayout16BitAccess"
/// } VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_WORKGROUP_MEMORY_EXPLICIT_LAYOUT_FEATURES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR#allocate(Arena)}, {@link VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.html"><code>VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.html"><code>VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR, Iterable<VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR at(long index) {
            return new VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR(segment.asSlice(index * VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES, VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES, VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES,
                (end - start) * VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR[] toArray() {
            VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR[] ret = new VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR ret = new VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR(segment.asSlice(0, VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR allocate(Arena arena) {
        VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR ret = new VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_WORKGROUP_MEMORY_EXPLICIT_LAYOUT_FEATURES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.Ptr ret = new VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_WORKGROUP_MEMORY_EXPLICIT_LAYOUT_FEATURES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR clone(Arena arena, VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR src) {
        VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_WORKGROUP_MEMORY_EXPLICIT_LAYOUT_FEATURES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int workgroupMemoryExplicitLayout() {
        return segment.get(LAYOUT$workgroupMemoryExplicitLayout, OFFSET$workgroupMemoryExplicitLayout);
    }

    public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR workgroupMemoryExplicitLayout(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$workgroupMemoryExplicitLayout, OFFSET$workgroupMemoryExplicitLayout, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int workgroupMemoryExplicitLayoutScalarBlockLayout() {
        return segment.get(LAYOUT$workgroupMemoryExplicitLayoutScalarBlockLayout, OFFSET$workgroupMemoryExplicitLayoutScalarBlockLayout);
    }

    public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR workgroupMemoryExplicitLayoutScalarBlockLayout(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$workgroupMemoryExplicitLayoutScalarBlockLayout, OFFSET$workgroupMemoryExplicitLayoutScalarBlockLayout, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int workgroupMemoryExplicitLayout8BitAccess() {
        return segment.get(LAYOUT$workgroupMemoryExplicitLayout8BitAccess, OFFSET$workgroupMemoryExplicitLayout8BitAccess);
    }

    public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR workgroupMemoryExplicitLayout8BitAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$workgroupMemoryExplicitLayout8BitAccess, OFFSET$workgroupMemoryExplicitLayout8BitAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int workgroupMemoryExplicitLayout16BitAccess() {
        return segment.get(LAYOUT$workgroupMemoryExplicitLayout16BitAccess, OFFSET$workgroupMemoryExplicitLayout16BitAccess);
    }

    public VkPhysicalDeviceWorkgroupMemoryExplicitLayoutFeaturesKHR workgroupMemoryExplicitLayout16BitAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$workgroupMemoryExplicitLayout16BitAccess, OFFSET$workgroupMemoryExplicitLayout16BitAccess, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("workgroupMemoryExplicitLayout"),
        ValueLayout.JAVA_INT.withName("workgroupMemoryExplicitLayoutScalarBlockLayout"),
        ValueLayout.JAVA_INT.withName("workgroupMemoryExplicitLayout8BitAccess"),
        ValueLayout.JAVA_INT.withName("workgroupMemoryExplicitLayout16BitAccess")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$workgroupMemoryExplicitLayout = PathElement.groupElement("workgroupMemoryExplicitLayout");
    public static final PathElement PATH$workgroupMemoryExplicitLayoutScalarBlockLayout = PathElement.groupElement("workgroupMemoryExplicitLayoutScalarBlockLayout");
    public static final PathElement PATH$workgroupMemoryExplicitLayout8BitAccess = PathElement.groupElement("workgroupMemoryExplicitLayout8BitAccess");
    public static final PathElement PATH$workgroupMemoryExplicitLayout16BitAccess = PathElement.groupElement("workgroupMemoryExplicitLayout16BitAccess");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$workgroupMemoryExplicitLayout = (OfInt) LAYOUT.select(PATH$workgroupMemoryExplicitLayout);
    public static final OfInt LAYOUT$workgroupMemoryExplicitLayoutScalarBlockLayout = (OfInt) LAYOUT.select(PATH$workgroupMemoryExplicitLayoutScalarBlockLayout);
    public static final OfInt LAYOUT$workgroupMemoryExplicitLayout8BitAccess = (OfInt) LAYOUT.select(PATH$workgroupMemoryExplicitLayout8BitAccess);
    public static final OfInt LAYOUT$workgroupMemoryExplicitLayout16BitAccess = (OfInt) LAYOUT.select(PATH$workgroupMemoryExplicitLayout16BitAccess);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$workgroupMemoryExplicitLayout = LAYOUT$workgroupMemoryExplicitLayout.byteSize();
    public static final long SIZE$workgroupMemoryExplicitLayoutScalarBlockLayout = LAYOUT$workgroupMemoryExplicitLayoutScalarBlockLayout.byteSize();
    public static final long SIZE$workgroupMemoryExplicitLayout8BitAccess = LAYOUT$workgroupMemoryExplicitLayout8BitAccess.byteSize();
    public static final long SIZE$workgroupMemoryExplicitLayout16BitAccess = LAYOUT$workgroupMemoryExplicitLayout16BitAccess.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$workgroupMemoryExplicitLayout = LAYOUT.byteOffset(PATH$workgroupMemoryExplicitLayout);
    public static final long OFFSET$workgroupMemoryExplicitLayoutScalarBlockLayout = LAYOUT.byteOffset(PATH$workgroupMemoryExplicitLayoutScalarBlockLayout);
    public static final long OFFSET$workgroupMemoryExplicitLayout8BitAccess = LAYOUT.byteOffset(PATH$workgroupMemoryExplicitLayout8BitAccess);
    public static final long OFFSET$workgroupMemoryExplicitLayout16BitAccess = LAYOUT.byteOffset(PATH$workgroupMemoryExplicitLayout16BitAccess);
}
