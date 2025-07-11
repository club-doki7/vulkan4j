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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrCompositionLayerPassthroughHTC.html"><code>XrCompositionLayerPassthroughHTC</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrCompositionLayerPassthroughHTC {
///     XrStructureType type; // @link substring="XrStructureType" target="XrStructureType" @link substring="type" target="#type"
///     void const* next; // @link substring="next" target="#next"
///     XrCompositionLayerFlags layerFlags; // @link substring="XrCompositionLayerFlags" target="XrCompositionLayerFlags" @link substring="layerFlags" target="#layerFlags"
///     XrSpace space; // @link substring="XrSpace" target="XrSpace" @link substring="space" target="#space"
///     XrPassthroughHTC passthrough; // @link substring="XrPassthroughHTC" target="XrPassthroughHTC" @link substring="passthrough" target="#passthrough"
///     XrPassthroughColorHTC color; // @link substring="XrPassthroughColorHTC" target="XrPassthroughColorHTC" @link substring="color" target="#color"
/// } XrCompositionLayerPassthroughHTC;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `type = XR_TYPE_COMPOSITION_LAYER_PASSTHROUGH_HTC`
/// - `color.autoInit()`
///
/// The {@code allocate} ({@link XrCompositionLayerPassthroughHTC#allocate(Arena)}, {@link XrCompositionLayerPassthroughHTC#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link XrCompositionLayerPassthroughHTC#autoInit}
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrCompositionLayerPassthroughHTC.html"><code>XrCompositionLayerPassthroughHTC</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrCompositionLayerPassthroughHTC(@NotNull MemorySegment segment) implements IXrCompositionLayerPassthroughHTC {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrCompositionLayerPassthroughHTC.html"><code>XrCompositionLayerPassthroughHTC</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrCompositionLayerPassthroughHTC}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrCompositionLayerPassthroughHTC to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrCompositionLayerPassthroughHTC.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrCompositionLayerPassthroughHTC, Iterable<XrCompositionLayerPassthroughHTC> {
        public long size() {
            return segment.byteSize() / XrCompositionLayerPassthroughHTC.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrCompositionLayerPassthroughHTC at(long index) {
            return new XrCompositionLayerPassthroughHTC(segment.asSlice(index * XrCompositionLayerPassthroughHTC.BYTES, XrCompositionLayerPassthroughHTC.BYTES));
        }

        public XrCompositionLayerPassthroughHTC.Ptr at(long index, @NotNull Consumer<@NotNull XrCompositionLayerPassthroughHTC> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrCompositionLayerPassthroughHTC value) {
            MemorySegment s = segment.asSlice(index * XrCompositionLayerPassthroughHTC.BYTES, XrCompositionLayerPassthroughHTC.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrCompositionLayerPassthroughHTC.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrCompositionLayerPassthroughHTC.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrCompositionLayerPassthroughHTC.BYTES,
                (end - start) * XrCompositionLayerPassthroughHTC.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrCompositionLayerPassthroughHTC.BYTES));
        }

        public XrCompositionLayerPassthroughHTC[] toArray() {
            XrCompositionLayerPassthroughHTC[] ret = new XrCompositionLayerPassthroughHTC[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrCompositionLayerPassthroughHTC> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrCompositionLayerPassthroughHTC> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrCompositionLayerPassthroughHTC.BYTES;
            }

            @Override
            public XrCompositionLayerPassthroughHTC next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrCompositionLayerPassthroughHTC ret = new XrCompositionLayerPassthroughHTC(segment.asSlice(0, XrCompositionLayerPassthroughHTC.BYTES));
                segment = segment.asSlice(XrCompositionLayerPassthroughHTC.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrCompositionLayerPassthroughHTC allocate(Arena arena) {
        XrCompositionLayerPassthroughHTC ret = new XrCompositionLayerPassthroughHTC(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static XrCompositionLayerPassthroughHTC.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        XrCompositionLayerPassthroughHTC.Ptr ret = new XrCompositionLayerPassthroughHTC.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static XrCompositionLayerPassthroughHTC clone(Arena arena, XrCompositionLayerPassthroughHTC src) {
        XrCompositionLayerPassthroughHTC ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        type(XrStructureType.COMPOSITION_LAYER_PASSTHROUGH_HTC);
        color().autoInit();
    }

    public @EnumType(XrStructureType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public XrCompositionLayerPassthroughHTC type(@EnumType(XrStructureType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment next() {
        return segment.get(LAYOUT$next, OFFSET$next);
    }

    public XrCompositionLayerPassthroughHTC next(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$next, OFFSET$next, value);
        return this;
    }

    public XrCompositionLayerPassthroughHTC next(@Nullable IPointer pointer) {
        next(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(XrCompositionLayerFlags.class) long layerFlags() {
        return segment.get(LAYOUT$layerFlags, OFFSET$layerFlags);
    }

    public XrCompositionLayerPassthroughHTC layerFlags(@Bitmask(XrCompositionLayerFlags.class) long value) {
        segment.set(LAYOUT$layerFlags, OFFSET$layerFlags, value);
        return this;
    }

    public @Nullable XrSpace space() {
        MemorySegment s = segment.asSlice(OFFSET$space, SIZE$space);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new XrSpace(s);
    }

    public XrCompositionLayerPassthroughHTC space(@Nullable XrSpace value) {
        segment.set(LAYOUT$space, OFFSET$space, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable XrPassthroughHTC passthrough() {
        MemorySegment s = segment.asSlice(OFFSET$passthrough, SIZE$passthrough);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new XrPassthroughHTC(s);
    }

    public XrCompositionLayerPassthroughHTC passthrough(@Nullable XrPassthroughHTC value) {
        segment.set(LAYOUT$passthrough, OFFSET$passthrough, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull XrPassthroughColorHTC color() {
        return new XrPassthroughColorHTC(segment.asSlice(OFFSET$color, LAYOUT$color));
    }

    public XrCompositionLayerPassthroughHTC color(@NotNull XrPassthroughColorHTC value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$color, SIZE$color);
        return this;
    }

    public XrCompositionLayerPassthroughHTC color(Consumer<@NotNull XrPassthroughColorHTC> consumer) {
        consumer.accept(color());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.ADDRESS.withName("next"),
        ValueLayout.JAVA_LONG.withName("layerFlags"),
        ValueLayout.ADDRESS.withName("space"),
        ValueLayout.ADDRESS.withName("passthrough"),
        XrPassthroughColorHTC.LAYOUT.withName("color")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$next = PathElement.groupElement("next");
    public static final PathElement PATH$layerFlags = PathElement.groupElement("layerFlags");
    public static final PathElement PATH$space = PathElement.groupElement("space");
    public static final PathElement PATH$passthrough = PathElement.groupElement("passthrough");
    public static final PathElement PATH$color = PathElement.groupElement("color");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final AddressLayout LAYOUT$next = (AddressLayout) LAYOUT.select(PATH$next);
    public static final OfLong LAYOUT$layerFlags = (OfLong) LAYOUT.select(PATH$layerFlags);
    public static final AddressLayout LAYOUT$space = (AddressLayout) LAYOUT.select(PATH$space);
    public static final AddressLayout LAYOUT$passthrough = (AddressLayout) LAYOUT.select(PATH$passthrough);
    public static final StructLayout LAYOUT$color = (StructLayout) LAYOUT.select(PATH$color);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$next = LAYOUT$next.byteSize();
    public static final long SIZE$layerFlags = LAYOUT$layerFlags.byteSize();
    public static final long SIZE$space = LAYOUT$space.byteSize();
    public static final long SIZE$passthrough = LAYOUT$passthrough.byteSize();
    public static final long SIZE$color = LAYOUT$color.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$next = LAYOUT.byteOffset(PATH$next);
    public static final long OFFSET$layerFlags = LAYOUT.byteOffset(PATH$layerFlags);
    public static final long OFFSET$space = LAYOUT.byteOffset(PATH$space);
    public static final long OFFSET$passthrough = LAYOUT.byteOffset(PATH$passthrough);
    public static final long OFFSET$color = LAYOUT.byteOffset(PATH$color);
}
