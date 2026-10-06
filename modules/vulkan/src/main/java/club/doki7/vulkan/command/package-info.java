/// Vulkan API commands
///
/// ## Quick start
///
/// ### Vulkan function pointers initialization stages
///
/// Vulkan commands are basically Vulkan API functions. There are four classes of Vulkan commands:
/// - static commands ({@link club.doki7.vulkan.command.VkStaticCommands VkStaticCommands}):
/// The Vulkan commands loaded in a platform-specific manner that can then used to load the other
/// commands (i.e., {@code vkGetInstanceProcAddr} and {@code vkGetDeviceProcAddr})
/// - entry commands ({@link club.doki7.vulkan.command.VkEntryCommands VkEntryCommands}):
/// The Vulkan commands loaded using {@code vkGetInstanceProcAddr} and a null Vulkan instance. These
/// commands are not tied to a specific Vulkan instance and are used to query instance support and
/// create instances
/// - instance commands ({@link club.doki7.vulkan.command.VkInstanceCommands VkInstanceCommands}):
/// The Vulkan commands loaded using {@code vkGetInstanceProcAddr} and a valid Vulkan instance.
/// These commands are tied to a specific Vulkan instance and, among other things, are used to query
/// device support and create devices
/// - device commands ({@link club.doki7.vulkan.command.VkDeviceCommands VkDeviceCommands}):
/// The Vulkan commands loaded using {@code vkGetDeviceProcAddr} and a valid Vulkan device. These
/// commands are tied to a specific Vulkan device and expose most of the functionality you would
/// expect from a graphics API
///
/// For more information, read the relevant
/// <a href="https://registry.khronos.org/vulkan/specs/latest/html/vkspec.html#initialization-functionpointers">Vulkan specification part</a>.
///
/// ### The {@link club.doki7.vulkan.command.VulkanLoader VulkanLoader} class
///
/// To load these commands, the simplest way is to use
/// {@link club.doki7.vulkan.command.VulkanLoader VulkanLoader} provided:
///
/// {@snippet :
/// // load the Vulkan library, typically libvulkan.so or vulkan-1.dll
/// VulkanLoader.loadVulkanLibrary();
///
/// // load the static commands
/// VkStaticCommands staticCommands = VulkanLoader.loadStaticCommands();
/// // load the entry commands
/// VkEntryCommands entryCommands = VulkanLoader.loadEntryCommands(staticCommands);
///
/// // create vulkan instance
/// VkInstance instance = createVulkanInstance(entryCommands);
/// // load the instance commands
/// VkInstanceCommands instanceCommands = VulkanLoader.loadInstanceCommands(staticCommands, instance);
///
/// // create vulkan device
/// VkDevice device = createVulkanDevice(instanceCommands, instance);
/// // load the device commands
/// VkDeviceCommands deviceCommands = VulkanLoader.loadDeviceCommands(staticCommands, device);
/// }
///
/// See the documentation of each class for more details.
package club.doki7.vulkan.command;
