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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoSessionParametersCreateInfoKHR.html"><code>VkVideoSessionParametersCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoSessionParametersCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoSessionParametersCreateFlagsKHR flags; // optional // @link substring="VkVideoSessionParametersCreateFlagsKHR" target="VkVideoSessionParametersCreateFlagsKHR" @link substring="flags" target="#flags"
///     VkVideoSessionParametersKHR videoSessionParametersTemplate; // optional // @link substring="VkVideoSessionParametersKHR" target="VkVideoSessionParametersKHR" @link substring="videoSessionParametersTemplate" target="#videoSessionParametersTemplate"
///     VkVideoSessionKHR videoSession; // @link substring="VkVideoSessionKHR" target="VkVideoSessionKHR" @link substring="videoSession" target="#videoSession"
/// } VkVideoSessionParametersCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_SESSION_PARAMETERS_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoSessionParametersCreateInfoKHR#allocate(Arena)}, {@link VkVideoSessionParametersCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoSessionParametersCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoSessionParametersCreateInfoKHR.html"><code>VkVideoSessionParametersCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoSessionParametersCreateInfoKHR(@NotNull MemorySegment segment) implements IVkVideoSessionParametersCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoSessionParametersCreateInfoKHR.html"><code>VkVideoSessionParametersCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoSessionParametersCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoSessionParametersCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoSessionParametersCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoSessionParametersCreateInfoKHR, Iterable<VkVideoSessionParametersCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoSessionParametersCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoSessionParametersCreateInfoKHR at(long index) {
            return new VkVideoSessionParametersCreateInfoKHR(segment.asSlice(index * VkVideoSessionParametersCreateInfoKHR.BYTES, VkVideoSessionParametersCreateInfoKHR.BYTES));
        }

        public VkVideoSessionParametersCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoSessionParametersCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoSessionParametersCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoSessionParametersCreateInfoKHR.BYTES, VkVideoSessionParametersCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoSessionParametersCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoSessionParametersCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoSessionParametersCreateInfoKHR.BYTES,
                (end - start) * VkVideoSessionParametersCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoSessionParametersCreateInfoKHR.BYTES));
        }

        public VkVideoSessionParametersCreateInfoKHR[] toArray() {
            VkVideoSessionParametersCreateInfoKHR[] ret = new VkVideoSessionParametersCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoSessionParametersCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoSessionParametersCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoSessionParametersCreateInfoKHR.BYTES;
            }

            @Override
            public VkVideoSessionParametersCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoSessionParametersCreateInfoKHR ret = new VkVideoSessionParametersCreateInfoKHR(segment.asSlice(0, VkVideoSessionParametersCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoSessionParametersCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoSessionParametersCreateInfoKHR allocate(Arena arena) {
        VkVideoSessionParametersCreateInfoKHR ret = new VkVideoSessionParametersCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_SESSION_PARAMETERS_CREATE_INFO_KHR);
        return ret;
    }

    public static VkVideoSessionParametersCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoSessionParametersCreateInfoKHR.Ptr ret = new VkVideoSessionParametersCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_SESSION_PARAMETERS_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoSessionParametersCreateInfoKHR clone(Arena arena, VkVideoSessionParametersCreateInfoKHR src) {
        VkVideoSessionParametersCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_SESSION_PARAMETERS_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoSessionParametersCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoSessionParametersCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoSessionParametersCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoSessionParametersCreateFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoSessionParametersCreateInfoKHR flags(@Bitmask(VkVideoSessionParametersCreateFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkVideoSessionParametersKHR videoSessionParametersTemplate() {
        MemorySegment s = segment.asSlice(OFFSET$videoSessionParametersTemplate, SIZE$videoSessionParametersTemplate);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVideoSessionParametersKHR(s);
    }

    public VkVideoSessionParametersCreateInfoKHR videoSessionParametersTemplate(@Nullable VkVideoSessionParametersKHR value) {
        segment.set(LAYOUT$videoSessionParametersTemplate, OFFSET$videoSessionParametersTemplate, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkVideoSessionKHR videoSession() {
        MemorySegment s = segment.asSlice(OFFSET$videoSession, SIZE$videoSession);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVideoSessionKHR(s);
    }

    public VkVideoSessionParametersCreateInfoKHR videoSession(@Nullable VkVideoSessionKHR value) {
        segment.set(LAYOUT$videoSession, OFFSET$videoSession, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("videoSessionParametersTemplate"),
        ValueLayout.ADDRESS.withName("videoSession")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$videoSessionParametersTemplate = PathElement.groupElement("videoSessionParametersTemplate");
    public static final PathElement PATH$videoSession = PathElement.groupElement("videoSession");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$videoSessionParametersTemplate = (AddressLayout) LAYOUT.select(PATH$videoSessionParametersTemplate);
    public static final AddressLayout LAYOUT$videoSession = (AddressLayout) LAYOUT.select(PATH$videoSession);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$videoSessionParametersTemplate = LAYOUT$videoSessionParametersTemplate.byteSize();
    public static final long SIZE$videoSession = LAYOUT$videoSession.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$videoSessionParametersTemplate = LAYOUT.byteOffset(PATH$videoSessionParametersTemplate);
    public static final long OFFSET$videoSession = LAYOUT.byteOffset(PATH$videoSession);
}
