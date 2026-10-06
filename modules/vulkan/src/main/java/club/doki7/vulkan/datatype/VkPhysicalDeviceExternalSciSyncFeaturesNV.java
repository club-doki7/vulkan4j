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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalSciSyncFeaturesNV.html"><code>VkPhysicalDeviceExternalSciSyncFeaturesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceExternalSciSyncFeaturesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 sciSyncFence; // @link substring="sciSyncFence" target="#sciSyncFence"
///     VkBool32 sciSyncSemaphore; // @link substring="sciSyncSemaphore" target="#sciSyncSemaphore"
///     VkBool32 sciSyncImport; // @link substring="sciSyncImport" target="#sciSyncImport"
///     VkBool32 sciSyncExport; // @link substring="sciSyncExport" target="#sciSyncExport"
/// } VkPhysicalDeviceExternalSciSyncFeaturesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_SCI_SYNC_FEATURES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceExternalSciSyncFeaturesNV#allocate(Arena)}, {@link VkPhysicalDeviceExternalSciSyncFeaturesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceExternalSciSyncFeaturesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalSciSyncFeaturesNV.html"><code>VkPhysicalDeviceExternalSciSyncFeaturesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceExternalSciSyncFeaturesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExternalSciSyncFeaturesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalSciSyncFeaturesNV.html"><code>VkPhysicalDeviceExternalSciSyncFeaturesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceExternalSciSyncFeaturesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceExternalSciSyncFeaturesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceExternalSciSyncFeaturesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExternalSciSyncFeaturesNV, Iterable<VkPhysicalDeviceExternalSciSyncFeaturesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceExternalSciSyncFeaturesNV at(long index) {
            return new VkPhysicalDeviceExternalSciSyncFeaturesNV(segment.asSlice(index * VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES, VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES));
        }

        public VkPhysicalDeviceExternalSciSyncFeaturesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceExternalSciSyncFeaturesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceExternalSciSyncFeaturesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES, VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES,
                (end - start) * VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES));
        }

        public VkPhysicalDeviceExternalSciSyncFeaturesNV[] toArray() {
            VkPhysicalDeviceExternalSciSyncFeaturesNV[] ret = new VkPhysicalDeviceExternalSciSyncFeaturesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceExternalSciSyncFeaturesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceExternalSciSyncFeaturesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceExternalSciSyncFeaturesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceExternalSciSyncFeaturesNV ret = new VkPhysicalDeviceExternalSciSyncFeaturesNV(segment.asSlice(0, VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceExternalSciSyncFeaturesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceExternalSciSyncFeaturesNV allocate(Arena arena) {
        VkPhysicalDeviceExternalSciSyncFeaturesNV ret = new VkPhysicalDeviceExternalSciSyncFeaturesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_SCI_SYNC_FEATURES_NV);
        return ret;
    }

    public static VkPhysicalDeviceExternalSciSyncFeaturesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceExternalSciSyncFeaturesNV.Ptr ret = new VkPhysicalDeviceExternalSciSyncFeaturesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_SCI_SYNC_FEATURES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceExternalSciSyncFeaturesNV clone(Arena arena, VkPhysicalDeviceExternalSciSyncFeaturesNV src) {
        VkPhysicalDeviceExternalSciSyncFeaturesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_SCI_SYNC_FEATURES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceExternalSciSyncFeaturesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceExternalSciSyncFeaturesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceExternalSciSyncFeaturesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sciSyncFence() {
        return segment.get(LAYOUT$sciSyncFence, OFFSET$sciSyncFence);
    }

    public VkPhysicalDeviceExternalSciSyncFeaturesNV sciSyncFence(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sciSyncFence, OFFSET$sciSyncFence, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sciSyncSemaphore() {
        return segment.get(LAYOUT$sciSyncSemaphore, OFFSET$sciSyncSemaphore);
    }

    public VkPhysicalDeviceExternalSciSyncFeaturesNV sciSyncSemaphore(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sciSyncSemaphore, OFFSET$sciSyncSemaphore, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sciSyncImport() {
        return segment.get(LAYOUT$sciSyncImport, OFFSET$sciSyncImport);
    }

    public VkPhysicalDeviceExternalSciSyncFeaturesNV sciSyncImport(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sciSyncImport, OFFSET$sciSyncImport, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sciSyncExport() {
        return segment.get(LAYOUT$sciSyncExport, OFFSET$sciSyncExport);
    }

    public VkPhysicalDeviceExternalSciSyncFeaturesNV sciSyncExport(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sciSyncExport, OFFSET$sciSyncExport, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("sciSyncFence"),
        ValueLayout.JAVA_INT.withName("sciSyncSemaphore"),
        ValueLayout.JAVA_INT.withName("sciSyncImport"),
        ValueLayout.JAVA_INT.withName("sciSyncExport")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$sciSyncFence = PathElement.groupElement("sciSyncFence");
    public static final PathElement PATH$sciSyncSemaphore = PathElement.groupElement("sciSyncSemaphore");
    public static final PathElement PATH$sciSyncImport = PathElement.groupElement("sciSyncImport");
    public static final PathElement PATH$sciSyncExport = PathElement.groupElement("sciSyncExport");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$sciSyncFence = (OfInt) LAYOUT.select(PATH$sciSyncFence);
    public static final OfInt LAYOUT$sciSyncSemaphore = (OfInt) LAYOUT.select(PATH$sciSyncSemaphore);
    public static final OfInt LAYOUT$sciSyncImport = (OfInt) LAYOUT.select(PATH$sciSyncImport);
    public static final OfInt LAYOUT$sciSyncExport = (OfInt) LAYOUT.select(PATH$sciSyncExport);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$sciSyncFence = LAYOUT$sciSyncFence.byteSize();
    public static final long SIZE$sciSyncSemaphore = LAYOUT$sciSyncSemaphore.byteSize();
    public static final long SIZE$sciSyncImport = LAYOUT$sciSyncImport.byteSize();
    public static final long SIZE$sciSyncExport = LAYOUT$sciSyncExport.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$sciSyncFence = LAYOUT.byteOffset(PATH$sciSyncFence);
    public static final long OFFSET$sciSyncSemaphore = LAYOUT.byteOffset(PATH$sciSyncSemaphore);
    public static final long OFFSET$sciSyncImport = LAYOUT.byteOffset(PATH$sciSyncImport);
    public static final long OFFSET$sciSyncExport = LAYOUT.byteOffset(PATH$sciSyncExport);
}
