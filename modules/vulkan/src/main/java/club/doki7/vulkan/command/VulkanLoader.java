package club.doki7.vulkan.command;

import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.library.UnixLibraryLoader;
import club.doki7.ffm.library.WindowsLibraryLoader;
import club.doki7.ffm.ptr.BytePtr;
import club.doki7.vulkan.handle.VkDevice;
import club.doki7.vulkan.handle.VkInstance;
import org.jetbrains.annotations.NotNull;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;

/// Utility class for loading Vulkan functions
public final class VulkanLoader {
    /// Try loading the Vulkan library.
    ///
    /// This function is implemented in terms of
    /// {@link club.doki7.ffm.library.ILibraryLoader#loadLibrary(String) ILibraryLoader.loadLibary(String)}.
    /// On Windows it will try {@code "vulkan-1"} ({@code vulkan-1.dll}), and on other platforms it
    /// will try {@code "vulkan"} ({@code libvulkan.so} or {@code libvulkan.dylib}).
    ///
    /// Instead of using this function, you may also implement your own Vulkan library loading
    /// logic.
    ///
    /// <b>Notice for Linux users:</b> On some Linux platforms, {@code libvulkan.so} may not be
    /// installed under {@code /usr/lib},  {@code /usr/lib32} or {@code /usr/lib64}. For example,
    /// on my Debian 12 system, it is installed under <code>/lib/<i>cpu-os-libc-triplet</i></code>.
    /// Such locations might not be included by Java {@code java.library.path}. In that case,
    /// you may need to set the  {@code LD_LIBRARY_PATH} environment variable to include the
    /// directory where {@code libvulkan.so} is installed.
    ///
    /// <b>Notice for macOS users</b>: According to my observation, as long as the
    /// {@code libvulkan.dylib} is contained in the {@code java.library.path}, it will be loaded
    /// correctly. Since {@code java.library.path} includes {@code .} (i.e. {@code cwd}), when
    /// developing on macOS, you may simply symlink the {@code libvulkan.dylib} (provided by
    /// MoltenVk) to the project root directory. But by this moment the project maintainer don't
    /// have any knowledge on macOS software packaging. You may need to implement your own loading
    /// logic when packaging and releasing software. Contributions are welcome.
    ///
    /// @throws UnsatisfiedLinkError see {@link club.doki7.ffm.library.ILibraryLoader#loadLibrary(String) ILibraryLoader.loadLibrary(String)}
    public static ISharedLibrary loadVulkanLibrary() {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            return WindowsLibraryLoader.INSTANCE.loadLibrary("vulkan-1");
        } else {
            return UnixLibraryLoader.INSTANCE.loadLibrary("vulkan");
        }
    }

    /// Load Vulkan static commands.
    ///
    /// This function is in effect implemented in terms of
    /// {@link ISharedLibrary#load(String)} +
    /// {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}. If any
    /// of the static functions is not found, a {@link RuntimeException} will be thrown. If any of
    /// the functions cannot be linked due to any reason, the relevant exception will be thrown.
    ///
    /// Instead of using this function, you may also implement your own commands loading logic.
    ///
    /// @return loaded static commands
    /// @throws RuntimeException if any static function is not found
    /// @throws IllegalArgumentException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    /// @throws IllegalCallerException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    public static @NotNull VkStaticCommands loadStaticCommands(ISharedLibrary libVulkan) {
        return new VkStaticCommands(libVulkan);
    }

    /// Load Vulkan entry commands.
    ///
    /// This function is in effect implemented in terms of
    /// {@link VkStaticCommands#getInstanceProcAddr(VkInstance, BytePtr)} +
    /// {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}, while
    /// not providing actual pointer to the {@link VkInstance}. If any of the static functions is
    /// not found, a {@link RuntimeException} will be thrown. If any of the functions cannot be
    /// linked due to any reason, the relevant exception will be thrown.
    ///
    /// Instead of using this function, you may also implement your own commands loading logic.
    ///
    /// @param staticCommands static commands, providing the {@code vkGetInstanceProcAddr} function
    /// @return loaded entry commands
    /// @throws RuntimeException if any entry function is not found
    /// @throws IllegalArgumentException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    /// @throws IllegalCallerException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    public static @NotNull VkEntryCommands loadEntryCommands(
        @NotNull VkStaticCommands staticCommands
    ) {
        return new VkEntryCommands(name -> {
            try (Arena arena = Arena.ofConfined()) {
                MemorySegment s = staticCommands.getInstanceProcAddr(null, BytePtr.allocateString(arena, name));
                if (s.equals(MemorySegment.NULL)) {
                    throw new RuntimeException("Vulkan entry function " + name + " not found");
                }
                return s;
            }
        });
    }

    /// Load Vulkan instance commands.
    ///
    /// This function is implemented in terms of
    /// {@link VkStaticCommands#getInstanceProcAddr(VkInstance, BytePtr)} +
    /// {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}. If any
    /// of the functions is not found, that "slot" will be filled with {@code null}. Calling a
    /// function not loaded will result in a {@link NullPointerException}. Not found functions are
    /// usually caused by unsupported or **not requested** Vulkan extensions or layers.
    ///
    /// If the function address is found, but cannot be linked due to any reason, the relevant
    /// exception will be thrown.
    ///
    /// Instead of using this function, you may also implement your own commands loading logic.
    ///
    /// @param instance Vulkan instance
    /// @param staticCommands static commands, providing the {@code vkGetInstanceProcAddr} function
    /// @return loaded instance commands
    /// @throws IllegalArgumentException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    /// @throws IllegalCallerException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    public static @NotNull VkInstanceCommands loadInstanceCommands(
        @NotNull VkInstance instance,
        @NotNull VkStaticCommands staticCommands
    ) {
        return new VkInstanceCommands(name -> {
            try (Arena arena = Arena.ofConfined()) {
                return staticCommands.getInstanceProcAddr(instance, BytePtr.allocateString(arena, name));
            }
        });
    }

    /// Load Vulkan device commands.
    ///
    /// This function is implemented in terms of
    /// {@link VkStaticCommands#getDeviceProcAddr(VkDevice, BytePtr)} +
    /// {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}. If any
    /// of the functions is not found, that "slot" will be filled with {@code null}. Calling a
    /// function not loaded will result in a {@link NullPointerException}. Not found functions are
    /// usually caused by unsupported or **not requested** Vulkan extensions or layers.
    ///
    /// If the function address is found, but cannot be linked due to any reason, the relevant
    /// exception will be thrown.
    ///
    /// Instead of using this function, you may also implement your own commands loading logic.
    ///
    /// @param device Vulkan device
    /// @param staticCommands static commands, providing the loading functions
    /// @return loaded device commands
    /// @throws IllegalArgumentException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    /// @throws IllegalCallerException see {@link Linker#downcallHandle(MemorySegment, FunctionDescriptor, Linker.Option...)}
    public static @NotNull VkDeviceCommands loadDeviceCommands(
        @NotNull VkDevice device,
        @NotNull VkStaticCommands staticCommands
    ) {
        return new VkDeviceCommands(name -> {
            try (Arena arena = Arena.ofConfined()) {
                return staticCommands.getDeviceProcAddr(device, BytePtr.allocateString(arena, name));
            }
        });
    }

    private VulkanLoader() {}
}
