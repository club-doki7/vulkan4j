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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMutableDescriptorTypeListEXT.html"><code>VkMutableDescriptorTypeListEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMutableDescriptorTypeListEXT {
///     uint32_t descriptorTypeCount; // optional // @link substring="descriptorTypeCount" target="#descriptorTypeCount"
///     VkDescriptorType const* pDescriptorTypes; // optional // @link substring="VkDescriptorType" target="VkDescriptorType" @link substring="pDescriptorTypes" target="#pDescriptorTypes"
/// } VkMutableDescriptorTypeListEXT;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMutableDescriptorTypeListEXT.html"><code>VkMutableDescriptorTypeListEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMutableDescriptorTypeListEXT(@NotNull MemorySegment segment) implements IVkMutableDescriptorTypeListEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMutableDescriptorTypeListEXT.html"><code>VkMutableDescriptorTypeListEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMutableDescriptorTypeListEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMutableDescriptorTypeListEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMutableDescriptorTypeListEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMutableDescriptorTypeListEXT, Iterable<VkMutableDescriptorTypeListEXT> {
        public long size() {
            return segment.byteSize() / VkMutableDescriptorTypeListEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMutableDescriptorTypeListEXT at(long index) {
            return new VkMutableDescriptorTypeListEXT(segment.asSlice(index * VkMutableDescriptorTypeListEXT.BYTES, VkMutableDescriptorTypeListEXT.BYTES));
        }

        public VkMutableDescriptorTypeListEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkMutableDescriptorTypeListEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMutableDescriptorTypeListEXT value) {
            MemorySegment s = segment.asSlice(index * VkMutableDescriptorTypeListEXT.BYTES, VkMutableDescriptorTypeListEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMutableDescriptorTypeListEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMutableDescriptorTypeListEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMutableDescriptorTypeListEXT.BYTES,
                (end - start) * VkMutableDescriptorTypeListEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMutableDescriptorTypeListEXT.BYTES));
        }

        public VkMutableDescriptorTypeListEXT[] toArray() {
            VkMutableDescriptorTypeListEXT[] ret = new VkMutableDescriptorTypeListEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMutableDescriptorTypeListEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMutableDescriptorTypeListEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMutableDescriptorTypeListEXT.BYTES;
            }

            @Override
            public VkMutableDescriptorTypeListEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMutableDescriptorTypeListEXT ret = new VkMutableDescriptorTypeListEXT(segment.asSlice(0, VkMutableDescriptorTypeListEXT.BYTES));
                segment = segment.asSlice(VkMutableDescriptorTypeListEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMutableDescriptorTypeListEXT allocate(Arena arena) {
        return new VkMutableDescriptorTypeListEXT(arena.allocate(LAYOUT));
    }

    public static VkMutableDescriptorTypeListEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkMutableDescriptorTypeListEXT.Ptr(segment);
    }

    public static VkMutableDescriptorTypeListEXT clone(Arena arena, VkMutableDescriptorTypeListEXT src) {
        VkMutableDescriptorTypeListEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int descriptorTypeCount() {
        return segment.get(LAYOUT$descriptorTypeCount, OFFSET$descriptorTypeCount);
    }

    public VkMutableDescriptorTypeListEXT descriptorTypeCount(@Unsigned int value) {
        segment.set(LAYOUT$descriptorTypeCount, OFFSET$descriptorTypeCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkDescriptorType.class) IntPtr pDescriptorTypes() {
        MemorySegment s = pDescriptorTypesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkMutableDescriptorTypeListEXT pDescriptorTypes(@Nullable @EnumType(VkDescriptorType.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDescriptorTypesRaw(s);
        return this;
    }

    public @Pointer(target=VkDescriptorType.class) @NotNull MemorySegment pDescriptorTypesRaw() {
        return segment.get(LAYOUT$pDescriptorTypes, OFFSET$pDescriptorTypes);
    }

    public void pDescriptorTypesRaw(@Pointer(target=VkDescriptorType.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDescriptorTypes, OFFSET$pDescriptorTypes, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("descriptorTypeCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDescriptorTypes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$descriptorTypeCount = PathElement.groupElement("descriptorTypeCount");
    public static final PathElement PATH$pDescriptorTypes = PathElement.groupElement("pDescriptorTypes");

    public static final OfInt LAYOUT$descriptorTypeCount = (OfInt) LAYOUT.select(PATH$descriptorTypeCount);
    public static final AddressLayout LAYOUT$pDescriptorTypes = (AddressLayout) LAYOUT.select(PATH$pDescriptorTypes);

    public static final long SIZE$descriptorTypeCount = LAYOUT$descriptorTypeCount.byteSize();
    public static final long SIZE$pDescriptorTypes = LAYOUT$pDescriptorTypes.byteSize();

    public static final long OFFSET$descriptorTypeCount = LAYOUT.byteOffset(PATH$descriptorTypeCount);
    public static final long OFFSET$pDescriptorTypes = LAYOUT.byteOffset(PATH$pDescriptorTypes);
}
