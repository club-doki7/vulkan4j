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

    public void freeMemory(MemorySegment segment) {
        if (MH$freeMemory == null) {
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
