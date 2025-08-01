package tutorial.vulkan.part04.ch14;

import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.ptr.BytePtr;
import club.doki7.ffm.ptr.FloatPtr;
import club.doki7.ffm.ptr.IntPtr;
import club.doki7.ffm.ptr.PointerPtr;
import club.doki7.glfw.GLFW;
import club.doki7.glfw.GLFWLoader;
import club.doki7.glfw.handle.GLFWwindow;
import club.doki7.vulkan.Version;
import club.doki7.vulkan.VkConstants;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.command.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
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
        glfw.windowHint(GLFW.RESIZABLE, GLFW.FALSE);
        window = Objects.requireNonNull(glfw.createWindow(WIDTH, HEIGHT, WINDOW_TITLE, null, null));
    }

    private void initVulkan() {
        entryCommands = VulkanLoader.loadEntryCommands(staticCommands);

        createInstance();
        setupDebugMessenger();
        createSurface();
        pickPhysicalDevice();
        createLogicalDevice();
        createSwapchain();
        createImageViews();
        createRenderPass();
        createGraphicsPipeline();
        createFramebuffers();
        createCommandPool();
        createCommandBuffer();
    }

    private void mainLoop() {
        while (glfw.windowShouldClose(window) == GLFW.FALSE) {
            glfw.pollEvents();
        }
    }

    private void cleanup() {
        deviceCommands.destroyCommandPool(device, commandPool, null);
        for (var framebuffer : swapChainFramebuffers) {
            deviceCommands.destroyFramebuffer(device, framebuffer, null);
        }
        deviceCommands.destroyPipeline(device, graphicsPipeline, null);
        deviceCommands.destroyPipelineLayout(device, pipelineLayout, null);
        deviceCommands.destroyRenderPass(device, renderPass, null);
        for (var imageView : swapChainImageViews) {
            deviceCommands.destroyImageView(device, imageView, null);
        }
        deviceCommands.destroySwapchainKHR(device, swapChain, null);
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
            var deviceFeatures = VkPhysicalDeviceFeatures.allocate(arena);
            deviceCreateInfo.pEnabledFeatures(deviceFeatures);

            if (ENABLE_VALIDATION_LAYERS) {
                deviceCreateInfo
                        .enabledLayerCount(1)
                        .ppEnabledLayerNames(PointerPtr.allocateStrings(arena, VALIDATION_LAYER_NAME));
            }

            deviceCreateInfo.enabledExtensionCount(1);
            var ppEnabledExtensionNames = PointerPtr.allocateStrings(arena, VkConstants.KHR_SWAPCHAIN_EXTENSION_NAME);
            deviceCreateInfo.ppEnabledExtensionNames(ppEnabledExtensionNames);

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

        try (var arena = Arena.ofConfined()) {
            var createInfo = VkImageViewCreateInfo.allocate(arena);
            var pImageView = VkImageView.Ptr.allocate(arena);

            for (long i = 0; i < swapChainImages.size(); i++) {
                createInfo.image(swapChainImages.read(i))
                        .viewType(VkImageViewType._2D)
                        .format(swapChainImageFormat)
                        .components(it -> it
                                .r(VkComponentSwizzle.IDENTITY)
                                .g(VkComponentSwizzle.IDENTITY)
                                .b(VkComponentSwizzle.IDENTITY)
                                .a(VkComponentSwizzle.IDENTITY))
                        .subresourceRange(it -> it
                                .aspectMask(VkImageAspectFlags.COLOR)
                                .baseMipLevel(0)
                                .levelCount(1)
                                .baseArrayLayer(0)
                                .layerCount(1));

                var result = deviceCommands.createImageView(device, createInfo, null, pImageView);
                if (result != VkResult.SUCCESS) {
                    throw new RuntimeException("Failed to create image views, vulkan error code: " + VkResult.explain(result));
                }
                swapChainImageViews.write(i, Objects.requireNonNull(pImageView.read()));
            }
        }
    }

    private void createRenderPass() {
        try (var arena = Arena.ofConfined()) {
            var colorAttachment = VkAttachmentDescription.allocate(arena)
                    .format(swapChainImageFormat)
                    .samples(VkSampleCountFlags._1)
                    .loadOp(VkAttachmentLoadOp.CLEAR)
                    .storeOp(VkAttachmentStoreOp.STORE)
                    .stencilLoadOp(VkAttachmentLoadOp.DONT_CARE)
                    .stencilStoreOp(VkAttachmentStoreOp.DONT_CARE)
                    .initialLayout(VkImageLayout.UNDEFINED)
                    .finalLayout(VkImageLayout.PRESENT_SRC_KHR);

            var colorAttachmentRef = VkAttachmentReference.allocate(arena)
                    .attachment(0)
                    .layout(VkImageLayout.COLOR_ATTACHMENT_OPTIMAL);

            var subpass = VkSubpassDescription.allocate(arena)
                    .pipelineBindPoint(VkPipelineBindPoint.GRAPHICS)
                    .colorAttachmentCount(1)
                    .pColorAttachments(colorAttachmentRef);

            var renderPassInfo = VkRenderPassCreateInfo.allocate(arena)
                    .attachmentCount(1)
                    .pAttachments(colorAttachment)
                    .subpassCount(1)
                    .pSubpasses(subpass);

            var pRenderPass = VkRenderPass.Ptr.allocate(arena);
            var result = deviceCommands.createRenderPass(device, renderPassInfo, null, pRenderPass);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to create render pass, vulkan error code: " + VkResult.explain(result));
            }
            renderPass = Objects.requireNonNull(pRenderPass.read());
        }
    }

    private void createGraphicsPipeline() {
        try (var arena = Arena.ofConfined()) {
            var vertShaderCode = readShaderFile("/shader/vert.spv", arena);
            var fragShaderCode = readShaderFile("/shader/frag.spv", arena);
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

            var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.allocate(arena);

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
                    .frontFace(VkFrontFace.CLOCKWISE)
                    .depthBiasEnable(VkConstants.FALSE);

            var multisampling = VkPipelineMultisampleStateCreateInfo.allocate(arena)
                    .sampleShadingEnable(VkConstants.FALSE)
                    .rasterizationSamples(VkSampleCountFlags._1);

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
                    .pColorBlendState(colorBlending)
                    .pDynamicState(dynamicStateInfo)
                    .layout(pipelineLayout)
                    .renderPass(renderPass)
                    .subpass(0);

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

    private void createFramebuffers() {
        swapChainFramebuffers = VkFramebuffer.Ptr.allocate(Arena.ofAuto(), swapChainImageViews.size());

        for (int i = 0; i < swapChainImageViews.size(); i++) {
            try (var arena = Arena.ofConfined()) {
                var pAttachments = VkImageView.Ptr.allocateV(arena, swapChainImageViews.read(i));

                var framebufferInfo = VkFramebufferCreateInfo.allocate(arena)
                        .renderPass(renderPass)
                        .attachmentCount(1)
                        .pAttachments(pAttachments)
                        .width(swapChainExtent.width())
                        .height(swapChainExtent.height())
                        .layers(1);

                var pFramebuffer = swapChainFramebuffers.offset(i);
                var result = deviceCommands.createFramebuffer(device, framebufferInfo, null, pFramebuffer);
                if (result != VkResult.SUCCESS) {
                    throw new RuntimeException("Failed to create framebuffer, vulkan error code: " + VkResult.explain(result));
                }
            }
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

    private void createCommandBuffer() {
        try (var arena = Arena.ofConfined()) {
            var allocInfo = VkCommandBufferAllocateInfo.allocate(arena)
                    .commandPool(commandPool)
                    .level(VkCommandBufferLevel.PRIMARY)
                    .commandBufferCount(1);

            var pCommandBuffer = VkCommandBuffer.Ptr.allocate(arena);
            var result = deviceCommands.allocateCommandBuffers(device, allocInfo, pCommandBuffer);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to allocate command buffer, vulkan error code: " + VkResult.explain(result));
            }
            commandBuffer = Objects.requireNonNull(pCommandBuffer.read());
        }
    }

    private void recordCommandBuffer(VkCommandBuffer commandBuffer, int imageIndex) {
        try (var arena = Arena.ofConfined()) {
            var beginInfo = VkCommandBufferBeginInfo.allocate(arena);

            var result = deviceCommands.beginCommandBuffer(commandBuffer, beginInfo);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to begin recording command buffer, vulkan error code: " + VkResult.explain(result));
            }

            var renderPassInfo = VkRenderPassBeginInfo.allocate(arena)
                    .renderPass(renderPass)
                    .framebuffer(swapChainFramebuffers.read(imageIndex))
                    .clearValueCount(1)
                    .pClearValues(VkClearValue.allocate(arena)
                            .color(it -> it.float32().writeV(0.0f, 0.0f, 0.0f, 1.0f)))
                    .renderArea(it -> it
                            .offset(offset -> offset.x(0).y(0))
                            .extent(swapChainExtent));

            deviceCommands.cmdBeginRenderPass(commandBuffer, renderPassInfo, VkSubpassContents.INLINE);
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

            deviceCommands.cmdDraw(commandBuffer, 3, 1, 0, 0);
            deviceCommands.cmdEndRenderPass(commandBuffer);

            result = deviceCommands.endCommandBuffer(commandBuffer);
            if (result != VkResult.SUCCESS) {
                throw new RuntimeException("Failed to end recording command buffer, vulkan error code: " + VkResult.explain(result));
            }
        }
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
            if (!ENABLE_VALIDATION_LAYERS) {
                return glfwExtensions;
            }
            else {
                var extensions = PointerPtr.allocate(arena, glfwExtensionCount + 1);
                for (int i = 0; i < glfwExtensionCount; i++) {
                    extensions.write(i, glfwExtensions.read(i));
                }

                extensions.write(glfwExtensionCount, BytePtr.allocateString(arena, VkConstants.EXT_DEBUG_UTILS_EXTENSION_NAME));
                return extensions;
            }
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
            return swapChainSupport.formats().size() != 0 && swapChainSupport.presentModes().size() != 0;
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

    private static IntPtr readShaderFile(String filename, Arena arena) {
        try (var stream = Application.class.getResourceAsStream(filename)) {
            if (stream == null) {
                throw new RuntimeException("Failed to open shader file: " + filename);
            }

            var bytes = stream.readAllBytes();
            assert bytes.length % Integer.BYTES == 0;
            return IntPtr.allocate(arena, bytes);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to read shader file: " + filename, e);
        }
    }

    private GLFWwindow window;

    private VkEntryCommands entryCommands;
    private VkInstance instance;
    private VkInstanceCommands instanceCommands;
    private VkDebugUtilsMessengerEXT debugMessenger;
    private VkPhysicalDevice physicalDevice;
    private VkDevice device;
    private VkDeviceCommands deviceCommands;
    private VkQueue graphicsQueue;
    private VkSurfaceKHR surface;
    private VkQueue presentQueue;
    private VkSwapchainKHR swapChain;
    private VkImage.Ptr swapChainImages;
    private @EnumType(VkFormat.class) int swapChainImageFormat;
    private VkExtent2D swapChainExtent;
    private VkImageView.Ptr swapChainImageViews;
    private VkRenderPass renderPass;
    private VkPipelineLayout pipelineLayout;
    private VkPipeline graphicsPipeline;
    private VkFramebuffer.Ptr swapChainFramebuffers;
    private VkCommandPool commandPool;
    private VkCommandBuffer commandBuffer;

    private static final ISharedLibrary libGLFW = GLFWLoader.loadGLFWLibrary();
    private static final GLFW glfw = GLFWLoader.loadGLFW(libGLFW);
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final BytePtr WINDOW_TITLE = BytePtr.allocateString(Arena.global(), "Vulkan");
    private static final ISharedLibrary libVulkan = VulkanLoader.loadVulkanLibrary();
    private static final VkStaticCommands staticCommands = VulkanLoader.loadStaticCommands(libVulkan);
    private static final boolean ENABLE_VALIDATION_LAYERS = System.getProperty("validation") != null;
    private static final String VALIDATION_LAYER_NAME = "VK_LAYER_KHRONOS_validation";
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
