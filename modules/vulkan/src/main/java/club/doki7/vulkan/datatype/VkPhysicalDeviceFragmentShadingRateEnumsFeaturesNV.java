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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.html"><code>VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 fragmentShadingRateEnums; // @link substring="fragmentShadingRateEnums" target="#fragmentShadingRateEnums"
///     VkBool32 supersampleFragmentShadingRates; // @link substring="supersampleFragmentShadingRates" target="#supersampleFragmentShadingRates"
///     VkBool32 noInvocationFragmentShadingRates; // @link substring="noInvocationFragmentShadingRates" target="#noInvocationFragmentShadingRates"
/// } VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_ENUMS_FEATURES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV#allocate(Arena)}, {@link VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.html"><code>VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.html"><code>VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV, Iterable<VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV at(long index) {
            return new VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV(segment.asSlice(index * VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES, VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES));
        }

        public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES, VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES,
                (end - start) * VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES));
        }

        public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV[] toArray() {
            VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV[] ret = new VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV ret = new VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV(segment.asSlice(0, VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV allocate(Arena arena) {
        VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV ret = new VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_ENUMS_FEATURES_NV);
        return ret;
    }

    public static VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.Ptr ret = new VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_ENUMS_FEATURES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV clone(Arena arena, VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV src) {
        VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_ENUMS_FEATURES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateEnums() {
        return segment.get(LAYOUT$fragmentShadingRateEnums, OFFSET$fragmentShadingRateEnums);
    }

    public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV fragmentShadingRateEnums(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateEnums, OFFSET$fragmentShadingRateEnums, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int supersampleFragmentShadingRates() {
        return segment.get(LAYOUT$supersampleFragmentShadingRates, OFFSET$supersampleFragmentShadingRates);
    }

    public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV supersampleFragmentShadingRates(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$supersampleFragmentShadingRates, OFFSET$supersampleFragmentShadingRates, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int noInvocationFragmentShadingRates() {
        return segment.get(LAYOUT$noInvocationFragmentShadingRates, OFFSET$noInvocationFragmentShadingRates);
    }

    public VkPhysicalDeviceFragmentShadingRateEnumsFeaturesNV noInvocationFragmentShadingRates(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$noInvocationFragmentShadingRates, OFFSET$noInvocationFragmentShadingRates, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateEnums"),
        ValueLayout.JAVA_INT.withName("supersampleFragmentShadingRates"),
        ValueLayout.JAVA_INT.withName("noInvocationFragmentShadingRates")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$fragmentShadingRateEnums = PathElement.groupElement("fragmentShadingRateEnums");
    public static final PathElement PATH$supersampleFragmentShadingRates = PathElement.groupElement("supersampleFragmentShadingRates");
    public static final PathElement PATH$noInvocationFragmentShadingRates = PathElement.groupElement("noInvocationFragmentShadingRates");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$fragmentShadingRateEnums = (OfInt) LAYOUT.select(PATH$fragmentShadingRateEnums);
    public static final OfInt LAYOUT$supersampleFragmentShadingRates = (OfInt) LAYOUT.select(PATH$supersampleFragmentShadingRates);
    public static final OfInt LAYOUT$noInvocationFragmentShadingRates = (OfInt) LAYOUT.select(PATH$noInvocationFragmentShadingRates);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$fragmentShadingRateEnums = LAYOUT$fragmentShadingRateEnums.byteSize();
    public static final long SIZE$supersampleFragmentShadingRates = LAYOUT$supersampleFragmentShadingRates.byteSize();
    public static final long SIZE$noInvocationFragmentShadingRates = LAYOUT$noInvocationFragmentShadingRates.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$fragmentShadingRateEnums = LAYOUT.byteOffset(PATH$fragmentShadingRateEnums);
    public static final long OFFSET$supersampleFragmentShadingRates = LAYOUT.byteOffset(PATH$supersampleFragmentShadingRates);
    public static final long OFFSET$noInvocationFragmentShadingRates = LAYOUT.byteOffset(PATH$noInvocationFragmentShadingRates);
}
