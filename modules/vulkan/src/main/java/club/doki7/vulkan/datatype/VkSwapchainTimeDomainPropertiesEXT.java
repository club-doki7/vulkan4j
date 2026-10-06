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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainTimeDomainPropertiesEXT.html"><code>VkSwapchainTimeDomainPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSwapchainTimeDomainPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t timeDomainCount; // @link substring="timeDomainCount" target="#timeDomainCount"
///     VkTimeDomainKHR* pTimeDomains; // @link substring="VkTimeDomainKHR" target="VkTimeDomainKHR" @link substring="pTimeDomains" target="#pTimeDomains"
///     uint64_t* pTimeDomainIds; // @link substring="pTimeDomainIds" target="#pTimeDomainIds"
/// } VkSwapchainTimeDomainPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SWAPCHAIN_TIME_DOMAIN_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkSwapchainTimeDomainPropertiesEXT#allocate(Arena)}, {@link VkSwapchainTimeDomainPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSwapchainTimeDomainPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainTimeDomainPropertiesEXT.html"><code>VkSwapchainTimeDomainPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSwapchainTimeDomainPropertiesEXT(@NotNull MemorySegment segment) implements IVkSwapchainTimeDomainPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainTimeDomainPropertiesEXT.html"><code>VkSwapchainTimeDomainPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSwapchainTimeDomainPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSwapchainTimeDomainPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSwapchainTimeDomainPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSwapchainTimeDomainPropertiesEXT, Iterable<VkSwapchainTimeDomainPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkSwapchainTimeDomainPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSwapchainTimeDomainPropertiesEXT at(long index) {
            return new VkSwapchainTimeDomainPropertiesEXT(segment.asSlice(index * VkSwapchainTimeDomainPropertiesEXT.BYTES, VkSwapchainTimeDomainPropertiesEXT.BYTES));
        }

        public VkSwapchainTimeDomainPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkSwapchainTimeDomainPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSwapchainTimeDomainPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkSwapchainTimeDomainPropertiesEXT.BYTES, VkSwapchainTimeDomainPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSwapchainTimeDomainPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSwapchainTimeDomainPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSwapchainTimeDomainPropertiesEXT.BYTES,
                (end - start) * VkSwapchainTimeDomainPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSwapchainTimeDomainPropertiesEXT.BYTES));
        }

        public VkSwapchainTimeDomainPropertiesEXT[] toArray() {
            VkSwapchainTimeDomainPropertiesEXT[] ret = new VkSwapchainTimeDomainPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSwapchainTimeDomainPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSwapchainTimeDomainPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSwapchainTimeDomainPropertiesEXT.BYTES;
            }

            @Override
            public VkSwapchainTimeDomainPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSwapchainTimeDomainPropertiesEXT ret = new VkSwapchainTimeDomainPropertiesEXT(segment.asSlice(0, VkSwapchainTimeDomainPropertiesEXT.BYTES));
                segment = segment.asSlice(VkSwapchainTimeDomainPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSwapchainTimeDomainPropertiesEXT allocate(Arena arena) {
        VkSwapchainTimeDomainPropertiesEXT ret = new VkSwapchainTimeDomainPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SWAPCHAIN_TIME_DOMAIN_PROPERTIES_EXT);
        return ret;
    }

    public static VkSwapchainTimeDomainPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSwapchainTimeDomainPropertiesEXT.Ptr ret = new VkSwapchainTimeDomainPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SWAPCHAIN_TIME_DOMAIN_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkSwapchainTimeDomainPropertiesEXT clone(Arena arena, VkSwapchainTimeDomainPropertiesEXT src) {
        VkSwapchainTimeDomainPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SWAPCHAIN_TIME_DOMAIN_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSwapchainTimeDomainPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSwapchainTimeDomainPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSwapchainTimeDomainPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int timeDomainCount() {
        return segment.get(LAYOUT$timeDomainCount, OFFSET$timeDomainCount);
    }

    public VkSwapchainTimeDomainPropertiesEXT timeDomainCount(@Unsigned int value) {
        segment.set(LAYOUT$timeDomainCount, OFFSET$timeDomainCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkTimeDomainKHR.class) IntPtr pTimeDomains() {
        MemorySegment s = pTimeDomainsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkSwapchainTimeDomainPropertiesEXT pTimeDomains(@Nullable @EnumType(VkTimeDomainKHR.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTimeDomainsRaw(s);
        return this;
    }

    public @Pointer(target=VkTimeDomainKHR.class) @NotNull MemorySegment pTimeDomainsRaw() {
        return segment.get(LAYOUT$pTimeDomains, OFFSET$pTimeDomains);
    }

    public void pTimeDomainsRaw(@Pointer(target=VkTimeDomainKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTimeDomains, OFFSET$pTimeDomains, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pTimeDomainIds() {
        MemorySegment s = pTimeDomainIdsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkSwapchainTimeDomainPropertiesEXT pTimeDomainIds(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTimeDomainIdsRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pTimeDomainIdsRaw() {
        return segment.get(LAYOUT$pTimeDomainIds, OFFSET$pTimeDomainIds);
    }

    public void pTimeDomainIdsRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTimeDomainIds, OFFSET$pTimeDomainIds, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("timeDomainCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pTimeDomains"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pTimeDomainIds")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$timeDomainCount = PathElement.groupElement("timeDomainCount");
    public static final PathElement PATH$pTimeDomains = PathElement.groupElement("pTimeDomains");
    public static final PathElement PATH$pTimeDomainIds = PathElement.groupElement("pTimeDomainIds");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$timeDomainCount = (OfInt) LAYOUT.select(PATH$timeDomainCount);
    public static final AddressLayout LAYOUT$pTimeDomains = (AddressLayout) LAYOUT.select(PATH$pTimeDomains);
    public static final AddressLayout LAYOUT$pTimeDomainIds = (AddressLayout) LAYOUT.select(PATH$pTimeDomainIds);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$timeDomainCount = LAYOUT$timeDomainCount.byteSize();
    public static final long SIZE$pTimeDomains = LAYOUT$pTimeDomains.byteSize();
    public static final long SIZE$pTimeDomainIds = LAYOUT$pTimeDomainIds.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$timeDomainCount = LAYOUT.byteOffset(PATH$timeDomainCount);
    public static final long OFFSET$pTimeDomains = LAYOUT.byteOffset(PATH$pTimeDomains);
    public static final long OFFSET$pTimeDomainIds = LAYOUT.byteOffset(PATH$pTimeDomainIds);
}
