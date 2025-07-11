package example.vulkan;

import club.doki7.ffm.annotation.Bitmask;
import club.doki7.ffm.annotation.NativeType;
import club.doki7.ffm.annotation.Pointer;
import club.doki7.ffm.annotation.Unsigned;
import club.doki7.ffm.library.ILibraryLoader;
import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.ptr.BytePtr;
import club.doki7.ffm.ptr.FloatPtr;
import club.doki7.ffm.ptr.IntPtr;
import club.doki7.ffm.ptr.PointerPtr;
import club.doki7.vma.VMA;
import club.doki7.vma.VMAJavaTraceUtil;
import club.doki7.vma.VMAUtil;
import club.doki7.vma.bitmask.VmaAllocationCreateFlags;
import club.doki7.vma.datatype.VmaAllocationCreateInfo;
import club.doki7.vma.datatype.VmaAllocationInfo;
import club.doki7.vma.datatype.VmaAllocatorCreateInfo;
import club.doki7.vma.datatype.VmaVulkanFunctions;
import club.doki7.vma.enumtype.VmaMemoryUsage;
import club.doki7.vma.handle.VmaAllocation;
import club.doki7.vma.handle.VmaAllocator;
import club.doki7.vulkan.Version;
import club.doki7.vulkan.VkConstants;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.command.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;


final class Application {
    static void applicationStart(ISharedLibrary libVMA, VkStaticCommands sCmd, VkEntryCommands eCmd, Arena arena) {
        // region 1. instance creation
        VkApplicationInfo applicationInfo = VkApplicationInfo.allocate(arena)
                .pApplicationName(BytePtr.allocateString(arena, "Compute Shader Example"))
                .applicationVersion(new Version(1, 0, 0, 0).encode())
                .pEngineName(BytePtr.allocateString(arena, "Doki7 Engine"))
                .engineVersion(new Version(1, 0, 0, 0).encode())
                .apiVersion(Version.VK_API_VERSION_1_0.encode());

        VkInstanceCreateInfo instanceCreateInfo = VkInstanceCreateInfo.allocate(arena)
                .pApplicationInfo(applicationInfo)
                .enabledLayerCount(1)
                .ppEnabledLayerNames(PointerPtr.allocateV(arena, BytePtr.allocateString(arena, VALIDATION_LAYER_NAME)))
                .enabledExtensionCount(1)
                .ppEnabledExtensionNames(PointerPtr.allocateV(arena, BytePtr.allocateString(arena, VkConstants.EXT_DEBUG_UTILS_EXTENSION_NAME)));

        VkDebugUtilsMessengerCreateInfoEXT debugUtilsMessengerCreateInfo = VkDebugUtilsMessengerCreateInfoEXT.allocate(arena)
                .messageSeverity(
                        VkDebugUtilsMessageSeverityFlagsEXT.VERBOSE
                        | VkDebugUtilsMessageSeverityFlagsEXT.WARNING
                        | VkDebugUtilsMessageSeverityFlagsEXT.ERROR
                ).messageType(
                        VkDebugUtilsMessageTypeFlagsEXT.GENERAL
                        | VkDebugUtilsMessageTypeFlagsEXT.VALIDATION
                        | VkDebugUtilsMessageTypeFlagsEXT.PERFORMANCE
                ).pfnUserCallback(Application::debugCallback);

        instanceCreateInfo.pNext(debugUtilsMessengerCreateInfo);

        VkInstance.Ptr pInstance = VkInstance.Ptr.allocate(arena);
        int result = eCmd.createInstance(instanceCreateInfo, null, pInstance);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create Vulkan instance: " + VkResult.explain(result));
        }
        VkInstance instance = Objects.requireNonNull(pInstance.read());
        VkInstanceCommands iCmd = VulkanLoader.loadInstanceCommands(instance, sCmd);
        // endregion

