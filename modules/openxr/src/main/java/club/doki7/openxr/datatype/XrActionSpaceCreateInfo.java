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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrActionSpaceCreateInfo.html"><code>XrActionSpaceCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrActionSpaceCreateInfo {
///     XrStructureType type; // @link substring="XrStructureType" target="XrStructureType" @link substring="type" target="#type"
///     void const* next; // @link substring="next" target="#next"
///     XrAction action; // @link substring="XrAction" target="XrAction" @link substring="action" target="#action"
///     XrPath subactionPath; // optional // @link substring="subactionPath" target="#subactionPath"
///     XrPosef poseInActionSpace; // @link substring="XrPosef" target="XrPosef" @link substring="poseInActionSpace" target="#poseInActionSpace"
/// } XrActionSpaceCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `type = XR_TYPE_ACTION_SPACE_CREATE_INFO`
///
/// The {@code allocate} ({@link XrActionSpaceCreateInfo#allocate(Arena)}, {@link XrActionSpaceCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link XrActionSpaceCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrActionSpaceCreateInfo.html"><code>XrActionSpaceCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrActionSpaceCreateInfo(@NotNull MemorySegment segment) implements IXrActionSpaceCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrActionSpaceCreateInfo.html"><code>XrActionSpaceCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrActionSpaceCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrActionSpaceCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrActionSpaceCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrActionSpaceCreateInfo, Iterable<XrActionSpaceCreateInfo> {
        public long size() {
            return segment.byteSize() / XrActionSpaceCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrActionSpaceCreateInfo at(long index) {
            return new XrActionSpaceCreateInfo(segment.asSlice(index * XrActionSpaceCreateInfo.BYTES, XrActionSpaceCreateInfo.BYTES));
        }

        public XrActionSpaceCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull XrActionSpaceCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrActionSpaceCreateInfo value) {
            MemorySegment s = segment.asSlice(index * XrActionSpaceCreateInfo.BYTES, XrActionSpaceCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrActionSpaceCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrActionSpaceCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrActionSpaceCreateInfo.BYTES,
                (end - start) * XrActionSpaceCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrActionSpaceCreateInfo.BYTES));
        }

        public XrActionSpaceCreateInfo[] toArray() {
            XrActionSpaceCreateInfo[] ret = new XrActionSpaceCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrActionSpaceCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrActionSpaceCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrActionSpaceCreateInfo.BYTES;
            }

            @Override
            public XrActionSpaceCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrActionSpaceCreateInfo ret = new XrActionSpaceCreateInfo(segment.asSlice(0, XrActionSpaceCreateInfo.BYTES));
                segment = segment.asSlice(XrActionSpaceCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrActionSpaceCreateInfo allocate(Arena arena) {
        XrActionSpaceCreateInfo ret = new XrActionSpaceCreateInfo(arena.allocate(LAYOUT));
        ret.type(XrStructureType.ACTION_SPACE_CREATE_INFO);
        return ret;
    }

    public static XrActionSpaceCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        XrActionSpaceCreateInfo.Ptr ret = new XrActionSpaceCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).type(XrStructureType.ACTION_SPACE_CREATE_INFO);
        }
        return ret;
    }

    public static XrActionSpaceCreateInfo clone(Arena arena, XrActionSpaceCreateInfo src) {
        XrActionSpaceCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        type(XrStructureType.ACTION_SPACE_CREATE_INFO);
    }

    public @EnumType(XrStructureType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public XrActionSpaceCreateInfo type(@EnumType(XrStructureType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment next() {
        return segment.get(LAYOUT$next, OFFSET$next);
    }

    public XrActionSpaceCreateInfo next(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$next, OFFSET$next, value);
        return this;
    }

    public XrActionSpaceCreateInfo next(@Nullable IPointer pointer) {
        next(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable XrAction action() {
        MemorySegment s = segment.asSlice(OFFSET$action, SIZE$action);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new XrAction(s);
    }

    public XrActionSpaceCreateInfo action(@Nullable XrAction value) {
        segment.set(LAYOUT$action, OFFSET$action, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("XrPath") @Unsigned long subactionPath() {
        return segment.get(LAYOUT$subactionPath, OFFSET$subactionPath);
    }

    public XrActionSpaceCreateInfo subactionPath(@NativeType("XrPath") @Unsigned long value) {
        segment.set(LAYOUT$subactionPath, OFFSET$subactionPath, value);
        return this;
    }

    public @NotNull XrPosef poseInActionSpace() {
        return new XrPosef(segment.asSlice(OFFSET$poseInActionSpace, LAYOUT$poseInActionSpace));
    }

    public XrActionSpaceCreateInfo poseInActionSpace(@NotNull XrPosef value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$poseInActionSpace, SIZE$poseInActionSpace);
        return this;
    }

    public XrActionSpaceCreateInfo poseInActionSpace(Consumer<@NotNull XrPosef> consumer) {
        consumer.accept(poseInActionSpace());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.ADDRESS.withName("next"),
        ValueLayout.ADDRESS.withName("action"),
        ValueLayout.JAVA_LONG.withName("subactionPath"),
        XrPosef.LAYOUT.withName("poseInActionSpace")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$next = PathElement.groupElement("next");
    public static final PathElement PATH$action = PathElement.groupElement("action");
    public static final PathElement PATH$subactionPath = PathElement.groupElement("subactionPath");
    public static final PathElement PATH$poseInActionSpace = PathElement.groupElement("poseInActionSpace");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final AddressLayout LAYOUT$next = (AddressLayout) LAYOUT.select(PATH$next);
    public static final AddressLayout LAYOUT$action = (AddressLayout) LAYOUT.select(PATH$action);
    public static final OfLong LAYOUT$subactionPath = (OfLong) LAYOUT.select(PATH$subactionPath);
    public static final StructLayout LAYOUT$poseInActionSpace = (StructLayout) LAYOUT.select(PATH$poseInActionSpace);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$next = LAYOUT$next.byteSize();
    public static final long SIZE$action = LAYOUT$action.byteSize();
    public static final long SIZE$subactionPath = LAYOUT$subactionPath.byteSize();
    public static final long SIZE$poseInActionSpace = LAYOUT$poseInActionSpace.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$next = LAYOUT.byteOffset(PATH$next);
    public static final long OFFSET$action = LAYOUT.byteOffset(PATH$action);
    public static final long OFFSET$subactionPath = LAYOUT.byteOffset(PATH$subactionPath);
    public static final long OFFSET$poseInActionSpace = LAYOUT.byteOffset(PATH$poseInActionSpace);
}
