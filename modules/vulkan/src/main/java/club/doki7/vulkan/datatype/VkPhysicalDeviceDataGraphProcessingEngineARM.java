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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphProcessingEngineARM.html"><code>VkPhysicalDeviceDataGraphProcessingEngineARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDataGraphProcessingEngineARM {
///     VkPhysicalDeviceDataGraphProcessingEngineTypeARM type; // @link substring="VkPhysicalDeviceDataGraphProcessingEngineTypeARM" target="VkPhysicalDeviceDataGraphProcessingEngineTypeARM" @link substring="type" target="#type"
///     VkBool32 isForeign; // @link substring="isForeign" target="#isForeign"
/// } VkPhysicalDeviceDataGraphProcessingEngineARM;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphProcessingEngineARM.html"><code>VkPhysicalDeviceDataGraphProcessingEngineARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDataGraphProcessingEngineARM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDataGraphProcessingEngineARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphProcessingEngineARM.html"><code>VkPhysicalDeviceDataGraphProcessingEngineARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDataGraphProcessingEngineARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDataGraphProcessingEngineARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDataGraphProcessingEngineARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDataGraphProcessingEngineARM, Iterable<VkPhysicalDeviceDataGraphProcessingEngineARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDataGraphProcessingEngineARM at(long index) {
            return new VkPhysicalDeviceDataGraphProcessingEngineARM(segment.asSlice(index * VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES, VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES));
        }

        public VkPhysicalDeviceDataGraphProcessingEngineARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDataGraphProcessingEngineARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDataGraphProcessingEngineARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES, VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES,
                (end - start) * VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES));
        }

        public VkPhysicalDeviceDataGraphProcessingEngineARM[] toArray() {
            VkPhysicalDeviceDataGraphProcessingEngineARM[] ret = new VkPhysicalDeviceDataGraphProcessingEngineARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDataGraphProcessingEngineARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDataGraphProcessingEngineARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES;
            }

            @Override
            public VkPhysicalDeviceDataGraphProcessingEngineARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDataGraphProcessingEngineARM ret = new VkPhysicalDeviceDataGraphProcessingEngineARM(segment.asSlice(0, VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDataGraphProcessingEngineARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDataGraphProcessingEngineARM allocate(Arena arena) {
        return new VkPhysicalDeviceDataGraphProcessingEngineARM(arena.allocate(LAYOUT));
    }

    public static VkPhysicalDeviceDataGraphProcessingEngineARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPhysicalDeviceDataGraphProcessingEngineARM.Ptr(segment);
    }

    public static VkPhysicalDeviceDataGraphProcessingEngineARM clone(Arena arena, VkPhysicalDeviceDataGraphProcessingEngineARM src) {
        VkPhysicalDeviceDataGraphProcessingEngineARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkPhysicalDeviceDataGraphProcessingEngineTypeARM.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkPhysicalDeviceDataGraphProcessingEngineARM type(@EnumType(VkPhysicalDeviceDataGraphProcessingEngineTypeARM.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int isForeign() {
        return segment.get(LAYOUT$isForeign, OFFSET$isForeign);
    }

    public VkPhysicalDeviceDataGraphProcessingEngineARM isForeign(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$isForeign, OFFSET$isForeign, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("isForeign")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$isForeign = PathElement.groupElement("isForeign");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$isForeign = (OfInt) LAYOUT.select(PATH$isForeign);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$isForeign = LAYOUT$isForeign.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$isForeign = LAYOUT.byteOffset(PATH$isForeign);
}
