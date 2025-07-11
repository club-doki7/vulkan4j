package tutorial.vulkan.part_ex.ch_ex4;

import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.library.ILibraryLoader;
import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.ptr.*;
import club.doki7.glfw.GLFW;
import club.doki7.glfw.GLFWLoader;
import club.doki7.glfw.handle.GLFWwindow;
import club.doki7.shaderc.Shaderc;
import club.doki7.shaderc.ShadercUtil;
import club.doki7.shaderc.enumtype.ShadercShaderKind;
import club.doki7.shaderc.handle.ShadercCompileOptions;
import club.doki7.shaderc.handle.ShadercCompiler;
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
import de.javagl.obj.ObjData;
import de.javagl.obj.ObjReader;
import de.javagl.obj.ObjUtils;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteOrder;
import java.util.Objects;

class Application {
    public void run() {
        initWindow();
        initVulkan();
        mainLoop();
        cleanup();
    }

    private void initWindow() {
        if (glfw.init() != GLFW.TRUE) {
            throw new RuntimeException("Failed to initialize GLFW");
        }

        if (glfw.vulkanSupported() != GLFW.TRUE) {
            throw new RuntimeException("Vulkan is not supported");
        }

        glfw.windowHint(GLFW.CLIENT_API, GLFW.NO_API);
        window = Objects.requireNonNull(glfw.createWindow(WIDTH, HEIGHT, WINDOW_TITLE, null, null));

        glfw.setFramebufferSizeCallback(window, (_, _, _) -> this.framebufferResized = true);
    }

    private void initVulkan() {
        entryCommands = VulkanLoader.loadEntryCommands(staticCommands);

        createInstance();
        setupDebugMessenger();
        createSurface();
        pickPhysicalDevice();
        createLogicalDevice();
        createVMA();
        createSwapchain();
        createImageViews();
        createDescriptorSetLayout();
        createShaderCompiler();
        createGraphicsPipeline();
        createCommandPool();
        createColorResources();
        createDepthResources();
        createTextureImage();
        createTextureImageView();
        createTextureSampler();
        loadModel();
        createVertexBuffer();
        createIndexBuffer();
        createUniformBuffers();
        createDescriptorPool();
        createDescriptorSets();
        createCommandBuffers();
        createSyncObjects();
    }

    private void mainLoop() {
        while (glfw.windowShouldClose(window) == GLFW.FALSE) {
            glfw.pollEvents();
            drawFrame();
        }

        deviceCommands.deviceWaitIdle(device);
    }

    private void cleanup() {
        for (var semaphore : pImageAvailableSemaphores) {
            deviceCommands.destroySemaphore(device, semaphore, null);
        }
        for (var fence : pInFlightFences) {
            deviceCommands.destroyFence(device, fence, null);
        }
        deviceCommands.destroyCommandPool(device, commandPool, null);
        cleanupSwapChain();
        deviceCommands.destroySampler(device, textureSampler, null);
        deviceCommands.destroyImageView(device, textureImageView, null);
        vma.destroyImage(vmaAllocator, textureImage, textureImageAllocation);
        vma.destroyBuffer(vmaAllocator, vertexBuffer, vertexBufferAllocation);
        vma.destroyBuffer(vmaAllocator, indexBuffer, indexBufferAllocation);
        deviceCommands.destroyPipeline(device, graphicsPipeline, null);
        deviceCommands.destroyPipelineLayout(device, pipelineLayout, null);
        vma.destroyBuffer(vmaAllocator, uniformBuffer, uniformBufferAllocation);
        deviceCommands.destroyDescriptorPool(device, descriptorPool, null);
        deviceCommands.destroyDescriptorSetLayout(device, descriptorSetLayout, null);
        vma.destroyAllocator(vmaAllocator);
        deviceCommands.destroyDevice(device, null);
        instanceCommands.destroySurfaceKHR(instance, surface, null);
        if (ENABLE_VALIDATION_LAYERS) {
            instanceCommands.destroyDebugUtilsMessengerEXT(instance, debugMessenger, null);
        }
        instanceCommands.destroyInstance(instance, null);
        glfw.destroyWindow(window);
        glfw.terminate();
    }

