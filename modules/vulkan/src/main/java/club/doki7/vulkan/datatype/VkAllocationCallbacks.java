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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAllocationCallbacks.html"><code>VkAllocationCallbacks</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAllocationCallbacks {
///     void* pUserData; // optional // @link substring="pUserData" target="#pUserData"
///     PFN_vkAllocationFunction pfnAllocation; // @link substring="PFN_vkAllocationFunction" target="IPFN_vkAllocationFunction" @link substring="pfnAllocation" target="#pfnAllocation"
///     PFN_vkReallocationFunction pfnReallocation; // @link substring="PFN_vkReallocationFunction" target="IPFN_vkReallocationFunction" @link substring="pfnReallocation" target="#pfnReallocation"
///     PFN_vkFreeFunction pfnFree; // @link substring="PFN_vkFreeFunction" target="IPFN_vkFreeFunction" @link substring="pfnFree" target="#pfnFree"
///     PFN_vkInternalAllocationNotification pfnInternalAllocation; // optional // @link substring="PFN_vkInternalAllocationNotification" target="IPFN_vkInternalAllocationNotification" @link substring="pfnInternalAllocation" target="#pfnInternalAllocation"
///     PFN_vkInternalFreeNotification pfnInternalFree; // optional // @link substring="PFN_vkInternalFreeNotification" target="IPFN_vkInternalFreeNotification" @link substring="pfnInternalFree" target="#pfnInternalFree"
/// } VkAllocationCallbacks;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAllocationCallbacks.html"><code>VkAllocationCallbacks</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAllocationCallbacks(@NotNull MemorySegment segment) implements IVkAllocationCallbacks {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAllocationCallbacks.html"><code>VkAllocationCallbacks</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAllocationCallbacks}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAllocationCallbacks to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAllocationCallbacks.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAllocationCallbacks, Iterable<VkAllocationCallbacks> {
        public long size() {
            return segment.byteSize() / VkAllocationCallbacks.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAllocationCallbacks at(long index) {
            return new VkAllocationCallbacks(segment.asSlice(index * VkAllocationCallbacks.BYTES, VkAllocationCallbacks.BYTES));
        }

        public VkAllocationCallbacks.Ptr at(long index, @NotNull Consumer<@NotNull VkAllocationCallbacks> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAllocationCallbacks value) {
            MemorySegment s = segment.asSlice(index * VkAllocationCallbacks.BYTES, VkAllocationCallbacks.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAllocationCallbacks.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAllocationCallbacks.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAllocationCallbacks.BYTES,
                (end - start) * VkAllocationCallbacks.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAllocationCallbacks.BYTES));
        }

        public VkAllocationCallbacks[] toArray() {
            VkAllocationCallbacks[] ret = new VkAllocationCallbacks[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAllocationCallbacks> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAllocationCallbacks> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAllocationCallbacks.BYTES;
            }

            @Override
            public VkAllocationCallbacks next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAllocationCallbacks ret = new VkAllocationCallbacks(segment.asSlice(0, VkAllocationCallbacks.BYTES));
                segment = segment.asSlice(VkAllocationCallbacks.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAllocationCallbacks allocate(Arena arena) {
        return new VkAllocationCallbacks(arena.allocate(LAYOUT));
    }

    public static VkAllocationCallbacks.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkAllocationCallbacks.Ptr(segment);
    }

    public static VkAllocationCallbacks clone(Arena arena, VkAllocationCallbacks src) {
        VkAllocationCallbacks ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pUserData() {
        return segment.get(LAYOUT$pUserData, OFFSET$pUserData);
    }

    public VkAllocationCallbacks pUserData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pUserData, OFFSET$pUserData, value);
        return this;
    }

    public VkAllocationCallbacks pUserData(@Nullable IPointer pointer) {
        pUserData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkAllocationFunction") @NotNull MemorySegment pfnAllocation() {
        return segment.get(LAYOUT$pfnAllocation, OFFSET$pfnAllocation);
    }

    public VkAllocationCallbacks pfnAllocation(@Pointer(comment="PFN_vkAllocationFunction") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pfnAllocation, OFFSET$pfnAllocation, value);
        return this;
    }

    public VkAllocationCallbacks pfnAllocation(@NotNull IPFN_vkAllocationFunction value) {
        return pfnAllocation(IPFN_vkAllocationFunction.ofNative(value));
    }

    public VkAllocationCallbacks pfnAllocation(@NotNull Arena arena, @NotNull IPFN_vkAllocationFunction value) {
        return pfnAllocation(IPFN_vkAllocationFunction.ofNative(arena, value));
    }

    public VkAllocationCallbacks pfnAllocation(@Nullable IPointer pointer) {
        pfnAllocation(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkReallocationFunction") @NotNull MemorySegment pfnReallocation() {
        return segment.get(LAYOUT$pfnReallocation, OFFSET$pfnReallocation);
    }

    public VkAllocationCallbacks pfnReallocation(@Pointer(comment="PFN_vkReallocationFunction") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pfnReallocation, OFFSET$pfnReallocation, value);
        return this;
    }

    public VkAllocationCallbacks pfnReallocation(@NotNull IPFN_vkReallocationFunction value) {
        return pfnReallocation(IPFN_vkReallocationFunction.ofNative(value));
    }

    public VkAllocationCallbacks pfnReallocation(@NotNull Arena arena, @NotNull IPFN_vkReallocationFunction value) {
        return pfnReallocation(IPFN_vkReallocationFunction.ofNative(arena, value));
    }

    public VkAllocationCallbacks pfnReallocation(@Nullable IPointer pointer) {
        pfnReallocation(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkFreeFunction") @NotNull MemorySegment pfnFree() {
        return segment.get(LAYOUT$pfnFree, OFFSET$pfnFree);
    }

    public VkAllocationCallbacks pfnFree(@Pointer(comment="PFN_vkFreeFunction") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pfnFree, OFFSET$pfnFree, value);
        return this;
    }

    public VkAllocationCallbacks pfnFree(@NotNull IPFN_vkFreeFunction value) {
        return pfnFree(IPFN_vkFreeFunction.ofNative(value));
    }

    public VkAllocationCallbacks pfnFree(@NotNull Arena arena, @NotNull IPFN_vkFreeFunction value) {
        return pfnFree(IPFN_vkFreeFunction.ofNative(arena, value));
    }

    public VkAllocationCallbacks pfnFree(@Nullable IPointer pointer) {
        pfnFree(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkInternalAllocationNotification") @NotNull MemorySegment pfnInternalAllocation() {
        return segment.get(LAYOUT$pfnInternalAllocation, OFFSET$pfnInternalAllocation);
    }

    public VkAllocationCallbacks pfnInternalAllocation(@Pointer(comment="PFN_vkInternalAllocationNotification") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pfnInternalAllocation, OFFSET$pfnInternalAllocation, value);
        return this;
    }

    public VkAllocationCallbacks pfnInternalAllocation(@NotNull IPFN_vkInternalAllocationNotification value) {
        return pfnInternalAllocation(IPFN_vkInternalAllocationNotification.ofNative(value));
    }

    public VkAllocationCallbacks pfnInternalAllocation(@NotNull Arena arena, @NotNull IPFN_vkInternalAllocationNotification value) {
        return pfnInternalAllocation(IPFN_vkInternalAllocationNotification.ofNative(arena, value));
    }

    public VkAllocationCallbacks pfnInternalAllocation(@Nullable IPointer pointer) {
        pfnInternalAllocation(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="PFN_vkInternalFreeNotification") @NotNull MemorySegment pfnInternalFree() {
        return segment.get(LAYOUT$pfnInternalFree, OFFSET$pfnInternalFree);
    }

    public VkAllocationCallbacks pfnInternalFree(@Pointer(comment="PFN_vkInternalFreeNotification") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pfnInternalFree, OFFSET$pfnInternalFree, value);
        return this;
    }

    public VkAllocationCallbacks pfnInternalFree(@NotNull IPFN_vkInternalFreeNotification value) {
        return pfnInternalFree(IPFN_vkInternalFreeNotification.ofNative(value));
    }

    public VkAllocationCallbacks pfnInternalFree(@NotNull Arena arena, @NotNull IPFN_vkInternalFreeNotification value) {
        return pfnInternalFree(IPFN_vkInternalFreeNotification.ofNative(arena, value));
    }

    public VkAllocationCallbacks pfnInternalFree(@Nullable IPointer pointer) {
        pfnInternalFree(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("pUserData"),
        ValueLayout.ADDRESS.withName("pfnAllocation"),
        ValueLayout.ADDRESS.withName("pfnReallocation"),
        ValueLayout.ADDRESS.withName("pfnFree"),
        ValueLayout.ADDRESS.withName("pfnInternalAllocation"),
        ValueLayout.ADDRESS.withName("pfnInternalFree")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pUserData = PathElement.groupElement("pUserData");
    public static final PathElement PATH$pfnAllocation = PathElement.groupElement("pfnAllocation");
    public static final PathElement PATH$pfnReallocation = PathElement.groupElement("pfnReallocation");
    public static final PathElement PATH$pfnFree = PathElement.groupElement("pfnFree");
    public static final PathElement PATH$pfnInternalAllocation = PathElement.groupElement("pfnInternalAllocation");
    public static final PathElement PATH$pfnInternalFree = PathElement.groupElement("pfnInternalFree");

    public static final AddressLayout LAYOUT$pUserData = (AddressLayout) LAYOUT.select(PATH$pUserData);
    public static final AddressLayout LAYOUT$pfnAllocation = (AddressLayout) LAYOUT.select(PATH$pfnAllocation);
    public static final AddressLayout LAYOUT$pfnReallocation = (AddressLayout) LAYOUT.select(PATH$pfnReallocation);
    public static final AddressLayout LAYOUT$pfnFree = (AddressLayout) LAYOUT.select(PATH$pfnFree);
    public static final AddressLayout LAYOUT$pfnInternalAllocation = (AddressLayout) LAYOUT.select(PATH$pfnInternalAllocation);
    public static final AddressLayout LAYOUT$pfnInternalFree = (AddressLayout) LAYOUT.select(PATH$pfnInternalFree);

    public static final long SIZE$pUserData = LAYOUT$pUserData.byteSize();
    public static final long SIZE$pfnAllocation = LAYOUT$pfnAllocation.byteSize();
    public static final long SIZE$pfnReallocation = LAYOUT$pfnReallocation.byteSize();
    public static final long SIZE$pfnFree = LAYOUT$pfnFree.byteSize();
    public static final long SIZE$pfnInternalAllocation = LAYOUT$pfnInternalAllocation.byteSize();
    public static final long SIZE$pfnInternalFree = LAYOUT$pfnInternalFree.byteSize();

    public static final long OFFSET$pUserData = LAYOUT.byteOffset(PATH$pUserData);
    public static final long OFFSET$pfnAllocation = LAYOUT.byteOffset(PATH$pfnAllocation);
    public static final long OFFSET$pfnReallocation = LAYOUT.byteOffset(PATH$pfnReallocation);
    public static final long OFFSET$pfnFree = LAYOUT.byteOffset(PATH$pfnFree);
    public static final long OFFSET$pfnInternalAllocation = LAYOUT.byteOffset(PATH$pfnInternalAllocation);
    public static final long OFFSET$pfnInternalFree = LAYOUT.byteOffset(PATH$pfnInternalFree);
}
