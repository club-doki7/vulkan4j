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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassStripeBeginInfoARM.html"><code>VkRenderPassStripeBeginInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderPassStripeBeginInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t stripeInfoCount; // @link substring="stripeInfoCount" target="#stripeInfoCount"
///     VkRenderPassStripeInfoARM const* pStripeInfos; // @link substring="VkRenderPassStripeInfoARM" target="VkRenderPassStripeInfoARM" @link substring="pStripeInfos" target="#pStripeInfos"
/// } VkRenderPassStripeBeginInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDER_PASS_STRIPE_BEGIN_INFO_ARM`
///
/// The {@code allocate} ({@link VkRenderPassStripeBeginInfoARM#allocate(Arena)}, {@link VkRenderPassStripeBeginInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderPassStripeBeginInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassStripeBeginInfoARM.html"><code>VkRenderPassStripeBeginInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderPassStripeBeginInfoARM(@NotNull MemorySegment segment) implements IVkRenderPassStripeBeginInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassStripeBeginInfoARM.html"><code>VkRenderPassStripeBeginInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderPassStripeBeginInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderPassStripeBeginInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderPassStripeBeginInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderPassStripeBeginInfoARM, Iterable<VkRenderPassStripeBeginInfoARM> {
        public long size() {
            return segment.byteSize() / VkRenderPassStripeBeginInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderPassStripeBeginInfoARM at(long index) {
            return new VkRenderPassStripeBeginInfoARM(segment.asSlice(index * VkRenderPassStripeBeginInfoARM.BYTES, VkRenderPassStripeBeginInfoARM.BYTES));
        }

        public VkRenderPassStripeBeginInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderPassStripeBeginInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderPassStripeBeginInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkRenderPassStripeBeginInfoARM.BYTES, VkRenderPassStripeBeginInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderPassStripeBeginInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderPassStripeBeginInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderPassStripeBeginInfoARM.BYTES,
                (end - start) * VkRenderPassStripeBeginInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderPassStripeBeginInfoARM.BYTES));
        }

        public VkRenderPassStripeBeginInfoARM[] toArray() {
            VkRenderPassStripeBeginInfoARM[] ret = new VkRenderPassStripeBeginInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderPassStripeBeginInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderPassStripeBeginInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderPassStripeBeginInfoARM.BYTES;
            }

            @Override
            public VkRenderPassStripeBeginInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderPassStripeBeginInfoARM ret = new VkRenderPassStripeBeginInfoARM(segment.asSlice(0, VkRenderPassStripeBeginInfoARM.BYTES));
                segment = segment.asSlice(VkRenderPassStripeBeginInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderPassStripeBeginInfoARM allocate(Arena arena) {
        VkRenderPassStripeBeginInfoARM ret = new VkRenderPassStripeBeginInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDER_PASS_STRIPE_BEGIN_INFO_ARM);
        return ret;
    }

    public static VkRenderPassStripeBeginInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderPassStripeBeginInfoARM.Ptr ret = new VkRenderPassStripeBeginInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDER_PASS_STRIPE_BEGIN_INFO_ARM);
        }
        return ret;
    }

    public static VkRenderPassStripeBeginInfoARM clone(Arena arena, VkRenderPassStripeBeginInfoARM src) {
        VkRenderPassStripeBeginInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDER_PASS_STRIPE_BEGIN_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderPassStripeBeginInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderPassStripeBeginInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderPassStripeBeginInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int stripeInfoCount() {
        return segment.get(LAYOUT$stripeInfoCount, OFFSET$stripeInfoCount);
    }

    public VkRenderPassStripeBeginInfoARM stripeInfoCount(@Unsigned int value) {
        segment.set(LAYOUT$stripeInfoCount, OFFSET$stripeInfoCount, value);
        return this;
    }

    public VkRenderPassStripeBeginInfoARM pStripeInfos(@Nullable IVkRenderPassStripeInfoARM value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStripeInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRenderPassStripeInfoARM.Ptr pStripeInfos(int assumedCount) {
        MemorySegment s = pStripeInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRenderPassStripeInfoARM.BYTES);
        return new VkRenderPassStripeInfoARM.Ptr(s);
    }

    public @Nullable VkRenderPassStripeInfoARM pStripeInfos() {
        MemorySegment s = pStripeInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderPassStripeInfoARM(s);
    }

    public @Pointer(target=VkRenderPassStripeInfoARM.class) @NotNull MemorySegment pStripeInfosRaw() {
        return segment.get(LAYOUT$pStripeInfos, OFFSET$pStripeInfos);
    }

    public void pStripeInfosRaw(@Pointer(target=VkRenderPassStripeInfoARM.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStripeInfos, OFFSET$pStripeInfos, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stripeInfoCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRenderPassStripeInfoARM.LAYOUT).withName("pStripeInfos")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stripeInfoCount = PathElement.groupElement("stripeInfoCount");
    public static final PathElement PATH$pStripeInfos = PathElement.groupElement("pStripeInfos");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stripeInfoCount = (OfInt) LAYOUT.select(PATH$stripeInfoCount);
    public static final AddressLayout LAYOUT$pStripeInfos = (AddressLayout) LAYOUT.select(PATH$pStripeInfos);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stripeInfoCount = LAYOUT$stripeInfoCount.byteSize();
    public static final long SIZE$pStripeInfos = LAYOUT$pStripeInfos.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stripeInfoCount = LAYOUT.byteOffset(PATH$stripeInfoCount);
    public static final long OFFSET$pStripeInfos = LAYOUT.byteOffset(PATH$pStripeInfos);
}
