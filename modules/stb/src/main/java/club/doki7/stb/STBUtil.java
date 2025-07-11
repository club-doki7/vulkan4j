package club.doki7.stb;

import club.doki7.ffm.RawFunctionLoader;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

public final class STBUtil {
    public STBUtil(RawFunctionLoader loader) {
        PFN$freeMemory = loader.load("vk4jStbFreeMemory");
        if (PFN$freeMemory.equals(MemorySegment.NULL)) {
            MH$freeMemory = null;
        } else {
            MH$freeMemory = RawFunctionLoader.link(PFN$freeMemory, DESCRIPTOR$freeMemory);
        }
    }

    public boolean hasFreeMemory() {
        return MH$freeMemory != null;
    }

    /// Free memory allocated by STB functions.
    ///
    /// Some STB functions, `stb_vorbis_decode*` series for example, allocate memory internally
    /// implicitly with linked libc `malloc`. This method allows you to free that memory with `free`
    /// from the (theoretically) same libc implementation. To use this method, you need to use an
    /// STB build that supports `vk4jStbFreeMemory` function. See `stb_build` for more details.
    ///
    /// If this method is not accessible anyway,
    /// {@link club.doki7.ffm.LibcArena#freeNonAllocated LibcArena.freeNonAllocated} is an
    /// alternative with some risk.
    public void freeMemory(MemorySegment segment) {
        if (!hasFreeMemory()) {
            System.err.println("warn: freeMemory: vk4jStbFreeMemory not found");
            System.err.println("note: obviously you're not using a STB build supporting freeMemory");
            System.err.println("note: checkout vulkan4j/stb/stb_build to see how to enable freeMemory");
            return;
        }

        try {
            MH$freeMemory.invokeExact(segment);
        } catch (Throwable e) {
            System.err.println("error: failed invoking vk4jStbFreeMemory, please open an issue");
        }
    }

    public final MemorySegment PFN$freeMemory;
    public final MethodHandle MH$freeMemory;

    public static final FunctionDescriptor DESCRIPTOR$freeMemory =
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
}
