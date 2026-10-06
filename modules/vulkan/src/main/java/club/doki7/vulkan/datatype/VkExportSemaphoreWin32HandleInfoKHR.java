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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExportSemaphoreWin32HandleInfoKHR.html"><code>VkExportSemaphoreWin32HandleInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkExportSemaphoreWin32HandleInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     SECURITY_ATTRIBUTES const* pAttributes; // optional // @link substring="pAttributes" target="#pAttributes"
///     DWORD dwAccess; // @link substring="dwAccess" target="#dwAccess"
///     LPCWSTR name; // @link substring="name" target="#name"
/// } VkExportSemaphoreWin32HandleInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR`
///
/// The {@code allocate} ({@link VkExportSemaphoreWin32HandleInfoKHR#allocate(Arena)}, {@link VkExportSemaphoreWin32HandleInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkExportSemaphoreWin32HandleInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExportSemaphoreWin32HandleInfoKHR.html"><code>VkExportSemaphoreWin32HandleInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkExportSemaphoreWin32HandleInfoKHR(@NotNull MemorySegment segment) implements IVkExportSemaphoreWin32HandleInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExportSemaphoreWin32HandleInfoKHR.html"><code>VkExportSemaphoreWin32HandleInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkExportSemaphoreWin32HandleInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkExportSemaphoreWin32HandleInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkExportSemaphoreWin32HandleInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkExportSemaphoreWin32HandleInfoKHR, Iterable<VkExportSemaphoreWin32HandleInfoKHR> {
        public long size() {
            return segment.byteSize() / VkExportSemaphoreWin32HandleInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkExportSemaphoreWin32HandleInfoKHR at(long index) {
            return new VkExportSemaphoreWin32HandleInfoKHR(segment.asSlice(index * VkExportSemaphoreWin32HandleInfoKHR.BYTES, VkExportSemaphoreWin32HandleInfoKHR.BYTES));
        }

        public VkExportSemaphoreWin32HandleInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkExportSemaphoreWin32HandleInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkExportSemaphoreWin32HandleInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkExportSemaphoreWin32HandleInfoKHR.BYTES, VkExportSemaphoreWin32HandleInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkExportSemaphoreWin32HandleInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkExportSemaphoreWin32HandleInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkExportSemaphoreWin32HandleInfoKHR.BYTES,
                (end - start) * VkExportSemaphoreWin32HandleInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkExportSemaphoreWin32HandleInfoKHR.BYTES));
        }

        public VkExportSemaphoreWin32HandleInfoKHR[] toArray() {
            VkExportSemaphoreWin32HandleInfoKHR[] ret = new VkExportSemaphoreWin32HandleInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkExportSemaphoreWin32HandleInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkExportSemaphoreWin32HandleInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkExportSemaphoreWin32HandleInfoKHR.BYTES;
            }

            @Override
            public VkExportSemaphoreWin32HandleInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkExportSemaphoreWin32HandleInfoKHR ret = new VkExportSemaphoreWin32HandleInfoKHR(segment.asSlice(0, VkExportSemaphoreWin32HandleInfoKHR.BYTES));
                segment = segment.asSlice(VkExportSemaphoreWin32HandleInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkExportSemaphoreWin32HandleInfoKHR allocate(Arena arena) {
        VkExportSemaphoreWin32HandleInfoKHR ret = new VkExportSemaphoreWin32HandleInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR);
        return ret;
    }

    public static VkExportSemaphoreWin32HandleInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkExportSemaphoreWin32HandleInfoKHR.Ptr ret = new VkExportSemaphoreWin32HandleInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR);
        }
        return ret;
    }

    public static VkExportSemaphoreWin32HandleInfoKHR clone(Arena arena, VkExportSemaphoreWin32HandleInfoKHR src) {
        VkExportSemaphoreWin32HandleInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkExportSemaphoreWin32HandleInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkExportSemaphoreWin32HandleInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkExportSemaphoreWin32HandleInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pAttributes() {
        return segment.get(LAYOUT$pAttributes, OFFSET$pAttributes);
    }

    public VkExportSemaphoreWin32HandleInfoKHR pAttributes(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAttributes, OFFSET$pAttributes, value);
        return this;
    }

    public VkExportSemaphoreWin32HandleInfoKHR pAttributes(@Nullable IPointer pointer) {
        pAttributes(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("DWORD") @Unsigned int dwAccess() {
        return segment.get(LAYOUT$dwAccess, OFFSET$dwAccess);
    }

    public VkExportSemaphoreWin32HandleInfoKHR dwAccess(@NativeType("DWORD") @Unsigned int value) {
        segment.set(LAYOUT$dwAccess, OFFSET$dwAccess, value);
        return this;
    }

    /// Note: the returned {@link ShortPtr} does not have correct
    /// {@link ShortPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link ShortPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned ShortPtr name() {
        MemorySegment s = nameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new ShortPtr(s);
    }

    public VkExportSemaphoreWin32HandleInfoKHR name(@Nullable @Unsigned ShortPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        nameRaw(s);
        return this;
    }

    public @Pointer(comment="uint16_t*") @NotNull MemorySegment nameRaw() {
        return segment.get(LAYOUT$name, OFFSET$name);
    }

    public void nameRaw(@Pointer(comment="uint16_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$name, OFFSET$name, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("pAttributes"),
        ValueLayout.JAVA_INT.withName("dwAccess"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT).withName("name")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pAttributes = PathElement.groupElement("pAttributes");
    public static final PathElement PATH$dwAccess = PathElement.groupElement("dwAccess");
    public static final PathElement PATH$name = PathElement.groupElement("name");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pAttributes = (AddressLayout) LAYOUT.select(PATH$pAttributes);
    public static final OfInt LAYOUT$dwAccess = (OfInt) LAYOUT.select(PATH$dwAccess);
    public static final AddressLayout LAYOUT$name = (AddressLayout) LAYOUT.select(PATH$name);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pAttributes = LAYOUT$pAttributes.byteSize();
    public static final long SIZE$dwAccess = LAYOUT$dwAccess.byteSize();
    public static final long SIZE$name = LAYOUT$name.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pAttributes = LAYOUT.byteOffset(PATH$pAttributes);
    public static final long OFFSET$dwAccess = LAYOUT.byteOffset(PATH$dwAccess);
    public static final long OFFSET$name = LAYOUT.byteOffset(PATH$name);
}
