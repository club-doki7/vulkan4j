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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCooperativeMatrixPropertiesKHR.html"><code>VkCooperativeMatrixPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCooperativeMatrixPropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t MSize; // @link substring="MSize" target="#MSize"
///     uint32_t NSize; // @link substring="NSize" target="#NSize"
///     uint32_t KSize; // @link substring="KSize" target="#KSize"
///     VkComponentTypeKHR AType; // @link substring="VkComponentTypeKHR" target="VkComponentTypeKHR" @link substring="AType" target="#AType"
///     VkComponentTypeKHR BType; // @link substring="VkComponentTypeKHR" target="VkComponentTypeKHR" @link substring="BType" target="#BType"
///     VkComponentTypeKHR CType; // @link substring="VkComponentTypeKHR" target="VkComponentTypeKHR" @link substring="CType" target="#CType"
///     VkComponentTypeKHR ResultType; // @link substring="VkComponentTypeKHR" target="VkComponentTypeKHR" @link substring="ResultType" target="#ResultType"
///     VkBool32 saturatingAccumulation; // @link substring="saturatingAccumulation" target="#saturatingAccumulation"
///     VkScopeKHR scope; // @link substring="VkScopeKHR" target="VkScopeKHR" @link substring="scope" target="#scope"
/// } VkCooperativeMatrixPropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COOPERATIVE_MATRIX_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkCooperativeMatrixPropertiesKHR#allocate(Arena)}, {@link VkCooperativeMatrixPropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCooperativeMatrixPropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCooperativeMatrixPropertiesKHR.html"><code>VkCooperativeMatrixPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCooperativeMatrixPropertiesKHR(@NotNull MemorySegment segment) implements IVkCooperativeMatrixPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCooperativeMatrixPropertiesKHR.html"><code>VkCooperativeMatrixPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCooperativeMatrixPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCooperativeMatrixPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCooperativeMatrixPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCooperativeMatrixPropertiesKHR, Iterable<VkCooperativeMatrixPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkCooperativeMatrixPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCooperativeMatrixPropertiesKHR at(long index) {
            return new VkCooperativeMatrixPropertiesKHR(segment.asSlice(index * VkCooperativeMatrixPropertiesKHR.BYTES, VkCooperativeMatrixPropertiesKHR.BYTES));
        }

        public VkCooperativeMatrixPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkCooperativeMatrixPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCooperativeMatrixPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkCooperativeMatrixPropertiesKHR.BYTES, VkCooperativeMatrixPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCooperativeMatrixPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCooperativeMatrixPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCooperativeMatrixPropertiesKHR.BYTES,
                (end - start) * VkCooperativeMatrixPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCooperativeMatrixPropertiesKHR.BYTES));
        }

        public VkCooperativeMatrixPropertiesKHR[] toArray() {
            VkCooperativeMatrixPropertiesKHR[] ret = new VkCooperativeMatrixPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCooperativeMatrixPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCooperativeMatrixPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCooperativeMatrixPropertiesKHR.BYTES;
            }

            @Override
            public VkCooperativeMatrixPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCooperativeMatrixPropertiesKHR ret = new VkCooperativeMatrixPropertiesKHR(segment.asSlice(0, VkCooperativeMatrixPropertiesKHR.BYTES));
                segment = segment.asSlice(VkCooperativeMatrixPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCooperativeMatrixPropertiesKHR allocate(Arena arena) {
        VkCooperativeMatrixPropertiesKHR ret = new VkCooperativeMatrixPropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COOPERATIVE_MATRIX_PROPERTIES_KHR);
        return ret;
    }

    public static VkCooperativeMatrixPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCooperativeMatrixPropertiesKHR.Ptr ret = new VkCooperativeMatrixPropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COOPERATIVE_MATRIX_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkCooperativeMatrixPropertiesKHR clone(Arena arena, VkCooperativeMatrixPropertiesKHR src) {
        VkCooperativeMatrixPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COOPERATIVE_MATRIX_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCooperativeMatrixPropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCooperativeMatrixPropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCooperativeMatrixPropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int MSize() {
        return segment.get(LAYOUT$MSize, OFFSET$MSize);
    }

    public VkCooperativeMatrixPropertiesKHR MSize(@Unsigned int value) {
        segment.set(LAYOUT$MSize, OFFSET$MSize, value);
        return this;
    }

    public @Unsigned int NSize() {
        return segment.get(LAYOUT$NSize, OFFSET$NSize);
    }

    public VkCooperativeMatrixPropertiesKHR NSize(@Unsigned int value) {
        segment.set(LAYOUT$NSize, OFFSET$NSize, value);
        return this;
    }

    public @Unsigned int KSize() {
        return segment.get(LAYOUT$KSize, OFFSET$KSize);
    }

    public VkCooperativeMatrixPropertiesKHR KSize(@Unsigned int value) {
        segment.set(LAYOUT$KSize, OFFSET$KSize, value);
        return this;
    }

    public @EnumType(VkComponentTypeKHR.class) int AType() {
        return segment.get(LAYOUT$AType, OFFSET$AType);
    }

    public VkCooperativeMatrixPropertiesKHR AType(@EnumType(VkComponentTypeKHR.class) int value) {
        segment.set(LAYOUT$AType, OFFSET$AType, value);
        return this;
    }

    public @EnumType(VkComponentTypeKHR.class) int BType() {
        return segment.get(LAYOUT$BType, OFFSET$BType);
    }

    public VkCooperativeMatrixPropertiesKHR BType(@EnumType(VkComponentTypeKHR.class) int value) {
        segment.set(LAYOUT$BType, OFFSET$BType, value);
        return this;
    }

    public @EnumType(VkComponentTypeKHR.class) int CType() {
        return segment.get(LAYOUT$CType, OFFSET$CType);
    }

    public VkCooperativeMatrixPropertiesKHR CType(@EnumType(VkComponentTypeKHR.class) int value) {
        segment.set(LAYOUT$CType, OFFSET$CType, value);
        return this;
    }

    public @EnumType(VkComponentTypeKHR.class) int ResultType() {
        return segment.get(LAYOUT$ResultType, OFFSET$ResultType);
    }

    public VkCooperativeMatrixPropertiesKHR ResultType(@EnumType(VkComponentTypeKHR.class) int value) {
        segment.set(LAYOUT$ResultType, OFFSET$ResultType, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int saturatingAccumulation() {
        return segment.get(LAYOUT$saturatingAccumulation, OFFSET$saturatingAccumulation);
    }

    public VkCooperativeMatrixPropertiesKHR saturatingAccumulation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$saturatingAccumulation, OFFSET$saturatingAccumulation, value);
        return this;
    }

    public @EnumType(VkScopeKHR.class) int scope() {
        return segment.get(LAYOUT$scope, OFFSET$scope);
    }

    public VkCooperativeMatrixPropertiesKHR scope(@EnumType(VkScopeKHR.class) int value) {
        segment.set(LAYOUT$scope, OFFSET$scope, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("MSize"),
        ValueLayout.JAVA_INT.withName("NSize"),
        ValueLayout.JAVA_INT.withName("KSize"),
        ValueLayout.JAVA_INT.withName("AType"),
        ValueLayout.JAVA_INT.withName("BType"),
        ValueLayout.JAVA_INT.withName("CType"),
        ValueLayout.JAVA_INT.withName("ResultType"),
        ValueLayout.JAVA_INT.withName("saturatingAccumulation"),
        ValueLayout.JAVA_INT.withName("scope")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$MSize = PathElement.groupElement("MSize");
    public static final PathElement PATH$NSize = PathElement.groupElement("NSize");
    public static final PathElement PATH$KSize = PathElement.groupElement("KSize");
    public static final PathElement PATH$AType = PathElement.groupElement("AType");
    public static final PathElement PATH$BType = PathElement.groupElement("BType");
    public static final PathElement PATH$CType = PathElement.groupElement("CType");
    public static final PathElement PATH$ResultType = PathElement.groupElement("ResultType");
    public static final PathElement PATH$saturatingAccumulation = PathElement.groupElement("saturatingAccumulation");
    public static final PathElement PATH$scope = PathElement.groupElement("scope");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$MSize = (OfInt) LAYOUT.select(PATH$MSize);
    public static final OfInt LAYOUT$NSize = (OfInt) LAYOUT.select(PATH$NSize);
    public static final OfInt LAYOUT$KSize = (OfInt) LAYOUT.select(PATH$KSize);
    public static final OfInt LAYOUT$AType = (OfInt) LAYOUT.select(PATH$AType);
    public static final OfInt LAYOUT$BType = (OfInt) LAYOUT.select(PATH$BType);
    public static final OfInt LAYOUT$CType = (OfInt) LAYOUT.select(PATH$CType);
    public static final OfInt LAYOUT$ResultType = (OfInt) LAYOUT.select(PATH$ResultType);
    public static final OfInt LAYOUT$saturatingAccumulation = (OfInt) LAYOUT.select(PATH$saturatingAccumulation);
    public static final OfInt LAYOUT$scope = (OfInt) LAYOUT.select(PATH$scope);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$MSize = LAYOUT$MSize.byteSize();
    public static final long SIZE$NSize = LAYOUT$NSize.byteSize();
    public static final long SIZE$KSize = LAYOUT$KSize.byteSize();
    public static final long SIZE$AType = LAYOUT$AType.byteSize();
    public static final long SIZE$BType = LAYOUT$BType.byteSize();
    public static final long SIZE$CType = LAYOUT$CType.byteSize();
    public static final long SIZE$ResultType = LAYOUT$ResultType.byteSize();
    public static final long SIZE$saturatingAccumulation = LAYOUT$saturatingAccumulation.byteSize();
    public static final long SIZE$scope = LAYOUT$scope.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$MSize = LAYOUT.byteOffset(PATH$MSize);
    public static final long OFFSET$NSize = LAYOUT.byteOffset(PATH$NSize);
    public static final long OFFSET$KSize = LAYOUT.byteOffset(PATH$KSize);
    public static final long OFFSET$AType = LAYOUT.byteOffset(PATH$AType);
    public static final long OFFSET$BType = LAYOUT.byteOffset(PATH$BType);
    public static final long OFFSET$CType = LAYOUT.byteOffset(PATH$CType);
    public static final long OFFSET$ResultType = LAYOUT.byteOffset(PATH$ResultType);
    public static final long OFFSET$saturatingAccumulation = LAYOUT.byteOffset(PATH$saturatingAccumulation);
    public static final long OFFSET$scope = LAYOUT.byteOffset(PATH$scope);
}
