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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrFrameEndInfo.html"><code>XrFrameEndInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrFrameEndInfo {
///     XrStructureType type; // @link substring="XrStructureType" target="XrStructureType" @link substring="type" target="#type"
///     void const* next; // @link substring="next" target="#next"
///     XrTime displayTime; // @link substring="displayTime" target="#displayTime"
///     XrEnvironmentBlendMode environmentBlendMode; // @link substring="XrEnvironmentBlendMode" target="XrEnvironmentBlendMode" @link substring="environmentBlendMode" target="#environmentBlendMode"
///     uint32_t layerCount; // optional // @link substring="layerCount" target="#layerCount"
///     XrCompositionLayerBaseHeader const* const* layers; // optional // @link substring="XrCompositionLayerBaseHeader" target="XrCompositionLayerBaseHeader" @link substring="layers" target="#layers"
/// } XrFrameEndInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `type = XR_TYPE_FRAME_END_INFO`
///
/// The {@code allocate} ({@link XrFrameEndInfo#allocate(Arena)}, {@link XrFrameEndInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link XrFrameEndInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrFrameEndInfo.html"><code>XrFrameEndInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrFrameEndInfo(@NotNull MemorySegment segment) implements IXrFrameEndInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrFrameEndInfo.html"><code>XrFrameEndInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrFrameEndInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrFrameEndInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrFrameEndInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrFrameEndInfo, Iterable<XrFrameEndInfo> {
        public long size() {
            return segment.byteSize() / XrFrameEndInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrFrameEndInfo at(long index) {
            return new XrFrameEndInfo(segment.asSlice(index * XrFrameEndInfo.BYTES, XrFrameEndInfo.BYTES));
        }

        public XrFrameEndInfo.Ptr at(long index, @NotNull Consumer<@NotNull XrFrameEndInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrFrameEndInfo value) {
            MemorySegment s = segment.asSlice(index * XrFrameEndInfo.BYTES, XrFrameEndInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrFrameEndInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrFrameEndInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrFrameEndInfo.BYTES,
                (end - start) * XrFrameEndInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrFrameEndInfo.BYTES));
        }

        public XrFrameEndInfo[] toArray() {
            XrFrameEndInfo[] ret = new XrFrameEndInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrFrameEndInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrFrameEndInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrFrameEndInfo.BYTES;
            }

            @Override
            public XrFrameEndInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrFrameEndInfo ret = new XrFrameEndInfo(segment.asSlice(0, XrFrameEndInfo.BYTES));
                segment = segment.asSlice(XrFrameEndInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrFrameEndInfo allocate(Arena arena) {
        XrFrameEndInfo ret = new XrFrameEndInfo(arena.allocate(LAYOUT));
        ret.type(XrStructureType.FRAME_END_INFO);
        return ret;
    }

    public static XrFrameEndInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        XrFrameEndInfo.Ptr ret = new XrFrameEndInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).type(XrStructureType.FRAME_END_INFO);
        }
        return ret;
    }

    public static XrFrameEndInfo clone(Arena arena, XrFrameEndInfo src) {
        XrFrameEndInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        type(XrStructureType.FRAME_END_INFO);
    }

    public @EnumType(XrStructureType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public XrFrameEndInfo type(@EnumType(XrStructureType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment next() {
        return segment.get(LAYOUT$next, OFFSET$next);
    }

    public XrFrameEndInfo next(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$next, OFFSET$next, value);
        return this;
    }

    public XrFrameEndInfo next(@Nullable IPointer pointer) {
        next(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("XrTime") long displayTime() {
        return segment.get(LAYOUT$displayTime, OFFSET$displayTime);
    }

    public XrFrameEndInfo displayTime(@NativeType("XrTime") long value) {
        segment.set(LAYOUT$displayTime, OFFSET$displayTime, value);
        return this;
    }

    public @EnumType(XrEnvironmentBlendMode.class) int environmentBlendMode() {
        return segment.get(LAYOUT$environmentBlendMode, OFFSET$environmentBlendMode);
    }

    public XrFrameEndInfo environmentBlendMode(@EnumType(XrEnvironmentBlendMode.class) int value) {
        segment.set(LAYOUT$environmentBlendMode, OFFSET$environmentBlendMode, value);
        return this;
    }

    public @Unsigned int layerCount() {
        return segment.get(LAYOUT$layerCount, OFFSET$layerCount);
    }

    public XrFrameEndInfo layerCount(@Unsigned int value) {
        segment.set(LAYOUT$layerCount, OFFSET$layerCount, value);
        return this;
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr layers() {
        MemorySegment s = layersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public XrFrameEndInfo layers(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        layersRaw(s);
        return this;
    }

    public @Pointer(comment="void**") @NotNull MemorySegment layersRaw() {
        return segment.get(LAYOUT$layers, OFFSET$layers);
    }

    public void layersRaw(@Pointer(comment="void**") @NotNull MemorySegment value) {
        segment.set(LAYOUT$layers, OFFSET$layers, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.ADDRESS.withName("next"),
        ValueLayout.JAVA_LONG.withName("displayTime"),
        ValueLayout.JAVA_INT.withName("environmentBlendMode"),
        ValueLayout.JAVA_INT.withName("layerCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(XrCompositionLayerBaseHeader.LAYOUT)).withName("layers")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$next = PathElement.groupElement("next");
    public static final PathElement PATH$displayTime = PathElement.groupElement("displayTime");
    public static final PathElement PATH$environmentBlendMode = PathElement.groupElement("environmentBlendMode");
    public static final PathElement PATH$layerCount = PathElement.groupElement("layerCount");
    public static final PathElement PATH$layers = PathElement.groupElement("layers");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final AddressLayout LAYOUT$next = (AddressLayout) LAYOUT.select(PATH$next);
    public static final OfLong LAYOUT$displayTime = (OfLong) LAYOUT.select(PATH$displayTime);
    public static final OfInt LAYOUT$environmentBlendMode = (OfInt) LAYOUT.select(PATH$environmentBlendMode);
    public static final OfInt LAYOUT$layerCount = (OfInt) LAYOUT.select(PATH$layerCount);
    public static final AddressLayout LAYOUT$layers = (AddressLayout) LAYOUT.select(PATH$layers);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$next = LAYOUT$next.byteSize();
    public static final long SIZE$displayTime = LAYOUT$displayTime.byteSize();
    public static final long SIZE$environmentBlendMode = LAYOUT$environmentBlendMode.byteSize();
    public static final long SIZE$layerCount = LAYOUT$layerCount.byteSize();
    public static final long SIZE$layers = LAYOUT$layers.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$next = LAYOUT.byteOffset(PATH$next);
    public static final long OFFSET$displayTime = LAYOUT.byteOffset(PATH$displayTime);
    public static final long OFFSET$environmentBlendMode = LAYOUT.byteOffset(PATH$environmentBlendMode);
    public static final long OFFSET$layerCount = LAYOUT.byteOffset(PATH$layerCount);
    public static final long OFFSET$layers = LAYOUT.byteOffset(PATH$layers);
}