    private void createInstance() {
        try (var arena = Arena.ofConfined()) {
            if (ENABLE_VALIDATION_LAYERS && !checkValidationLayerSupport()) {
                throw new RuntimeException("Validation layers requested, but not available");
            }

            var appInfo = VkApplicationInfo.allocate(arena)
                    .pApplicationName(BytePtr.allocateString(arena, "Zdravstvuyte, Vulkan!"))
                    .applicationVersion(new Version(0, 1, 0, 0).encode())
                    .pEngineName(BytePtr.allocateString(arena, "Soloviev D-30"))
                    .engineVersion(new Version(0, 1, 0, 0).encode())
                    .apiVersion(Version.VK_API_VERSION_1_0.encode());

            var instanceCreateInfo = VkInstanceCreateInfo.allocate(arena)
                    .pApplicationInfo(appInfo);

            if (ENABLE_VALIDATION_LAYERS) {
                                instanceCreateInfo
                        .enabledLayerCount(1)
                        .ppEnabledLayerNames(PointerPtr.allocateStrings(arena, VALIDATION_LAYER_NAME));

                var debugCreateInfo = VkDebugUtilsMessengerCreateInfoEXT.allocate(arena);
                populateDebugMessengerCreateInfo(debugCreateInfo);
                instanceCreateInfo.pNext(debugCreateInfo);
            }

            var extensions = getRequiredExtensions(arena);
            instanceCreateInfo.enabledExtensionCount((int) extensions.size())
                    .ppEnabledExtensionNames(extensions);

            var pInstance = VkInstance.Ptr.allocate(arena);
            var result = entryCommands.createInstance(instanceCreateInfo, null, pInstance);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create instance, vulkan error code: " + VkResult.explain(result));
            }
            instance = Objects.requireNonNull(pInstance.read());
            instanceCommands = VulkanLoader.loadInstanceCommands(instance, staticCommands);
        }
    }

    private void setupDebugMessenger() {
        if (!ENABLE_VALIDATION_LAYERS) {
            return;
        }

        try (var arena = Arena.ofConfined()) {
            var debugUtilsMessengerCreateInfo = VkDebugUtilsMessengerCreateInfoEXT.allocate(arena);
            populateDebugMessengerCreateInfo(debugUtilsMessengerCreateInfo);

            var pDebugMessenger = VkDebugUtilsMessengerEXT.Ptr.allocate(arena);
            var result = instanceCommands.createDebugUtilsMessengerEXT(
                    instance,
                    debugUtilsMessengerCreateInfo,
                    null,
                    pDebugMessenger
            );
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to set up debug messenger, vulkan error code: " + VkResult.explain(result));
            }
            debugMessenger = Objects.requireNonNull(pDebugMessenger.read());
        }
    }

    private void createSurface() {
        try (var arena = Arena.ofConfined()) {
            var pSurface = VkSurfaceKHR.Ptr.allocate(arena);
            var result = glfw.createWindowSurface(instance, window, null, pSurface);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create window surface, vulkan error code: " + VkResult.explain(result));
            }
            surface = Objects.requireNonNull(pSurface.read());
        }
    }

    private void pickPhysicalDevice() {
        try (var arena = Arena.ofConfined()) {
            var pDeviceCount = IntPtr.allocate(arena);
            var result = instanceCommands.enumeratePhysicalDevices(instance, pDeviceCount, null);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to enumerate physical devices, vulkan error code: " + VkResult.explain(result));
            }

            var deviceCount = pDeviceCount.read();
            if (deviceCount == 0) {
                throw new RuntimeException("Failed to find GPUs with Vulkan support");
            }

            var pDevices = VkPhysicalDevice.Ptr.allocate(arena, deviceCount);
            result = instanceCommands.enumeratePhysicalDevices(instance, pDeviceCount, pDevices);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to enumerate physical devices, vulkan error code: " + VkResult.explain(result));
            }

            for (var device : pDevices) {
                if (isDeviceSuitable(device)) {
                    physicalDevice = device;
                    msaaSamples = getMaxUsableSampleCount();
                    break;
                }
            }

            if (physicalDevice == null) {
                throw new RuntimeException("Failed to find a suitable Vulkan physical device");
            }
        }
    }

    private void createLogicalDevice() {
        var indices = findQueueFamilies(physicalDevice);
        assert indices != null : "Queue family indices should not be null";

        try (var arena = Arena.ofConfined()) {
            var deviceCreateInfo = VkDeviceCreateInfo.allocate(arena);
            var pQueuePriorities = FloatPtr.allocateV(arena, 1.0f);
            if (indices.graphicsFamily == indices.presentFamily) {
                var queueCreateInfo = VkDeviceQueueCreateInfo.allocate(arena)
                        .queueCount(1)
                        .queueFamilyIndex(indices.graphicsFamily())
                        .pQueuePriorities(pQueuePriorities);
                deviceCreateInfo.queueCreateInfoCount(1).pQueueCreateInfos(queueCreateInfo);
            }
            else {
                var queueCreateInfos = VkDeviceQueueCreateInfo.allocate(arena, 2)
                        .at(0, it -> it
                                .queueCount(1)
                                .queueFamilyIndex(indices.graphicsFamily())
                                .pQueuePriorities(pQueuePriorities))
                        .at(1, it -> it
                                .queueCount(1)
                                .queueFamilyIndex(indices.presentFamily())
                                .pQueuePriorities(pQueuePriorities));
                deviceCreateInfo.queueCreateInfoCount(2).pQueueCreateInfos(queueCreateInfos);
            }
            var deviceFeatures = VkPhysicalDeviceFeatures.allocate(arena)
                    .samplerAnisotropy(VkConstants.TRUE)
                    .sampleRateShading(VkConstants.TRUE);
            deviceCreateInfo.pEnabledFeatures(deviceFeatures);

            if (ENABLE_VALIDATION_LAYERS) {
                deviceCreateInfo
                        .enabledLayerCount(1)
                        .ppEnabledLayerNames(PointerPtr.allocateStrings(arena, VALIDATION_LAYER_NAME));
            }

            deviceCreateInfo.enabledExtensionCount(6);
            var ppEnabledExtensionNames = PointerPtr.allocate(arena, 6);
            ppEnabledExtensionNames.write(0, BytePtr.allocateString(arena, VkConstants.KHR_SWAPCHAIN_EXTENSION_NAME));
            ppEnabledExtensionNames.write(1, BytePtr.allocateString(arena, VkConstants.KHR_DYNAMIC_RENDERING_EXTENSION_NAME));
            ppEnabledExtensionNames.write(2, BytePtr.allocateString(arena, VkConstants.KHR_DEPTH_STENCIL_RESOLVE_EXTENSION_NAME));
            ppEnabledExtensionNames.write(3, BytePtr.allocateString(arena, VkConstants.KHR_CREATE_RENDERPASS_2_EXTENSION_NAME));
            ppEnabledExtensionNames.write(4, BytePtr.allocateString(arena, VkConstants.KHR_MULTIVIEW_EXTENSION_NAME));
            ppEnabledExtensionNames.write(5, BytePtr.allocateString(arena, VkConstants.KHR_MAINTENANCE_2_EXTENSION_NAME));
            deviceCreateInfo.ppEnabledExtensionNames(ppEnabledExtensionNames);

            var dynamicRenderingFeature = VkPhysicalDeviceDynamicRenderingFeatures.allocate(arena);
            dynamicRenderingFeature.dynamicRendering(VkConstants.TRUE);
            deviceCreateInfo.pNext(dynamicRenderingFeature);

            var pDevice = VkDevice.Ptr.allocate(arena);
            var result = instanceCommands.createDevice(physicalDevice, deviceCreateInfo, null, pDevice);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create logical device, vulkan error code: " + VkResult.explain(result));
            }
            device = Objects.requireNonNull(pDevice.read());
            deviceCommands = VulkanLoader.loadDeviceCommands(device, staticCommands);

            var pQueue = VkQueue.Ptr.allocate(arena);
            deviceCommands.getDeviceQueue(device, indices.graphicsFamily(), 0, pQueue);
            graphicsQueue = Objects.requireNonNull(pQueue.read());

            deviceCommands.getDeviceQueue(device, indices.presentFamily(), 0, pQueue);
            presentQueue = Objects.requireNonNull(pQueue.read());
        }
    }

    private void createVMA() {
        VMAJavaTraceUtil.enableJavaTraceForVMA(libVMA);

        try (var arena = Arena.ofConfined()) {
            var vmaVulkanFunctions = VmaVulkanFunctions.allocate(arena);
            VMAUtil.fillVulkanFunctions(
                    vmaVulkanFunctions,
                    staticCommands,
                    entryCommands,
                    instanceCommands,
                    deviceCommands
            );

            var vmaCreateInfo = VmaAllocatorCreateInfo.allocate(arena)
                    .instance(instance)
                    .physicalDevice(physicalDevice)
                    .device(device)
                    .pVulkanFunctions(vmaVulkanFunctions)
                    .vulkanApiVersion(Version.VK_API_VERSION_1_0.encode());

            var pVmaAllocator = VmaAllocator.Ptr.allocate(arena);
            var result = vma.createAllocator(vmaCreateInfo, pVmaAllocator);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create VMA allocator, vulkan error code: " + VkResult.explain(result));
            }

            vmaAllocator = Objects.requireNonNull(pVmaAllocator.read());
        }
    }

    private void createSwapchain() {
        try (var arena = Arena.ofConfined()) {
            var swapChainSupport = querySwapChainSupport(physicalDevice, arena);

            var surfaceFormat = chooseSwapSurfaceFormat(swapChainSupport.formats());
            var presentMode = chooseSwapPresentMode(swapChainSupport.presentModes());
            var extent = chooseSwapExtent(swapChainSupport.capabilities(), arena);

            var imageCount = swapChainSupport.capabilities.minImageCount() + 1;
            if (swapChainSupport.capabilities.maxImageCount() > 0
                && imageCount > swapChainSupport.capabilities.maxImageCount()) {
                imageCount = swapChainSupport.capabilities.maxImageCount();
            }

            var createInfo = VkSwapchainCreateInfoKHR.allocate(arena)
                    .surface(surface)
                    .minImageCount(imageCount)
                    .imageFormat(surfaceFormat.format())
                    .imageColorSpace(surfaceFormat.colorSpace())
                    .imageExtent(extent)
                    .imageArrayLayers(1)
                    .imageUsage(VkImageUsageFlags.COLOR_ATTACHMENT);
            var indices = findQueueFamilies(physicalDevice);
            assert indices != null : "Queue family indices should not be null";
            if (indices.graphicsFamily != indices.presentFamily) {
                var pQueueFamilyIndices = IntPtr.allocateV(arena, indices.graphicsFamily(), indices.presentFamily());
                createInfo.imageSharingMode(VkSharingMode.CONCURRENT)
                        .queueFamilyIndexCount(2)
                        .pQueueFamilyIndices(pQueueFamilyIndices);
            }
            else {
                createInfo.imageSharingMode(VkSharingMode.EXCLUSIVE);
            }

            createInfo.preTransform(swapChainSupport.capabilities.currentTransform())
                    .compositeAlpha(VkCompositeAlphaFlagsKHR.OPAQUE)
                    .presentMode(presentMode)
                    .clipped(VkConstants.TRUE)
                    .oldSwapchain(null);

            var pSwapChain = VkSwapchainKHR.Ptr.allocate(arena);
            var result = deviceCommands.createSwapchainKHR(device, createInfo, null, pSwapChain);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create swap chain, vulkan error code: " + VkResult.explain(result));
            }
            swapChain = Objects.requireNonNull(pSwapChain.read());

            var pImageCount = IntPtr.allocate(arena);
            result = deviceCommands.getSwapchainImagesKHR(device, swapChain, pImageCount, null);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to get swap chain images, vulkan error code: " + VkResult.explain(result));
            }
            assert pImageCount.read() == imageCount : "Image count mismatch";

            swapChainImages = VkImage.Ptr.allocate(Arena.ofAuto(), imageCount);
            result = deviceCommands.getSwapchainImagesKHR(device, swapChain, pImageCount, swapChainImages);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to get swap chain images, vulkan error code: " + VkResult.explain(result));
            }

            swapChainImageFormat = surfaceFormat.format();
            swapChainExtent = VkExtent2D.clone(Arena.ofAuto(), extent);
        }
    }

    private void createImageViews() {
        swapChainImageViews = VkImageView.Ptr.allocate(Arena.ofAuto(), swapChainImages.size());
        for (long i = 0; i < swapChainImages.size(); i++) {
            swapChainImageViews.write(i, createImageView(
                    swapChainImages.read(i),
                    swapChainImageFormat,
                    VkImageAspectFlags.COLOR,
                    1
            ));
        }
    }

    private void createDescriptorSetLayout() {
        try (var arena = Arena.ofConfined()) {
            var bindings = VkDescriptorSetLayoutBinding.allocate(arena, 2)
                    .at(0, it -> it
                            .binding(0)
                            .descriptorType(VkDescriptorType.UNIFORM_BUFFER)
                            .descriptorCount(1)
                            .stageFlags(VkShaderStageFlags.VERTEX))
                    .at(1, it -> it
                            .binding(1)
                            .descriptorCount(1)
                            .descriptorType(VkDescriptorType.COMBINED_IMAGE_SAMPLER)
                            .stageFlags(VkShaderStageFlags.FRAGMENT));

            var layoutInfo = VkDescriptorSetLayoutCreateInfo.allocate(arena)
                    .bindingCount(2)
                    .pBindings(bindings);

            var pDescriptorSetLayout = VkDescriptorSetLayout.Ptr.allocate(arena);
            var result = deviceCommands.createDescriptorSetLayout(device, layoutInfo, null, pDescriptorSetLayout);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create descriptor set layout, vulkan error code: " + VkResult.explain(result));
            }
            descriptorSetLayout = Objects.requireNonNull(pDescriptorSetLayout.read());
        }
    }

    private void createShaderCompiler() {
        shadercCompiler = shaderc.compilerInitialize();
        shadercCompileOptions = shaderc.compileOptionsInitialize();

        var includeCallacks = ShadercUtil.makeCallbacks(
                Arena.global(),
                (requestedSource, _, _, _) -> {
                    try (var inputStream = Application.class.getResourceAsStream("/shader/" + requestedSource)) {
                        if (inputStream == null) {
                            throw new IOException("Failed to load include file: /shader/" + requestedSource);
                        }

                        var source = new String(inputStream.readAllBytes());
                        return new ShadercUtil.IncludeResult(requestedSource, source);
                    }
                }
        );
        shaderc.compileOptionsSetIncludeCallbacks(
                shadercCompileOptions,
                includeCallacks.pfnIncludeResolve,
                includeCallacks.pfnIncludeResultRelease,
                MemorySegment.NULL
        );
    }

    private void createGraphicsPipeline() {
        try (var arena = Arena.ofConfined()) {
            var vertShaderCode = compileShader(arena, "/shader/ch_ex4.vert", ShadercShaderKind.VERTEX_SHADER);
            var fragShaderCode = compileShader(arena, "/shader/ch_ex4.frag", ShadercShaderKind.FRAGMENT_SHADER);
            var vertexShaderModule = createShaderModule(vertShaderCode);
            var fragmentShaderModule = createShaderModule(fragShaderCode);

            var shaderStages = VkPipelineShaderStageCreateInfo.allocate(arena, 2)
                    .at(0, it -> it
                            .stage(VkShaderStageFlags.VERTEX)
                            .module(vertexShaderModule)
                            .pName(BytePtr.allocateString(arena, "main")))
                    .at(1, it -> it
                            .stage(VkShaderStageFlags.FRAGMENT)
                            .module(fragmentShaderModule)
                            .pName(BytePtr.allocateString(arena, "main")));

            var dynamicStates = IntPtr.allocateV(arena, VkDynamicState.VIEWPORT, VkDynamicState.SCISSOR);

            var dynamicStateInfo = VkPipelineDynamicStateCreateInfo.allocate(arena)
                    .dynamicStateCount((int) dynamicStates.size())
                    .pDynamicStates(dynamicStates);

            var bindingDescription = getBindingDescription(arena);
            var attributeDescription = getAttributeDescriptions(arena);
            var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.allocate(arena)
                    .vertexBindingDescriptionCount(1)
                    .pVertexBindingDescriptions(bindingDescription)
                    .vertexAttributeDescriptionCount((int) attributeDescription.size())
                    .pVertexAttributeDescriptions(attributeDescription);

            var inputAssembly = VkPipelineInputAssemblyStateCreateInfo.allocate(arena)
                    .topology(VkPrimitiveTopology.TRIANGLE_LIST)
                    .primitiveRestartEnable(VkConstants.FALSE);

            var viewportStateInfo = VkPipelineViewportStateCreateInfo.allocate(arena)
                    .viewportCount(1)
                    .scissorCount(1);

            var rasterizer = VkPipelineRasterizationStateCreateInfo.allocate(arena)
                    .depthClampEnable(VkConstants.FALSE)
                    .rasterizerDiscardEnable(VkConstants.FALSE)
                    .polygonMode(VkPolygonMode.FILL)
                    .lineWidth(1.0f)
                    .cullMode(VkCullModeFlags.BACK)
                    .frontFace(VkFrontFace.COUNTER_CLOCKWISE)
                    .depthBiasEnable(VkConstants.FALSE);

            var multisampling = VkPipelineMultisampleStateCreateInfo.allocate(arena)
                    .sampleShadingEnable(VkConstants.TRUE)
                    .minSampleShading(0.2f)
                    .rasterizationSamples(msaaSamples);

            var depthStencil = VkPipelineDepthStencilStateCreateInfo.allocate(arena)
                    .depthTestEnable(VkConstants.TRUE)
                    .depthWriteEnable(VkConstants.TRUE)
                    .depthCompareOp(VkCompareOp.LESS)
                    .depthBoundsTestEnable(VkConstants.FALSE)
                    .stencilTestEnable(VkConstants.FALSE);

            var colorBlendAttachment = VkPipelineColorBlendAttachmentState.allocate(arena)
                    .colorWriteMask(
                            VkColorComponentFlags.R
                            | VkColorComponentFlags.G
                            | VkColorComponentFlags.B
                            | VkColorComponentFlags.A
                    ).blendEnable(VkConstants.FALSE);

            var colorBlending = VkPipelineColorBlendStateCreateInfo.allocate(arena)
                    .logicOpEnable(VkConstants.FALSE)
                    .attachmentCount(1)
                    .pAttachments(colorBlendAttachment);

            var pipelineLayoutInfo = VkPipelineLayoutCreateInfo.allocate(arena);
            var pushConstantRange = VkPushConstantRange.allocate(arena);
            pushConstantRange.stageFlags(VkShaderStageFlags.VERTEX);
            pushConstantRange.offset(0);
            pushConstantRange.size(16 * Float.BYTES);
            pipelineLayoutInfo.pushConstantRangeCount(1);
            pipelineLayoutInfo.pPushConstantRanges(pushConstantRange);
            var pDescriptorSetLayout = VkDescriptorSetLayout.Ptr.allocateV(arena, descriptorSetLayout);
            pipelineLayoutInfo.setLayoutCount(1).pSetLayouts(pDescriptorSetLayout);
            var pPipelineLayout = VkPipelineLayout.Ptr.allocate(arena);
            var result = deviceCommands.createPipelineLayout(device, pipelineLayoutInfo, null, pPipelineLayout);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create pipeline layout, vulkan error code: " + VkResult.explain(result));
            }
            pipelineLayout = Objects.requireNonNull(pPipelineLayout.read());

            var pipelineInfo = VkGraphicsPipelineCreateInfo.allocate(arena)
                    .stageCount(2)
                    .pStages(shaderStages)
                    .pVertexInputState(vertexInputInfo)
                    .pInputAssemblyState(inputAssembly)
                    .pViewportState(viewportStateInfo)
                    .pRasterizationState(rasterizer)
                    .pMultisampleState(multisampling)
                    .pDepthStencilState(depthStencil)
                    .pColorBlendState(colorBlending)
                    .pDynamicState(dynamicStateInfo)
                    .layout(pipelineLayout);

            depthFormat = findDepthFormat();
            var pipelineRenderingCreateInfo = VkPipelineRenderingCreateInfo.allocate(arena)
                    .colorAttachmentCount(1)
                    .pColorAttachmentFormats(IntPtr.allocateV(arena, swapChainImageFormat))
                    .depthAttachmentFormat(depthFormat);
            pipelineInfo.pNext(pipelineRenderingCreateInfo);

            var pGraphicsPipeline = VkPipeline.Ptr.allocate(arena);
            result = deviceCommands.createGraphicsPipelines(device, null, 1, pipelineInfo, null, pGraphicsPipeline);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create graphics pipeline, vulkan error code: " + VkResult.explain(result));
            }
            graphicsPipeline = Objects.requireNonNull(pGraphicsPipeline.read());

            deviceCommands.destroyShaderModule(device, vertexShaderModule, null);
            deviceCommands.destroyShaderModule(device, fragmentShaderModule, null);
        }
    }

    private void createCommandPool() {
        try (var arena = Arena.ofConfined()) {
            var queueFamilyIndices = findQueueFamilies(physicalDevice);
            assert queueFamilyIndices != null;

            var poolInfo = VkCommandPoolCreateInfo.allocate(arena)
                    .flags(VkCommandPoolCreateFlags.RESET_COMMAND_BUFFER)
                    .queueFamilyIndex(queueFamilyIndices.graphicsFamily());

            var pCommandPool = VkCommandPool.Ptr.allocate(arena);
            var result = deviceCommands.createCommandPool(device, poolInfo, null, pCommandPool);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create command pool, vulkan error code: " + VkResult.explain(result));
            }
            commandPool = Objects.requireNonNull(pCommandPool.read());
        }
    }

    private void createColorResources() {
        var colorFormat = swapChainImageFormat;

        var pair = createImage(
                swapChainExtent.width(),
                swapChainExtent.height(),
                1,
                msaaSamples,
                colorFormat,
                VkImageTiling.OPTIMAL,
                VkImageUsageFlags.TRANSIENT_ATTACHMENT | VkImageUsageFlags.COLOR_ATTACHMENT
        );
        colorImage = pair.first;
        colorImageAllocation = pair.second;
        colorImageView = createImageView(colorImage, colorFormat, VkImageAspectFlags.COLOR, 1);
    }

    private void createDepthResources() {
        var pair = createImage(
                swapChainExtent.width(),
                swapChainExtent.height(),
                1,
                msaaSamples,
                depthFormat,
                VkImageTiling.OPTIMAL,
                VkImageUsageFlags.DEPTH_STENCIL_ATTACHMENT
        );
        depthImage = pair.first;
        depthImageAllocation = pair.second;
        depthImageView = createImageView(depthImage, depthFormat, VkImageAspectFlags.DEPTH, 1);

        transitionImageLayout(
                depthImage,
                depthFormat,
                VkImageLayout.UNDEFINED,
                VkImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL,
                1
        );
    }

    private void loadModel() {
        try (var stream = Application.class.getResourceAsStream(MODEL_PATH)) {
            if (stream == null) {
                throw new RuntimeException("Failed to load model");
            }

            var obj = ObjReader.read(stream);
            obj = ObjUtils.convertToRenderable(obj);

            indices = ObjData.getFaceVertexIndicesArray(obj);
            var verticesArray = ObjData.getVerticesArray(obj);
            var texCoordsArray = ObjData.getTexCoordsArray(obj, 2);
            vertices = new float[obj.getNumVertices() * 8];
            for (int i = 0; i < obj.getNumVertices(); i++) {
                // vec3 pos
                vertices[i * 8] = verticesArray[i * 3];
                vertices[i * 8 + 1] = verticesArray[i * 3 + 1];
                vertices[i * 8 + 2] = verticesArray[i * 3 + 2];
                // vec3 color
                vertices[i * 8 + 3] = 1.0f;
                vertices[i * 8 + 4] = 1.0f;
                vertices[i * 8 + 5] = 1.0f;
                // vec2 texCoord
                vertices[i * 8 + 6] = texCoordsArray[i * 2];
                vertices[i * 8 + 7] = 1.0f - texCoordsArray[i * 2 + 1];
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to load model", e);
        }
    }

    private void createVertexBuffer() {
        try (var arena = Arena.ofConfined()) {
            var bufferSize = vertices.length * Float.BYTES;

            var pair = createBuffer(
                    bufferSize,
                    VkBufferUsageFlags.TRANSFER_SRC,
                    VmaAllocationCreateFlags.HOST_ACCESS_RANDOM,
                    VkMemoryPropertyFlags.HOST_COHERENT,
                    null
            );
            var stagingBuffer = pair.first;
            var stagingBufferAllocation = pair.second;

            var ppData = PointerPtr.allocate(arena);
            var result = vma.mapMemory(vmaAllocator, stagingBufferAllocation, ppData);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to map vertex buffer memory, vulkan error code: " + VkResult.explain(result));
            }
            var pData = ppData.read().reinterpret(bufferSize);
            pData.copyFrom(MemorySegment.ofArray(vertices));
            vma.unmapMemory(vmaAllocator, stagingBufferAllocation);

            pair = createBuffer(
                    bufferSize,
                    VkBufferUsageFlags.TRANSFER_DST | VkBufferUsageFlags.VERTEX_BUFFER,
                    0,
                    0,
                    null
            );
            vertexBuffer = pair.first;
            vertexBufferAllocation = pair.second;

            copyBuffer(stagingBuffer, vertexBuffer, bufferSize);

            vma.destroyBuffer(vmaAllocator, stagingBuffer, stagingBufferAllocation);
        }
    }

    private void createIndexBuffer() {
        try (var arena = Arena.ofConfined()) {
            var bufferSize = indices.length * Integer.BYTES;

            var pair = createBuffer(
                    bufferSize,
                    VkBufferUsageFlags.TRANSFER_SRC,
                    VmaAllocationCreateFlags.HOST_ACCESS_RANDOM,
                    VkMemoryPropertyFlags.HOST_COHERENT,
                    null
            );
            var stagingBuffer = pair.first;
            var stagingBufferAllocation = pair.second;

            var ppData = PointerPtr.allocate(arena);
            var result = vma.mapMemory(vmaAllocator, stagingBufferAllocation, ppData);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to map index buffer memory, vulkan error code: " + VkResult.explain(result));
            }
            var pData = ppData.read().reinterpret(bufferSize);
            pData.copyFrom(MemorySegment.ofArray(indices));
            vma.unmapMemory(vmaAllocator, stagingBufferAllocation);

            pair = createBuffer(
                    bufferSize,
                    VkBufferUsageFlags.TRANSFER_DST | VkBufferUsageFlags.INDEX_BUFFER,
                    0,
                    0,
                    null
            );
            indexBuffer = pair.first;
            indexBufferAllocation = pair.second;

            copyBuffer(stagingBuffer, indexBuffer, bufferSize);

            vma.destroyBuffer(vmaAllocator, stagingBuffer, stagingBufferAllocation);
        }
    }

    private void createUniformBuffers() {
        var bufferSize = UniformBufferObject.bufferSize();

        try (var arena = Arena.ofConfined()) {
            var allocationInfo = VmaAllocationInfo.allocate(arena);
            var pair = createBuffer(
                    bufferSize * Float.BYTES,
                    VkBufferUsageFlags.UNIFORM_BUFFER,
                    VmaAllocationCreateFlags.MAPPED | VmaAllocationCreateFlags.HOST_ACCESS_RANDOM,
                    VkMemoryPropertyFlags.HOST_COHERENT,
                    allocationInfo
            );
            uniformBuffer = pair.first;
            uniformBufferAllocation = pair.second;
            uniformBufferMapped = new FloatPtr(allocationInfo.pMappedData()).reinterpret(bufferSize);
        }

        updateUniformBuffer();
    }

    private void createDescriptorPool() {
        try (var arena = Arena.ofConfined()) {
            var poolSizes = VkDescriptorPoolSize.allocate(arena, 2)
                    .at(0, it -> it
                            .type(VkDescriptorType.UNIFORM_BUFFER)
                            .descriptorCount(MAX_FRAMES_IN_FLIGHT))
                    .at(1, it -> it
                            .type(VkDescriptorType.COMBINED_IMAGE_SAMPLER)
                            .descriptorCount(MAX_FRAMES_IN_FLIGHT));

            var poolInfo = VkDescriptorPoolCreateInfo.allocate(arena)
                    .poolSizeCount(2)
                    .pPoolSizes(poolSizes)
                    .maxSets(MAX_FRAMES_IN_FLIGHT);

            var pDescriptorPool = VkDescriptorPool.Ptr.allocate(arena);
            var result = deviceCommands.createDescriptorPool(device, poolInfo, null, pDescriptorPool);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create descriptor pool, vulkan error code: " + VkResult.explain(result));
            }
            descriptorPool = Objects.requireNonNull(pDescriptorPool.read());
        }
    }

    private void createDescriptorSets() {
        descriptorSets = VkDescriptorSet.Ptr.allocate(Arena.ofAuto(), MAX_FRAMES_IN_FLIGHT);

        try (Arena arena = Arena.ofConfined()) {
            var pLayouts = VkDescriptorSetLayout.Ptr.allocateV(arena, descriptorSetLayout, descriptorSetLayout);

            var allocInfo = VkDescriptorSetAllocateInfo.allocate(arena)
                    .descriptorPool(descriptorPool)
                    .descriptorSetCount(MAX_FRAMES_IN_FLIGHT)
                    .pSetLayouts(pLayouts);

            var result = deviceCommands.allocateDescriptorSets(device, allocInfo, descriptorSets);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to allocate descriptor sets, vulkan error code: " + VkResult.explain(result));
            }

            for (int i = 0; i < MAX_FRAMES_IN_FLIGHT; i++){
                var bufferInfo = VkDescriptorBufferInfo.allocate(arena)
                        .buffer(uniformBuffer)
                        .offset(0)
                        .range((long) UniformBufferObject.bufferSize() * Float.BYTES);

                var imageInfo = VkDescriptorImageInfo.allocate(arena)
                        .imageLayout(VkImageLayout.SHADER_READ_ONLY_OPTIMAL)
                        .imageView(textureImageView)
                        .sampler(textureSampler);

                int finalI = i;
                var descriptorWrite = VkWriteDescriptorSet.allocate(arena, 2)
                        .at(0, it -> it
                                .dstSet(descriptorSets.read(finalI))
                                .dstBinding(0)
                                .dstArrayElement(0)
                                .descriptorType(VkDescriptorType.UNIFORM_BUFFER)
                                .descriptorCount(1)
                                .pBufferInfo(bufferInfo))
                        .at(1, it -> it
                                .dstSet(descriptorSets.read(finalI))
                                .dstBinding(1)
                                .dstArrayElement(0)
                                .descriptorType(VkDescriptorType.COMBINED_IMAGE_SAMPLER)
                                .descriptorCount(1)
                                .pImageInfo(imageInfo));

                deviceCommands.updateDescriptorSets(device, 2, descriptorWrite, 0, null);
            }
        }
    }

    private void createCommandBuffers() {
        pCommandBuffers = VkCommandBuffer.Ptr.allocate(Arena.ofAuto(), MAX_FRAMES_IN_FLIGHT);

        try (var arena = Arena.ofConfined()) {
            var allocInfo = VkCommandBufferAllocateInfo.allocate(arena)
                    .commandPool(commandPool)
                    .level(VkCommandBufferLevel.PRIMARY)
                    .commandBufferCount(1);

            for (int i = 0; i < MAX_FRAMES_IN_FLIGHT; i++) {
                var pCommandBuffer = pCommandBuffers.offset(i);
                var result = deviceCommands.allocateCommandBuffers(device, allocInfo, pCommandBuffer);
                if (result != VkResult.SUCCESS) {
                    throw new RuntimeException("Failed to allocate command buffer, vulkan error code: " + VkResult.explain(result));
                }
            }
        }
    }

    private void createTextureImage() {
        BufferedImage image;
        try (var stream = Application.class.getResourceAsStream(TEXTURE_PATH)) {
            if (stream == null) {
                throw new RuntimeException("Failed to load texture image");
            }
            image = ImageIO.read(stream);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to load texture image", e);
        }

        var width = image.getWidth();
        var height = image.getHeight();
        var imageSize = width * height;
        var imageSizeBytes = imageSize * 4;
        textureMipLevels = (int) Math.floor(Math.log(Math.max(width, height)) / Math.log(2)) + 1;

        var pair = createBuffer(
                imageSizeBytes,
                VkBufferUsageFlags.TRANSFER_SRC,
                VmaAllocationCreateFlags.HOST_ACCESS_RANDOM,
                VkMemoryPropertyFlags.HOST_COHERENT,
                null
        );
        var stagingBuffer = pair.first;
        var stagingBufferAllocation = pair.second;

        try (Arena arena = Arena.ofConfined()) {
            var ppData = PointerPtr.allocate(arena);
            var result = vma.mapMemory(vmaAllocator, stagingBufferAllocation, ppData);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to map texture image memory, vulkan error code: " + VkResult.explain(result));
            }
            var buffer = new BytePtr(ppData.read().reinterpret(imageSizeBytes));
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    var color = new Color(image.getRGB(x, y), true);
                    var linearIndex = y * width + x;
                    buffer.write(linearIndex * 4L, (byte) color.getRed());
                    buffer.write(linearIndex * 4L + 1, (byte) color.getGreen());
                    buffer.write(linearIndex * 4L + 2, (byte) color.getBlue());
                    buffer.write(linearIndex * 4L + 3, (byte) color.getAlpha());
                }
            }
            vma.unmapMemory(vmaAllocator, stagingBufferAllocation);

            var pair2 = createImage(
                    width,
                    height,
                    textureMipLevels,
                    VkSampleCountFlags._1,
                    VkFormat.R8G8B8A8_SRGB,
                    VkImageTiling.OPTIMAL,
                    VkImageUsageFlags.TRANSFER_DST
                    | VkImageUsageFlags.SAMPLED
                    | VkImageUsageFlags.TRANSFER_SRC
            );
            textureImage = pair2.first;
            textureImageAllocation = pair2.second;

            transitionImageLayout(
                    textureImage,
                    VkFormat.R8G8B8A8_SRGB,
                    VkImageLayout.UNDEFINED,
                    VkImageLayout.TRANSFER_DST_OPTIMAL,
                    textureMipLevels
            );
            copyBufferToImage(stagingBuffer, textureImage, width, height);
            generateMipmaps(textureImage, VkFormat.R8G8B8A8_SRGB, width, height, textureMipLevels);

            vma.destroyBuffer(vmaAllocator, stagingBuffer, stagingBufferAllocation);
        }
    }

    private void createTextureImageView() {
        textureImageView = createImageView(
                textureImage,
                VkFormat.R8G8B8A8_SRGB,
                VkImageAspectFlags.COLOR,
                textureMipLevels
        );
    }

    private void createTextureSampler() {
        try (var arena = Arena.ofConfined()) {
            var properties = VkPhysicalDeviceProperties.allocate(arena);
            instanceCommands.getPhysicalDeviceProperties(physicalDevice, properties);

            var samplerInfo = VkSamplerCreateInfo.allocate(arena)
                    .magFilter(VkFilter.LINEAR)
                    .minFilter(VkFilter.LINEAR)
                    .addressModeU(VkSamplerAddressMode.REPEAT)
                    .addressModeV(VkSamplerAddressMode.REPEAT)
                    .addressModeW(VkSamplerAddressMode.REPEAT)
                    .anisotropyEnable(VkConstants.TRUE)
                    .maxAnisotropy(properties.limits().maxSamplerAnisotropy())
                    .borderColor(VkBorderColor.INT_OPAQUE_BLACK)
                    .unnormalizedCoordinates(VkConstants.FALSE)
                    .compareEnable(VkConstants.FALSE)
                    .compareOp(VkCompareOp.ALWAYS)
                    .mipmapMode(VkSamplerMipmapMode.LINEAR)
                    .mipLodBias(0.0f)
                    .minLod(0.0f)
                    .maxLod(0.0f);

            var pSampler = VkSampler.Ptr.allocate(arena);
            var result = deviceCommands.createSampler(device, samplerInfo, null, pSampler);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create texture sampler, vulkan error code: " + VkResult.explain(result));
            }
            textureSampler = Objects.requireNonNull(pSampler.read());
        }
    }

    private void createSyncObjects() {
        pImageAvailableSemaphores = VkSemaphore.Ptr.allocate(Arena.ofAuto(), MAX_FRAMES_IN_FLIGHT);
        pInFlightFences = VkFence.Ptr.allocate(Arena.ofAuto(), MAX_FRAMES_IN_FLIGHT);

        try (var arena = Arena.ofConfined()) {
            var semaphoreInfo = VkSemaphoreCreateInfo.allocate(arena);
            var fenceCreateInfo = VkFenceCreateInfo.allocate(arena)
                    .flags(VkFenceCreateFlags.SIGNALED);

            for (int i = 0; i < MAX_FRAMES_IN_FLIGHT; i++) {
                var pImageAvailableSemaphore = pImageAvailableSemaphores.offset(i);
                var pInFlightFence = pInFlightFences.offset(i);

                if (deviceCommands.createSemaphore(device, semaphoreInfo, null, pImageAvailableSemaphore) != VkResult.SUCCESS
                    || deviceCommands.createFence(device, fenceCreateInfo, null, pInFlightFence) != VkResult.SUCCESS) {
                    throw new RuntimeException("Failed to create synchronization objects for a frame");
                }
            }
        }

        createSwapchainSyncObjects();
    }

    private void drawFrame() {
        var pInFlightFence = pInFlightFences.offset(currentFrame);
        var pImageAvailableSemaphore = pImageAvailableSemaphores.offset(currentFrame);
        var inFlightFence = pInFlightFence.read();
        var imageAvailableSemaphore = pImageAvailableSemaphore.read();
        var pCommandBuffer = pCommandBuffers.offset(currentFrame);
        var commandBuffer = pCommandBuffer.read();

        try (var arena = Arena.ofConfined()) {
            deviceCommands.waitForFences(device, 1, pInFlightFence, VkConstants.TRUE, NativeLayout.UINT64_MAX);
            deviceCommands.resetFences(device, 1, pInFlightFence);

            var pImageIndex = IntPtr.allocate(arena);
            var result = deviceCommands.acquireNextImageKHR(
                    device,
                    swapChain,
                    NativeLayout.UINT64_MAX,
                    imageAvailableSemaphore,
                    null,
                    pImageIndex
            );
            if (result == VkResult.ERROR_OUT_OF_DATE_KHR) {
                recreateSwapchain();
                return;
            } else if (result != VkResult.SUCCESS && result != VkResult.SUBOPTIMAL_KHR) {
                throw new RuntimeException("Failed to acquire swap chain image, vulkan error code: " + VkResult.explain(result));
            }
            deviceCommands.resetFences(device, 1, pInFlightFence);

            var imageIndex = pImageIndex.read();

            var pRenderFinishedSemaphore = pRenderFinishedSemaphores.offset(imageIndex);

            deviceCommands.resetCommandBuffer(commandBuffer, 0);
            recordCommandBuffer(commandBuffer, imageIndex);

            var submitInfo = VkSubmitInfo.allocate(arena)
                    .waitSemaphoreCount(1)
                    .pWaitSemaphores(pImageAvailableSemaphore)
                    .pWaitDstStageMask(IntPtr.allocateV(arena, VkPipelineStageFlags.COLOR_ATTACHMENT_OUTPUT))
                    .commandBufferCount(1)
                    .pCommandBuffers(pCommandBuffer)
                    .signalSemaphoreCount(1)
                    .pSignalSemaphores(pRenderFinishedSemaphore);

            result = deviceCommands.queueSubmit(graphicsQueue, 1, submitInfo, inFlightFence);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to submit draw command buffer, vulkan error code: " + VkResult.explain(result));
            }

            var presentInfo = VkPresentInfoKHR.allocate(arena)
                    .waitSemaphoreCount(1)
                    .pWaitSemaphores(pRenderFinishedSemaphore)
                    .swapchainCount(1)
                    .pSwapchains(VkSwapchainKHR.Ptr.allocateV(arena, swapChain))
                    .pImageIndices(pImageIndex)
                    .pResults(null);

            result = deviceCommands.queuePresentKHR(presentQueue, presentInfo);
            if (result == VkResult.ERROR_OUT_OF_DATE_KHR || framebufferResized) {
                framebufferResized = false;
                recreateSwapchain();
            }
            else if (result != VkResult.SUCCESS && result != VkResult.SUBOPTIMAL_KHR) {
                throw new RuntimeException("Failed to submit draw command buffer, vulkan error code: " + VkResult.explain(result));
            }
        }

        currentFrame = (currentFrame + 1) % MAX_FRAMES_IN_FLIGHT;
    }

    private void recordCommandBuffer(VkCommandBuffer commandBuffer, int imageIndex) {
        try (var arena = Arena.ofConfined()) {
            var beginInfo = VkCommandBufferBeginInfo.allocate(arena);

            var result = deviceCommands.beginCommandBuffer(commandBuffer, beginInfo);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to begin recording command buffer, vulkan error code: " + VkResult.explain(result));
            }

            var preImageMemoryBarrier = VkImageMemoryBarrier.allocate(arena)
                    .srcAccessMask(0)
                    .dstAccessMask(VkAccessFlags.COLOR_ATTACHMENT_WRITE)
                    .oldLayout(VkImageLayout.UNDEFINED)
                    .newLayout(VkImageLayout.COLOR_ATTACHMENT_OPTIMAL)
                    .image(swapChainImages.read(imageIndex))
                    .subresourceRange(it -> it
                            .aspectMask(VkImageAspectFlags.COLOR)
                            .baseMipLevel(0)
                            .levelCount(1)
                            .baseArrayLayer(0)
                            .layerCount(1));
            deviceCommands.cmdPipelineBarrier(
                    commandBuffer,
                    VkPipelineStageFlags.TOP_OF_PIPE,
                    VkPipelineStageFlags.COLOR_ATTACHMENT_OUTPUT,
                    0,
                    0, null,
                    0, null,
                    1, preImageMemoryBarrier
            );

            var renderingInfo = VkRenderingInfo.allocate(arena)
                    .renderArea(it -> it
                            .offset(offset -> offset.x(0).y(0))
                            .extent(swapChainExtent))
                    .layerCount(1);

            var renderingAttachmentInfos = VkRenderingAttachmentInfo.allocate(arena, 2);
            var colorAttachmentInfo = renderingAttachmentInfos.at(0);
            colorAttachmentInfo.imageView(colorImageView)
                    .imageLayout(VkImageLayout.COLOR_ATTACHMENT_OPTIMAL)
                    .loadOp(VkAttachmentLoadOp.CLEAR)
                    .storeOp(VkAttachmentStoreOp.DONT_CARE)
                    .resolveMode(VkResolveModeFlags.AVERAGE)
                    .resolveImageView(swapChainImageViews.read(imageIndex))
                    .resolveImageLayout(VkImageLayout.COLOR_ATTACHMENT_OPTIMAL);
            var depthAttachmentInfo = renderingAttachmentInfos.at(1);
            depthAttachmentInfo.imageView(depthImageView)
                    .imageLayout(VkImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL)
                    .loadOp(VkAttachmentLoadOp.CLEAR)
                    .storeOp(VkAttachmentStoreOp.DONT_CARE);
            depthAttachmentInfo.clearValue().depthStencil().depth(1.0f);

            renderingInfo.colorAttachmentCount(1)
                    .pColorAttachments(colorAttachmentInfo)
                    .pDepthAttachment(depthAttachmentInfo);

            deviceCommands.cmdBeginRenderingKHR(commandBuffer, renderingInfo);
            deviceCommands.cmdBindPipeline(commandBuffer, VkPipelineBindPoint.GRAPHICS, graphicsPipeline);

            var viewport = VkViewport.allocate(arena)
                    .x(0.0f)
                    .y(0.0f)
                    .width(swapChainExtent.width())
                    .height(swapChainExtent.height())
                    .minDepth(0.0f)
                    .maxDepth(1.0f);
            deviceCommands.cmdSetViewport(commandBuffer, 0, 1, viewport);

            var scissor = VkRect2D.allocate(arena)
                    .offset(it -> it.x(0).y(0))
                    .extent(swapChainExtent);
            deviceCommands.cmdSetScissor(commandBuffer, 0, 1, scissor);

            var vertexBuffers = VkBuffer.Ptr.allocateV(arena, vertexBuffer);
            var offsets = LongPtr.allocateV(arena, 0L);
            deviceCommands.cmdBindVertexBuffers(commandBuffer, 0, 1, vertexBuffers, offsets);
            deviceCommands.cmdBindIndexBuffer(commandBuffer, indexBuffer, 0, VkIndexType.UINT32);

            var pDescriptorSet = descriptorSets.offset(currentFrame);
            deviceCommands.cmdBindDescriptorSets(
                    commandBuffer,
                    VkPipelineBindPoint.GRAPHICS,
                    pipelineLayout,
                    0,
                    1,
                    pDescriptorSet,
                    0,
                    null
            );

            var time = (System.currentTimeMillis() - startTime) / 1000.0f;
            var model = new Matrix4f().rotate((float) (Math.toRadians(90.0f) * time), 0.0f, 0.0f, 1.0f);
            var pushConstantBuffer = FloatPtr.allocate(arena, 16);
            model.get(pushConstantBuffer.segment().asByteBuffer().order(ByteOrder.nativeOrder()));
            deviceCommands.cmdPushConstants(
                    commandBuffer,
                    pipelineLayout,
                    VkShaderStageFlags.VERTEX,
                    0,
                    16 * Float.BYTES,
                    pushConstantBuffer.segment()
            );

            deviceCommands.cmdDrawIndexed(commandBuffer, indices.length, 1, 0, 0, 0);

            deviceCommands.cmdEndRenderingKHR(commandBuffer);

            var postImageMemoryBarrier = VkImageMemoryBarrier.allocate(arena)
                    .srcAccessMask(VkAccessFlags.COLOR_ATTACHMENT_WRITE)
                    .dstAccessMask(0)
                    .oldLayout(VkImageLayout.COLOR_ATTACHMENT_OPTIMAL)
                    .newLayout(VkImageLayout.PRESENT_SRC_KHR)
                    .image(swapChainImages.read(imageIndex))
                    .subresourceRange(it -> it
                            .aspectMask(VkImageAspectFlags.COLOR)
                            .baseMipLevel(0)
                            .levelCount(1)
                            .baseArrayLayer(0)
                            .layerCount(1));
            deviceCommands.cmdPipelineBarrier(
                    commandBuffer,
                    VkPipelineStageFlags.COLOR_ATTACHMENT_OUTPUT,
                    VkPipelineStageFlags.BOTTOM_OF_PIPE,
                    0,
                    0, null,
                    0, null,
                    1, postImageMemoryBarrier
            );

            result = deviceCommands.endCommandBuffer(commandBuffer);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to end recording command buffer, vulkan error code: " + VkResult.explain(result));
            }
        }
    }

    private void updateUniformBuffer() {
        var view = new Matrix4f().lookAt(
                2.0f, 2.0f, 2.0f,
                0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f
        );
        var proj = new Matrix4f().perspective(
                (float) Math.toRadians(45.0f),
                swapChainExtent.width() / (float) swapChainExtent.height(),
                0.1f,
                10.0f,
                true
        );
        proj.m11(-proj.m11());
        new UniformBufferObject(view, proj).writeToFloatPtr(uniformBufferMapped);
    }

    private void recreateSwapchain() {
        try (var arena = Arena.ofConfined()) {
            var pWidth = IntPtr.allocate(arena);
            var pHeight = IntPtr.allocate(arena);
            glfw.getFramebufferSize(window, pWidth, pHeight);
            while (pWidth.read() == 0 || pHeight.read() == 0) {
                glfw.getFramebufferSize(window, pWidth, pHeight);
                glfw.waitEvents();
            }
        }

        deviceCommands.deviceWaitIdle(device);

        cleanupSwapChain();

        createSwapchain();
        createImageViews();
        createColorResources();
        createDepthResources();
        createSwapchainSyncObjects();

        updateUniformBuffer();
    }

    private boolean checkValidationLayerSupport() {
        try (var arena = Arena.ofConfined()) {
            var pLayerCount = IntPtr.allocate(arena);
            var result = entryCommands.enumerateInstanceLayerProperties(pLayerCount, null);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to enumerate instance layer properties, vulkan error code: " + VkResult.explain(result));
            }

            var layerCount = pLayerCount.read();
            var availableLayers = VkLayerProperties.allocate(arena, layerCount);
            result = entryCommands.enumerateInstanceLayerProperties(pLayerCount, availableLayers);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to enumerate instance layer properties, vulkan error code: " + VkResult.explain(result));
            }

            for (var layer : availableLayers) {
                if (VALIDATION_LAYER_NAME.equals(layer.layerName().readString())) {
                    return true;
                }
            }

            return false;
        }
    }

    private PointerPtr getRequiredExtensions(Arena arena) {
        try (var localArena = Arena.ofConfined()) {
            var pGLFWExtensionCount = IntPtr.allocate(localArena);
            var glfwExtensions = glfw.getRequiredInstanceExtensions(pGLFWExtensionCount);
            if (glfwExtensions == null) {
                throw new RuntimeException("Failed to get GLFW required instance extensions");
            }

            var glfwExtensionCount = pGLFWExtensionCount.read();
            glfwExtensions = glfwExtensions.reinterpret(glfwExtensionCount);

            PointerPtr extensions;
            if (!ENABLE_VALIDATION_LAYERS) {
                extensions = PointerPtr.allocate(arena, glfwExtensionCount + 1);
            }
            else {
                extensions = PointerPtr.allocate(arena, glfwExtensionCount + 2);
            }

            for (int i = 0; i < glfwExtensionCount; i++) {
                extensions.write(i, glfwExtensions.read(i));
            }

            extensions.write(glfwExtensionCount, BytePtr.allocateString(arena, VkConstants.KHR_GET_PHYSICAL_DEVICE_PROPERTIES_2_EXTENSION_NAME));
            if (ENABLE_VALIDATION_LAYERS) {
                extensions.write(glfwExtensionCount + 1, BytePtr.allocateString(arena, VkConstants.EXT_DEBUG_UTILS_EXTENSION_NAME));
            }
            return extensions;
        }
    }

    private boolean isDeviceSuitable(VkPhysicalDevice device) {
        var indices = findQueueFamilies(device);
        var extensionsSupported = checkDeviceExtensionSupport(device);
        if ((indices == null) || !extensionsSupported) {
            return false;
        }

        try (var arena = Arena.ofConfined()) {
            var swapChainSupport = querySwapChainSupport(device, arena);
            var supportedFeatures = VkPhysicalDeviceFeatures.allocate(arena);
            instanceCommands.getPhysicalDeviceFeatures(device, supportedFeatures);
            return swapChainSupport.formats().size() != 0
                   && swapChainSupport.presentModes().size() != 0
                   && supportedFeatures.samplerAnisotropy() == VkConstants.TRUE;
        }
    }

    private record QueueFamilyIndices(int graphicsFamily, int presentFamily) {}

    private QueueFamilyIndices findQueueFamilies(VkPhysicalDevice device) {
        try (var arena = Arena.ofConfined()) {
            var pQueueFamilyCount = IntPtr.allocate(arena);
            instanceCommands.getPhysicalDeviceQueueFamilyProperties(device, pQueueFamilyCount, null);

            var queueFamilyCount = pQueueFamilyCount.read();
            var queueFamilies = VkQueueFamilyProperties.allocate(arena, queueFamilyCount);
            instanceCommands.getPhysicalDeviceQueueFamilyProperties(device, pQueueFamilyCount, queueFamilies);

            int graphicsFamily = -1;
            int presentFamily = -1;
            var pSurfaceSupport = IntPtr.allocate(arena);
            for (int i = 0; i < queueFamilyCount; i++) {
                var queueFamily = queueFamilies.at(i);
                if ((queueFamily.queueFlags() & VkQueueFlags.GRAPHICS) != 0) {
                    graphicsFamily = i;
                }

                if (instanceCommands.getPhysicalDeviceSurfaceSupportKHR(device, i, surface, pSurfaceSupport) == VkResult.SUCCESS
                    && pSurfaceSupport.read() == VkConstants.TRUE) {
                    presentFamily = i;
                }

                if (graphicsFamily != -1 && presentFamily != -1) {
                    break;
                }
            }

            if (graphicsFamily >= 0 && presentFamily >= 0) {
                return new QueueFamilyIndices(graphicsFamily, presentFamily);
            } else {
                return null;
            }
        }
    }

    private boolean checkDeviceExtensionSupport(VkPhysicalDevice device) {
        try (var arena = Arena.ofConfined()) {
            var pExtensionCount = IntPtr.allocate(arena);
            var result = instanceCommands.enumerateDeviceExtensionProperties(device, null, pExtensionCount, null);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to enumerate device extension properties, vulkan error code: " + VkResult.explain(result));
            }

            var extensionCount = pExtensionCount.read();
            var availableExtensions = VkExtensionProperties.allocate(arena, extensionCount);
            result = instanceCommands.enumerateDeviceExtensionProperties(device, null, pExtensionCount, availableExtensions);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to enumerate device extension properties, vulkan error code: " + VkResult.explain(result));
            }

            for (var extension : availableExtensions) {
                if (VkConstants.KHR_SWAPCHAIN_EXTENSION_NAME.equals(extension.extensionName().readString())) {
                    return true;
                }
            }

            return false;
        }
    }

    private record SwapchainSupportDetails(
            VkSurfaceCapabilitiesKHR capabilities,
            VkSurfaceFormatKHR.Ptr formats,
            @EnumType(VkPresentModeKHR.class) IntPtr presentModes
    ) {}

    private SwapchainSupportDetails querySwapChainSupport(VkPhysicalDevice device, Arena arena) {
        var surfaceCapabilities = VkSurfaceCapabilitiesKHR.allocate(arena);
        var result = instanceCommands.getPhysicalDeviceSurfaceCapabilitiesKHR(device, surface, surfaceCapabilities);
        if (result != VkResult.SUCCESS) {
            throw new RuntimeException("Failed to get physical device surface capabilities, vulkan error code: " + VkResult.explain(result));
        }

        try (var localArena = Arena.ofConfined()) {
            var pFormatCount = IntPtr.allocate(localArena);
            result = instanceCommands.getPhysicalDeviceSurfaceFormatsKHR(device, surface, pFormatCount, null);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to get physical device surface formats, vulkan error code: " + VkResult.explain(result));
            }

            var formatCount = pFormatCount.read();
            var formats = VkSurfaceFormatKHR.allocate(arena, formatCount);
            result = instanceCommands.getPhysicalDeviceSurfaceFormatsKHR(device, surface, pFormatCount, formats);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to get physical device surface formats, vulkan error code: " + VkResult.explain(result));
            }

            var pPresentModeCount = IntPtr.allocate(localArena);
            result = instanceCommands.getPhysicalDeviceSurfacePresentModesKHR(device, surface, pPresentModeCount, null);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to get physical device surface present modes, vulkan error code: " + VkResult.explain(result));
            }

            var presentModeCount = pPresentModeCount.read();
            var presentModes = IntPtr.allocate(arena, presentModeCount);
            result = instanceCommands.getPhysicalDeviceSurfacePresentModesKHR(device, surface, pPresentModeCount, presentModes);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to get physical device surface present modes, vulkan error code: " + VkResult.explain(result));
            }

            return new SwapchainSupportDetails(surfaceCapabilities, formats, presentModes);
        }
    }

    private VkSurfaceFormatKHR chooseSwapSurfaceFormat(VkSurfaceFormatKHR.Ptr formats) {
        for (var format : formats) {
            if (format.format() == VkFormat.B8G8R8A8_SRGB
                && format.colorSpace() == VkColorSpaceKHR.SRGB_NONLINEAR) {
                return format;
            }
        }

        return formats.at(0);
    }

    private @EnumType(VkPresentModeKHR.class) int chooseSwapPresentMode(
            @EnumType(VkPresentModeKHR.class) IntPtr presentModes
    ) {
        for (int presentMode : presentModes) {
            if (presentMode == VkPresentModeKHR.MAILBOX) {
                return presentMode;
            }
        }
        return VkPresentModeKHR.FIFO;
    }

    private VkExtent2D chooseSwapExtent(VkSurfaceCapabilitiesKHR capabilities, Arena arena) {
        if (capabilities.currentExtent().width() != NativeLayout.UINT32_MAX) {
            return capabilities.currentExtent();
        }
        else {
            try (var localArena = Arena.ofConfined()) {
                var pWidth = IntPtr.allocate(localArena);
                var pHeight = IntPtr.allocate(localArena);
                glfw.getFramebufferSize(window, pWidth, pHeight);
                var width = pWidth.read();
                var height = pHeight.read();

                return VkExtent2D.allocate(arena)
                        .width(Math.clamp(width, capabilities.minImageExtent().width(), capabilities.maxImageExtent().width()))
                        .height(Math.clamp(height, capabilities.minImageExtent().height(), capabilities.maxImageExtent().height()));
            }
        }
    }

    private VkShaderModule createShaderModule(IntPtr code) {
        try (var arena = Arena.ofConfined()) {
            var createInfo = VkShaderModuleCreateInfo.allocate(arena)
                    .codeSize(code.size() * Integer.BYTES)
                    .pCode(code);

            var pShaderModule = VkShaderModule.Ptr.allocate(arena);
            var result = deviceCommands.createShaderModule(device, createInfo, null, pShaderModule);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create shader module, vulkan error code: " + VkResult.explain(result));
            }
            return Objects.requireNonNull(pShaderModule.read());
        }
    }

    private void createSwapchainSyncObjects() {
        pRenderFinishedSemaphores = VkSemaphore.Ptr.allocate(Arena.ofAuto(), swapChainImages.size());
        try (var arena = Arena.ofConfined()) {
            var semaphoreInfo = VkSemaphoreCreateInfo.allocate(arena);
            for (int i = 0; i < swapChainImages.size(); i++) {
                var pRenderFinishedSemaphore = pRenderFinishedSemaphores.offset(i);
                if (deviceCommands.createSemaphore(device, semaphoreInfo, null, pRenderFinishedSemaphore) != VkResult.SUCCESS) {
                    throw new RuntimeException("Failed to create render finished semaphore for swap chain image " + i);
                }
            }
        }
    }

    private void cleanupSwapChain() {
        deviceCommands.destroyImageView(device, colorImageView, null);
        vma.destroyImage(vmaAllocator, colorImage, colorImageAllocation);
        deviceCommands.destroyImageView(device, depthImageView, null);
        vma.destroyImage(vmaAllocator, depthImage, depthImageAllocation);
        for (var imageView : swapChainImageViews) {
            deviceCommands.destroyImageView(device, imageView, null);
        }
        for (var semaphore : pRenderFinishedSemaphores) {
            deviceCommands.destroySemaphore(device, semaphore, null);
        }
        deviceCommands.destroySwapchainKHR(device, swapChain, null);
    }

    private record Pair<T1, T2>(T1 first, T2 second) {}

    private Pair<VkBuffer, VmaAllocation> createBuffer(
            int size,
            @Bitmask(VkBufferUsageFlags.class) int usage,
            @Bitmask(VmaAllocationCreateFlags.class) int vmaAllocationCreationFlags,
            @Bitmask(VkMemoryPropertyFlags.class) int vkMemoryPropertyFlags,
            @Nullable @Pointer VmaAllocationInfo allocationInfo
    ) {
        try (var arena = Arena.ofConfined()) {
            var bufferInfo = VkBufferCreateInfo.allocate(arena)
                    .size(size)
                    .usage(usage)
                    .sharingMode(VkSharingMode.EXCLUSIVE);

            var allocationCreateInfo = VmaAllocationCreateInfo.allocate(arena)
                    .usage(VmaMemoryUsage.AUTO)
                    .flags(vmaAllocationCreationFlags)
                    .requiredFlags(vkMemoryPropertyFlags);

            var pBuffer = VkBuffer.Ptr.allocate(arena);
            var pAllocation = VmaAllocation.Ptr.allocate(arena);
            var result = vma.createBuffer(vmaAllocator, bufferInfo, allocationCreateInfo, pBuffer, pAllocation, allocationInfo);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create vertex buffer, vulkan error code: " + VkResult.explain(result));
            }
            var buffer = Objects.requireNonNull(pBuffer.read());
            var allocation = Objects.requireNonNull(pAllocation.read());

            return new Pair<>(buffer, allocation);
        }
    }

    private record UniformBufferObject(Matrix4f view, Matrix4f proj) {
        public static int bufferSize() {
            return 16 * 2;
        }

        public void writeToFloatPtr(FloatPtr buffer) {
            assert buffer.size() >= bufferSize();

            view.get(buffer.segment().asByteBuffer().order(ByteOrder.nativeOrder()));
            proj.get(buffer.offset(16).segment().asByteBuffer().order(ByteOrder.nativeOrder()));
        }
    }

    private void copyBuffer(VkBuffer srcBuffer, VkBuffer dstBuffer, int size) {
        try (var arena = Arena.ofConfined()) {
            var commandBuffer = beginSingleTimeCommands();

            var copyRegion = VkBufferCopy.allocate(arena)
                    .size(size);
            deviceCommands.cmdCopyBuffer(commandBuffer, srcBuffer, dstBuffer, 1, copyRegion);

            endSingleTimeCommands(commandBuffer);
        }
    }

    private Pair<VkImage, VmaAllocation> createImage(
            int width,
            int height,
            int mipLevels,
            @Bitmask(VkSampleCountFlags.class) int numSamples,
            @EnumType(VkFormat.class) int format,
            @EnumType(VkImageTiling.class) int tiling,
            @Bitmask(VkImageUsageFlags.class) int usage
    ) {
        try (var arena = Arena.ofConfined()) {
            var imageInfo = VkImageCreateInfo.allocate(arena)
                    .imageType(VkImageType._2D)
                    .mipLevels(mipLevels)
                    .arrayLayers(1)
                    .format(format)
                    .tiling(tiling)
                    .initialLayout(VkImageLayout.UNDEFINED)
                    .usage(usage)
                    .samples(numSamples)
                    .sharingMode(VkSharingMode.EXCLUSIVE)
                    .extent(it -> it.width(width).height(height).depth(1));

            var allocationCreateInfo = VmaAllocationCreateInfo.allocate(arena);
            allocationCreateInfo.usage(VmaMemoryUsage.AUTO_PREFER_DEVICE);

            var pImage = VkImage.Ptr.allocate(arena);
            var pAllocation = VmaAllocation.Ptr.allocate(arena);
            var result = vma.createImage(vmaAllocator, imageInfo, allocationCreateInfo, pImage, pAllocation, null);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create image, vulkan error code: " + VkResult.explain(result));
            }
            var image = Objects.requireNonNull(pImage.read());
            var allocation = Objects.requireNonNull(pAllocation.read());
            return new Pair<>(image, allocation);
        }
    }

    private void transitionImageLayout(
            VkImage image,
            @EnumType(VkFormat.class) int format,
            @EnumType(VkImageLayout.class) int oldLayout,
            @EnumType(VkImageLayout.class) int newLayout,
            int mipLevels
    ) {
        try (var arena = Arena.ofConfined()) {
            var commandBuffer = beginSingleTimeCommands();

            var barrier = VkImageMemoryBarrier.allocate(arena)
                    .oldLayout(oldLayout)
                    .newLayout(newLayout)
                    .srcQueueFamilyIndex(VkConstants.QUEUE_FAMILY_IGNORED)
                    .dstQueueFamilyIndex(VkConstants.QUEUE_FAMILY_IGNORED)
                    .image(image);
            var subResourceRange = barrier.subresourceRange()
                    .aspectMask(VkImageAspectFlags.COLOR)
                    .baseMipLevel(0)
                    .levelCount(mipLevels)
                    .baseArrayLayer(0)
                    .layerCount(1);

            if (newLayout == VkImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL) {
                subResourceRange.aspectMask(VkImageAspectFlags.DEPTH);
                if (hasStencilComponent(format)) {
                    subResourceRange.aspectMask(subResourceRange.aspectMask()
                                                | VkImageAspectFlags.STENCIL);
                }
            }
            else {
                subResourceRange.aspectMask(VkImageAspectFlags.COLOR);
            }

            @Bitmask(VkPipelineStageFlags.class) int sourceStage;
            @Bitmask(VkPipelineStageFlags.class) int destinationStage;

            if (oldLayout == VkImageLayout.UNDEFINED
                && newLayout == VkImageLayout.TRANSFER_DST_OPTIMAL) {
                barrier.srcAccessMask(0).dstAccessMask(VkAccessFlags.TRANSFER_WRITE);

                sourceStage = VkPipelineStageFlags.TOP_OF_PIPE;
                destinationStage = VkPipelineStageFlags.TRANSFER;
            }
            else if (oldLayout == VkImageLayout.TRANSFER_DST_OPTIMAL
                     && newLayout == VkImageLayout.SHADER_READ_ONLY_OPTIMAL) {
                barrier.srcAccessMask(VkAccessFlags.TRANSFER_WRITE).dstAccessMask(VkAccessFlags.SHADER_READ);

                sourceStage = VkPipelineStageFlags.TRANSFER;
                destinationStage = VkPipelineStageFlags.FRAGMENT_SHADER;
            }
            else if (oldLayout == VkImageLayout.UNDEFINED
                     && newLayout == VkImageLayout.DEPTH_STENCIL_ATTACHMENT_OPTIMAL) {
                barrier.srcAccessMask(0)
                        .dstAccessMask(VkAccessFlags.DEPTH_STENCIL_ATTACHMENT_READ
                                       | VkAccessFlags.DEPTH_STENCIL_ATTACHMENT_WRITE);

                sourceStage = VkPipelineStageFlags.TOP_OF_PIPE;
                destinationStage = VkPipelineStageFlags.EARLY_FRAGMENT_TESTS;
            }
            else {
                throw new RuntimeException(
                        "Unsupported layout transition from "
                        + VkImageLayout.explain(oldLayout)
                        + " to "
                        + VkImageLayout.explain(newLayout)
                );
            }

            deviceCommands.cmdPipelineBarrier(
                    commandBuffer,
                    sourceStage,
                    destinationStage,
                    0,
                    0, null,
                    0, null,
                    1, barrier
            );

            endSingleTimeCommands(commandBuffer);
        }
    }

    private void copyBufferToImage(
            VkBuffer buffer,
            VkImage image,
            int width,
            int height
    ) {
        try (var arena = Arena.ofConfined()) {
            var commandBuffer = beginSingleTimeCommands();

            var region = VkBufferImageCopy.allocate(arena)
                    .bufferOffset(0)
                    .bufferRowLength(0)
                    .bufferImageHeight(0)
                    .imageSubresource(it -> it
                            .aspectMask(VkImageAspectFlags.COLOR)
                            .mipLevel(0)
                            .baseArrayLayer(0)
                            .layerCount(1))
                    .imageOffset(it -> it.x(0).y(0).z(0))
                    .imageExtent(it -> it
                        .width(width)
                        .height(height)
                        .depth(1));

            deviceCommands.cmdCopyBufferToImage(
                    commandBuffer,
                    buffer,
                    image,
                    VkImageLayout.TRANSFER_DST_OPTIMAL,
                    1,
                    region
            );

            endSingleTimeCommands(commandBuffer);
        }
    }

    private VkCommandBuffer beginSingleTimeCommands() {
        try (var arena = Arena.ofConfined()) {
            var allocInfo = VkCommandBufferAllocateInfo.allocate(arena)
                    .level(VkCommandBufferLevel.PRIMARY)
                    .commandPool(commandPool)
                    .commandBufferCount(1);

            var pCommandBuffer = VkCommandBuffer.Ptr.allocate(arena);
            var result = deviceCommands.allocateCommandBuffers(device, allocInfo, pCommandBuffer);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to allocate command buffer, vulkan error code: " + VkResult.explain(result));
            }
            var commandBuffer = Objects.requireNonNull(pCommandBuffer.read());

            var beginInfo = VkCommandBufferBeginInfo.allocate(arena)
                    .flags(VkCommandBufferUsageFlags.ONE_TIME_SUBMIT);
            result = deviceCommands.beginCommandBuffer(commandBuffer, beginInfo);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to begin recording command buffer, vulkan error code: " + VkResult.explain(result));
            }

            return commandBuffer;
        }
    }

    private void endSingleTimeCommands(VkCommandBuffer commandBuffer) {
        deviceCommands.endCommandBuffer(commandBuffer);

        try (var arena = Arena.ofConfined()) {
            var pCommandBuffer = VkCommandBuffer.Ptr.allocateV(arena, commandBuffer);
            var submitInfo = VkSubmitInfo.allocate(arena)
                    .commandBufferCount(1)
                    .pCommandBuffers(pCommandBuffer);

            deviceCommands.queueSubmit(graphicsQueue, 1, submitInfo, null);
            deviceCommands.queueWaitIdle(graphicsQueue);
            deviceCommands.freeCommandBuffers(device, commandPool, 1, pCommandBuffer);
        }
    }

    private VkImageView createImageView(
            VkImage image,
            @EnumType(VkFormat.class) int format,
            @Bitmask(VkImageAspectFlags.class) int aspect,
            int mipLevels
    ) {
        try (var arena = Arena.ofConfined()) {
            var viewInfo = VkImageViewCreateInfo.allocate(arena)
                    .image(image)
                    .viewType(VkImageViewType._2D)
                    .format(format)
                    .subresourceRange(it -> it
                            .aspectMask(aspect)
                            .baseMipLevel(0)
                            .levelCount(mipLevels)
                            .baseArrayLayer(0)
                            .layerCount(1));

            var pImageView = VkImageView.Ptr.allocate(arena);
            var result = deviceCommands.createImageView(device, viewInfo, null, pImageView);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create image view, vulkan error code: " + VkResult.explain(result));
            }
            return Objects.requireNonNull(pImageView.read());
        }
    }

    private @EnumType(VkFormat.class) int findDepthFormat() {
        return findSupportedFormat(
                new int[] {
                        VkFormat.D32_SFLOAT,
                        VkFormat.D32_SFLOAT_S8_UINT,
                        VkFormat.D24_UNORM_S8_UINT
                },
                VkImageTiling.OPTIMAL,
                VkFormatFeatureFlags.DEPTH_STENCIL_ATTACHMENT
        );
    }

    private @EnumType(VkFormat.class) int findSupportedFormat(
            @EnumType(VkFormat.class) int[] candidates,
            @EnumType(VkImageTiling.class) int tiling,
            @Bitmask(VkFormatFeatureFlags.class) int features
    ) {
        for (var format : candidates) {
            try (var arena = Arena.ofConfined()) {
                var props = VkFormatProperties.allocate(arena);
                instanceCommands.getPhysicalDeviceFormatProperties(physicalDevice, format, props);

                if (tiling == VkImageTiling.LINEAR && (props.linearTilingFeatures() & features) == features) {
                    return format;
                }
                else if (tiling == VkImageTiling.OPTIMAL && (props.optimalTilingFeatures() & features) == features) {
                    return format;
                }
            }
        }

        throw new RuntimeException("Failed to find supported format");
    }

    private boolean hasStencilComponent(@EnumType(VkFormat.class) int format) {
        return format == VkFormat.D32_SFLOAT_S8_UINT || format == VkFormat.D24_UNORM_S8_UINT;
    }

    private void generateMipmaps(
            VkImage image,
            @EnumType(VkFormat.class) int imageFormat,
            int texWidth,
            int texHeight,
            int mipLevels
    ) {
        try (var arena = Arena.ofConfined()) {
            var formatProperties = VkFormatProperties.allocate(arena);
            instanceCommands.getPhysicalDeviceFormatProperties(physicalDevice, imageFormat, formatProperties);
            if ((formatProperties.optimalTilingFeatures() & VkFormatFeatureFlags.SAMPLED_IMAGE_FILTER_LINEAR) == 0) {
                throw new RuntimeException("Texture image format does not support linear blitting");
            }

            var commandBuffer = beginSingleTimeCommands();

            var barrier = VkImageMemoryBarrier.allocate(arena)
                    .image(image)
                    .srcQueueFamilyIndex(VkConstants.QUEUE_FAMILY_IGNORED)
                    .dstQueueFamilyIndex(VkConstants.QUEUE_FAMILY_IGNORED)
                    .subresourceRange(it -> it
                            .aspectMask(VkImageAspectFlags.COLOR)
                            .baseArrayLayer(0)
                            .layerCount(1)
                            .levelCount(1));

            var blit = VkImageBlit.allocate(arena);

            var mipWidth = texWidth;
            var mipHeight = texHeight;
            for (var i = 1; i < mipLevels; i++) {
                barrier.subresourceRange().baseMipLevel(i - 1);
                barrier.oldLayout(VkImageLayout.TRANSFER_DST_OPTIMAL)
                        .newLayout(VkImageLayout.TRANSFER_SRC_OPTIMAL)
                        .srcAccessMask(VkAccessFlags.TRANSFER_WRITE)
                        .dstAccessMask(VkAccessFlags.TRANSFER_READ);
                deviceCommands.cmdPipelineBarrier(
                        commandBuffer,
                        VkPipelineStageFlags.TRANSFER,
                        VkPipelineStageFlags.TRANSFER,
                        0,
                        0, null,
                        0, null,
                        1, barrier
                );

                var srcOffsets = blit.srcOffsets();
                srcOffsets.at(0)
                        .x(0)
                        .y(0)
                        .z(0);
                srcOffsets.at(1)
                        .x(mipWidth)
                        .y(mipHeight)
                        .z(1);
                blit.srcSubresource()
                        .aspectMask(VkImageAspectFlags.COLOR)
                        .mipLevel(i - 1)
                        .baseArrayLayer(0)
                        .layerCount(1);
                var dstOffsets = blit.dstOffsets();
                dstOffsets.at(0)
                        .x(0)
                        .y(0)
                        .z(0);
                dstOffsets.at(1)
                        .x(mipWidth > 1 ? mipWidth / 2 : 1)
                        .y(mipHeight > 1 ? mipHeight / 2 : 1)
                        .z(1);
                blit.dstSubresource()
                        .aspectMask(VkImageAspectFlags.COLOR)
                        .mipLevel(i)
                        .baseArrayLayer(0)
                        .layerCount(1);

                deviceCommands.cmdBlitImage(
                        commandBuffer,
                        image,
                        VkImageLayout.TRANSFER_SRC_OPTIMAL,
                        image,
                        VkImageLayout.TRANSFER_DST_OPTIMAL,
                        1,
                        blit,
                        VkFilter.LINEAR
                );

                barrier.oldLayout(VkImageLayout.TRANSFER_SRC_OPTIMAL)
                        .newLayout(VkImageLayout.SHADER_READ_ONLY_OPTIMAL)
                        .srcAccessMask(VkAccessFlags.TRANSFER_READ)
                        .dstAccessMask(VkAccessFlags.SHADER_READ);
                deviceCommands.cmdPipelineBarrier(
                        commandBuffer,
                        VkPipelineStageFlags.TRANSFER,
                        VkPipelineStageFlags.FRAGMENT_SHADER,
                        0,
                        0, null,
                        0, null,
                        1, barrier
                );

                if (mipWidth > 1) {
                    mipWidth /= 2;
                }
                if (mipHeight > 1) {
                    mipHeight /= 2;
                }
            }

            barrier.subresourceRange().baseMipLevel(mipLevels - 1);
            barrier.oldLayout(VkImageLayout.TRANSFER_DST_OPTIMAL)
                    .newLayout(VkImageLayout.SHADER_READ_ONLY_OPTIMAL)
                    .srcAccessMask(VkAccessFlags.TRANSFER_WRITE)
                    .dstAccessMask(VkAccessFlags.SHADER_READ);

            deviceCommands.cmdPipelineBarrier(
                    commandBuffer,
                    VkPipelineStageFlags.TRANSFER,
                    VkPipelineStageFlags.FRAGMENT_SHADER,
                    0,
                    0, null,
                    0, null,
                    1, barrier
            );

            endSingleTimeCommands(commandBuffer);
        }
    }

    private IntPtr compileShader(
            Arena arena,
            String filename,
            @EnumType(ShadercShaderKind.class) int shaderKind
    ) {
        try (var stream = Application.class.getResourceAsStream(filename);
             var localArena = Arena.ofConfined()) {
            if (stream == null) {
                throw new RuntimeException("Failed to open shader file: " + filename);
            }

            var text = new String(stream.readAllBytes());
            var sourcePtr = BytePtr.allocateString(localArena, text);
            var result = Objects.requireNonNull(shaderc.compileIntoSPV(
                    shadercCompiler,
                    sourcePtr,
                    sourcePtr.size() - 1,
                    shaderKind,
                    BytePtr.allocateString(localArena, filename),
                    BytePtr.allocateString(localArena, "main"),
                    shadercCompileOptions
            ));

            if (shaderc.resultGetNumErrors(result) != 0) {
                String errorMessage = Objects.requireNonNull(shaderc.resultGetErrorMessage(result))
                        .readString();
                shaderc.resultRelease(result);
                throw new RuntimeException("Shader compilation failed: " + errorMessage);
            }

            long size = shaderc.resultGetLength(result);
            BytePtr bytes = Objects.requireNonNull(shaderc.resultGetBytes(result)).reinterpret(size);
            assert bytes.size() % Integer.BYTES == 0 : "Shader bytecode size is not a multiple of 4";

            IntPtr ret = IntPtr.allocate(arena, bytes.size() / Integer.BYTES);
            ret.segment().copyFrom(bytes.segment());
            shaderc.resultRelease(result);

            return ret;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read shader file: " + filename, e);
        }
    }

    private @Bitmask(VkSampleCountFlags.class) int getMaxUsableSampleCount() {
        try (var arena = Arena.ofConfined()) {
            var physicalDeviceProperties = VkPhysicalDeviceProperties.allocate(arena);
            instanceCommands.getPhysicalDeviceProperties(physicalDevice, physicalDeviceProperties);

            var counts = physicalDeviceProperties.limits().framebufferColorSampleCounts()
                         & physicalDeviceProperties.limits().framebufferDepthSampleCounts();

            if ((counts & VkSampleCountFlags._64) != 0) {
                return VkSampleCountFlags._64;
            }
            if ((counts & VkSampleCountFlags._32) != 0) {
                return VkSampleCountFlags._32;
            }
            if ((counts & VkSampleCountFlags._16) != 0) {
                return VkSampleCountFlags._16;
            }
            if ((counts & VkSampleCountFlags._8) != 0) {
                return VkSampleCountFlags._8;
            }
            if ((counts & VkSampleCountFlags._4) != 0) {
                return VkSampleCountFlags._4;
            }
            if ((counts & VkSampleCountFlags._2) != 0) {
                return VkSampleCountFlags._2;
            }

            return VkSampleCountFlags._1;
        }
    }

    private static @NativeType("VkBool32") @Unsigned int debugCallback(
            @Bitmask(VkDebugUtilsMessageSeverityFlagsEXT.class) int ignoredMessageSeverity,
            @Bitmask(VkDebugUtilsMessageTypeFlagsEXT.class) int ignoredMessageType,
            @Pointer(target=VkDebugUtilsMessengerCallbackDataEXT.class) MemorySegment pCallbackData,
            @Pointer(comment="void*") MemorySegment ignoredPUserData
    ) {
        var callbackData = new VkDebugUtilsMessengerCallbackDataEXT(pCallbackData.reinterpret(VkDebugUtilsMessengerCallbackDataEXT.BYTES));
        System.err.println("Validation layer: " + Objects.requireNonNull(callbackData.pMessage()).readString());
        return VkConstants.FALSE;
    }

    private static void populateDebugMessengerCreateInfo(VkDebugUtilsMessengerCreateInfoEXT debugUtilsMessengerCreateInfo) {
        debugUtilsMessengerCreateInfo.messageSeverity(
                VkDebugUtilsMessageSeverityFlagsEXT.VERBOSE
                | VkDebugUtilsMessageSeverityFlagsEXT.WARNING
                | VkDebugUtilsMessageSeverityFlagsEXT.ERROR
        ).messageType(
                VkDebugUtilsMessageTypeFlagsEXT.GENERAL
                | VkDebugUtilsMessageTypeFlagsEXT.VALIDATION
                | VkDebugUtilsMessageTypeFlagsEXT.PERFORMANCE
        ).pfnUserCallback(Application::debugCallback);
    }

    private static VkVertexInputBindingDescription getBindingDescription(Arena arena) {
        return VkVertexInputBindingDescription.allocate(arena)
                .binding(0)
                .stride(Float.BYTES * 8)
                .inputRate(VkVertexInputRate.VERTEX);
    }

    private static VkVertexInputAttributeDescription.Ptr getAttributeDescriptions(Arena arena) {
        return VkVertexInputAttributeDescription.allocate(arena, 3)
                .at(0, it -> it
                        .binding(0)
                        .location(0)
                        .format(VkFormat.R32G32B32_SFLOAT)
                        .offset(0))
                .at(1, it -> it
                        .binding(0)
                        .location(1)
                        .format(VkFormat.R32G32B32_SFLOAT)
                        .offset(Float.BYTES * 3))
                .at(2, it -> it
                        .binding(0)
                        .location(2)
                        .format(VkFormat.R32G32_SFLOAT)
                        .offset(Float.BYTES * 6));
    }

    private GLFWwindow window;

    private VkEntryCommands entryCommands;
    private VkInstance instance;
    private VkInstanceCommands instanceCommands;
    private VkDebugUtilsMessengerEXT debugMessenger;
    private VkPhysicalDevice physicalDevice;
    private @Bitmask(VkSampleCountFlags.class) int msaaSamples;
    private VkDevice device;
    private VkDeviceCommands deviceCommands;
    private VkQueue graphicsQueue;
    private VkSurfaceKHR surface;
    private VkQueue presentQueue;
    private VmaAllocator vmaAllocator;
    private VkSwapchainKHR swapChain;
    private VkImage.Ptr swapChainImages;
    private @EnumType(VkFormat.class) int swapChainImageFormat;
    private VkExtent2D swapChainExtent;
    private VkImageView.Ptr swapChainImageViews;
    private VkDescriptorSetLayout descriptorSetLayout;
    private ShadercCompiler shadercCompiler;
    private ShadercCompileOptions shadercCompileOptions;
    private VkPipelineLayout pipelineLayout;
    private VkPipeline graphicsPipeline;
    private VkCommandPool commandPool;
    private VkCommandBuffer.Ptr pCommandBuffers;
    private VkSemaphore.Ptr pImageAvailableSemaphores;
    private VkSemaphore.Ptr pRenderFinishedSemaphores;
    private VkFence.Ptr pInFlightFences;
    private int currentFrame;
    private boolean framebufferResized = false;
    private float[] vertices;
    private int[] indices;
    private VkBuffer vertexBuffer;
    private VmaAllocation vertexBufferAllocation;
    private VkBuffer indexBuffer;
    private VmaAllocation indexBufferAllocation;
    private VkBuffer uniformBuffer;
    private VmaAllocation uniformBufferAllocation;
    private FloatPtr uniformBufferMapped;
    private VkDescriptorPool descriptorPool;
    private VkDescriptorSet.Ptr descriptorSets;
    private int textureMipLevels;
    private VkImage textureImage;
    private VmaAllocation textureImageAllocation;
    private VkImageView textureImageView;
    private VkSampler textureSampler;
    private VkImage colorImage;
    private VmaAllocation colorImageAllocation;
    private VkImageView colorImageView;
    private @EnumType(VkFormat.class) int depthFormat;
    private VkImage depthImage;
    private VmaAllocation depthImageAllocation;
    private VkImageView depthImageView;

    private static final ISharedLibrary libGLFW = GLFWLoader.loadGLFWLibrary();
    private static final GLFW glfw = GLFWLoader.loadGLFW(libGLFW);
    private static final ISharedLibrary libShaderc = ILibraryLoader.platformLoader().loadLibrary("shaderc_shared");
    private static final Shaderc shaderc = new Shaderc(libShaderc);
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final BytePtr WINDOW_TITLE = BytePtr.allocateString(Arena.global(), "Vulkan");
    private static final ISharedLibrary libVulkan = VulkanLoader.loadVulkanLibrary();
    private static final VkStaticCommands staticCommands = VulkanLoader.loadStaticCommands(libVulkan);
    private static final boolean ENABLE_VALIDATION_LAYERS = System.getProperty("validation") != null;
    private static final String VALIDATION_LAYER_NAME = "VK_LAYER_KHRONOS_validation";
    private static final int MAX_FRAMES_IN_FLIGHT = 2;
    private static final long startTime = System.currentTimeMillis();
    private static final String MODEL_PATH = "/model/viking_room.obj";
    private static final String TEXTURE_PATH = "/texture/viking_room.png";
    private static final ISharedLibrary libVMA = ILibraryLoader.platformLoader().loadLibrary("vma");
    private static final VMA vma = new VMA(libVMA);
}

public class Main {
    public static void main(String[] args) {
        try {
            var app = new Application();
            app.run();
        }
        catch (Throwable e) {
            e.printStackTrace(System.err);
        }
    }
}
