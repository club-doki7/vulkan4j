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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFlagsEXT.html"><code>VkValidationFlagsEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkValidationFlagsEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t disabledValidationCheckCount; // @link substring="disabledValidationCheckCount" target="#disabledValidationCheckCount"
///     VkValidationCheckEXT const* pDisabledValidationChecks; // @link substring="VkValidationCheckEXT" target="VkValidationCheckEXT" @link substring="pDisabledValidationChecks" target="#pDisabledValidationChecks"
/// } VkValidationFlagsEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VALIDATION_FLAGS_EXT`
///
/// The {@code allocate} ({@link VkValidationFlagsEXT#allocate(Arena)}, {@link VkValidationFlagsEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkValidationFlagsEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFlagsEXT.html"><code>VkValidationFlagsEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkValidationFlagsEXT(@NotNull MemorySegment segment) implements IVkValidationFlagsEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFlagsEXT.html"><code>VkValidationFlagsEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkValidationFlagsEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkValidationFlagsEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkValidationFlagsEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkValidationFlagsEXT, Iterable<VkValidationFlagsEXT> {
        public long size() {
            return segment.byteSize() / VkValidationFlagsEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkValidationFlagsEXT at(long index) {
            return new VkValidationFlagsEXT(segment.asSlice(index * VkValidationFlagsEXT.BYTES, VkValidationFlagsEXT.BYTES));
        }

        public VkValidationFlagsEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkValidationFlagsEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkValidationFlagsEXT value) {
            MemorySegment s = segment.asSlice(index * VkValidationFlagsEXT.BYTES, VkValidationFlagsEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkValidationFlagsEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkValidationFlagsEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkValidationFlagsEXT.BYTES,
                (end - start) * VkValidationFlagsEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkValidationFlagsEXT.BYTES));
        }

        public VkValidationFlagsEXT[] toArray() {
            VkValidationFlagsEXT[] ret = new VkValidationFlagsEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkValidationFlagsEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkValidationFlagsEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkValidationFlagsEXT.BYTES;
            }

            @Override
            public VkValidationFlagsEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkValidationFlagsEXT ret = new VkValidationFlagsEXT(segment.asSlice(0, VkValidationFlagsEXT.BYTES));
                segment = segment.asSlice(VkValidationFlagsEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkValidationFlagsEXT allocate(Arena arena) {
        VkValidationFlagsEXT ret = new VkValidationFlagsEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VALIDATION_FLAGS_EXT);
        return ret;
    }

    public static VkValidationFlagsEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkValidationFlagsEXT.Ptr ret = new VkValidationFlagsEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VALIDATION_FLAGS_EXT);
        }
        return ret;
    }

    public static VkValidationFlagsEXT clone(Arena arena, VkValidationFlagsEXT src) {
        VkValidationFlagsEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VALIDATION_FLAGS_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkValidationFlagsEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkValidationFlagsEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkValidationFlagsEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int disabledValidationCheckCount() {
        return segment.get(LAYOUT$disabledValidationCheckCount, OFFSET$disabledValidationCheckCount);
    }

    public VkValidationFlagsEXT disabledValidationCheckCount(@Unsigned int value) {
        segment.set(LAYOUT$disabledValidationCheckCount, OFFSET$disabledValidationCheckCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkValidationCheckEXT.class) IntPtr pDisabledValidationChecks() {
        MemorySegment s = pDisabledValidationChecksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkValidationFlagsEXT pDisabledValidationChecks(@Nullable @EnumType(VkValidationCheckEXT.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDisabledValidationChecksRaw(s);
        return this;
    }

    public @Pointer(target=VkValidationCheckEXT.class) @NotNull MemorySegment pDisabledValidationChecksRaw() {
        return segment.get(LAYOUT$pDisabledValidationChecks, OFFSET$pDisabledValidationChecks);
    }

    public void pDisabledValidationChecksRaw(@Pointer(target=VkValidationCheckEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDisabledValidationChecks, OFFSET$pDisabledValidationChecks, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("disabledValidationCheckCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDisabledValidationChecks")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$disabledValidationCheckCount = PathElement.groupElement("disabledValidationCheckCount");
    public static final PathElement PATH$pDisabledValidationChecks = PathElement.groupElement("pDisabledValidationChecks");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$disabledValidationCheckCount = (OfInt) LAYOUT.select(PATH$disabledValidationCheckCount);
    public static final AddressLayout LAYOUT$pDisabledValidationChecks = (AddressLayout) LAYOUT.select(PATH$pDisabledValidationChecks);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$disabledValidationCheckCount = LAYOUT$disabledValidationCheckCount.byteSize();
    public static final long SIZE$pDisabledValidationChecks = LAYOUT$pDisabledValidationChecks.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$disabledValidationCheckCount = LAYOUT.byteOffset(PATH$disabledValidationCheckCount);
    public static final long OFFSET$pDisabledValidationChecks = LAYOUT.byteOffset(PATH$pDisabledValidationChecks);
}