        // region 2. debug messenger creation
        VkDebugUtilsMessengerEXT.Ptr pMessenger = VkDebugUtilsMessengerEXT.Ptr.allocate(arena);
        result = iCmd.createDebugUtilsMessengerEXT(
                instance,
                debugUtilsMessengerCreateInfo,
                null,
                pMessenger
        );
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create debug messenger: " + VkResult.explain(result));
        }
        VkDebugUtilsMessengerEXT messenger = Objects.requireNonNull(pMessenger.read());
        // endregion

        // region 3. pick physical device
        IntPtr pPhysicalDeviceCount = IntPtr.allocate(arena);
        result = iCmd.enumeratePhysicalDevices(instance, pPhysicalDeviceCount, null);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to enumerate physical devices: " + VkResult.explain(result));
        }
        int physicalDeviceCount = pPhysicalDeviceCount.read();
        if (physicalDeviceCount == 0) {
            throw new RuntimeException("No physical devices found");
        }

        VkPhysicalDevice.Ptr pPhysicalDevices = VkPhysicalDevice.Ptr.allocate(arena, physicalDeviceCount);
        result = iCmd.enumeratePhysicalDevices(instance, pPhysicalDeviceCount, pPhysicalDevices);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to enumerate physical devices: " + VkResult.explain(result));
        }
        VkPhysicalDevice physicalDevice = Objects.requireNonNull(pPhysicalDevices.read(0));
        // endregion

        // region 4. find compute queue family
        IntPtr pQueueFamilyCount = IntPtr.allocate(arena);
        iCmd.getPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueFamilyCount, null);
        int queueFamilyCount = pQueueFamilyCount.read();
        if (queueFamilyCount == 0) {
            throw new RuntimeException("No queue families found");
        }
        VkQueueFamilyProperties.Ptr pQueueFamilies = VkQueueFamilyProperties.allocate(arena, queueFamilyCount);
        iCmd.getPhysicalDeviceQueueFamilyProperties(physicalDevice, pQueueFamilyCount, pQueueFamilies);

        int computeQueueFamilyIndex = -1;
        for (int i = 0; i < queueFamilyCount; i++) {
            VkQueueFamilyProperties queueFamily = pQueueFamilies.at(i);
            if ((queueFamily.queueFlags() & VkQueueFlags.COMPUTE) != 0) {
                computeQueueFamilyIndex = i;
                break;
            }
        }
        if (computeQueueFamilyIndex == -1) {
            throw new RuntimeException("No compute queue family found");
        }
        // endregion

        // region 5. create logical device and compute queue
        VkDeviceQueueCreateInfo pQueueCreateInfo = VkDeviceQueueCreateInfo.allocate(arena)
                .queueFamilyIndex(computeQueueFamilyIndex)
                .queueCount(1)
                .pQueuePriorities(FloatPtr.allocateV(arena, 1.0f));
        VkDeviceCreateInfo deviceCreateInfo = VkDeviceCreateInfo.allocate(arena)
                .queueCreateInfoCount(1)
                .pQueueCreateInfos(pQueueCreateInfo);
        VkDevice.Ptr pDevice = VkDevice.Ptr.allocate(arena);
        result = iCmd.createDevice(physicalDevice, deviceCreateInfo, null, pDevice);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create logical device: " + VkResult.explain(result));
        }
        VkDevice device = Objects.requireNonNull(pDevice.read());
        VkDeviceCommands dCmd = VulkanLoader.loadDeviceCommands(device, sCmd);
        // endregion

        // region 6. get compute queue
        VkQueue.Ptr pComputeQueue = VkQueue.Ptr.allocate(arena);
        dCmd.getDeviceQueue(device, computeQueueFamilyIndex, 0, pComputeQueue);
        VkQueue computeQueue = Objects.requireNonNull(pComputeQueue.read());
        // endregion

        // region 7. create shader module: read the binary file "example/resc/nop.comp.spv"
        byte[] shaderCode;
        try {
            shaderCode = Files.readAllBytes(Path.of("example/resc/nop.comp.spv"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read shader file: example/resc/nop.comp.spv", e);
        }
        assert shaderCode.length % 4 == 0 : "Shader code length must be a multiple of 4 bytes";
        IntPtr pShaderCode = IntPtr.allocate(arena, shaderCode);
        VkShaderModuleCreateInfo shaderModuleCreateInfo = VkShaderModuleCreateInfo.allocate(arena)
                .codeSize(shaderCode.length)
                .pCode(pShaderCode);
        VkShaderModule.Ptr pShaderModule = VkShaderModule.Ptr.allocate(arena);
        result = dCmd.createShaderModule(device, shaderModuleCreateInfo, null, pShaderModule);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create shader module: " + VkResult.explain(result));
        }
        VkShaderModule shaderModule = Objects.requireNonNull(pShaderModule.read());
        // endregion

        // region 8. create compute pipeline
        // 8.1 create Descriptor Set Layout
        VkDescriptorSetLayoutBinding descriptorSetLayoutBinding = VkDescriptorSetLayoutBinding.allocate(arena)
                .binding(0)
                .descriptorType(VkDescriptorType.STORAGE_IMAGE)
                .descriptorCount(1)
                .stageFlags(VkShaderStageFlags.COMPUTE);
        VkDescriptorSetLayoutCreateInfo descriptorSetLayoutCreateInfo = VkDescriptorSetLayoutCreateInfo.allocate(arena)
                .bindingCount(1)
                .pBindings(descriptorSetLayoutBinding);
        VkDescriptorSetLayout.Ptr pDescriptorSetLayout = VkDescriptorSetLayout.Ptr.allocate(arena);
        result = dCmd.createDescriptorSetLayout(device, descriptorSetLayoutCreateInfo, null, pDescriptorSetLayout);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create descriptor set layout: " + VkResult.explain(result));
        }
        VkDescriptorSetLayout descriptorSetLayout = Objects.requireNonNull(pDescriptorSetLayout.read());

        // 8.2 create Pipeline Layout
        VkPipelineLayoutCreateInfo pipelineLayoutCreateInfo = VkPipelineLayoutCreateInfo.allocate(arena)
                .setLayoutCount(1)
                .pSetLayouts(pDescriptorSetLayout); // Use the pointer to the layout

        VkPipelineLayout.Ptr pPipelineLayout = VkPipelineLayout.Ptr.allocate(arena);
        result = dCmd.createPipelineLayout(device, pipelineLayoutCreateInfo, null, pPipelineLayout);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create pipeline layout: " + VkResult.explain(result));
        }
        VkPipelineLayout pipelineLayout = Objects.requireNonNull(pPipelineLayout.read());

        // 8.3 create Compute Pipeline
        VkComputePipelineCreateInfo computePipelineCreateInfo = VkComputePipelineCreateInfo.allocate(arena)
                .stage(it -> it
                        .stage(VkShaderStageFlags.COMPUTE)
                        .module(shaderModule)
                        .pName(BytePtr.allocateString(arena, "main")))
                .layout(pipelineLayout);

        VkPipeline.Ptr pComputePipeline = VkPipeline.Ptr.allocate(arena);
        result = dCmd.createComputePipelines(device, null, 1, computePipelineCreateInfo, null, pComputePipeline);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create compute pipeline: " + VkResult.explain(result));
        }
        VkPipeline computePipeline = Objects.requireNonNull(pComputePipeline.read());
        // endregion

        // region 9. Load VMA
        VMAJavaTraceUtil.enableJavaTraceForVMA(libVMA);
        VMA vma = new VMA(libVMA);

        VmaVulkanFunctions vmaVulkanFunctions = VmaVulkanFunctions.allocate(arena);
        VMAUtil.fillVulkanFunctions(vmaVulkanFunctions, sCmd, eCmd, iCmd, dCmd);
        VmaAllocatorCreateInfo allocatorCreateInfo = VmaAllocatorCreateInfo.allocate(arena)
                .physicalDevice(physicalDevice)
                .device(device)
                .instance(instance)
                .vulkanApiVersion(Version.VK_API_VERSION_1_0.encode())
                .pVulkanFunctions(vmaVulkanFunctions);
        VmaAllocator.Ptr pAllocator = VmaAllocator.Ptr.allocate(arena);
        result = vma.createAllocator(allocatorCreateInfo, pAllocator);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create VMA allocator: " + VkResult.explain(result));
        }
        VmaAllocator allocator = Objects.requireNonNull(pAllocator.read());
        // endregion

        // region 10. create an image and image view
        // for simplicity, just create a 256x256 image, shared between host and device. Also, we make it initially
        // mapped between host and device via a VMA flag.
        VkImageCreateInfo imageCreateInfo = VkImageCreateInfo.allocate(arena)
                .imageType(VkImageType._2D)
                .format(VkFormat.R32G32B32A32_SFLOAT)
                .extent(VkExtent3D.allocate(arena).width(256).height(256).depth(1))
                .mipLevels(1)
                .arrayLayers(1)
                .samples(VkSampleCountFlags._1)
                .tiling(VkImageTiling.LINEAR)
                .usage(VkImageUsageFlags.STORAGE | VkImageUsageFlags.SAMPLED)
                .sharingMode(VkSharingMode.EXCLUSIVE);
        VmaAllocationCreateInfo allocationCreateInfo = VmaAllocationCreateInfo.allocate(arena)
                .flags(VmaAllocationCreateFlags.HOST_ACCESS_RANDOM | VmaAllocationCreateFlags.MAPPED)
                .requiredFlags(VkMemoryPropertyFlags.HOST_COHERENT)
                .usage(VmaMemoryUsage.AUTO);
        VkImage.Ptr pImage = VkImage.Ptr.allocate(arena);
        VmaAllocation.Ptr pAllocation = VmaAllocation.Ptr.allocate(arena);
        VmaAllocationInfo allocationInfo = VmaAllocationInfo.allocate(arena);
        result = vma.createImage(
                allocator,
                imageCreateInfo,
                allocationCreateInfo,
                pImage,
                pAllocation,
                allocationInfo
        );
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create image: " + VkResult.explain(result));
        }
        VkImage image = Objects.requireNonNull(pImage.read());
        FloatPtr pMappedData = new FloatPtr(allocationInfo.pMappedData().reinterpret(Float.BYTES * 4 * 256 * 256));

        VkImageViewCreateInfo imageViewCreateInfo = VkImageViewCreateInfo.allocate(arena)
                .image(image) // Use the image created in region 10
                .viewType(VkImageViewType._2D)
                .format(VkFormat.R32G32B32A32_SFLOAT)
                .components(VkComponentMapping.allocate(arena) // Optional: identity mapping is default
                        .r(VkComponentSwizzle.IDENTITY)
                        .g(VkComponentSwizzle.IDENTITY)
                        .b(VkComponentSwizzle.IDENTITY)
                        .a(VkComponentSwizzle.IDENTITY))
                .subresourceRange(VkImageSubresourceRange.allocate(arena)
                        .aspectMask(VkImageAspectFlags.COLOR)
                        .baseMipLevel(0)
                        .levelCount(1)
                        .baseArrayLayer(0)
                        .layerCount(1));

        VkImageView.Ptr pImageView = VkImageView.Ptr.allocate(arena);
        result = dCmd.createImageView(device, imageViewCreateInfo, null, pImageView);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create image view: " + VkResult.explain(result));
        }
        VkImageView imageView = Objects.requireNonNull(pImageView.read());
        // endregion

        // region 11. create descriptor pool and descriptor set
        VkDescriptorPoolSize descriptorPoolSize = VkDescriptorPoolSize.allocate(arena)
                .type(VkDescriptorType.STORAGE_IMAGE)
                .descriptorCount(1);
        VkDescriptorPoolCreateInfo descriptorPoolCreateInfo = VkDescriptorPoolCreateInfo.allocate(arena)
                .poolSizeCount(1)
                .pPoolSizes(descriptorPoolSize)
                .maxSets(1);
        VkDescriptorPool.Ptr pDescriptorPool = VkDescriptorPool.Ptr.allocate(arena);
        result = dCmd.createDescriptorPool(device, descriptorPoolCreateInfo, null, pDescriptorPool);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create descriptor pool: " + VkResult.explain(result));
        }
        VkDescriptorPool descriptorPool = Objects.requireNonNull(pDescriptorPool.read());

        VkDescriptorSetAllocateInfo descriptorSetAllocateInfo = VkDescriptorSetAllocateInfo.allocate(arena)
                .descriptorPool(descriptorPool)
                .descriptorSetCount(1)
                .pSetLayouts(pDescriptorSetLayout); // Use pDescriptorSetLayout from region 8

        VkDescriptorSet.Ptr pDescriptorSet = VkDescriptorSet.Ptr.allocate(arena);
        result = dCmd.allocateDescriptorSets(device, descriptorSetAllocateInfo, pDescriptorSet);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to allocate descriptor set: " + VkResult.explain(result));
        }
        VkDescriptorSet descriptorSet = Objects.requireNonNull(pDescriptorSet.read());

        VkDescriptorImageInfo descriptorImageInfo = VkDescriptorImageInfo.allocate(arena)
                .imageView(imageView)
                .imageLayout(VkImageLayout.GENERAL); // Shader will write to it

        VkWriteDescriptorSet writeDescriptorSet = VkWriteDescriptorSet.allocate(arena)
                .dstSet(descriptorSet)
                .dstBinding(0) // Matches binding in shader
                .dstArrayElement(0)
                .descriptorCount(1)
                .descriptorType(VkDescriptorType.STORAGE_IMAGE)
                .pImageInfo(descriptorImageInfo);

        dCmd.updateDescriptorSets(device, 1, writeDescriptorSet, 0, null);
        // endregion

        // region 12. create command pool and command buffer
        VkCommandPoolCreateInfo commandPoolCreateInfo = VkCommandPoolCreateInfo.allocate(arena)
                .queueFamilyIndex(computeQueueFamilyIndex)
                .flags(VkCommandPoolCreateFlags.TRANSIENT);
        VkCommandPool.Ptr pCommandPool = VkCommandPool.Ptr.allocate(arena);
        result = dCmd.createCommandPool(device, commandPoolCreateInfo, null, pCommandPool);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to create command pool: " + VkResult.explain(result));
        }
        VkCommandPool commandPool = Objects.requireNonNull(pCommandPool.read());

        VkCommandBufferAllocateInfo commandBufferAllocateInfo = VkCommandBufferAllocateInfo.allocate(arena)
                .commandPool(commandPool)
                .level(VkCommandBufferLevel.PRIMARY)
                .commandBufferCount(1);
        VkCommandBuffer.Ptr pCommandBuffer = VkCommandBuffer.Ptr.allocate(arena);
        result = dCmd.allocateCommandBuffers(device, commandBufferAllocateInfo, pCommandBuffer);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to allocate command buffer: " + VkResult.explain(result));
        }
        VkCommandBuffer commandBuffer = Objects.requireNonNull(pCommandBuffer.read());
        // endregion

        // region 13. record command buffer
        dCmd.beginCommandBuffer(commandBuffer, VkCommandBufferBeginInfo.allocate(arena)
                .flags(VkCommandBufferUsageFlags.ONE_TIME_SUBMIT));

        // image barrier: convert image layout to GENERAL for compute shader
        VkImageMemoryBarrier imageMemoryBarrier = VkImageMemoryBarrier.allocate(arena)
                .sType(VkStructureType.IMAGE_MEMORY_BARRIER)
                .srcAccessMask(0)
                .dstAccessMask(VkAccessFlags.SHADER_WRITE)
                .oldLayout(VkImageLayout.UNDEFINED)
                .newLayout(VkImageLayout.GENERAL)
                .srcQueueFamilyIndex(computeQueueFamilyIndex)
                .dstQueueFamilyIndex(computeQueueFamilyIndex)
                .image(image)
                .subresourceRange(VkImageSubresourceRange.allocate(arena)
                        .aspectMask(VkImageAspectFlags.COLOR)
                        .baseMipLevel(0)
                        .levelCount(1)
                        .baseArrayLayer(0)
                        .layerCount(1));
        dCmd.cmdPipelineBarrier(
                commandBuffer,
                VkPipelineStageFlags.TOP_OF_PIPE,
                VkPipelineStageFlags.COMPUTE_SHADER,
                0, // dependency flags
                0, null, // no memory barriers
                0, null, // no buffer barriers
                1, imageMemoryBarrier // image barrier
        );

        dCmd.cmdBindPipeline(commandBuffer, VkPipelineBindPoint.COMPUTE, computePipeline);
        dCmd.cmdBindDescriptorSets(
                commandBuffer,
                VkPipelineBindPoint.COMPUTE,
                pipelineLayout,
                /*firstSet=*/0,
                /*descriptorSetCount=*/1,
                pDescriptorSet,
                /*dynamicOffsetCount=*/0,
                /*pDynamicOffsets=*/null
        );
        dCmd.cmdDispatch(commandBuffer, 256 / 8, 256 / 8, 1);
        dCmd.endCommandBuffer(commandBuffer);
        // endregion

        // region 14. submit command buffer
        VkSubmitInfo submitInfo = VkSubmitInfo.allocate(arena)
                .commandBufferCount(1)
                .pCommandBuffers(pCommandBuffer);
        result = dCmd.queueSubmit(computeQueue, 1, submitInfo, null);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to submit command buffer: " + VkResult.explain(result));
        }
        // endregion

        // region 15. read back the image data, save it to a bitmap file
        dCmd.queueWaitIdle(computeQueue);

        BufferedImage bufferedImage = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < 256; y++) {
            for (int x = 0; x < 256; x++) {
                int offset = (y * 256 + x) * 4; // 4 floats per pixel (R, G, B, A)

                int r = (int)(pMappedData.read(offset) * 255.0f);
                int g = (int)(pMappedData.read(offset + 1) * 255.0f);
                int b = (int)(pMappedData.read(offset + 2) * 255.0f);
                int a = (int)(pMappedData.read(offset + 3) * 255.0f);
                bufferedImage.setRGB(x, y, (a << 24) | (r << 16) | (g << 8) | b);
            }
        }

        try {
            Path outputPath = Path.of("output.png");
            ImageIO.write(bufferedImage, "PNG", outputPath.toFile());
            System.out.println("Image saved to: " + outputPath.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
        // endregion

        // region 16. cleanup
        dCmd.destroyCommandPool(device, commandPool, null);
        dCmd.destroyDescriptorPool(device, descriptorPool, null);
        dCmd.destroyDescriptorSetLayout(device, descriptorSetLayout, null);
        dCmd.destroyPipeline(device, computePipeline, null);
        dCmd.destroyPipelineLayout(device, pipelineLayout, null);
        dCmd.destroyShaderModule(device, shaderModule, null);
        dCmd.destroyImageView(device, imageView, null);
        vma.destroyImage(allocator, image, pAllocation.read());
        vma.destroyAllocator(allocator);
        dCmd.destroyDevice(device, null);
        iCmd.destroyDebugUtilsMessengerEXT(instance, messenger, null);
        iCmd.destroyInstance(instance, null);
        // endregion
    }

    private static @NativeType("VkBool32") @Unsigned int debugCallback(
            @Bitmask(VkDebugUtilsMessageSeverityFlagsEXT.class) int ignoredMessageSeverity,
            @Bitmask(VkDebugUtilsMessageTypeFlagsEXT.class) int ignoredMessageType,
            @Pointer(target= VkDebugUtilsMessengerCallbackDataEXT.class) MemorySegment pCallbackData,
            @Pointer(comment="void*") MemorySegment ignoredPUserData
    ) {
        var callbackData = new VkDebugUtilsMessengerCallbackDataEXT(pCallbackData.reinterpret(VkDebugUtilsMessengerCallbackDataEXT.BYTES));
        System.err.println("Validation layer: " + Objects.requireNonNull(callbackData.pMessage()).readString());
        return VkConstants.FALSE;
    }

    private static final String VALIDATION_LAYER_NAME = "VK_LAYER_KHRONOS_validation";
}

public final class ComputeShader {
    public static void main(String[] args) {
        try (ISharedLibrary libVulkan = VulkanLoader.loadVulkanLibrary();
             ISharedLibrary libVMA = ILibraryLoader.platformLoader().loadLibrary("vma");
             Arena arena = Arena.ofConfined()) {
            VkStaticCommands sCmd = VulkanLoader.loadStaticCommands(libVulkan);
            VkEntryCommands eCmd = VulkanLoader.loadEntryCommands(sCmd);
            Application.applicationStart(libVMA, sCmd, eCmd, arena);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
