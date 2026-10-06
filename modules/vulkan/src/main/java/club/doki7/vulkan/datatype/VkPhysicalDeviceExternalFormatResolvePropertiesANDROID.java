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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.html"><code>VkPhysicalDeviceExternalFormatResolvePropertiesANDROID</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceExternalFormatResolvePropertiesANDROID {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 nullColorAttachmentWithExternalFormatResolve; // @link substring="nullColorAttachmentWithExternalFormatResolve" target="#nullColorAttachmentWithExternalFormatResolve"
///     VkChromaLocation externalFormatResolveChromaOffsetX; // @link substring="VkChromaLocation" target="VkChromaLocation" @link substring="externalFormatResolveChromaOffsetX" target="#externalFormatResolveChromaOffsetX"
///     VkChromaLocation externalFormatResolveChromaOffsetY; // @link substring="VkChromaLocation" target="VkChromaLocation" @link substring="externalFormatResolveChromaOffsetY" target="#externalFormatResolveChromaOffsetY"
/// } VkPhysicalDeviceExternalFormatResolvePropertiesANDROID;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_FORMAT_RESOLVE_PROPERTIES_ANDROID`
///
/// The {@code allocate} ({@link VkPhysicalDeviceExternalFormatResolvePropertiesANDROID#allocate(Arena)}, {@link VkPhysicalDeviceExternalFormatResolvePropertiesANDROID#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceExternalFormatResolvePropertiesANDROID#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.html"><code>VkPhysicalDeviceExternalFormatResolvePropertiesANDROID</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceExternalFormatResolvePropertiesANDROID(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExternalFormatResolvePropertiesANDROID {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.html"><code>VkPhysicalDeviceExternalFormatResolvePropertiesANDROID</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceExternalFormatResolvePropertiesANDROID}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceExternalFormatResolvePropertiesANDROID to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExternalFormatResolvePropertiesANDROID, Iterable<VkPhysicalDeviceExternalFormatResolvePropertiesANDROID> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceExternalFormatResolvePropertiesANDROID at(long index) {
            return new VkPhysicalDeviceExternalFormatResolvePropertiesANDROID(segment.asSlice(index * VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES, VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES));
        }

        public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceExternalFormatResolvePropertiesANDROID> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceExternalFormatResolvePropertiesANDROID value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES, VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES,
                (end - start) * VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES));
        }

        public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID[] toArray() {
            VkPhysicalDeviceExternalFormatResolvePropertiesANDROID[] ret = new VkPhysicalDeviceExternalFormatResolvePropertiesANDROID[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceExternalFormatResolvePropertiesANDROID> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceExternalFormatResolvePropertiesANDROID> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES;
            }

            @Override
            public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceExternalFormatResolvePropertiesANDROID ret = new VkPhysicalDeviceExternalFormatResolvePropertiesANDROID(segment.asSlice(0, VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceExternalFormatResolvePropertiesANDROID allocate(Arena arena) {
        VkPhysicalDeviceExternalFormatResolvePropertiesANDROID ret = new VkPhysicalDeviceExternalFormatResolvePropertiesANDROID(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_FORMAT_RESOLVE_PROPERTIES_ANDROID);
        return ret;
    }

    public static VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.Ptr ret = new VkPhysicalDeviceExternalFormatResolvePropertiesANDROID.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_FORMAT_RESOLVE_PROPERTIES_ANDROID);
        }
        return ret;
    }

    public static VkPhysicalDeviceExternalFormatResolvePropertiesANDROID clone(Arena arena, VkPhysicalDeviceExternalFormatResolvePropertiesANDROID src) {
        VkPhysicalDeviceExternalFormatResolvePropertiesANDROID ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_FORMAT_RESOLVE_PROPERTIES_ANDROID);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int nullColorAttachmentWithExternalFormatResolve() {
        return segment.get(LAYOUT$nullColorAttachmentWithExternalFormatResolve, OFFSET$nullColorAttachmentWithExternalFormatResolve);
    }

    public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID nullColorAttachmentWithExternalFormatResolve(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$nullColorAttachmentWithExternalFormatResolve, OFFSET$nullColorAttachmentWithExternalFormatResolve, value);
        return this;
    }

    public @EnumType(VkChromaLocation.class) int externalFormatResolveChromaOffsetX() {
        return segment.get(LAYOUT$externalFormatResolveChromaOffsetX, OFFSET$externalFormatResolveChromaOffsetX);
    }

    public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID externalFormatResolveChromaOffsetX(@EnumType(VkChromaLocation.class) int value) {
        segment.set(LAYOUT$externalFormatResolveChromaOffsetX, OFFSET$externalFormatResolveChromaOffsetX, value);
        return this;
    }

    public @EnumType(VkChromaLocation.class) int externalFormatResolveChromaOffsetY() {
        return segment.get(LAYOUT$externalFormatResolveChromaOffsetY, OFFSET$externalFormatResolveChromaOffsetY);
    }

    public VkPhysicalDeviceExternalFormatResolvePropertiesANDROID externalFormatResolveChromaOffsetY(@EnumType(VkChromaLocation.class) int value) {
        segment.set(LAYOUT$externalFormatResolveChromaOffsetY, OFFSET$externalFormatResolveChromaOffsetY, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("nullColorAttachmentWithExternalFormatResolve"),
        ValueLayout.JAVA_INT.withName("externalFormatResolveChromaOffsetX"),
        ValueLayout.JAVA_INT.withName("externalFormatResolveChromaOffsetY")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$nullColorAttachmentWithExternalFormatResolve = PathElement.groupElement("nullColorAttachmentWithExternalFormatResolve");
    public static final PathElement PATH$externalFormatResolveChromaOffsetX = PathElement.groupElement("externalFormatResolveChromaOffsetX");
    public static final PathElement PATH$externalFormatResolveChromaOffsetY = PathElement.groupElement("externalFormatResolveChromaOffsetY");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$nullColorAttachmentWithExternalFormatResolve = (OfInt) LAYOUT.select(PATH$nullColorAttachmentWithExternalFormatResolve);
    public static final OfInt LAYOUT$externalFormatResolveChromaOffsetX = (OfInt) LAYOUT.select(PATH$externalFormatResolveChromaOffsetX);
    public static final OfInt LAYOUT$externalFormatResolveChromaOffsetY = (OfInt) LAYOUT.select(PATH$externalFormatResolveChromaOffsetY);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$nullColorAttachmentWithExternalFormatResolve = LAYOUT$nullColorAttachmentWithExternalFormatResolve.byteSize();
    public static final long SIZE$externalFormatResolveChromaOffsetX = LAYOUT$externalFormatResolveChromaOffsetX.byteSize();
    public static final long SIZE$externalFormatResolveChromaOffsetY = LAYOUT$externalFormatResolveChromaOffsetY.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$nullColorAttachmentWithExternalFormatResolve = LAYOUT.byteOffset(PATH$nullColorAttachmentWithExternalFormatResolve);
    public static final long OFFSET$externalFormatResolveChromaOffsetX = LAYOUT.byteOffset(PATH$externalFormatResolveChromaOffsetX);
    public static final long OFFSET$externalFormatResolveChromaOffsetY = LAYOUT.byteOffset(PATH$externalFormatResolveChromaOffsetY);
}
