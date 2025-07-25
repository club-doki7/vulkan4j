package club.doki7.openxr.datatype;

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
import club.doki7.openxr.bitmask.*;
import club.doki7.openxr.handle.*;
import club.doki7.openxr.enumtype.*;
import static club.doki7.openxr.XRConstants.*;
import club.doki7.openxr.XRFunctionTypes.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSceneComponentsLocateInfoMSFT.html"><code>XrSceneComponentsLocateInfoMSFT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrSceneComponentsLocateInfoMSFT {
///     XrStructureType type; // @link substring="XrStructureType" target="XrStructureType" @link substring="type" target="#type"
///     void const* next; // @link substring="next" target="#next"
///     XrSpace baseSpace; // @link substring="XrSpace" target="XrSpace" @link substring="baseSpace" target="#baseSpace"
///     XrTime time; // @link substring="time" target="#time"
///     uint32_t componentIdCount; // optional // @link substring="componentIdCount" target="#componentIdCount"
///     XrUuidMSFT const* componentIds; // optional // @link substring="XrUuidMSFT" target="XrUuidMSFT" @link substring="componentIds" target="#componentIds"
/// } XrSceneComponentsLocateInfoMSFT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `type = XR_TYPE_SCENE_COMPONENTS_LOCATE_INFO_MSFT`
///
/// The {@code allocate} ({@link XrSceneComponentsLocateInfoMSFT#allocate(Arena)}, {@link XrSceneComponentsLocateInfoMSFT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link XrSceneComponentsLocateInfoMSFT#autoInit}
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSceneComponentsLocateInfoMSFT.html"><code>XrSceneComponentsLocateInfoMSFT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrSceneComponentsLocateInfoMSFT(@NotNull MemorySegment segment) implements IXrSceneComponentsLocateInfoMSFT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSceneComponentsLocateInfoMSFT.html"><code>XrSceneComponentsLocateInfoMSFT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrSceneComponentsLocateInfoMSFT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrSceneComponentsLocateInfoMSFT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrSceneComponentsLocateInfoMSFT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrSceneComponentsLocateInfoMSFT, Iterable<XrSceneComponentsLocateInfoMSFT> {
        public long size() {
            return segment.byteSize() / XrSceneComponentsLocateInfoMSFT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrSceneComponentsLocateInfoMSFT at(long index) {
            return new XrSceneComponentsLocateInfoMSFT(segment.asSlice(index * XrSceneComponentsLocateInfoMSFT.BYTES, XrSceneComponentsLocateInfoMSFT.BYTES));
        }

        public XrSceneComponentsLocateInfoMSFT.Ptr at(long index, @NotNull Consumer<@NotNull XrSceneComponentsLocateInfoMSFT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrSceneComponentsLocateInfoMSFT value) {
            MemorySegment s = segment.asSlice(index * XrSceneComponentsLocateInfoMSFT.BYTES, XrSceneComponentsLocateInfoMSFT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrSceneComponentsLocateInfoMSFT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrSceneComponentsLocateInfoMSFT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrSceneComponentsLocateInfoMSFT.BYTES,
                (end - start) * XrSceneComponentsLocateInfoMSFT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrSceneComponentsLocateInfoMSFT.BYTES));
        }

        public XrSceneComponentsLocateInfoMSFT[] toArray() {
            XrSceneComponentsLocateInfoMSFT[] ret = new XrSceneComponentsLocateInfoMSFT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrSceneComponentsLocateInfoMSFT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrSceneComponentsLocateInfoMSFT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrSceneComponentsLocateInfoMSFT.BYTES;
            }

            @Override
            public XrSceneComponentsLocateInfoMSFT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrSceneComponentsLocateInfoMSFT ret = new XrSceneComponentsLocateInfoMSFT(segment.asSlice(0, XrSceneComponentsLocateInfoMSFT.BYTES));
                segment = segment.asSlice(XrSceneComponentsLocateInfoMSFT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrSceneComponentsLocateInfoMSFT allocate(Arena arena) {
        XrSceneComponentsLocateInfoMSFT ret = new XrSceneComponentsLocateInfoMSFT(arena.allocate(LAYOUT));
        ret.type(XrStructureType.SCENE_COMPONENTS_LOCATE_INFO_MSFT);
        return ret;
    }

    public static XrSceneComponentsLocateInfoMSFT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        XrSceneComponentsLocateInfoMSFT.Ptr ret = new XrSceneComponentsLocateInfoMSFT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).type(XrStructureType.SCENE_COMPONENTS_LOCATE_INFO_MSFT);
        }
        return ret;
    }

    public static XrSceneComponentsLocateInfoMSFT clone(Arena arena, XrSceneComponentsLocateInfoMSFT src) {
        XrSceneComponentsLocateInfoMSFT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        type(XrStructureType.SCENE_COMPONENTS_LOCATE_INFO_MSFT);
    }

    public @EnumType(XrStructureType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public XrSceneComponentsLocateInfoMSFT type(@EnumType(XrStructureType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment next() {
        return segment.get(LAYOUT$next, OFFSET$next);
    }

    public XrSceneComponentsLocateInfoMSFT next(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$next, OFFSET$next, value);
        return this;
    }

    public XrSceneComponentsLocateInfoMSFT next(@Nullable IPointer pointer) {
        next(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable XrSpace baseSpace() {
        MemorySegment s = segment.asSlice(OFFSET$baseSpace, SIZE$baseSpace);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new XrSpace(s);
    }

    public XrSceneComponentsLocateInfoMSFT baseSpace(@Nullable XrSpace value) {
        segment.set(LAYOUT$baseSpace, OFFSET$baseSpace, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("XrTime") long time() {
        return segment.get(LAYOUT$time, OFFSET$time);
    }

    public XrSceneComponentsLocateInfoMSFT time(@NativeType("XrTime") long value) {
        segment.set(LAYOUT$time, OFFSET$time, value);
        return this;
    }

    public @Unsigned int componentIdCount() {
        return segment.get(LAYOUT$componentIdCount, OFFSET$componentIdCount);
    }

    public XrSceneComponentsLocateInfoMSFT componentIdCount(@Unsigned int value) {
        segment.set(LAYOUT$componentIdCount, OFFSET$componentIdCount, value);
        return this;
    }

    public XrSceneComponentsLocateInfoMSFT componentIds(@Nullable IXrUuidMSFT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        componentIdsRaw(s);
        return this;
    }

    @Unsafe public @Nullable XrUuidMSFT.Ptr componentIds(int assumedCount) {
        MemorySegment s = componentIdsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * XrUuidMSFT.BYTES);
        return new XrUuidMSFT.Ptr(s);
    }

    public @Nullable XrUuidMSFT componentIds() {
        MemorySegment s = componentIdsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new XrUuidMSFT(s);
    }

    public @Pointer(target=XrUuidMSFT.class) @NotNull MemorySegment componentIdsRaw() {
        return segment.get(LAYOUT$componentIds, OFFSET$componentIds);
    }

    public void componentIdsRaw(@Pointer(target=XrUuidMSFT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$componentIds, OFFSET$componentIds, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.ADDRESS.withName("next"),
        ValueLayout.ADDRESS.withName("baseSpace"),
        ValueLayout.JAVA_LONG.withName("time"),
        ValueLayout.JAVA_INT.withName("componentIdCount"),
        ValueLayout.ADDRESS.withTargetLayout(XrUuidMSFT.LAYOUT).withName("componentIds")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$next = PathElement.groupElement("next");
    public static final PathElement PATH$baseSpace = PathElement.groupElement("baseSpace");
    public static final PathElement PATH$time = PathElement.groupElement("time");
    public static final PathElement PATH$componentIdCount = PathElement.groupElement("componentIdCount");
    public static final PathElement PATH$componentIds = PathElement.groupElement("componentIds");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final AddressLayout LAYOUT$next = (AddressLayout) LAYOUT.select(PATH$next);
    public static final AddressLayout LAYOUT$baseSpace = (AddressLayout) LAYOUT.select(PATH$baseSpace);
    public static final OfLong LAYOUT$time = (OfLong) LAYOUT.select(PATH$time);
    public static final OfInt LAYOUT$componentIdCount = (OfInt) LAYOUT.select(PATH$componentIdCount);
    public static final AddressLayout LAYOUT$componentIds = (AddressLayout) LAYOUT.select(PATH$componentIds);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$next = LAYOUT$next.byteSize();
    public static final long SIZE$baseSpace = LAYOUT$baseSpace.byteSize();
    public static final long SIZE$time = LAYOUT$time.byteSize();
    public static final long SIZE$componentIdCount = LAYOUT$componentIdCount.byteSize();
    public static final long SIZE$componentIds = LAYOUT$componentIds.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$next = LAYOUT.byteOffset(PATH$next);
    public static final long OFFSET$baseSpace = LAYOUT.byteOffset(PATH$baseSpace);
    public static final long OFFSET$time = LAYOUT.byteOffset(PATH$time);
    public static final long OFFSET$componentIdCount = LAYOUT.byteOffset(PATH$componentIdCount);
    public static final long OFFSET$componentIds = LAYOUT.byteOffset(PATH$componentIds);
}
