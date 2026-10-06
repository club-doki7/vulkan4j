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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkApplicationInfo.html"><code>VkApplicationInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkApplicationInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     char const* pApplicationName; // optional // @link substring="pApplicationName" target="#pApplicationName"
///     uint32_t applicationVersion; // @link substring="applicationVersion" target="#applicationVersion"
///     char const* pEngineName; // optional // @link substring="pEngineName" target="#pEngineName"
///     uint32_t engineVersion; // @link substring="engineVersion" target="#engineVersion"
///     uint32_t apiVersion; // @link substring="apiVersion" target="#apiVersion"
/// } VkApplicationInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_APPLICATION_INFO`
///
/// The {@code allocate} ({@link VkApplicationInfo#allocate(Arena)}, {@link VkApplicationInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkApplicationInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkApplicationInfo.html"><code>VkApplicationInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkApplicationInfo(@NotNull MemorySegment segment) implements IVkApplicationInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkApplicationInfo.html"><code>VkApplicationInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkApplicationInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkApplicationInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkApplicationInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkApplicationInfo, Iterable<VkApplicationInfo> {
        public long size() {
            return segment.byteSize() / VkApplicationInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkApplicationInfo at(long index) {
            return new VkApplicationInfo(segment.asSlice(index * VkApplicationInfo.BYTES, VkApplicationInfo.BYTES));
        }

        public VkApplicationInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkApplicationInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkApplicationInfo value) {
            MemorySegment s = segment.asSlice(index * VkApplicationInfo.BYTES, VkApplicationInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkApplicationInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkApplicationInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkApplicationInfo.BYTES,
                (end - start) * VkApplicationInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkApplicationInfo.BYTES));
        }

        public VkApplicationInfo[] toArray() {
            VkApplicationInfo[] ret = new VkApplicationInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkApplicationInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkApplicationInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkApplicationInfo.BYTES;
            }

            @Override
            public VkApplicationInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkApplicationInfo ret = new VkApplicationInfo(segment.asSlice(0, VkApplicationInfo.BYTES));
                segment = segment.asSlice(VkApplicationInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkApplicationInfo allocate(Arena arena) {
        VkApplicationInfo ret = new VkApplicationInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.APPLICATION_INFO);
        return ret;
    }

    public static VkApplicationInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkApplicationInfo.Ptr ret = new VkApplicationInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.APPLICATION_INFO);
        }
        return ret;
    }

    public static VkApplicationInfo clone(Arena arena, VkApplicationInfo src) {
        VkApplicationInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.APPLICATION_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkApplicationInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkApplicationInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkApplicationInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pApplicationName() {
        MemorySegment s = pApplicationNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkApplicationInfo pApplicationName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pApplicationNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pApplicationNameRaw() {
        return segment.get(LAYOUT$pApplicationName, OFFSET$pApplicationName);
    }

    public void pApplicationNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pApplicationName, OFFSET$pApplicationName, value);
    }

    public @Unsigned int applicationVersion() {
        return segment.get(LAYOUT$applicationVersion, OFFSET$applicationVersion);
    }

    public VkApplicationInfo applicationVersion(@Unsigned int value) {
        segment.set(LAYOUT$applicationVersion, OFFSET$applicationVersion, value);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pEngineName() {
        MemorySegment s = pEngineNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkApplicationInfo pEngineName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pEngineNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pEngineNameRaw() {
        return segment.get(LAYOUT$pEngineName, OFFSET$pEngineName);
    }

    public void pEngineNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pEngineName, OFFSET$pEngineName, value);
    }

    public @Unsigned int engineVersion() {
        return segment.get(LAYOUT$engineVersion, OFFSET$engineVersion);
    }

    public VkApplicationInfo engineVersion(@Unsigned int value) {
        segment.set(LAYOUT$engineVersion, OFFSET$engineVersion, value);
        return this;
    }

    public @Unsigned int apiVersion() {
        return segment.get(LAYOUT$apiVersion, OFFSET$apiVersion);
    }

    public VkApplicationInfo apiVersion(@Unsigned int value) {
        segment.set(LAYOUT$apiVersion, OFFSET$apiVersion, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pApplicationName"),
        ValueLayout.JAVA_INT.withName("applicationVersion"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pEngineName"),
        ValueLayout.JAVA_INT.withName("engineVersion"),
        ValueLayout.JAVA_INT.withName("apiVersion")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pApplicationName = PathElement.groupElement("pApplicationName");
    public static final PathElement PATH$applicationVersion = PathElement.groupElement("applicationVersion");
    public static final PathElement PATH$pEngineName = PathElement.groupElement("pEngineName");
    public static final PathElement PATH$engineVersion = PathElement.groupElement("engineVersion");
    public static final PathElement PATH$apiVersion = PathElement.groupElement("apiVersion");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pApplicationName = (AddressLayout) LAYOUT.select(PATH$pApplicationName);
    public static final OfInt LAYOUT$applicationVersion = (OfInt) LAYOUT.select(PATH$applicationVersion);
    public static final AddressLayout LAYOUT$pEngineName = (AddressLayout) LAYOUT.select(PATH$pEngineName);
    public static final OfInt LAYOUT$engineVersion = (OfInt) LAYOUT.select(PATH$engineVersion);
    public static final OfInt LAYOUT$apiVersion = (OfInt) LAYOUT.select(PATH$apiVersion);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pApplicationName = LAYOUT$pApplicationName.byteSize();
    public static final long SIZE$applicationVersion = LAYOUT$applicationVersion.byteSize();
    public static final long SIZE$pEngineName = LAYOUT$pEngineName.byteSize();
    public static final long SIZE$engineVersion = LAYOUT$engineVersion.byteSize();
    public static final long SIZE$apiVersion = LAYOUT$apiVersion.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pApplicationName = LAYOUT.byteOffset(PATH$pApplicationName);
    public static final long OFFSET$applicationVersion = LAYOUT.byteOffset(PATH$applicationVersion);
    public static final long OFFSET$pEngineName = LAYOUT.byteOffset(PATH$pEngineName);
    public static final long OFFSET$engineVersion = LAYOUT.byteOffset(PATH$engineVersion);
    public static final long OFFSET$apiVersion = LAYOUT.byteOffset(PATH$apiVersion);
}
