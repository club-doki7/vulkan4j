package club.doki7.opencl;

import java.lang.foreign.*;
import java.lang.invoke.*;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.NativeLayout;
import org.jetbrains.annotations.NotNull;
import club.doki7.opencl.datatype.*;
import club.doki7.opencl.handle.*;

public final class CLFunctionTypes {
    public static final FunctionDescriptor pfn_free_func_0 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_free_func_1 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_0 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
        ValueLayout.ADDRESS,
        NativeLayout.C_SIZE_T,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_1 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
        ValueLayout.ADDRESS,
        NativeLayout.C_SIZE_T,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_2 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_3 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_4 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_5 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_6 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_7 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_8 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor pfn_notify_9 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS,
        ValueLayout.JAVA_INT,
        ValueLayout.ADDRESS
    );

    public static final FunctionDescriptor user_func_0 = FunctionDescriptor.ofVoid(
        ValueLayout.ADDRESS
    );

    @FunctionalInterface
    public interface Ipfn_free_func_0 {
        void invoke(
            @NativeType("CLCommandQueue") MemorySegment p0,
            @NativeType("cl_uint") @Unsigned int p1,
            @Pointer(comment="void*") @NotNull MemorySegment p2,
            @Pointer(comment="void*") @NotNull MemorySegment p3
        );

        static MethodHandle of(@NotNull Ipfn_free_func_0 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_free_func_0.class, "invoke", pfn_free_func_0.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_free_func_0 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_free_func_0 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_free_func_0, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_free_func_1 {
        void invoke(
            @NativeType("CLCommandQueue") MemorySegment p0,
            @NativeType("cl_uint") @Unsigned int p1,
            @Pointer(comment="void*") @NotNull MemorySegment p2,
            @Pointer(comment="void*") @NotNull MemorySegment p3
        );

        static MethodHandle of(@NotNull Ipfn_free_func_1 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_free_func_1.class, "invoke", pfn_free_func_1.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_free_func_1 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_free_func_1 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_free_func_1, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_0 {
        void invoke(
            @Pointer(comment="void*") @NotNull MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1,
            @NativeType("size_t") MemorySegment p2,
            @Pointer(comment="void*") @NotNull MemorySegment p3
        );

        static MethodHandle of(@NotNull Ipfn_notify_0 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_0.class, "invoke", pfn_notify_0.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_0 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_0 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_0, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_1 {
        void invoke(
            @Pointer(comment="void*") @NotNull MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1,
            @NativeType("size_t") MemorySegment p2,
            @Pointer(comment="void*") @NotNull MemorySegment p3
        );

        static MethodHandle of(@NotNull Ipfn_notify_1 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_1.class, "invoke", pfn_notify_1.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_1 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_1 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_1, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_2 {
        void invoke(
            @NativeType("CLContext") MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1
        );

        static MethodHandle of(@NotNull Ipfn_notify_2 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_2.class, "invoke", pfn_notify_2.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_2 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_2 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_2, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_3 {
        void invoke(
            @NativeType("CLMem") MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1
        );

        static MethodHandle of(@NotNull Ipfn_notify_3 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_3.class, "invoke", pfn_notify_3.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_3 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_3 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_3, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_4 {
        void invoke(
            @NativeType("CLMem") MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1
        );

        static MethodHandle of(@NotNull Ipfn_notify_4 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_4.class, "invoke", pfn_notify_4.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_4 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_4 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_4, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_5 {
        void invoke(
            @NativeType("CLProgram") MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1
        );

        static MethodHandle of(@NotNull Ipfn_notify_5 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_5.class, "invoke", pfn_notify_5.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_5 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_5 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_5, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_6 {
        void invoke(
            @NativeType("CLProgram") MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1
        );

        static MethodHandle of(@NotNull Ipfn_notify_6 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_6.class, "invoke", pfn_notify_6.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_6 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_6 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_6, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_7 {
        void invoke(
            @NativeType("CLProgram") MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1
        );

        static MethodHandle of(@NotNull Ipfn_notify_7 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_7.class, "invoke", pfn_notify_7.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_7 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_7 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_7, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_8 {
        void invoke(
            @NativeType("CLProgram") MemorySegment p0,
            @Pointer(comment="void*") @NotNull MemorySegment p1
        );

        static MethodHandle of(@NotNull Ipfn_notify_8 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_8.class, "invoke", pfn_notify_8.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_8 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_8 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_8, arena);
        }
    }

    @FunctionalInterface
    public interface Ipfn_notify_9 {
        void invoke(
            @NativeType("CLEvent") MemorySegment p0,
            @NativeType("cl_int") int p1,
            @Pointer(comment="void*") @NotNull MemorySegment p2
        );

        static MethodHandle of(@NotNull Ipfn_notify_9 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Ipfn_notify_9.class, "invoke", pfn_notify_9.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Ipfn_notify_9 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Ipfn_notify_9 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), pfn_notify_9, arena);
        }
    }

    @FunctionalInterface
    public interface Iuser_func_0 {
        void invoke(
            @Pointer(comment="void*") @NotNull MemorySegment p0
        );

        static MethodHandle of(@NotNull Iuser_func_0 lambda) {
            try {
                return MethodHandles.lookup().findVirtual(Iuser_func_0.class, "invoke", user_func_0.toMethodType()).bindTo(lambda);
            }
            catch (NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        static MemorySegment ofNative(@NotNull Iuser_func_0 lambda) {
            return ofNative(Arena.global(), lambda);
        }

        static MemorySegment ofNative(@NotNull Arena arena, @NotNull Iuser_func_0 lambda) {
            return Linker.nativeLinker().upcallStub(of(lambda), user_func_0, arena);
        }
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private CLFunctionTypes() {}
}
