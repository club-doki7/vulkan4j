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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrEventDataLocalizationChangedML.html"><code>XrEventDataLocalizationChangedML</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrEventDataLocalizationChangedML {
///     XrStructureType type; // @link substring="XrStructureType" target="XrStructureType" @link substring="type" target="#type"
///     void const* next; // @link substring="next" target="#next"
///     XrSession session; // @link substring="XrSession" target="XrSession" @link substring="session" target="#session"
///     XrLocalizationMapStateML state; // @link substring="XrLocalizationMapStateML" target="XrLocalizationMapStateML" @link substring="state" target="#state"
///     XrLocalizationMapML map; // @link substring="XrLocalizationMapML" target="XrLocalizationMapML" @link substring="map" target="#map"
///     XrLocalizationMapConfidenceML confidence; // @link substring="XrLocalizationMapConfidenceML" target="XrLocalizationMapConfidenceML" @link substring="confidence" target="#confidence"
///     XrLocalizationMapErrorFlagsML errorFlags; // @link substring="XrLocalizationMapErrorFlagsML" target="XrLocalizationMapErrorFlagsML" @link substring="errorFlags" target="#errorFlags"
/// } XrEventDataLocalizationChangedML;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `type = XR_TYPE_EVENT_DATA_LOCALIZATION_CHANGED_ML`
/// - `map.autoInit()`
///
/// The {@code allocate} ({@link XrEventDataLocalizationChangedML#allocate(Arena)}, {@link XrEventDataLocalizationChangedML#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link XrEventDataLocalizationChangedML#autoInit}
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrEventDataLocalizationChangedML.html"><code>XrEventDataLocalizationChangedML</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrEventDataLocalizationChangedML(@NotNull MemorySegment segment) implements IXrEventDataLocalizationChangedML {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrEventDataLocalizationChangedML.html"><code>XrEventDataLocalizationChangedML</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrEventDataLocalizationChangedML}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrEventDataLocalizationChangedML to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrEventDataLocalizationChangedML.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrEventDataLocalizationChangedML, Iterable<XrEventDataLocalizationChangedML> {
        public long size() {
            return segment.byteSize() / XrEventDataLocalizationChangedML.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrEventDataLocalizationChangedML at(long index) {
            return new XrEventDataLocalizationChangedML(segment.asSlice(index * XrEventDataLocalizationChangedML.BYTES, XrEventDataLocalizationChangedML.BYTES));
        }

        public XrEventDataLocalizationChangedML.Ptr at(long index, @NotNull Consumer<@NotNull XrEventDataLocalizationChangedML> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrEventDataLocalizationChangedML value) {
            MemorySegment s = segment.asSlice(index * XrEventDataLocalizationChangedML.BYTES, XrEventDataLocalizationChangedML.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrEventDataLocalizationChangedML.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrEventDataLocalizationChangedML.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrEventDataLocalizationChangedML.BYTES,
                (end - start) * XrEventDataLocalizationChangedML.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrEventDataLocalizationChangedML.BYTES));
        }

        public XrEventDataLocalizationChangedML[] toArray() {
            XrEventDataLocalizationChangedML[] ret = new XrEventDataLocalizationChangedML[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrEventDataLocalizationChangedML> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrEventDataLocalizationChangedML> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrEventDataLocalizationChangedML.BYTES;
            }

            @Override
            public XrEventDataLocalizationChangedML next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrEventDataLocalizationChangedML ret = new XrEventDataLocalizationChangedML(segment.asSlice(0, XrEventDataLocalizationChangedML.BYTES));
                segment = segment.asSlice(XrEventDataLocalizationChangedML.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrEventDataLocalizationChangedML allocate(Arena arena) {
        XrEventDataLocalizationChangedML ret = new XrEventDataLocalizationChangedML(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static XrEventDataLocalizationChangedML.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        XrEventDataLocalizationChangedML.Ptr ret = new XrEventDataLocalizationChangedML.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static XrEventDataLocalizationChangedML clone(Arena arena, XrEventDataLocalizationChangedML src) {
        XrEventDataLocalizationChangedML ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        type(XrStructureType.EVENT_DATA_LOCALIZATION_CHANGED_ML);
        map().autoInit();
    }

    public @EnumType(XrStructureType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public XrEventDataLocalizationChangedML type(@EnumType(XrStructureType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment next() {
        return segment.get(LAYOUT$next, OFFSET$next);
    }

    public XrEventDataLocalizationChangedML next(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$next, OFFSET$next, value);
        return this;
    }

    public XrEventDataLocalizationChangedML next(@Nullable IPointer pointer) {
        next(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable XrSession session() {
        MemorySegment s = segment.asSlice(OFFSET$session, SIZE$session);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new XrSession(s);
    }

    public XrEventDataLocalizationChangedML session(@Nullable XrSession value) {
        segment.set(LAYOUT$session, OFFSET$session, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(XrLocalizationMapStateML.class) int state() {
        return segment.get(LAYOUT$state, OFFSET$state);
    }

    public XrEventDataLocalizationChangedML state(@EnumType(XrLocalizationMapStateML.class) int value) {
        segment.set(LAYOUT$state, OFFSET$state, value);
        return this;
    }

    public @NotNull XrLocalizationMapML map() {
        return new XrLocalizationMapML(segment.asSlice(OFFSET$map, LAYOUT$map));
    }

    public XrEventDataLocalizationChangedML map(@NotNull XrLocalizationMapML value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$map, SIZE$map);
        return this;
    }

    public XrEventDataLocalizationChangedML map(Consumer<@NotNull XrLocalizationMapML> consumer) {
        consumer.accept(map());
        return this;
    }

    public @EnumType(XrLocalizationMapConfidenceML.class) int confidence() {
        return segment.get(LAYOUT$confidence, OFFSET$confidence);
    }

    public XrEventDataLocalizationChangedML confidence(@EnumType(XrLocalizationMapConfidenceML.class) int value) {
        segment.set(LAYOUT$confidence, OFFSET$confidence, value);
        return this;
    }

    public @Bitmask(XrLocalizationMapErrorFlagsML.class) long errorFlags() {
        return segment.get(LAYOUT$errorFlags, OFFSET$errorFlags);
    }

    public XrEventDataLocalizationChangedML errorFlags(@Bitmask(XrLocalizationMapErrorFlagsML.class) long value) {
        segment.set(LAYOUT$errorFlags, OFFSET$errorFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.ADDRESS.withName("next"),
        ValueLayout.ADDRESS.withName("session"),
        ValueLayout.JAVA_INT.withName("state"),
        XrLocalizationMapML.LAYOUT.withName("map"),
        ValueLayout.JAVA_INT.withName("confidence"),
        ValueLayout.JAVA_LONG.withName("errorFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$next = PathElement.groupElement("next");
    public static final PathElement PATH$session = PathElement.groupElement("session");
    public static final PathElement PATH$state = PathElement.groupElement("state");
    public static final PathElement PATH$map = PathElement.groupElement("map");
    public static final PathElement PATH$confidence = PathElement.groupElement("confidence");
    public static final PathElement PATH$errorFlags = PathElement.groupElement("errorFlags");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final AddressLayout LAYOUT$next = (AddressLayout) LAYOUT.select(PATH$next);
    public static final AddressLayout LAYOUT$session = (AddressLayout) LAYOUT.select(PATH$session);
    public static final OfInt LAYOUT$state = (OfInt) LAYOUT.select(PATH$state);
    public static final StructLayout LAYOUT$map = (StructLayout) LAYOUT.select(PATH$map);
    public static final OfInt LAYOUT$confidence = (OfInt) LAYOUT.select(PATH$confidence);
    public static final OfLong LAYOUT$errorFlags = (OfLong) LAYOUT.select(PATH$errorFlags);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$next = LAYOUT$next.byteSize();
    public static final long SIZE$session = LAYOUT$session.byteSize();
    public static final long SIZE$state = LAYOUT$state.byteSize();
    public static final long SIZE$map = LAYOUT$map.byteSize();
    public static final long SIZE$confidence = LAYOUT$confidence.byteSize();
    public static final long SIZE$errorFlags = LAYOUT$errorFlags.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$next = LAYOUT.byteOffset(PATH$next);
    public static final long OFFSET$session = LAYOUT.byteOffset(PATH$session);
    public static final long OFFSET$state = LAYOUT.byteOffset(PATH$state);
    public static final long OFFSET$map = LAYOUT.byteOffset(PATH$map);
    public static final long OFFSET$confidence = LAYOUT.byteOffset(PATH$confidence);
    public static final long OFFSET$errorFlags = LAYOUT.byteOffset(PATH$errorFlags);
}
