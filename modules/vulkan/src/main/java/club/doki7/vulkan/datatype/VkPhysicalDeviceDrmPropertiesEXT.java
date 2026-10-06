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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDrmPropertiesEXT.html"><code>VkPhysicalDeviceDrmPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDrmPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 hasPrimary; // @link substring="hasPrimary" target="#hasPrimary"
///     VkBool32 hasRender; // @link substring="hasRender" target="#hasRender"
///     int64_t primaryMajor; // @link substring="primaryMajor" target="#primaryMajor"
///     int64_t primaryMinor; // @link substring="primaryMinor" target="#primaryMinor"
///     int64_t renderMajor; // @link substring="renderMajor" target="#renderMajor"
///     int64_t renderMinor; // @link substring="renderMinor" target="#renderMinor"
/// } VkPhysicalDeviceDrmPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DRM_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDrmPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceDrmPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDrmPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDrmPropertiesEXT.html"><code>VkPhysicalDeviceDrmPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDrmPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDrmPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDrmPropertiesEXT.html"><code>VkPhysicalDeviceDrmPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDrmPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDrmPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDrmPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDrmPropertiesEXT, Iterable<VkPhysicalDeviceDrmPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDrmPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDrmPropertiesEXT at(long index) {
            return new VkPhysicalDeviceDrmPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceDrmPropertiesEXT.BYTES, VkPhysicalDeviceDrmPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDrmPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDrmPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDrmPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDrmPropertiesEXT.BYTES, VkPhysicalDeviceDrmPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDrmPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDrmPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDrmPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceDrmPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDrmPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDrmPropertiesEXT[] toArray() {
            VkPhysicalDeviceDrmPropertiesEXT[] ret = new VkPhysicalDeviceDrmPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDrmPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDrmPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDrmPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceDrmPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDrmPropertiesEXT ret = new VkPhysicalDeviceDrmPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceDrmPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDrmPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDrmPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceDrmPropertiesEXT ret = new VkPhysicalDeviceDrmPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DRM_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceDrmPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDrmPropertiesEXT.Ptr ret = new VkPhysicalDeviceDrmPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DRM_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceDrmPropertiesEXT clone(Arena arena, VkPhysicalDeviceDrmPropertiesEXT src) {
        VkPhysicalDeviceDrmPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DRM_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDrmPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDrmPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDrmPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hasPrimary() {
        return segment.get(LAYOUT$hasPrimary, OFFSET$hasPrimary);
    }

    public VkPhysicalDeviceDrmPropertiesEXT hasPrimary(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hasPrimary, OFFSET$hasPrimary, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hasRender() {
        return segment.get(LAYOUT$hasRender, OFFSET$hasRender);
    }

    public VkPhysicalDeviceDrmPropertiesEXT hasRender(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hasRender, OFFSET$hasRender, value);
        return this;
    }

    public long primaryMajor() {
        return segment.get(LAYOUT$primaryMajor, OFFSET$primaryMajor);
    }

    public VkPhysicalDeviceDrmPropertiesEXT primaryMajor(long value) {
        segment.set(LAYOUT$primaryMajor, OFFSET$primaryMajor, value);
        return this;
    }

    public long primaryMinor() {
        return segment.get(LAYOUT$primaryMinor, OFFSET$primaryMinor);
    }

    public VkPhysicalDeviceDrmPropertiesEXT primaryMinor(long value) {
        segment.set(LAYOUT$primaryMinor, OFFSET$primaryMinor, value);
        return this;
    }

    public long renderMajor() {
        return segment.get(LAYOUT$renderMajor, OFFSET$renderMajor);
    }

    public VkPhysicalDeviceDrmPropertiesEXT renderMajor(long value) {
        segment.set(LAYOUT$renderMajor, OFFSET$renderMajor, value);
        return this;
    }

    public long renderMinor() {
        return segment.get(LAYOUT$renderMinor, OFFSET$renderMinor);
    }

    public VkPhysicalDeviceDrmPropertiesEXT renderMinor(long value) {
        segment.set(LAYOUT$renderMinor, OFFSET$renderMinor, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("hasPrimary"),
        ValueLayout.JAVA_INT.withName("hasRender"),
        ValueLayout.JAVA_LONG.withName("primaryMajor"),
        ValueLayout.JAVA_LONG.withName("primaryMinor"),
        ValueLayout.JAVA_LONG.withName("renderMajor"),
        ValueLayout.JAVA_LONG.withName("renderMinor")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$hasPrimary = PathElement.groupElement("hasPrimary");
    public static final PathElement PATH$hasRender = PathElement.groupElement("hasRender");
    public static final PathElement PATH$primaryMajor = PathElement.groupElement("primaryMajor");
    public static final PathElement PATH$primaryMinor = PathElement.groupElement("primaryMinor");
    public static final PathElement PATH$renderMajor = PathElement.groupElement("renderMajor");
    public static final PathElement PATH$renderMinor = PathElement.groupElement("renderMinor");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$hasPrimary = (OfInt) LAYOUT.select(PATH$hasPrimary);
    public static final OfInt LAYOUT$hasRender = (OfInt) LAYOUT.select(PATH$hasRender);
    public static final OfLong LAYOUT$primaryMajor = (OfLong) LAYOUT.select(PATH$primaryMajor);
    public static final OfLong LAYOUT$primaryMinor = (OfLong) LAYOUT.select(PATH$primaryMinor);
    public static final OfLong LAYOUT$renderMajor = (OfLong) LAYOUT.select(PATH$renderMajor);
    public static final OfLong LAYOUT$renderMinor = (OfLong) LAYOUT.select(PATH$renderMinor);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$hasPrimary = LAYOUT$hasPrimary.byteSize();
    public static final long SIZE$hasRender = LAYOUT$hasRender.byteSize();
    public static final long SIZE$primaryMajor = LAYOUT$primaryMajor.byteSize();
    public static final long SIZE$primaryMinor = LAYOUT$primaryMinor.byteSize();
    public static final long SIZE$renderMajor = LAYOUT$renderMajor.byteSize();
    public static final long SIZE$renderMinor = LAYOUT$renderMinor.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$hasPrimary = LAYOUT.byteOffset(PATH$hasPrimary);
    public static final long OFFSET$hasRender = LAYOUT.byteOffset(PATH$hasRender);
    public static final long OFFSET$primaryMajor = LAYOUT.byteOffset(PATH$primaryMajor);
    public static final long OFFSET$primaryMinor = LAYOUT.byteOffset(PATH$primaryMinor);
    public static final long OFFSET$renderMajor = LAYOUT.byteOffset(PATH$renderMajor);
    public static final long OFFSET$renderMinor = LAYOUT.byteOffset(PATH$renderMinor);
}
