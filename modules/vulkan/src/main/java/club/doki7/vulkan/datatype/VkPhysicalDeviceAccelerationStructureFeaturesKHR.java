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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceAccelerationStructureFeaturesKHR.html"><code>VkPhysicalDeviceAccelerationStructureFeaturesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceAccelerationStructureFeaturesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 accelerationStructure; // @link substring="accelerationStructure" target="#accelerationStructure"
///     VkBool32 accelerationStructureCaptureReplay; // @link substring="accelerationStructureCaptureReplay" target="#accelerationStructureCaptureReplay"
///     VkBool32 accelerationStructureIndirectBuild; // @link substring="accelerationStructureIndirectBuild" target="#accelerationStructureIndirectBuild"
///     VkBool32 accelerationStructureHostCommands; // @link substring="accelerationStructureHostCommands" target="#accelerationStructureHostCommands"
///     VkBool32 descriptorBindingAccelerationStructureUpdateAfterBind; // @link substring="descriptorBindingAccelerationStructureUpdateAfterBind" target="#descriptorBindingAccelerationStructureUpdateAfterBind"
/// } VkPhysicalDeviceAccelerationStructureFeaturesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_FEATURES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceAccelerationStructureFeaturesKHR#allocate(Arena)}, {@link VkPhysicalDeviceAccelerationStructureFeaturesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceAccelerationStructureFeaturesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceAccelerationStructureFeaturesKHR.html"><code>VkPhysicalDeviceAccelerationStructureFeaturesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceAccelerationStructureFeaturesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceAccelerationStructureFeaturesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceAccelerationStructureFeaturesKHR.html"><code>VkPhysicalDeviceAccelerationStructureFeaturesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceAccelerationStructureFeaturesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceAccelerationStructureFeaturesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceAccelerationStructureFeaturesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceAccelerationStructureFeaturesKHR, Iterable<VkPhysicalDeviceAccelerationStructureFeaturesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceAccelerationStructureFeaturesKHR at(long index) {
            return new VkPhysicalDeviceAccelerationStructureFeaturesKHR(segment.asSlice(index * VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES, VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceAccelerationStructureFeaturesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceAccelerationStructureFeaturesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceAccelerationStructureFeaturesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES, VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES,
                (end - start) * VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceAccelerationStructureFeaturesKHR[] toArray() {
            VkPhysicalDeviceAccelerationStructureFeaturesKHR[] ret = new VkPhysicalDeviceAccelerationStructureFeaturesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceAccelerationStructureFeaturesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceAccelerationStructureFeaturesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceAccelerationStructureFeaturesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceAccelerationStructureFeaturesKHR ret = new VkPhysicalDeviceAccelerationStructureFeaturesKHR(segment.asSlice(0, VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceAccelerationStructureFeaturesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceAccelerationStructureFeaturesKHR allocate(Arena arena) {
        VkPhysicalDeviceAccelerationStructureFeaturesKHR ret = new VkPhysicalDeviceAccelerationStructureFeaturesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_FEATURES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceAccelerationStructureFeaturesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceAccelerationStructureFeaturesKHR.Ptr ret = new VkPhysicalDeviceAccelerationStructureFeaturesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_FEATURES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceAccelerationStructureFeaturesKHR clone(Arena arena, VkPhysicalDeviceAccelerationStructureFeaturesKHR src) {
        VkPhysicalDeviceAccelerationStructureFeaturesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_FEATURES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int accelerationStructure() {
        return segment.get(LAYOUT$accelerationStructure, OFFSET$accelerationStructure);
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR accelerationStructure(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$accelerationStructure, OFFSET$accelerationStructure, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int accelerationStructureCaptureReplay() {
        return segment.get(LAYOUT$accelerationStructureCaptureReplay, OFFSET$accelerationStructureCaptureReplay);
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR accelerationStructureCaptureReplay(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$accelerationStructureCaptureReplay, OFFSET$accelerationStructureCaptureReplay, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int accelerationStructureIndirectBuild() {
        return segment.get(LAYOUT$accelerationStructureIndirectBuild, OFFSET$accelerationStructureIndirectBuild);
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR accelerationStructureIndirectBuild(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$accelerationStructureIndirectBuild, OFFSET$accelerationStructureIndirectBuild, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int accelerationStructureHostCommands() {
        return segment.get(LAYOUT$accelerationStructureHostCommands, OFFSET$accelerationStructureHostCommands);
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR accelerationStructureHostCommands(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$accelerationStructureHostCommands, OFFSET$accelerationStructureHostCommands, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingAccelerationStructureUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingAccelerationStructureUpdateAfterBind, OFFSET$descriptorBindingAccelerationStructureUpdateAfterBind);
    }

    public VkPhysicalDeviceAccelerationStructureFeaturesKHR descriptorBindingAccelerationStructureUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingAccelerationStructureUpdateAfterBind, OFFSET$descriptorBindingAccelerationStructureUpdateAfterBind, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("accelerationStructure"),
        ValueLayout.JAVA_INT.withName("accelerationStructureCaptureReplay"),
        ValueLayout.JAVA_INT.withName("accelerationStructureIndirectBuild"),
        ValueLayout.JAVA_INT.withName("accelerationStructureHostCommands"),
        ValueLayout.JAVA_INT.withName("descriptorBindingAccelerationStructureUpdateAfterBind")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$accelerationStructure = PathElement.groupElement("accelerationStructure");
    public static final PathElement PATH$accelerationStructureCaptureReplay = PathElement.groupElement("accelerationStructureCaptureReplay");
    public static final PathElement PATH$accelerationStructureIndirectBuild = PathElement.groupElement("accelerationStructureIndirectBuild");
    public static final PathElement PATH$accelerationStructureHostCommands = PathElement.groupElement("accelerationStructureHostCommands");
    public static final PathElement PATH$descriptorBindingAccelerationStructureUpdateAfterBind = PathElement.groupElement("descriptorBindingAccelerationStructureUpdateAfterBind");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$accelerationStructure = (OfInt) LAYOUT.select(PATH$accelerationStructure);
    public static final OfInt LAYOUT$accelerationStructureCaptureReplay = (OfInt) LAYOUT.select(PATH$accelerationStructureCaptureReplay);
    public static final OfInt LAYOUT$accelerationStructureIndirectBuild = (OfInt) LAYOUT.select(PATH$accelerationStructureIndirectBuild);
    public static final OfInt LAYOUT$accelerationStructureHostCommands = (OfInt) LAYOUT.select(PATH$accelerationStructureHostCommands);
    public static final OfInt LAYOUT$descriptorBindingAccelerationStructureUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingAccelerationStructureUpdateAfterBind);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$accelerationStructure = LAYOUT$accelerationStructure.byteSize();
    public static final long SIZE$accelerationStructureCaptureReplay = LAYOUT$accelerationStructureCaptureReplay.byteSize();
    public static final long SIZE$accelerationStructureIndirectBuild = LAYOUT$accelerationStructureIndirectBuild.byteSize();
    public static final long SIZE$accelerationStructureHostCommands = LAYOUT$accelerationStructureHostCommands.byteSize();
    public static final long SIZE$descriptorBindingAccelerationStructureUpdateAfterBind = LAYOUT$descriptorBindingAccelerationStructureUpdateAfterBind.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$accelerationStructure = LAYOUT.byteOffset(PATH$accelerationStructure);
    public static final long OFFSET$accelerationStructureCaptureReplay = LAYOUT.byteOffset(PATH$accelerationStructureCaptureReplay);
    public static final long OFFSET$accelerationStructureIndirectBuild = LAYOUT.byteOffset(PATH$accelerationStructureIndirectBuild);
    public static final long OFFSET$accelerationStructureHostCommands = LAYOUT.byteOffset(PATH$accelerationStructureHostCommands);
    public static final long OFFSET$descriptorBindingAccelerationStructureUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingAccelerationStructureUpdateAfterBind);
}
