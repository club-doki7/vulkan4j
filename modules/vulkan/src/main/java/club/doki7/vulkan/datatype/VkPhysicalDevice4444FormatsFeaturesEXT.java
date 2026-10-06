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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevice4444FormatsFeaturesEXT.html"><code>VkPhysicalDevice4444FormatsFeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDevice4444FormatsFeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 formatA4R4G4B4; // @link substring="formatA4R4G4B4" target="#formatA4R4G4B4"
///     VkBool32 formatA4B4G4R4; // @link substring="formatA4B4G4R4" target="#formatA4B4G4R4"
/// } VkPhysicalDevice4444FormatsFeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_4444_FORMATS_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDevice4444FormatsFeaturesEXT#allocate(Arena)}, {@link VkPhysicalDevice4444FormatsFeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDevice4444FormatsFeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevice4444FormatsFeaturesEXT.html"><code>VkPhysicalDevice4444FormatsFeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDevice4444FormatsFeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDevice4444FormatsFeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevice4444FormatsFeaturesEXT.html"><code>VkPhysicalDevice4444FormatsFeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDevice4444FormatsFeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDevice4444FormatsFeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDevice4444FormatsFeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDevice4444FormatsFeaturesEXT, Iterable<VkPhysicalDevice4444FormatsFeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDevice4444FormatsFeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDevice4444FormatsFeaturesEXT at(long index) {
            return new VkPhysicalDevice4444FormatsFeaturesEXT(segment.asSlice(index * VkPhysicalDevice4444FormatsFeaturesEXT.BYTES, VkPhysicalDevice4444FormatsFeaturesEXT.BYTES));
        }

        public VkPhysicalDevice4444FormatsFeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDevice4444FormatsFeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDevice4444FormatsFeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDevice4444FormatsFeaturesEXT.BYTES, VkPhysicalDevice4444FormatsFeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDevice4444FormatsFeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDevice4444FormatsFeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDevice4444FormatsFeaturesEXT.BYTES,
                (end - start) * VkPhysicalDevice4444FormatsFeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDevice4444FormatsFeaturesEXT.BYTES));
        }

        public VkPhysicalDevice4444FormatsFeaturesEXT[] toArray() {
            VkPhysicalDevice4444FormatsFeaturesEXT[] ret = new VkPhysicalDevice4444FormatsFeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDevice4444FormatsFeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDevice4444FormatsFeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDevice4444FormatsFeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDevice4444FormatsFeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDevice4444FormatsFeaturesEXT ret = new VkPhysicalDevice4444FormatsFeaturesEXT(segment.asSlice(0, VkPhysicalDevice4444FormatsFeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDevice4444FormatsFeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDevice4444FormatsFeaturesEXT allocate(Arena arena) {
        VkPhysicalDevice4444FormatsFeaturesEXT ret = new VkPhysicalDevice4444FormatsFeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_4444_FORMATS_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDevice4444FormatsFeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDevice4444FormatsFeaturesEXT.Ptr ret = new VkPhysicalDevice4444FormatsFeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_4444_FORMATS_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDevice4444FormatsFeaturesEXT clone(Arena arena, VkPhysicalDevice4444FormatsFeaturesEXT src) {
        VkPhysicalDevice4444FormatsFeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_4444_FORMATS_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDevice4444FormatsFeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDevice4444FormatsFeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDevice4444FormatsFeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int formatA4R4G4B4() {
        return segment.get(LAYOUT$formatA4R4G4B4, OFFSET$formatA4R4G4B4);
    }

    public VkPhysicalDevice4444FormatsFeaturesEXT formatA4R4G4B4(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$formatA4R4G4B4, OFFSET$formatA4R4G4B4, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int formatA4B4G4R4() {
        return segment.get(LAYOUT$formatA4B4G4R4, OFFSET$formatA4B4G4R4);
    }

    public VkPhysicalDevice4444FormatsFeaturesEXT formatA4B4G4R4(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$formatA4B4G4R4, OFFSET$formatA4B4G4R4, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("formatA4R4G4B4"),
        ValueLayout.JAVA_INT.withName("formatA4B4G4R4")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$formatA4R4G4B4 = PathElement.groupElement("formatA4R4G4B4");
    public static final PathElement PATH$formatA4B4G4R4 = PathElement.groupElement("formatA4B4G4R4");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$formatA4R4G4B4 = (OfInt) LAYOUT.select(PATH$formatA4R4G4B4);
    public static final OfInt LAYOUT$formatA4B4G4R4 = (OfInt) LAYOUT.select(PATH$formatA4B4G4R4);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$formatA4R4G4B4 = LAYOUT$formatA4R4G4B4.byteSize();
    public static final long SIZE$formatA4B4G4R4 = LAYOUT$formatA4B4G4R4.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$formatA4R4G4B4 = LAYOUT.byteOffset(PATH$formatA4R4G4B4);
    public static final long OFFSET$formatA4B4G4R4 = LAYOUT.byteOffset(PATH$formatA4B4G4R4);
}
