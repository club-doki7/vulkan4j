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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevice16BitStorageFeatures.html"><code>VkPhysicalDevice16BitStorageFeatures</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDevice16BitStorageFeatures {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 storageBuffer16BitAccess; // @link substring="storageBuffer16BitAccess" target="#storageBuffer16BitAccess"
///     VkBool32 uniformAndStorageBuffer16BitAccess; // @link substring="uniformAndStorageBuffer16BitAccess" target="#uniformAndStorageBuffer16BitAccess"
///     VkBool32 storagePushConstant16; // @link substring="storagePushConstant16" target="#storagePushConstant16"
///     VkBool32 storageInputOutput16; // @link substring="storageInputOutput16" target="#storageInputOutput16"
/// } VkPhysicalDevice16BitStorageFeatures;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDevice16BitStorageFeatures#allocate(Arena)}, {@link VkPhysicalDevice16BitStorageFeatures#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDevice16BitStorageFeatures#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevice16BitStorageFeatures.html"><code>VkPhysicalDevice16BitStorageFeatures</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDevice16BitStorageFeatures(@NotNull MemorySegment segment) implements IVkPhysicalDevice16BitStorageFeatures {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevice16BitStorageFeatures.html"><code>VkPhysicalDevice16BitStorageFeatures</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDevice16BitStorageFeatures}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDevice16BitStorageFeatures to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDevice16BitStorageFeatures.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDevice16BitStorageFeatures, Iterable<VkPhysicalDevice16BitStorageFeatures> {
        public long size() {
            return segment.byteSize() / VkPhysicalDevice16BitStorageFeatures.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDevice16BitStorageFeatures at(long index) {
            return new VkPhysicalDevice16BitStorageFeatures(segment.asSlice(index * VkPhysicalDevice16BitStorageFeatures.BYTES, VkPhysicalDevice16BitStorageFeatures.BYTES));
        }

        public VkPhysicalDevice16BitStorageFeatures.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDevice16BitStorageFeatures> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDevice16BitStorageFeatures value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDevice16BitStorageFeatures.BYTES, VkPhysicalDevice16BitStorageFeatures.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDevice16BitStorageFeatures.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDevice16BitStorageFeatures.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDevice16BitStorageFeatures.BYTES,
                (end - start) * VkPhysicalDevice16BitStorageFeatures.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDevice16BitStorageFeatures.BYTES));
        }

        public VkPhysicalDevice16BitStorageFeatures[] toArray() {
            VkPhysicalDevice16BitStorageFeatures[] ret = new VkPhysicalDevice16BitStorageFeatures[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDevice16BitStorageFeatures> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDevice16BitStorageFeatures> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDevice16BitStorageFeatures.BYTES;
            }

            @Override
            public VkPhysicalDevice16BitStorageFeatures next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDevice16BitStorageFeatures ret = new VkPhysicalDevice16BitStorageFeatures(segment.asSlice(0, VkPhysicalDevice16BitStorageFeatures.BYTES));
                segment = segment.asSlice(VkPhysicalDevice16BitStorageFeatures.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDevice16BitStorageFeatures allocate(Arena arena) {
        VkPhysicalDevice16BitStorageFeatures ret = new VkPhysicalDevice16BitStorageFeatures(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES);
        return ret;
    }

    public static VkPhysicalDevice16BitStorageFeatures.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDevice16BitStorageFeatures.Ptr ret = new VkPhysicalDevice16BitStorageFeatures.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDevice16BitStorageFeatures clone(Arena arena, VkPhysicalDevice16BitStorageFeatures src) {
        VkPhysicalDevice16BitStorageFeatures ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDevice16BitStorageFeatures sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDevice16BitStorageFeatures pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDevice16BitStorageFeatures pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int storageBuffer16BitAccess() {
        return segment.get(LAYOUT$storageBuffer16BitAccess, OFFSET$storageBuffer16BitAccess);
    }

    public VkPhysicalDevice16BitStorageFeatures storageBuffer16BitAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$storageBuffer16BitAccess, OFFSET$storageBuffer16BitAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int uniformAndStorageBuffer16BitAccess() {
        return segment.get(LAYOUT$uniformAndStorageBuffer16BitAccess, OFFSET$uniformAndStorageBuffer16BitAccess);
    }

    public VkPhysicalDevice16BitStorageFeatures uniformAndStorageBuffer16BitAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$uniformAndStorageBuffer16BitAccess, OFFSET$uniformAndStorageBuffer16BitAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int storagePushConstant16() {
        return segment.get(LAYOUT$storagePushConstant16, OFFSET$storagePushConstant16);
    }

    public VkPhysicalDevice16BitStorageFeatures storagePushConstant16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$storagePushConstant16, OFFSET$storagePushConstant16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int storageInputOutput16() {
        return segment.get(LAYOUT$storageInputOutput16, OFFSET$storageInputOutput16);
    }

    public VkPhysicalDevice16BitStorageFeatures storageInputOutput16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$storageInputOutput16, OFFSET$storageInputOutput16, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("storageBuffer16BitAccess"),
        ValueLayout.JAVA_INT.withName("uniformAndStorageBuffer16BitAccess"),
        ValueLayout.JAVA_INT.withName("storagePushConstant16"),
        ValueLayout.JAVA_INT.withName("storageInputOutput16")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$storageBuffer16BitAccess = PathElement.groupElement("storageBuffer16BitAccess");
    public static final PathElement PATH$uniformAndStorageBuffer16BitAccess = PathElement.groupElement("uniformAndStorageBuffer16BitAccess");
    public static final PathElement PATH$storagePushConstant16 = PathElement.groupElement("storagePushConstant16");
    public static final PathElement PATH$storageInputOutput16 = PathElement.groupElement("storageInputOutput16");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$storageBuffer16BitAccess = (OfInt) LAYOUT.select(PATH$storageBuffer16BitAccess);
    public static final OfInt LAYOUT$uniformAndStorageBuffer16BitAccess = (OfInt) LAYOUT.select(PATH$uniformAndStorageBuffer16BitAccess);
    public static final OfInt LAYOUT$storagePushConstant16 = (OfInt) LAYOUT.select(PATH$storagePushConstant16);
    public static final OfInt LAYOUT$storageInputOutput16 = (OfInt) LAYOUT.select(PATH$storageInputOutput16);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$storageBuffer16BitAccess = LAYOUT$storageBuffer16BitAccess.byteSize();
    public static final long SIZE$uniformAndStorageBuffer16BitAccess = LAYOUT$uniformAndStorageBuffer16BitAccess.byteSize();
    public static final long SIZE$storagePushConstant16 = LAYOUT$storagePushConstant16.byteSize();
    public static final long SIZE$storageInputOutput16 = LAYOUT$storageInputOutput16.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$storageBuffer16BitAccess = LAYOUT.byteOffset(PATH$storageBuffer16BitAccess);
    public static final long OFFSET$uniformAndStorageBuffer16BitAccess = LAYOUT.byteOffset(PATH$uniformAndStorageBuffer16BitAccess);
    public static final long OFFSET$storagePushConstant16 = LAYOUT.byteOffset(PATH$storagePushConstant16);
    public static final long OFFSET$storageInputOutput16 = LAYOUT.byteOffset(PATH$storageInputOutput16);
}
