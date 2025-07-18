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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrActionSetCreateInfo.html"><code>XrActionSetCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrActionSetCreateInfo {
///     XrStructureType type; // @link substring="XrStructureType" target="XrStructureType" @link substring="type" target="#type"
///     void const* next; // @link substring="next" target="#next"
///     char[XR_MAX_ACTION_SET_NAME_SIZE] actionSetName; // @link substring="actionSetName" target="#actionSetName"
///     char[XR_MAX_LOCALIZED_ACTION_SET_NAME_SIZE] localizedActionSetName; // @link substring="localizedActionSetName" target="#localizedActionSetName"
///     uint32_t priority; // @link substring="priority" target="#priority"
/// } XrActionSetCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `type = XR_TYPE_ACTION_SET_CREATE_INFO`
///
/// The {@code allocate} ({@link XrActionSetCreateInfo#allocate(Arena)}, {@link XrActionSetCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link XrActionSetCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrActionSetCreateInfo.html"><code>XrActionSetCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrActionSetCreateInfo(@NotNull MemorySegment segment) implements IXrActionSetCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrActionSetCreateInfo.html"><code>XrActionSetCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrActionSetCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrActionSetCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrActionSetCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrActionSetCreateInfo, Iterable<XrActionSetCreateInfo> {
        public long size() {
            return segment.byteSize() / XrActionSetCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrActionSetCreateInfo at(long index) {
            return new XrActionSetCreateInfo(segment.asSlice(index * XrActionSetCreateInfo.BYTES, XrActionSetCreateInfo.BYTES));
        }

        public XrActionSetCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull XrActionSetCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrActionSetCreateInfo value) {
            MemorySegment s = segment.asSlice(index * XrActionSetCreateInfo.BYTES, XrActionSetCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrActionSetCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrActionSetCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrActionSetCreateInfo.BYTES,
                (end - start) * XrActionSetCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrActionSetCreateInfo.BYTES));
        }

        public XrActionSetCreateInfo[] toArray() {
            XrActionSetCreateInfo[] ret = new XrActionSetCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrActionSetCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrActionSetCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrActionSetCreateInfo.BYTES;
            }

            @Override
            public XrActionSetCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrActionSetCreateInfo ret = new XrActionSetCreateInfo(segment.asSlice(0, XrActionSetCreateInfo.BYTES));
                segment = segment.asSlice(XrActionSetCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrActionSetCreateInfo allocate(Arena arena) {
        XrActionSetCreateInfo ret = new XrActionSetCreateInfo(arena.allocate(LAYOUT));
        ret.type(XrStructureType.ACTION_SET_CREATE_INFO);
        return ret;
    }

    public static XrActionSetCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        XrActionSetCreateInfo.Ptr ret = new XrActionSetCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).type(XrStructureType.ACTION_SET_CREATE_INFO);
        }
        return ret;
    }

    public static XrActionSetCreateInfo clone(Arena arena, XrActionSetCreateInfo src) {
        XrActionSetCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        type(XrStructureType.ACTION_SET_CREATE_INFO);
    }

    public @EnumType(XrStructureType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public XrActionSetCreateInfo type(@EnumType(XrStructureType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment next() {
        return segment.get(LAYOUT$next, OFFSET$next);
    }

    public XrActionSetCreateInfo next(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$next, OFFSET$next, value);
        return this;
    }

    public XrActionSetCreateInfo next(@Nullable IPointer pointer) {
        next(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public BytePtr actionSetName() {
        return new BytePtr(actionSetNameRaw());
    }

    public XrActionSetCreateInfo actionSetName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = actionSetName();
        consumer.accept(ptr);
        return this;
    }

    public XrActionSetCreateInfo actionSetName(BytePtr value) {
        MemorySegment s = actionSetNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment actionSetNameRaw() {
        return segment.asSlice(OFFSET$actionSetName, SIZE$actionSetName);
    }

    public BytePtr localizedActionSetName() {
        return new BytePtr(localizedActionSetNameRaw());
    }

    public XrActionSetCreateInfo localizedActionSetName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = localizedActionSetName();
        consumer.accept(ptr);
        return this;
    }

    public XrActionSetCreateInfo localizedActionSetName(BytePtr value) {
        MemorySegment s = localizedActionSetNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment localizedActionSetNameRaw() {
        return segment.asSlice(OFFSET$localizedActionSetName, SIZE$localizedActionSetName);
    }

    public @Unsigned int priority() {
        return segment.get(LAYOUT$priority, OFFSET$priority);
    }

    public XrActionSetCreateInfo priority(@Unsigned int value) {
        segment.set(LAYOUT$priority, OFFSET$priority, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.ADDRESS.withName("next"),
        MemoryLayout.sequenceLayout(MAX_ACTION_SET_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("actionSetName"),
        MemoryLayout.sequenceLayout(MAX_LOCALIZED_ACTION_SET_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("localizedActionSetName"),
        ValueLayout.JAVA_INT.withName("priority")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$next = PathElement.groupElement("next");
    public static final PathElement PATH$actionSetName = PathElement.groupElement("actionSetName");
    public static final PathElement PATH$localizedActionSetName = PathElement.groupElement("localizedActionSetName");
    public static final PathElement PATH$priority = PathElement.groupElement("priority");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final AddressLayout LAYOUT$next = (AddressLayout) LAYOUT.select(PATH$next);
    public static final SequenceLayout LAYOUT$actionSetName = (SequenceLayout) LAYOUT.select(PATH$actionSetName);
    public static final SequenceLayout LAYOUT$localizedActionSetName = (SequenceLayout) LAYOUT.select(PATH$localizedActionSetName);
    public static final OfInt LAYOUT$priority = (OfInt) LAYOUT.select(PATH$priority);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$next = LAYOUT$next.byteSize();
    public static final long SIZE$actionSetName = LAYOUT$actionSetName.byteSize();
    public static final long SIZE$localizedActionSetName = LAYOUT$localizedActionSetName.byteSize();
    public static final long SIZE$priority = LAYOUT$priority.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$next = LAYOUT.byteOffset(PATH$next);
    public static final long OFFSET$actionSetName = LAYOUT.byteOffset(PATH$actionSetName);
    public static final long OFFSET$localizedActionSetName = LAYOUT.byteOffset(PATH$localizedActionSetName);
    public static final long OFFSET$priority = LAYOUT.byteOffset(PATH$priority);
}
