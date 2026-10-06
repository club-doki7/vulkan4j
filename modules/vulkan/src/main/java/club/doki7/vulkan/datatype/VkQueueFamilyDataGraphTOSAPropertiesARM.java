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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphTOSAPropertiesARM.html"><code>VkQueueFamilyDataGraphTOSAPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkQueueFamilyDataGraphTOSAPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t profileCount; // @link substring="profileCount" target="#profileCount"
///     VkDataGraphTOSANameQualityARM const* pProfiles; // @link substring="VkDataGraphTOSANameQualityARM" target="VkDataGraphTOSANameQualityARM" @link substring="pProfiles" target="#pProfiles"
///     uint32_t extensionCount; // @link substring="extensionCount" target="#extensionCount"
///     VkDataGraphTOSANameQualityARM const* pExtensions; // @link substring="VkDataGraphTOSANameQualityARM" target="VkDataGraphTOSANameQualityARM" @link substring="pExtensions" target="#pExtensions"
///     VkDataGraphTOSALevelARM level; // @link substring="VkDataGraphTOSALevelARM" target="VkDataGraphTOSALevelARM" @link substring="level" target="#level"
/// } VkQueueFamilyDataGraphTOSAPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_QUEUE_FAMILY_DATA_GRAPH_TOSA_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkQueueFamilyDataGraphTOSAPropertiesARM#allocate(Arena)}, {@link VkQueueFamilyDataGraphTOSAPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkQueueFamilyDataGraphTOSAPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphTOSAPropertiesARM.html"><code>VkQueueFamilyDataGraphTOSAPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkQueueFamilyDataGraphTOSAPropertiesARM(@NotNull MemorySegment segment) implements IVkQueueFamilyDataGraphTOSAPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphTOSAPropertiesARM.html"><code>VkQueueFamilyDataGraphTOSAPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkQueueFamilyDataGraphTOSAPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkQueueFamilyDataGraphTOSAPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkQueueFamilyDataGraphTOSAPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkQueueFamilyDataGraphTOSAPropertiesARM, Iterable<VkQueueFamilyDataGraphTOSAPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkQueueFamilyDataGraphTOSAPropertiesARM at(long index) {
            return new VkQueueFamilyDataGraphTOSAPropertiesARM(segment.asSlice(index * VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES, VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES));
        }

        public VkQueueFamilyDataGraphTOSAPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkQueueFamilyDataGraphTOSAPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkQueueFamilyDataGraphTOSAPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES, VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES,
                (end - start) * VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES));
        }

        public VkQueueFamilyDataGraphTOSAPropertiesARM[] toArray() {
            VkQueueFamilyDataGraphTOSAPropertiesARM[] ret = new VkQueueFamilyDataGraphTOSAPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkQueueFamilyDataGraphTOSAPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkQueueFamilyDataGraphTOSAPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES;
            }

            @Override
            public VkQueueFamilyDataGraphTOSAPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkQueueFamilyDataGraphTOSAPropertiesARM ret = new VkQueueFamilyDataGraphTOSAPropertiesARM(segment.asSlice(0, VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES));
                segment = segment.asSlice(VkQueueFamilyDataGraphTOSAPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkQueueFamilyDataGraphTOSAPropertiesARM allocate(Arena arena) {
        VkQueueFamilyDataGraphTOSAPropertiesARM ret = new VkQueueFamilyDataGraphTOSAPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_TOSA_PROPERTIES_ARM);
        return ret;
    }

    public static VkQueueFamilyDataGraphTOSAPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkQueueFamilyDataGraphTOSAPropertiesARM.Ptr ret = new VkQueueFamilyDataGraphTOSAPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_TOSA_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkQueueFamilyDataGraphTOSAPropertiesARM clone(Arena arena, VkQueueFamilyDataGraphTOSAPropertiesARM src) {
        VkQueueFamilyDataGraphTOSAPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_TOSA_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int profileCount() {
        return segment.get(LAYOUT$profileCount, OFFSET$profileCount);
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM profileCount(@Unsigned int value) {
        segment.set(LAYOUT$profileCount, OFFSET$profileCount, value);
        return this;
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM pProfiles(@Nullable IVkDataGraphTOSANameQualityARM value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pProfilesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDataGraphTOSANameQualityARM.Ptr pProfiles(int assumedCount) {
        MemorySegment s = pProfilesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDataGraphTOSANameQualityARM.BYTES);
        return new VkDataGraphTOSANameQualityARM.Ptr(s);
    }

    public @Nullable VkDataGraphTOSANameQualityARM pProfiles() {
        MemorySegment s = pProfilesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDataGraphTOSANameQualityARM(s);
    }

    public @Pointer(target=VkDataGraphTOSANameQualityARM.class) @NotNull MemorySegment pProfilesRaw() {
        return segment.get(LAYOUT$pProfiles, OFFSET$pProfiles);
    }

    public void pProfilesRaw(@Pointer(target=VkDataGraphTOSANameQualityARM.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pProfiles, OFFSET$pProfiles, value);
    }

    public @Unsigned int extensionCount() {
        return segment.get(LAYOUT$extensionCount, OFFSET$extensionCount);
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM extensionCount(@Unsigned int value) {
        segment.set(LAYOUT$extensionCount, OFFSET$extensionCount, value);
        return this;
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM pExtensions(@Nullable IVkDataGraphTOSANameQualityARM value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pExtensionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDataGraphTOSANameQualityARM.Ptr pExtensions(int assumedCount) {
        MemorySegment s = pExtensionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDataGraphTOSANameQualityARM.BYTES);
        return new VkDataGraphTOSANameQualityARM.Ptr(s);
    }

    public @Nullable VkDataGraphTOSANameQualityARM pExtensions() {
        MemorySegment s = pExtensionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDataGraphTOSANameQualityARM(s);
    }

    public @Pointer(target=VkDataGraphTOSANameQualityARM.class) @NotNull MemorySegment pExtensionsRaw() {
        return segment.get(LAYOUT$pExtensions, OFFSET$pExtensions);
    }

    public void pExtensionsRaw(@Pointer(target=VkDataGraphTOSANameQualityARM.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pExtensions, OFFSET$pExtensions, value);
    }

    public @EnumType(VkDataGraphTOSALevelARM.class) int level() {
        return segment.get(LAYOUT$level, OFFSET$level);
    }

    public VkQueueFamilyDataGraphTOSAPropertiesARM level(@EnumType(VkDataGraphTOSALevelARM.class) int value) {
        segment.set(LAYOUT$level, OFFSET$level, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("profileCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDataGraphTOSANameQualityARM.LAYOUT).withName("pProfiles"),
        ValueLayout.JAVA_INT.withName("extensionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDataGraphTOSANameQualityARM.LAYOUT).withName("pExtensions"),
        ValueLayout.JAVA_INT.withName("level")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$profileCount = PathElement.groupElement("profileCount");
    public static final PathElement PATH$pProfiles = PathElement.groupElement("pProfiles");
    public static final PathElement PATH$extensionCount = PathElement.groupElement("extensionCount");
    public static final PathElement PATH$pExtensions = PathElement.groupElement("pExtensions");
    public static final PathElement PATH$level = PathElement.groupElement("level");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$profileCount = (OfInt) LAYOUT.select(PATH$profileCount);
    public static final AddressLayout LAYOUT$pProfiles = (AddressLayout) LAYOUT.select(PATH$pProfiles);
    public static final OfInt LAYOUT$extensionCount = (OfInt) LAYOUT.select(PATH$extensionCount);
    public static final AddressLayout LAYOUT$pExtensions = (AddressLayout) LAYOUT.select(PATH$pExtensions);
    public static final OfInt LAYOUT$level = (OfInt) LAYOUT.select(PATH$level);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$profileCount = LAYOUT$profileCount.byteSize();
    public static final long SIZE$pProfiles = LAYOUT$pProfiles.byteSize();
    public static final long SIZE$extensionCount = LAYOUT$extensionCount.byteSize();
    public static final long SIZE$pExtensions = LAYOUT$pExtensions.byteSize();
    public static final long SIZE$level = LAYOUT$level.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$profileCount = LAYOUT.byteOffset(PATH$profileCount);
    public static final long OFFSET$pProfiles = LAYOUT.byteOffset(PATH$pProfiles);
    public static final long OFFSET$extensionCount = LAYOUT.byteOffset(PATH$extensionCount);
    public static final long OFFSET$pExtensions = LAYOUT.byteOffset(PATH$pExtensions);
    public static final long OFFSET$level = LAYOUT.byteOffset(PATH$level);
}
