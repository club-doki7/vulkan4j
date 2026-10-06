package club.doki7.vulkan.command;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;
import static club.doki7.vulkan.VkFunctionTypes.*;

public final class VkInstanceCommands {
    public VkInstanceCommands(RawFunctionLoader loader) {
        SEGMENT$vkAcquireDrmDisplayEXT = loader.apply("vkAcquireDrmDisplayEXT");
        HANDLE$vkAcquireDrmDisplayEXT = RawFunctionLoader.link(SEGMENT$vkAcquireDrmDisplayEXT, Descriptors.DESCRIPTOR$vkAcquireDrmDisplayEXT);
        SEGMENT$vkAcquireWinrtDisplayNV = loader.apply("vkAcquireWinrtDisplayNV");
        HANDLE$vkAcquireWinrtDisplayNV = RawFunctionLoader.link(SEGMENT$vkAcquireWinrtDisplayNV, Descriptors.DESCRIPTOR$vkAcquireWinrtDisplayNV);
        SEGMENT$vkAcquireXlibDisplayEXT = loader.apply("vkAcquireXlibDisplayEXT");
        HANDLE$vkAcquireXlibDisplayEXT = RawFunctionLoader.link(SEGMENT$vkAcquireXlibDisplayEXT, Descriptors.DESCRIPTOR$vkAcquireXlibDisplayEXT);
        SEGMENT$vkCmdBeginDebugUtilsLabelEXT = loader.apply("vkCmdBeginDebugUtilsLabelEXT");
        HANDLE$vkCmdBeginDebugUtilsLabelEXT = RawFunctionLoader.link(SEGMENT$vkCmdBeginDebugUtilsLabelEXT, Descriptors.DESCRIPTOR$vkCmdBeginDebugUtilsLabelEXT);
        SEGMENT$vkCmdEndDebugUtilsLabelEXT = loader.apply("vkCmdEndDebugUtilsLabelEXT");
        HANDLE$vkCmdEndDebugUtilsLabelEXT = RawFunctionLoader.link(SEGMENT$vkCmdEndDebugUtilsLabelEXT, Descriptors.DESCRIPTOR$vkCmdEndDebugUtilsLabelEXT);
        SEGMENT$vkCmdInsertDebugUtilsLabelEXT = loader.apply("vkCmdInsertDebugUtilsLabelEXT");
        HANDLE$vkCmdInsertDebugUtilsLabelEXT = RawFunctionLoader.link(SEGMENT$vkCmdInsertDebugUtilsLabelEXT, Descriptors.DESCRIPTOR$vkCmdInsertDebugUtilsLabelEXT);
        SEGMENT$vkCreateAndroidSurfaceKHR = loader.apply("vkCreateAndroidSurfaceKHR");
        HANDLE$vkCreateAndroidSurfaceKHR = RawFunctionLoader.link(SEGMENT$vkCreateAndroidSurfaceKHR, Descriptors.DESCRIPTOR$vkCreateAndroidSurfaceKHR);
        SEGMENT$vkCreateDebugReportCallbackEXT = loader.apply("vkCreateDebugReportCallbackEXT");
        HANDLE$vkCreateDebugReportCallbackEXT = RawFunctionLoader.link(SEGMENT$vkCreateDebugReportCallbackEXT, Descriptors.DESCRIPTOR$vkCreateDebugReportCallbackEXT);
        SEGMENT$vkCreateDebugUtilsMessengerEXT = loader.apply("vkCreateDebugUtilsMessengerEXT");
        HANDLE$vkCreateDebugUtilsMessengerEXT = RawFunctionLoader.link(SEGMENT$vkCreateDebugUtilsMessengerEXT, Descriptors.DESCRIPTOR$vkCreateDebugUtilsMessengerEXT);
        SEGMENT$vkCreateDevice = loader.apply("vkCreateDevice");
        HANDLE$vkCreateDevice = RawFunctionLoader.link(SEGMENT$vkCreateDevice, Descriptors.DESCRIPTOR$vkCreateDevice);
        SEGMENT$vkCreateDirectFBSurfaceEXT = loader.apply("vkCreateDirectFBSurfaceEXT");
        HANDLE$vkCreateDirectFBSurfaceEXT = RawFunctionLoader.link(SEGMENT$vkCreateDirectFBSurfaceEXT, Descriptors.DESCRIPTOR$vkCreateDirectFBSurfaceEXT);
        SEGMENT$vkCreateDisplayModeKHR = loader.apply("vkCreateDisplayModeKHR");
        HANDLE$vkCreateDisplayModeKHR = RawFunctionLoader.link(SEGMENT$vkCreateDisplayModeKHR, Descriptors.DESCRIPTOR$vkCreateDisplayModeKHR);
        SEGMENT$vkCreateDisplayPlaneSurfaceKHR = loader.apply("vkCreateDisplayPlaneSurfaceKHR");
        HANDLE$vkCreateDisplayPlaneSurfaceKHR = RawFunctionLoader.link(SEGMENT$vkCreateDisplayPlaneSurfaceKHR, Descriptors.DESCRIPTOR$vkCreateDisplayPlaneSurfaceKHR);
        SEGMENT$vkCreateHeadlessSurfaceEXT = loader.apply("vkCreateHeadlessSurfaceEXT");
        HANDLE$vkCreateHeadlessSurfaceEXT = RawFunctionLoader.link(SEGMENT$vkCreateHeadlessSurfaceEXT, Descriptors.DESCRIPTOR$vkCreateHeadlessSurfaceEXT);
        SEGMENT$vkCreateIOSSurfaceMVK = loader.apply("vkCreateIOSSurfaceMVK");
        HANDLE$vkCreateIOSSurfaceMVK = RawFunctionLoader.link(SEGMENT$vkCreateIOSSurfaceMVK, Descriptors.DESCRIPTOR$vkCreateIOSSurfaceMVK);
        SEGMENT$vkCreateImagePipeSurfaceFUCHSIA = loader.apply("vkCreateImagePipeSurfaceFUCHSIA");
        HANDLE$vkCreateImagePipeSurfaceFUCHSIA = RawFunctionLoader.link(SEGMENT$vkCreateImagePipeSurfaceFUCHSIA, Descriptors.DESCRIPTOR$vkCreateImagePipeSurfaceFUCHSIA);
        SEGMENT$vkCreateMacOSSurfaceMVK = loader.apply("vkCreateMacOSSurfaceMVK");
        HANDLE$vkCreateMacOSSurfaceMVK = RawFunctionLoader.link(SEGMENT$vkCreateMacOSSurfaceMVK, Descriptors.DESCRIPTOR$vkCreateMacOSSurfaceMVK);
        SEGMENT$vkCreateMetalSurfaceEXT = loader.apply("vkCreateMetalSurfaceEXT");
        HANDLE$vkCreateMetalSurfaceEXT = RawFunctionLoader.link(SEGMENT$vkCreateMetalSurfaceEXT, Descriptors.DESCRIPTOR$vkCreateMetalSurfaceEXT);
        SEGMENT$vkCreateScreenSurfaceQNX = loader.apply("vkCreateScreenSurfaceQNX");
        HANDLE$vkCreateScreenSurfaceQNX = RawFunctionLoader.link(SEGMENT$vkCreateScreenSurfaceQNX, Descriptors.DESCRIPTOR$vkCreateScreenSurfaceQNX);
        SEGMENT$vkCreateStreamDescriptorSurfaceGGP = loader.apply("vkCreateStreamDescriptorSurfaceGGP");
        HANDLE$vkCreateStreamDescriptorSurfaceGGP = RawFunctionLoader.link(SEGMENT$vkCreateStreamDescriptorSurfaceGGP, Descriptors.DESCRIPTOR$vkCreateStreamDescriptorSurfaceGGP);
        SEGMENT$vkCreateSurfaceOHOS = loader.apply("vkCreateSurfaceOHOS");
        HANDLE$vkCreateSurfaceOHOS = RawFunctionLoader.link(SEGMENT$vkCreateSurfaceOHOS, Descriptors.DESCRIPTOR$vkCreateSurfaceOHOS);
        SEGMENT$vkCreateUbmSurfaceSEC = loader.apply("vkCreateUbmSurfaceSEC");
        HANDLE$vkCreateUbmSurfaceSEC = RawFunctionLoader.link(SEGMENT$vkCreateUbmSurfaceSEC, Descriptors.DESCRIPTOR$vkCreateUbmSurfaceSEC);
        SEGMENT$vkCreateViSurfaceNN = loader.apply("vkCreateViSurfaceNN");
        HANDLE$vkCreateViSurfaceNN = RawFunctionLoader.link(SEGMENT$vkCreateViSurfaceNN, Descriptors.DESCRIPTOR$vkCreateViSurfaceNN);
        SEGMENT$vkCreateWaylandSurfaceKHR = loader.apply("vkCreateWaylandSurfaceKHR");
        HANDLE$vkCreateWaylandSurfaceKHR = RawFunctionLoader.link(SEGMENT$vkCreateWaylandSurfaceKHR, Descriptors.DESCRIPTOR$vkCreateWaylandSurfaceKHR);
        SEGMENT$vkCreateWin32SurfaceKHR = loader.apply("vkCreateWin32SurfaceKHR");
        HANDLE$vkCreateWin32SurfaceKHR = RawFunctionLoader.link(SEGMENT$vkCreateWin32SurfaceKHR, Descriptors.DESCRIPTOR$vkCreateWin32SurfaceKHR);
        SEGMENT$vkCreateXcbSurfaceKHR = loader.apply("vkCreateXcbSurfaceKHR");
        HANDLE$vkCreateXcbSurfaceKHR = RawFunctionLoader.link(SEGMENT$vkCreateXcbSurfaceKHR, Descriptors.DESCRIPTOR$vkCreateXcbSurfaceKHR);
        SEGMENT$vkCreateXlibSurfaceKHR = loader.apply("vkCreateXlibSurfaceKHR");
        HANDLE$vkCreateXlibSurfaceKHR = RawFunctionLoader.link(SEGMENT$vkCreateXlibSurfaceKHR, Descriptors.DESCRIPTOR$vkCreateXlibSurfaceKHR);
        SEGMENT$vkDebugReportMessageEXT = loader.apply("vkDebugReportMessageEXT");
        HANDLE$vkDebugReportMessageEXT = RawFunctionLoader.link(SEGMENT$vkDebugReportMessageEXT, Descriptors.DESCRIPTOR$vkDebugReportMessageEXT);
        SEGMENT$vkDestroyDebugReportCallbackEXT = loader.apply("vkDestroyDebugReportCallbackEXT");
        HANDLE$vkDestroyDebugReportCallbackEXT = RawFunctionLoader.link(SEGMENT$vkDestroyDebugReportCallbackEXT, Descriptors.DESCRIPTOR$vkDestroyDebugReportCallbackEXT);
        SEGMENT$vkDestroyDebugUtilsMessengerEXT = loader.apply("vkDestroyDebugUtilsMessengerEXT");
        HANDLE$vkDestroyDebugUtilsMessengerEXT = RawFunctionLoader.link(SEGMENT$vkDestroyDebugUtilsMessengerEXT, Descriptors.DESCRIPTOR$vkDestroyDebugUtilsMessengerEXT);
        SEGMENT$vkDestroyInstance = loader.apply("vkDestroyInstance");
        HANDLE$vkDestroyInstance = RawFunctionLoader.link(SEGMENT$vkDestroyInstance, Descriptors.DESCRIPTOR$vkDestroyInstance);
        SEGMENT$vkDestroySurfaceKHR = loader.apply("vkDestroySurfaceKHR");
        HANDLE$vkDestroySurfaceKHR = RawFunctionLoader.link(SEGMENT$vkDestroySurfaceKHR, Descriptors.DESCRIPTOR$vkDestroySurfaceKHR);
        SEGMENT$vkEnumerateDeviceExtensionProperties = loader.apply("vkEnumerateDeviceExtensionProperties");
        HANDLE$vkEnumerateDeviceExtensionProperties = RawFunctionLoader.link(SEGMENT$vkEnumerateDeviceExtensionProperties, Descriptors.DESCRIPTOR$vkEnumerateDeviceExtensionProperties);
        SEGMENT$vkEnumerateDeviceLayerProperties = loader.apply("vkEnumerateDeviceLayerProperties");
        HANDLE$vkEnumerateDeviceLayerProperties = RawFunctionLoader.link(SEGMENT$vkEnumerateDeviceLayerProperties, Descriptors.DESCRIPTOR$vkEnumerateDeviceLayerProperties);
        SEGMENT$vkEnumeratePhysicalDeviceGroups = loader.apply("vkEnumeratePhysicalDeviceGroups");
        HANDLE$vkEnumeratePhysicalDeviceGroups = RawFunctionLoader.link(SEGMENT$vkEnumeratePhysicalDeviceGroups, Descriptors.DESCRIPTOR$vkEnumeratePhysicalDeviceGroups);
        SEGMENT$vkEnumeratePhysicalDeviceGroupsKHR = loader.apply("vkEnumeratePhysicalDeviceGroupsKHR");
        HANDLE$vkEnumeratePhysicalDeviceGroupsKHR = RawFunctionLoader.link(SEGMENT$vkEnumeratePhysicalDeviceGroupsKHR, Descriptors.DESCRIPTOR$vkEnumeratePhysicalDeviceGroups);
        SEGMENT$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM = loader.apply("vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM");
        HANDLE$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM = RawFunctionLoader.link(SEGMENT$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM, Descriptors.DESCRIPTOR$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM);
        SEGMENT$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR = loader.apply("vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR");
        HANDLE$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR = RawFunctionLoader.link(SEGMENT$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR, Descriptors.DESCRIPTOR$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR);
        SEGMENT$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM = loader.apply("vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM");
        HANDLE$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM = RawFunctionLoader.link(SEGMENT$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM, Descriptors.DESCRIPTOR$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM);
        SEGMENT$vkEnumeratePhysicalDevices = loader.apply("vkEnumeratePhysicalDevices");
        HANDLE$vkEnumeratePhysicalDevices = RawFunctionLoader.link(SEGMENT$vkEnumeratePhysicalDevices, Descriptors.DESCRIPTOR$vkEnumeratePhysicalDevices);
        SEGMENT$vkGetDisplayModeProperties2KHR = loader.apply("vkGetDisplayModeProperties2KHR");
        HANDLE$vkGetDisplayModeProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetDisplayModeProperties2KHR, Descriptors.DESCRIPTOR$vkGetDisplayModeProperties2KHR);
        SEGMENT$vkGetDisplayModePropertiesKHR = loader.apply("vkGetDisplayModePropertiesKHR");
        HANDLE$vkGetDisplayModePropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetDisplayModePropertiesKHR, Descriptors.DESCRIPTOR$vkGetDisplayModePropertiesKHR);
        SEGMENT$vkGetDisplayPlaneCapabilities2KHR = loader.apply("vkGetDisplayPlaneCapabilities2KHR");
        HANDLE$vkGetDisplayPlaneCapabilities2KHR = RawFunctionLoader.link(SEGMENT$vkGetDisplayPlaneCapabilities2KHR, Descriptors.DESCRIPTOR$vkGetDisplayPlaneCapabilities2KHR);
        SEGMENT$vkGetDisplayPlaneCapabilitiesKHR = loader.apply("vkGetDisplayPlaneCapabilitiesKHR");
        HANDLE$vkGetDisplayPlaneCapabilitiesKHR = RawFunctionLoader.link(SEGMENT$vkGetDisplayPlaneCapabilitiesKHR, Descriptors.DESCRIPTOR$vkGetDisplayPlaneCapabilitiesKHR);
        SEGMENT$vkGetDisplayPlaneSupportedDisplaysKHR = loader.apply("vkGetDisplayPlaneSupportedDisplaysKHR");
        HANDLE$vkGetDisplayPlaneSupportedDisplaysKHR = RawFunctionLoader.link(SEGMENT$vkGetDisplayPlaneSupportedDisplaysKHR, Descriptors.DESCRIPTOR$vkGetDisplayPlaneSupportedDisplaysKHR);
        SEGMENT$vkGetDrmDisplayEXT = loader.apply("vkGetDrmDisplayEXT");
        HANDLE$vkGetDrmDisplayEXT = RawFunctionLoader.link(SEGMENT$vkGetDrmDisplayEXT, Descriptors.DESCRIPTOR$vkGetDrmDisplayEXT);
        SEGMENT$vkGetPhysicalDeviceCalibrateableTimeDomainsEXT = loader.apply("vkGetPhysicalDeviceCalibrateableTimeDomainsEXT");
        HANDLE$vkGetPhysicalDeviceCalibrateableTimeDomainsEXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceCalibrateableTimeDomainsEXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR);
        SEGMENT$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR = loader.apply("vkGetPhysicalDeviceCalibrateableTimeDomainsKHR");
        HANDLE$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR);
        SEGMENT$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV = loader.apply("vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV");
        HANDLE$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV);
        SEGMENT$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT = loader.apply("vkGetPhysicalDeviceCooperativeMatrixProperties2EXT");
        HANDLE$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT);
        SEGMENT$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR = loader.apply("vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR");
        HANDLE$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR);
        SEGMENT$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV = loader.apply("vkGetPhysicalDeviceCooperativeMatrixPropertiesNV");
        HANDLE$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV);
        SEGMENT$vkGetPhysicalDeviceCooperativeVectorPropertiesNV = loader.apply("vkGetPhysicalDeviceCooperativeVectorPropertiesNV");
        HANDLE$vkGetPhysicalDeviceCooperativeVectorPropertiesNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceCooperativeVectorPropertiesNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceCooperativeVectorPropertiesNV);
        SEGMENT$vkGetPhysicalDeviceDescriptorSizeEXT = loader.apply("vkGetPhysicalDeviceDescriptorSizeEXT");
        HANDLE$vkGetPhysicalDeviceDescriptorSizeEXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceDescriptorSizeEXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceDescriptorSizeEXT);
        SEGMENT$vkGetPhysicalDeviceDirectFBPresentationSupportEXT = loader.apply("vkGetPhysicalDeviceDirectFBPresentationSupportEXT");
        HANDLE$vkGetPhysicalDeviceDirectFBPresentationSupportEXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceDirectFBPresentationSupportEXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceDirectFBPresentationSupportEXT);
        SEGMENT$vkGetPhysicalDeviceDisplayPlaneProperties2KHR = loader.apply("vkGetPhysicalDeviceDisplayPlaneProperties2KHR");
        HANDLE$vkGetPhysicalDeviceDisplayPlaneProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceDisplayPlaneProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceDisplayPlaneProperties2KHR);
        SEGMENT$vkGetPhysicalDeviceDisplayPlanePropertiesKHR = loader.apply("vkGetPhysicalDeviceDisplayPlanePropertiesKHR");
        HANDLE$vkGetPhysicalDeviceDisplayPlanePropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceDisplayPlanePropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceDisplayPlanePropertiesKHR);
        SEGMENT$vkGetPhysicalDeviceDisplayProperties2KHR = loader.apply("vkGetPhysicalDeviceDisplayProperties2KHR");
        HANDLE$vkGetPhysicalDeviceDisplayProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceDisplayProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceDisplayProperties2KHR);
        SEGMENT$vkGetPhysicalDeviceDisplayPropertiesKHR = loader.apply("vkGetPhysicalDeviceDisplayPropertiesKHR");
        HANDLE$vkGetPhysicalDeviceDisplayPropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceDisplayPropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceDisplayPropertiesKHR);
        SEGMENT$vkGetPhysicalDeviceExternalBufferProperties = loader.apply("vkGetPhysicalDeviceExternalBufferProperties");
        HANDLE$vkGetPhysicalDeviceExternalBufferProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalBufferProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalBufferProperties);
        SEGMENT$vkGetPhysicalDeviceExternalBufferPropertiesKHR = loader.apply("vkGetPhysicalDeviceExternalBufferPropertiesKHR");
        HANDLE$vkGetPhysicalDeviceExternalBufferPropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalBufferPropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalBufferProperties);
        SEGMENT$vkGetPhysicalDeviceExternalFenceProperties = loader.apply("vkGetPhysicalDeviceExternalFenceProperties");
        HANDLE$vkGetPhysicalDeviceExternalFenceProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalFenceProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalFenceProperties);
        SEGMENT$vkGetPhysicalDeviceExternalFencePropertiesKHR = loader.apply("vkGetPhysicalDeviceExternalFencePropertiesKHR");
        HANDLE$vkGetPhysicalDeviceExternalFencePropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalFencePropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalFenceProperties);
        SEGMENT$vkGetPhysicalDeviceExternalImageFormatPropertiesNV = loader.apply("vkGetPhysicalDeviceExternalImageFormatPropertiesNV");
        HANDLE$vkGetPhysicalDeviceExternalImageFormatPropertiesNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalImageFormatPropertiesNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalImageFormatPropertiesNV);
        SEGMENT$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV = loader.apply("vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV");
        HANDLE$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV);
        SEGMENT$vkGetPhysicalDeviceExternalSemaphoreProperties = loader.apply("vkGetPhysicalDeviceExternalSemaphoreProperties");
        HANDLE$vkGetPhysicalDeviceExternalSemaphoreProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalSemaphoreProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalSemaphoreProperties);
        SEGMENT$vkGetPhysicalDeviceExternalSemaphorePropertiesKHR = loader.apply("vkGetPhysicalDeviceExternalSemaphorePropertiesKHR");
        HANDLE$vkGetPhysicalDeviceExternalSemaphorePropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalSemaphorePropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalSemaphoreProperties);
        SEGMENT$vkGetPhysicalDeviceExternalTensorPropertiesARM = loader.apply("vkGetPhysicalDeviceExternalTensorPropertiesARM");
        HANDLE$vkGetPhysicalDeviceExternalTensorPropertiesARM = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceExternalTensorPropertiesARM, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceExternalTensorPropertiesARM);
        SEGMENT$vkGetPhysicalDeviceFeatures = loader.apply("vkGetPhysicalDeviceFeatures");
        HANDLE$vkGetPhysicalDeviceFeatures = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceFeatures, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceFeatures);
        SEGMENT$vkGetPhysicalDeviceFeatures2 = loader.apply("vkGetPhysicalDeviceFeatures2");
        HANDLE$vkGetPhysicalDeviceFeatures2 = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceFeatures2, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceFeatures2);
        SEGMENT$vkGetPhysicalDeviceFeatures2KHR = loader.apply("vkGetPhysicalDeviceFeatures2KHR");
        HANDLE$vkGetPhysicalDeviceFeatures2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceFeatures2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceFeatures2);
        SEGMENT$vkGetPhysicalDeviceFormatProperties = loader.apply("vkGetPhysicalDeviceFormatProperties");
        HANDLE$vkGetPhysicalDeviceFormatProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceFormatProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceFormatProperties);
        SEGMENT$vkGetPhysicalDeviceFormatProperties2 = loader.apply("vkGetPhysicalDeviceFormatProperties2");
        HANDLE$vkGetPhysicalDeviceFormatProperties2 = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceFormatProperties2, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceFormatProperties2);
        SEGMENT$vkGetPhysicalDeviceFormatProperties2KHR = loader.apply("vkGetPhysicalDeviceFormatProperties2KHR");
        HANDLE$vkGetPhysicalDeviceFormatProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceFormatProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceFormatProperties2);
        SEGMENT$vkGetPhysicalDeviceFragmentShadingRatesKHR = loader.apply("vkGetPhysicalDeviceFragmentShadingRatesKHR");
        HANDLE$vkGetPhysicalDeviceFragmentShadingRatesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceFragmentShadingRatesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceFragmentShadingRatesKHR);
        SEGMENT$vkGetPhysicalDeviceImageFormatProperties = loader.apply("vkGetPhysicalDeviceImageFormatProperties");
        HANDLE$vkGetPhysicalDeviceImageFormatProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceImageFormatProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceImageFormatProperties);
        SEGMENT$vkGetPhysicalDeviceImageFormatProperties2 = loader.apply("vkGetPhysicalDeviceImageFormatProperties2");
        HANDLE$vkGetPhysicalDeviceImageFormatProperties2 = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceImageFormatProperties2, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceImageFormatProperties2);
        SEGMENT$vkGetPhysicalDeviceImageFormatProperties2KHR = loader.apply("vkGetPhysicalDeviceImageFormatProperties2KHR");
        HANDLE$vkGetPhysicalDeviceImageFormatProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceImageFormatProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceImageFormatProperties2);
        SEGMENT$vkGetPhysicalDeviceMemoryProperties = loader.apply("vkGetPhysicalDeviceMemoryProperties");
        HANDLE$vkGetPhysicalDeviceMemoryProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceMemoryProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceMemoryProperties);
        SEGMENT$vkGetPhysicalDeviceMemoryProperties2 = loader.apply("vkGetPhysicalDeviceMemoryProperties2");
        HANDLE$vkGetPhysicalDeviceMemoryProperties2 = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceMemoryProperties2, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceMemoryProperties2);
        SEGMENT$vkGetPhysicalDeviceMemoryProperties2KHR = loader.apply("vkGetPhysicalDeviceMemoryProperties2KHR");
        HANDLE$vkGetPhysicalDeviceMemoryProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceMemoryProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceMemoryProperties2);
        SEGMENT$vkGetPhysicalDeviceMultisamplePropertiesEXT = loader.apply("vkGetPhysicalDeviceMultisamplePropertiesEXT");
        HANDLE$vkGetPhysicalDeviceMultisamplePropertiesEXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceMultisamplePropertiesEXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceMultisamplePropertiesEXT);
        SEGMENT$vkGetPhysicalDeviceOpticalFlowImageFormatsNV = loader.apply("vkGetPhysicalDeviceOpticalFlowImageFormatsNV");
        HANDLE$vkGetPhysicalDeviceOpticalFlowImageFormatsNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceOpticalFlowImageFormatsNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceOpticalFlowImageFormatsNV);
        SEGMENT$vkGetPhysicalDevicePresentRectanglesKHR = loader.apply("vkGetPhysicalDevicePresentRectanglesKHR");
        HANDLE$vkGetPhysicalDevicePresentRectanglesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDevicePresentRectanglesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDevicePresentRectanglesKHR);
        SEGMENT$vkGetPhysicalDeviceProperties = loader.apply("vkGetPhysicalDeviceProperties");
        HANDLE$vkGetPhysicalDeviceProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceProperties);
        SEGMENT$vkGetPhysicalDeviceProperties2 = loader.apply("vkGetPhysicalDeviceProperties2");
        HANDLE$vkGetPhysicalDeviceProperties2 = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceProperties2, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceProperties2);
        SEGMENT$vkGetPhysicalDeviceProperties2KHR = loader.apply("vkGetPhysicalDeviceProperties2KHR");
        HANDLE$vkGetPhysicalDeviceProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceProperties2);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM = loader.apply("vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM");
        HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM = loader.apply("vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM");
        HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM = loader.apply("vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM");
        HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM = loader.apply("vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM");
        HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR = loader.apply("vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR");
        HANDLE$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties = loader.apply("vkGetPhysicalDeviceQueueFamilyProperties");
        HANDLE$vkGetPhysicalDeviceQueueFamilyProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyProperties);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties2 = loader.apply("vkGetPhysicalDeviceQueueFamilyProperties2");
        HANDLE$vkGetPhysicalDeviceQueueFamilyProperties2 = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties2, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyProperties2);
        SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties2KHR = loader.apply("vkGetPhysicalDeviceQueueFamilyProperties2KHR");
        HANDLE$vkGetPhysicalDeviceQueueFamilyProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyProperties2);
        SEGMENT$vkGetPhysicalDeviceRefreshableObjectTypesKHR = loader.apply("vkGetPhysicalDeviceRefreshableObjectTypesKHR");
        HANDLE$vkGetPhysicalDeviceRefreshableObjectTypesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceRefreshableObjectTypesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceRefreshableObjectTypesKHR);
        SEGMENT$vkGetPhysicalDeviceSciBufAttributesNV = loader.apply("vkGetPhysicalDeviceSciBufAttributesNV");
        HANDLE$vkGetPhysicalDeviceSciBufAttributesNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSciBufAttributesNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSciBufAttributesNV);
        SEGMENT$vkGetPhysicalDeviceSciSyncAttributesNV = loader.apply("vkGetPhysicalDeviceSciSyncAttributesNV");
        HANDLE$vkGetPhysicalDeviceSciSyncAttributesNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSciSyncAttributesNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSciSyncAttributesNV);
        SEGMENT$vkGetPhysicalDeviceScreenPresentationSupportQNX = loader.apply("vkGetPhysicalDeviceScreenPresentationSupportQNX");
        HANDLE$vkGetPhysicalDeviceScreenPresentationSupportQNX = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceScreenPresentationSupportQNX, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceScreenPresentationSupportQNX);
        SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties = loader.apply("vkGetPhysicalDeviceSparseImageFormatProperties");
        HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSparseImageFormatProperties);
        SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties2 = loader.apply("vkGetPhysicalDeviceSparseImageFormatProperties2");
        HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties2 = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties2, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSparseImageFormatProperties2);
        SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties2KHR = loader.apply("vkGetPhysicalDeviceSparseImageFormatProperties2KHR");
        HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSparseImageFormatProperties2);
        SEGMENT$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV = loader.apply("vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV");
        HANDLE$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV);
        SEGMENT$vkGetPhysicalDeviceSurfaceCapabilities2EXT = loader.apply("vkGetPhysicalDeviceSurfaceCapabilities2EXT");
        HANDLE$vkGetPhysicalDeviceSurfaceCapabilities2EXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfaceCapabilities2EXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfaceCapabilities2EXT);
        SEGMENT$vkGetPhysicalDeviceSurfaceCapabilities2KHR = loader.apply("vkGetPhysicalDeviceSurfaceCapabilities2KHR");
        HANDLE$vkGetPhysicalDeviceSurfaceCapabilities2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfaceCapabilities2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfaceCapabilities2KHR);
        SEGMENT$vkGetPhysicalDeviceSurfaceCapabilitiesKHR = loader.apply("vkGetPhysicalDeviceSurfaceCapabilitiesKHR");
        HANDLE$vkGetPhysicalDeviceSurfaceCapabilitiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfaceCapabilitiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfaceCapabilitiesKHR);
        SEGMENT$vkGetPhysicalDeviceSurfaceFormats2KHR = loader.apply("vkGetPhysicalDeviceSurfaceFormats2KHR");
        HANDLE$vkGetPhysicalDeviceSurfaceFormats2KHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfaceFormats2KHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfaceFormats2KHR);
        SEGMENT$vkGetPhysicalDeviceSurfaceFormatsKHR = loader.apply("vkGetPhysicalDeviceSurfaceFormatsKHR");
        HANDLE$vkGetPhysicalDeviceSurfaceFormatsKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfaceFormatsKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfaceFormatsKHR);
        SEGMENT$vkGetPhysicalDeviceSurfacePresentModes2EXT = loader.apply("vkGetPhysicalDeviceSurfacePresentModes2EXT");
        HANDLE$vkGetPhysicalDeviceSurfacePresentModes2EXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfacePresentModes2EXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfacePresentModes2EXT);
        SEGMENT$vkGetPhysicalDeviceSurfacePresentModesKHR = loader.apply("vkGetPhysicalDeviceSurfacePresentModesKHR");
        HANDLE$vkGetPhysicalDeviceSurfacePresentModesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfacePresentModesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfacePresentModesKHR);
        SEGMENT$vkGetPhysicalDeviceSurfaceSupportKHR = loader.apply("vkGetPhysicalDeviceSurfaceSupportKHR");
        HANDLE$vkGetPhysicalDeviceSurfaceSupportKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceSurfaceSupportKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceSurfaceSupportKHR);
        SEGMENT$vkGetPhysicalDeviceToolProperties = loader.apply("vkGetPhysicalDeviceToolProperties");
        HANDLE$vkGetPhysicalDeviceToolProperties = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceToolProperties, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceToolProperties);
        SEGMENT$vkGetPhysicalDeviceToolPropertiesEXT = loader.apply("vkGetPhysicalDeviceToolPropertiesEXT");
        HANDLE$vkGetPhysicalDeviceToolPropertiesEXT = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceToolPropertiesEXT, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceToolProperties);
        SEGMENT$vkGetPhysicalDeviceUbmPresentationSupportSEC = loader.apply("vkGetPhysicalDeviceUbmPresentationSupportSEC");
        HANDLE$vkGetPhysicalDeviceUbmPresentationSupportSEC = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceUbmPresentationSupportSEC, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceUbmPresentationSupportSEC);
        SEGMENT$vkGetPhysicalDeviceVideoCapabilitiesKHR = loader.apply("vkGetPhysicalDeviceVideoCapabilitiesKHR");
        HANDLE$vkGetPhysicalDeviceVideoCapabilitiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceVideoCapabilitiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceVideoCapabilitiesKHR);
        SEGMENT$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR = loader.apply("vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR");
        HANDLE$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR);
        SEGMENT$vkGetPhysicalDeviceVideoFormatPropertiesKHR = loader.apply("vkGetPhysicalDeviceVideoFormatPropertiesKHR");
        HANDLE$vkGetPhysicalDeviceVideoFormatPropertiesKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceVideoFormatPropertiesKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceVideoFormatPropertiesKHR);
        SEGMENT$vkGetPhysicalDeviceWaylandPresentationSupportKHR = loader.apply("vkGetPhysicalDeviceWaylandPresentationSupportKHR");
        HANDLE$vkGetPhysicalDeviceWaylandPresentationSupportKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceWaylandPresentationSupportKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceWaylandPresentationSupportKHR);
        SEGMENT$vkGetPhysicalDeviceWin32PresentationSupportKHR = loader.apply("vkGetPhysicalDeviceWin32PresentationSupportKHR");
        HANDLE$vkGetPhysicalDeviceWin32PresentationSupportKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceWin32PresentationSupportKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceWin32PresentationSupportKHR);
        SEGMENT$vkGetPhysicalDeviceXcbPresentationSupportKHR = loader.apply("vkGetPhysicalDeviceXcbPresentationSupportKHR");
        HANDLE$vkGetPhysicalDeviceXcbPresentationSupportKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceXcbPresentationSupportKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceXcbPresentationSupportKHR);
        SEGMENT$vkGetPhysicalDeviceXlibPresentationSupportKHR = loader.apply("vkGetPhysicalDeviceXlibPresentationSupportKHR");
        HANDLE$vkGetPhysicalDeviceXlibPresentationSupportKHR = RawFunctionLoader.link(SEGMENT$vkGetPhysicalDeviceXlibPresentationSupportKHR, Descriptors.DESCRIPTOR$vkGetPhysicalDeviceXlibPresentationSupportKHR);
        SEGMENT$vkGetRandROutputDisplayEXT = loader.apply("vkGetRandROutputDisplayEXT");
        HANDLE$vkGetRandROutputDisplayEXT = RawFunctionLoader.link(SEGMENT$vkGetRandROutputDisplayEXT, Descriptors.DESCRIPTOR$vkGetRandROutputDisplayEXT);
        SEGMENT$vkGetWinrtDisplayNV = loader.apply("vkGetWinrtDisplayNV");
        HANDLE$vkGetWinrtDisplayNV = RawFunctionLoader.link(SEGMENT$vkGetWinrtDisplayNV, Descriptors.DESCRIPTOR$vkGetWinrtDisplayNV);
        SEGMENT$vkQueueBeginDebugUtilsLabelEXT = loader.apply("vkQueueBeginDebugUtilsLabelEXT");
        HANDLE$vkQueueBeginDebugUtilsLabelEXT = RawFunctionLoader.link(SEGMENT$vkQueueBeginDebugUtilsLabelEXT, Descriptors.DESCRIPTOR$vkQueueBeginDebugUtilsLabelEXT);
        SEGMENT$vkQueueEndDebugUtilsLabelEXT = loader.apply("vkQueueEndDebugUtilsLabelEXT");
        HANDLE$vkQueueEndDebugUtilsLabelEXT = RawFunctionLoader.link(SEGMENT$vkQueueEndDebugUtilsLabelEXT, Descriptors.DESCRIPTOR$vkQueueEndDebugUtilsLabelEXT);
        SEGMENT$vkQueueInsertDebugUtilsLabelEXT = loader.apply("vkQueueInsertDebugUtilsLabelEXT");
        HANDLE$vkQueueInsertDebugUtilsLabelEXT = RawFunctionLoader.link(SEGMENT$vkQueueInsertDebugUtilsLabelEXT, Descriptors.DESCRIPTOR$vkQueueInsertDebugUtilsLabelEXT);
        SEGMENT$vkReleaseDisplayEXT = loader.apply("vkReleaseDisplayEXT");
        HANDLE$vkReleaseDisplayEXT = RawFunctionLoader.link(SEGMENT$vkReleaseDisplayEXT, Descriptors.DESCRIPTOR$vkReleaseDisplayEXT);
        SEGMENT$vkSetDebugUtilsObjectNameEXT = loader.apply("vkSetDebugUtilsObjectNameEXT");
        HANDLE$vkSetDebugUtilsObjectNameEXT = RawFunctionLoader.link(SEGMENT$vkSetDebugUtilsObjectNameEXT, Descriptors.DESCRIPTOR$vkSetDebugUtilsObjectNameEXT);
        SEGMENT$vkSetDebugUtilsObjectTagEXT = loader.apply("vkSetDebugUtilsObjectTagEXT");
        HANDLE$vkSetDebugUtilsObjectTagEXT = RawFunctionLoader.link(SEGMENT$vkSetDebugUtilsObjectTagEXT, Descriptors.DESCRIPTOR$vkSetDebugUtilsObjectTagEXT);
        SEGMENT$vkSubmitDebugUtilsMessageEXT = loader.apply("vkSubmitDebugUtilsMessageEXT");
        HANDLE$vkSubmitDebugUtilsMessageEXT = RawFunctionLoader.link(SEGMENT$vkSubmitDebugUtilsMessageEXT, Descriptors.DESCRIPTOR$vkSubmitDebugUtilsMessageEXT);
    }

    // region command wrappers

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkAcquireDrmDisplayEXT.html"><code>vkAcquireDrmDisplayEXT</code></a>
    public @EnumType(VkResult.class) int acquireDrmDisplayEXT(
        VkPhysicalDevice physicalDevice,
        int drmFd,
        VkDisplayKHR display
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkAcquireDrmDisplayEXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                drmFd,
                display.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkAcquireWinrtDisplayNV.html"><code>vkAcquireWinrtDisplayNV</code></a>
    public @EnumType(VkResult.class) int acquireWinrtDisplayNV(
        VkPhysicalDevice physicalDevice,
        VkDisplayKHR display
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkAcquireWinrtDisplayNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                display.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkAcquireXlibDisplayEXT.html"><code>vkAcquireXlibDisplayEXT</code></a>
    public @EnumType(VkResult.class) int acquireXlibDisplayEXT(
        VkPhysicalDevice physicalDevice,
        PointerPtr dpy,
        VkDisplayKHR display
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkAcquireXlibDisplayEXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                dpy.segment(),
                display.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCmdBeginDebugUtilsLabelEXT.html"><code>vkCmdBeginDebugUtilsLabelEXT</code></a>
    public void cmdBeginDebugUtilsLabelEXT(
        VkCommandBuffer commandBuffer,
        @Pointer VkDebugUtilsLabelEXT pLabelInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCmdBeginDebugUtilsLabelEXT);
        try {
            hFunction.invokeExact(
                commandBuffer.segment(),
                pLabelInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCmdEndDebugUtilsLabelEXT.html"><code>vkCmdEndDebugUtilsLabelEXT</code></a>
    public void cmdEndDebugUtilsLabelEXT(
        VkCommandBuffer commandBuffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCmdEndDebugUtilsLabelEXT);
        try {
            hFunction.invokeExact(
                commandBuffer.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCmdInsertDebugUtilsLabelEXT.html"><code>vkCmdInsertDebugUtilsLabelEXT</code></a>
    public void cmdInsertDebugUtilsLabelEXT(
        VkCommandBuffer commandBuffer,
        @Pointer VkDebugUtilsLabelEXT pLabelInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCmdInsertDebugUtilsLabelEXT);
        try {
            hFunction.invokeExact(
                commandBuffer.segment(),
                pLabelInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateAndroidSurfaceKHR.html"><code>vkCreateAndroidSurfaceKHR</code></a>
    public @EnumType(VkResult.class) int createAndroidSurfaceKHR(
        VkInstance instance,
        @Pointer VkAndroidSurfaceCreateInfoKHR pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateAndroidSurfaceKHR);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateDebugReportCallbackEXT.html"><code>vkCreateDebugReportCallbackEXT</code></a>
    public @EnumType(VkResult.class) int createDebugReportCallbackEXT(
        VkInstance instance,
        @Pointer VkDebugReportCallbackCreateInfoEXT pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkDebugReportCallbackEXT.Ptr pCallback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateDebugReportCallbackEXT);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pCallback.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateDebugUtilsMessengerEXT.html"><code>vkCreateDebugUtilsMessengerEXT</code></a>
    public @EnumType(VkResult.class) int createDebugUtilsMessengerEXT(
        VkInstance instance,
        @Pointer VkDebugUtilsMessengerCreateInfoEXT pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkDebugUtilsMessengerEXT.Ptr pMessenger
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateDebugUtilsMessengerEXT);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pMessenger.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateDevice.html"><code>vkCreateDevice</code></a>
    public @EnumType(VkResult.class) int createDevice(
        VkPhysicalDevice physicalDevice,
        @Pointer VkDeviceCreateInfo pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkDevice.Ptr pDevice
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateDevice);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pDevice.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateDirectFBSurfaceEXT.html"><code>vkCreateDirectFBSurfaceEXT</code></a>
    public @EnumType(VkResult.class) int createDirectFBSurfaceEXT(
        VkInstance instance,
        @Pointer VkDirectFBSurfaceCreateInfoEXT pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateDirectFBSurfaceEXT);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateDisplayModeKHR.html"><code>vkCreateDisplayModeKHR</code></a>
    public @EnumType(VkResult.class) int createDisplayModeKHR(
        VkPhysicalDevice physicalDevice,
        VkDisplayKHR display,
        @Pointer VkDisplayModeCreateInfoKHR pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkDisplayModeKHR.Ptr pMode
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateDisplayModeKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                display.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pMode.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateDisplayPlaneSurfaceKHR.html"><code>vkCreateDisplayPlaneSurfaceKHR</code></a>
    public @EnumType(VkResult.class) int createDisplayPlaneSurfaceKHR(
        VkInstance instance,
        @Pointer VkDisplaySurfaceCreateInfoKHR pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateDisplayPlaneSurfaceKHR);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateHeadlessSurfaceEXT.html"><code>vkCreateHeadlessSurfaceEXT</code></a>
    public @EnumType(VkResult.class) int createHeadlessSurfaceEXT(
        VkInstance instance,
        @Pointer VkHeadlessSurfaceCreateInfoEXT pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateHeadlessSurfaceEXT);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateIOSSurfaceMVK.html"><code>vkCreateIOSSurfaceMVK</code></a>
    public @EnumType(VkResult.class) int createIOSSurfaceMVK(
        VkInstance instance,
        @Pointer VkIOSSurfaceCreateInfoMVK pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateIOSSurfaceMVK);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateImagePipeSurfaceFUCHSIA.html"><code>vkCreateImagePipeSurfaceFUCHSIA</code></a>
    public @EnumType(VkResult.class) int createImagePipeSurfaceFUCHSIA(
        VkInstance instance,
        @Pointer VkImagePipeSurfaceCreateInfoFUCHSIA pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateImagePipeSurfaceFUCHSIA);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateMacOSSurfaceMVK.html"><code>vkCreateMacOSSurfaceMVK</code></a>
    public @EnumType(VkResult.class) int createMacOSSurfaceMVK(
        VkInstance instance,
        @Pointer VkMacOSSurfaceCreateInfoMVK pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateMacOSSurfaceMVK);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateMetalSurfaceEXT.html"><code>vkCreateMetalSurfaceEXT</code></a>
    public @EnumType(VkResult.class) int createMetalSurfaceEXT(
        VkInstance instance,
        @Pointer VkMetalSurfaceCreateInfoEXT pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateMetalSurfaceEXT);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateScreenSurfaceQNX.html"><code>vkCreateScreenSurfaceQNX</code></a>
    public @EnumType(VkResult.class) int createScreenSurfaceQNX(
        VkInstance instance,
        @Pointer VkScreenSurfaceCreateInfoQNX pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateScreenSurfaceQNX);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateStreamDescriptorSurfaceGGP.html"><code>vkCreateStreamDescriptorSurfaceGGP</code></a>
    public @EnumType(VkResult.class) int createStreamDescriptorSurfaceGGP(
        VkInstance instance,
        @Pointer VkStreamDescriptorSurfaceCreateInfoGGP pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateStreamDescriptorSurfaceGGP);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateSurfaceOHOS.html"><code>vkCreateSurfaceOHOS</code></a>
    public @EnumType(VkResult.class) int createSurfaceOHOS(
        VkInstance instance,
        @Pointer VkSurfaceCreateInfoOHOS pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateSurfaceOHOS);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateUbmSurfaceSEC.html"><code>vkCreateUbmSurfaceSEC</code></a>
    public @EnumType(VkResult.class) int createUbmSurfaceSEC(
        VkInstance instance,
        @Pointer VkUbmSurfaceCreateInfoSEC pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateUbmSurfaceSEC);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateViSurfaceNN.html"><code>vkCreateViSurfaceNN</code></a>
    public @EnumType(VkResult.class) int createViSurfaceNN(
        VkInstance instance,
        @Pointer VkViSurfaceCreateInfoNN pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateViSurfaceNN);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateWaylandSurfaceKHR.html"><code>vkCreateWaylandSurfaceKHR</code></a>
    public @EnumType(VkResult.class) int createWaylandSurfaceKHR(
        VkInstance instance,
        @Pointer VkWaylandSurfaceCreateInfoKHR pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateWaylandSurfaceKHR);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateWin32SurfaceKHR.html"><code>vkCreateWin32SurfaceKHR</code></a>
    public @EnumType(VkResult.class) int createWin32SurfaceKHR(
        VkInstance instance,
        @Pointer VkWin32SurfaceCreateInfoKHR pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateWin32SurfaceKHR);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateXcbSurfaceKHR.html"><code>vkCreateXcbSurfaceKHR</code></a>
    public @EnumType(VkResult.class) int createXcbSurfaceKHR(
        VkInstance instance,
        @Pointer VkXcbSurfaceCreateInfoKHR pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateXcbSurfaceKHR);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkCreateXlibSurfaceKHR.html"><code>vkCreateXlibSurfaceKHR</code></a>
    public @EnumType(VkResult.class) int createXlibSurfaceKHR(
        VkInstance instance,
        @Pointer VkXlibSurfaceCreateInfoKHR pCreateInfo,
        @Nullable @Pointer VkAllocationCallbacks pAllocator,
        @Pointer VkSurfaceKHR.Ptr pSurface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkCreateXlibSurfaceKHR);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pCreateInfo.segment(),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL),
                pSurface.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkDebugReportMessageEXT.html"><code>vkDebugReportMessageEXT</code></a>
    public void debugReportMessageEXT(
        VkInstance instance,
        @Bitmask(VkDebugReportFlagsEXT.class) int flags,
        @EnumType(VkDebugReportObjectTypeEXT.class) int objectType,
        @Unsigned long object,
        long location,
        int messageCode,
        BytePtr pLayerPrefix,
        BytePtr pMessage
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkDebugReportMessageEXT);
        try {
            hFunction.invokeExact(
                instance.segment(),
                flags,
                objectType,
                object,
                MemorySegment.ofAddress(location),
                messageCode,
                pLayerPrefix.segment(),
                pMessage.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkDestroyDebugReportCallbackEXT.html"><code>vkDestroyDebugReportCallbackEXT</code></a>
    public void destroyDebugReportCallbackEXT(
        VkInstance instance,
        @Nullable VkDebugReportCallbackEXT callback,
        @Nullable @Pointer VkAllocationCallbacks pAllocator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkDestroyDebugReportCallbackEXT);
        try {
            hFunction.invokeExact(
                instance.segment(),
                (MemorySegment) (callback != null ? callback.segment() : MemorySegment.NULL),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkDestroyDebugUtilsMessengerEXT.html"><code>vkDestroyDebugUtilsMessengerEXT</code></a>
    public void destroyDebugUtilsMessengerEXT(
        VkInstance instance,
        @Nullable VkDebugUtilsMessengerEXT messenger,
        @Nullable @Pointer VkAllocationCallbacks pAllocator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkDestroyDebugUtilsMessengerEXT);
        try {
            hFunction.invokeExact(
                instance.segment(),
                (MemorySegment) (messenger != null ? messenger.segment() : MemorySegment.NULL),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkDestroyInstance.html"><code>vkDestroyInstance</code></a>
    public void destroyInstance(
        @Nullable VkInstance instance,
        @Nullable @Pointer VkAllocationCallbacks pAllocator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkDestroyInstance);
        try {
            hFunction.invokeExact(
                (MemorySegment) (instance != null ? instance.segment() : MemorySegment.NULL),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkDestroySurfaceKHR.html"><code>vkDestroySurfaceKHR</code></a>
    public void destroySurfaceKHR(
        VkInstance instance,
        @Nullable VkSurfaceKHR surface,
        @Nullable @Pointer VkAllocationCallbacks pAllocator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkDestroySurfaceKHR);
        try {
            hFunction.invokeExact(
                instance.segment(),
                (MemorySegment) (surface != null ? surface.segment() : MemorySegment.NULL),
                (MemorySegment) (pAllocator != null ? pAllocator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumerateDeviceExtensionProperties.html"><code>vkEnumerateDeviceExtensionProperties</code></a>
    public @EnumType(VkResult.class) int enumerateDeviceExtensionProperties(
        VkPhysicalDevice physicalDevice,
        @Nullable BytePtr pLayerName,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkExtensionProperties pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumerateDeviceExtensionProperties);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                (MemorySegment) (pLayerName != null ? pLayerName.segment() : MemorySegment.NULL),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumerateDeviceLayerProperties.html"><code>vkEnumerateDeviceLayerProperties</code></a>
    public @EnumType(VkResult.class) int enumerateDeviceLayerProperties(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkLayerProperties pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumerateDeviceLayerProperties);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumeratePhysicalDeviceGroups.html"><code>vkEnumeratePhysicalDeviceGroups</code></a>
    public @EnumType(VkResult.class) int enumeratePhysicalDeviceGroups(
        VkInstance instance,
        @Unsigned IntPtr pPhysicalDeviceGroupCount,
        @Nullable @Pointer IVkPhysicalDeviceGroupProperties pPhysicalDeviceGroupProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumeratePhysicalDeviceGroups);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pPhysicalDeviceGroupCount.segment(),
                (MemorySegment) (pPhysicalDeviceGroupProperties != null ? pPhysicalDeviceGroupProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumeratePhysicalDeviceGroupsKHR.html"><code>vkEnumeratePhysicalDeviceGroupsKHR</code></a>
    public @EnumType(VkResult.class) int enumeratePhysicalDeviceGroupsKHR(
        VkInstance instance,
        @Unsigned IntPtr pPhysicalDeviceGroupCount,
        @Nullable @Pointer IVkPhysicalDeviceGroupProperties pPhysicalDeviceGroupProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumeratePhysicalDeviceGroupsKHR);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pPhysicalDeviceGroupCount.segment(),
                (MemorySegment) (pPhysicalDeviceGroupProperties != null ? pPhysicalDeviceGroupProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM.html"><code>vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM</code></a>
    public @EnumType(VkResult.class) int enumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        @Unsigned IntPtr pCounterCount,
        @Nullable @Pointer IVkPerformanceCounterARM pCounters,
        @Nullable @Pointer IVkPerformanceCounterDescriptionARM pCounterDescriptions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                pCounterCount.segment(),
                (MemorySegment) (pCounters != null ? pCounters.segment() : MemorySegment.NULL),
                (MemorySegment) (pCounterDescriptions != null ? pCounterDescriptions.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR.html"><code>vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR</code></a>
    public @EnumType(VkResult.class) int enumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        @Unsigned IntPtr pCounterCount,
        @Nullable @Pointer IVkPerformanceCounterKHR pCounters,
        @Nullable @Pointer IVkPerformanceCounterDescriptionKHR pCounterDescriptions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                pCounterCount.segment(),
                (MemorySegment) (pCounters != null ? pCounters.segment() : MemorySegment.NULL),
                (MemorySegment) (pCounterDescriptions != null ? pCounterDescriptions.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM.html"><code>vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM</code></a>
    public @EnumType(VkResult.class) int enumeratePhysicalDeviceShaderInstrumentationMetricsARM(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pDescriptionCount,
        @Nullable @Pointer IVkShaderInstrumentationMetricDescriptionARM pDescriptions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pDescriptionCount.segment(),
                (MemorySegment) (pDescriptions != null ? pDescriptions.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkEnumeratePhysicalDevices.html"><code>vkEnumeratePhysicalDevices</code></a>
    public @EnumType(VkResult.class) int enumeratePhysicalDevices(
        VkInstance instance,
        @Unsigned IntPtr pPhysicalDeviceCount,
        @Nullable @Pointer VkPhysicalDevice.Ptr pPhysicalDevices
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkEnumeratePhysicalDevices);
        try {
            return (int) hFunction.invokeExact(
                instance.segment(),
                pPhysicalDeviceCount.segment(),
                (MemorySegment) (pPhysicalDevices != null ? pPhysicalDevices.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetDisplayModeProperties2KHR.html"><code>vkGetDisplayModeProperties2KHR</code></a>
    public @EnumType(VkResult.class) int getDisplayModeProperties2KHR(
        VkPhysicalDevice physicalDevice,
        VkDisplayKHR display,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkDisplayModeProperties2KHR pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetDisplayModeProperties2KHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                display.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetDisplayModePropertiesKHR.html"><code>vkGetDisplayModePropertiesKHR</code></a>
    public @EnumType(VkResult.class) int getDisplayModePropertiesKHR(
        VkPhysicalDevice physicalDevice,
        VkDisplayKHR display,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkDisplayModePropertiesKHR pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetDisplayModePropertiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                display.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetDisplayPlaneCapabilities2KHR.html"><code>vkGetDisplayPlaneCapabilities2KHR</code></a>
    public @EnumType(VkResult.class) int getDisplayPlaneCapabilities2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkDisplayPlaneInfo2KHR pDisplayPlaneInfo,
        @Pointer VkDisplayPlaneCapabilities2KHR pCapabilities
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetDisplayPlaneCapabilities2KHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pDisplayPlaneInfo.segment(),
                pCapabilities.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetDisplayPlaneCapabilitiesKHR.html"><code>vkGetDisplayPlaneCapabilitiesKHR</code></a>
    public @EnumType(VkResult.class) int getDisplayPlaneCapabilitiesKHR(
        VkPhysicalDevice physicalDevice,
        VkDisplayModeKHR mode,
        @Unsigned int planeIndex,
        @Pointer VkDisplayPlaneCapabilitiesKHR pCapabilities
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetDisplayPlaneCapabilitiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                mode.segment(),
                planeIndex,
                pCapabilities.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetDisplayPlaneSupportedDisplaysKHR.html"><code>vkGetDisplayPlaneSupportedDisplaysKHR</code></a>
    public @EnumType(VkResult.class) int getDisplayPlaneSupportedDisplaysKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned int planeIndex,
        @Unsigned IntPtr pDisplayCount,
        @Nullable @Pointer VkDisplayKHR.Ptr pDisplays
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetDisplayPlaneSupportedDisplaysKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                planeIndex,
                pDisplayCount.segment(),
                (MemorySegment) (pDisplays != null ? pDisplays.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetDrmDisplayEXT.html"><code>vkGetDrmDisplayEXT</code></a>
    public @EnumType(VkResult.class) int getDrmDisplayEXT(
        VkPhysicalDevice physicalDevice,
        int drmFd,
        @Unsigned int connectorId,
        @Pointer VkDisplayKHR.Ptr display
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetDrmDisplayEXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                drmFd,
                connectorId,
                display.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceCalibrateableTimeDomainsEXT.html"><code>vkGetPhysicalDeviceCalibrateableTimeDomainsEXT</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceCalibrateableTimeDomainsEXT(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pTimeDomainCount,
        @Nullable @EnumType(VkTimeDomainKHR.class) IntPtr pTimeDomains
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceCalibrateableTimeDomainsEXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pTimeDomainCount.segment(),
                (MemorySegment) (pTimeDomains != null ? pTimeDomains.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceCalibrateableTimeDomainsKHR.html"><code>vkGetPhysicalDeviceCalibrateableTimeDomainsKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceCalibrateableTimeDomainsKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pTimeDomainCount,
        @Nullable @EnumType(VkTimeDomainKHR.class) IntPtr pTimeDomains
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pTimeDomainCount.segment(),
                (MemorySegment) (pTimeDomains != null ? pTimeDomains.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV.html"><code>vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkCooperativeMatrixFlexibleDimensionsPropertiesNV pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceCooperativeMatrixProperties2EXT.html"><code>vkGetPhysicalDeviceCooperativeMatrixProperties2EXT</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceCooperativeMatrixProperties2EXT(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceCooperativeMatrixInfo2EXT pCooperativeMatrixInfo,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkCooperativeMatrixProperties2EXT pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pCooperativeMatrixInfo.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR.html"><code>vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceCooperativeMatrixPropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkCooperativeMatrixPropertiesKHR pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceCooperativeMatrixPropertiesNV.html"><code>vkGetPhysicalDeviceCooperativeMatrixPropertiesNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceCooperativeMatrixPropertiesNV(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkCooperativeMatrixPropertiesNV pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceCooperativeVectorPropertiesNV.html"><code>vkGetPhysicalDeviceCooperativeVectorPropertiesNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceCooperativeVectorPropertiesNV(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkCooperativeVectorPropertiesNV pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceCooperativeVectorPropertiesNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceDescriptorSizeEXT.html"><code>vkGetPhysicalDeviceDescriptorSizeEXT</code></a>
    public @NativeType("VkDeviceSize") @Unsigned long getPhysicalDeviceDescriptorSizeEXT(
        VkPhysicalDevice physicalDevice,
        @EnumType(VkDescriptorType.class) int descriptorType
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceDescriptorSizeEXT);
        try {
            return (long) hFunction.invokeExact(
                physicalDevice.segment(),
                descriptorType
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceDirectFBPresentationSupportEXT.html"><code>vkGetPhysicalDeviceDirectFBPresentationSupportEXT</code></a>
    public @NativeType("VkBool32") @Unsigned int getPhysicalDeviceDirectFBPresentationSupportEXT(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        PointerPtr dfb
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceDirectFBPresentationSupportEXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                dfb.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceDisplayPlaneProperties2KHR.html"><code>vkGetPhysicalDeviceDisplayPlaneProperties2KHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceDisplayPlaneProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkDisplayPlaneProperties2KHR pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceDisplayPlaneProperties2KHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceDisplayPlanePropertiesKHR.html"><code>vkGetPhysicalDeviceDisplayPlanePropertiesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceDisplayPlanePropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkDisplayPlanePropertiesKHR pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceDisplayPlanePropertiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceDisplayProperties2KHR.html"><code>vkGetPhysicalDeviceDisplayProperties2KHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceDisplayProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkDisplayProperties2KHR pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceDisplayProperties2KHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceDisplayPropertiesKHR.html"><code>vkGetPhysicalDeviceDisplayPropertiesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceDisplayPropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkDisplayPropertiesKHR pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceDisplayPropertiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalBufferProperties.html"><code>vkGetPhysicalDeviceExternalBufferProperties</code></a>
    public void getPhysicalDeviceExternalBufferProperties(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceExternalBufferInfo pExternalBufferInfo,
        @Pointer VkExternalBufferProperties pExternalBufferProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalBufferProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pExternalBufferInfo.segment(),
                pExternalBufferProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalBufferPropertiesKHR.html"><code>vkGetPhysicalDeviceExternalBufferPropertiesKHR</code></a>
    public void getPhysicalDeviceExternalBufferPropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceExternalBufferInfo pExternalBufferInfo,
        @Pointer VkExternalBufferProperties pExternalBufferProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalBufferPropertiesKHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pExternalBufferInfo.segment(),
                pExternalBufferProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalFenceProperties.html"><code>vkGetPhysicalDeviceExternalFenceProperties</code></a>
    public void getPhysicalDeviceExternalFenceProperties(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceExternalFenceInfo pExternalFenceInfo,
        @Pointer VkExternalFenceProperties pExternalFenceProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalFenceProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pExternalFenceInfo.segment(),
                pExternalFenceProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalFencePropertiesKHR.html"><code>vkGetPhysicalDeviceExternalFencePropertiesKHR</code></a>
    public void getPhysicalDeviceExternalFencePropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceExternalFenceInfo pExternalFenceInfo,
        @Pointer VkExternalFenceProperties pExternalFenceProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalFencePropertiesKHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pExternalFenceInfo.segment(),
                pExternalFenceProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalImageFormatPropertiesNV.html"><code>vkGetPhysicalDeviceExternalImageFormatPropertiesNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceExternalImageFormatPropertiesNV(
        VkPhysicalDevice physicalDevice,
        @EnumType(VkFormat.class) int format,
        @EnumType(VkImageType.class) int type,
        @EnumType(VkImageTiling.class) int tiling,
        @Bitmask(VkImageUsageFlags.class) int usage,
        @Bitmask(VkImageCreateFlags.class) int flags,
        @Bitmask(VkExternalMemoryHandleTypeFlagsNV.class) int externalHandleType,
        @Pointer VkExternalImageFormatPropertiesNV pExternalImageFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalImageFormatPropertiesNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                format,
                type,
                tiling,
                usage,
                flags,
                externalHandleType,
                pExternalImageFormatProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV.html"><code>vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceExternalMemorySciBufPropertiesNV(
        VkPhysicalDevice physicalDevice,
        @Bitmask(VkExternalMemoryHandleTypeFlags.class) int handleType,
        @Pointer(comment="NvSciBufObj") @NotNull MemorySegment handle,
        @Pointer VkMemorySciBufPropertiesNV pMemorySciBufProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                handleType,
                handle,
                pMemorySciBufProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalSemaphoreProperties.html"><code>vkGetPhysicalDeviceExternalSemaphoreProperties</code></a>
    public void getPhysicalDeviceExternalSemaphoreProperties(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceExternalSemaphoreInfo pExternalSemaphoreInfo,
        @Pointer VkExternalSemaphoreProperties pExternalSemaphoreProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalSemaphoreProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pExternalSemaphoreInfo.segment(),
                pExternalSemaphoreProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalSemaphorePropertiesKHR.html"><code>vkGetPhysicalDeviceExternalSemaphorePropertiesKHR</code></a>
    public void getPhysicalDeviceExternalSemaphorePropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceExternalSemaphoreInfo pExternalSemaphoreInfo,
        @Pointer VkExternalSemaphoreProperties pExternalSemaphoreProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalSemaphorePropertiesKHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pExternalSemaphoreInfo.segment(),
                pExternalSemaphoreProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceExternalTensorPropertiesARM.html"><code>vkGetPhysicalDeviceExternalTensorPropertiesARM</code></a>
    public void getPhysicalDeviceExternalTensorPropertiesARM(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceExternalTensorInfoARM pExternalTensorInfo,
        @Pointer VkExternalTensorPropertiesARM pExternalTensorProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceExternalTensorPropertiesARM);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pExternalTensorInfo.segment(),
                pExternalTensorProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceFeatures.html"><code>vkGetPhysicalDeviceFeatures</code></a>
    public void getPhysicalDeviceFeatures(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceFeatures pFeatures
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceFeatures);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pFeatures.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceFeatures2.html"><code>vkGetPhysicalDeviceFeatures2</code></a>
    public void getPhysicalDeviceFeatures2(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceFeatures2 pFeatures
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceFeatures2);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pFeatures.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceFeatures2KHR.html"><code>vkGetPhysicalDeviceFeatures2KHR</code></a>
    public void getPhysicalDeviceFeatures2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceFeatures2 pFeatures
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceFeatures2KHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pFeatures.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceFormatProperties.html"><code>vkGetPhysicalDeviceFormatProperties</code></a>
    public void getPhysicalDeviceFormatProperties(
        VkPhysicalDevice physicalDevice,
        @EnumType(VkFormat.class) int format,
        @Pointer VkFormatProperties pFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceFormatProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                format,
                pFormatProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceFormatProperties2.html"><code>vkGetPhysicalDeviceFormatProperties2</code></a>
    public void getPhysicalDeviceFormatProperties2(
        VkPhysicalDevice physicalDevice,
        @EnumType(VkFormat.class) int format,
        @Pointer VkFormatProperties2 pFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceFormatProperties2);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                format,
                pFormatProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceFormatProperties2KHR.html"><code>vkGetPhysicalDeviceFormatProperties2KHR</code></a>
    public void getPhysicalDeviceFormatProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @EnumType(VkFormat.class) int format,
        @Pointer VkFormatProperties2 pFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceFormatProperties2KHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                format,
                pFormatProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceFragmentShadingRatesKHR.html"><code>vkGetPhysicalDeviceFragmentShadingRatesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceFragmentShadingRatesKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pFragmentShadingRateCount,
        @Nullable @Pointer IVkPhysicalDeviceFragmentShadingRateKHR pFragmentShadingRates
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceFragmentShadingRatesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pFragmentShadingRateCount.segment(),
                (MemorySegment) (pFragmentShadingRates != null ? pFragmentShadingRates.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceImageFormatProperties.html"><code>vkGetPhysicalDeviceImageFormatProperties</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceImageFormatProperties(
        VkPhysicalDevice physicalDevice,
        @EnumType(VkFormat.class) int format,
        @EnumType(VkImageType.class) int type,
        @EnumType(VkImageTiling.class) int tiling,
        @Bitmask(VkImageUsageFlags.class) int usage,
        @Bitmask(VkImageCreateFlags.class) int flags,
        @Pointer VkImageFormatProperties pImageFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceImageFormatProperties);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                format,
                type,
                tiling,
                usage,
                flags,
                pImageFormatProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceImageFormatProperties2.html"><code>vkGetPhysicalDeviceImageFormatProperties2</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceImageFormatProperties2(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceImageFormatInfo2 pImageFormatInfo,
        @Pointer VkImageFormatProperties2 pImageFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceImageFormatProperties2);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pImageFormatInfo.segment(),
                pImageFormatProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceImageFormatProperties2KHR.html"><code>vkGetPhysicalDeviceImageFormatProperties2KHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceImageFormatProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceImageFormatInfo2 pImageFormatInfo,
        @Pointer VkImageFormatProperties2 pImageFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceImageFormatProperties2KHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pImageFormatInfo.segment(),
                pImageFormatProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceMemoryProperties.html"><code>vkGetPhysicalDeviceMemoryProperties</code></a>
    public void getPhysicalDeviceMemoryProperties(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceMemoryProperties pMemoryProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceMemoryProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pMemoryProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceMemoryProperties2.html"><code>vkGetPhysicalDeviceMemoryProperties2</code></a>
    public void getPhysicalDeviceMemoryProperties2(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceMemoryProperties2 pMemoryProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceMemoryProperties2);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pMemoryProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceMemoryProperties2KHR.html"><code>vkGetPhysicalDeviceMemoryProperties2KHR</code></a>
    public void getPhysicalDeviceMemoryProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceMemoryProperties2 pMemoryProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceMemoryProperties2KHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pMemoryProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceMultisamplePropertiesEXT.html"><code>vkGetPhysicalDeviceMultisamplePropertiesEXT</code></a>
    public void getPhysicalDeviceMultisamplePropertiesEXT(
        VkPhysicalDevice physicalDevice,
        @Bitmask(VkSampleCountFlags.class) int samples,
        @Pointer VkMultisamplePropertiesEXT pMultisampleProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceMultisamplePropertiesEXT);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                samples,
                pMultisampleProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceOpticalFlowImageFormatsNV.html"><code>vkGetPhysicalDeviceOpticalFlowImageFormatsNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceOpticalFlowImageFormatsNV(
        VkPhysicalDevice physicalDevice,
        @Pointer VkOpticalFlowImageFormatInfoNV pOpticalFlowImageFormatInfo,
        @Unsigned IntPtr pFormatCount,
        @Nullable @Pointer IVkOpticalFlowImageFormatPropertiesNV pImageFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceOpticalFlowImageFormatsNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pOpticalFlowImageFormatInfo.segment(),
                pFormatCount.segment(),
                (MemorySegment) (pImageFormatProperties != null ? pImageFormatProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDevicePresentRectanglesKHR.html"><code>vkGetPhysicalDevicePresentRectanglesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDevicePresentRectanglesKHR(
        VkPhysicalDevice physicalDevice,
        VkSurfaceKHR surface,
        @Unsigned IntPtr pRectCount,
        @Nullable @Pointer IVkRect2D pRects
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDevicePresentRectanglesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                surface.segment(),
                pRectCount.segment(),
                (MemorySegment) (pRects != null ? pRects.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceProperties.html"><code>vkGetPhysicalDeviceProperties</code></a>
    public void getPhysicalDeviceProperties(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceProperties pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceProperties2.html"><code>vkGetPhysicalDeviceProperties2</code></a>
    public void getPhysicalDeviceProperties2(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceProperties2 pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceProperties2);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceProperties2KHR.html"><code>vkGetPhysicalDeviceProperties2KHR</code></a>
    public void getPhysicalDeviceProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceProperties2 pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceProperties2KHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM.html"><code>vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        @Pointer VkQueueFamilyDataGraphPropertiesARM pQueueFamilyDataGraphProperties,
        @Pointer VkBaseOutStructure pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                pQueueFamilyDataGraphProperties.segment(),
                pProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM.html"><code>vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        @Pointer VkQueueFamilyDataGraphPropertiesARM pQueueFamilyDataGraphProperties,
        @Pointer VkDataGraphOpticalFlowImageFormatInfoARM pOpticalFlowImageFormatInfo,
        @Unsigned IntPtr pFormatCount,
        @Nullable @Pointer IVkDataGraphOpticalFlowImageFormatPropertiesARM pImageFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                pQueueFamilyDataGraphProperties.segment(),
                pOpticalFlowImageFormatInfo.segment(),
                pFormatCount.segment(),
                (MemorySegment) (pImageFormatProperties != null ? pImageFormatProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM.html"><code>vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM</code></a>
    public void getPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM pQueueFamilyDataGraphProcessingEngineInfo,
        @Pointer VkQueueFamilyDataGraphProcessingEnginePropertiesARM pQueueFamilyDataGraphProcessingEngineProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pQueueFamilyDataGraphProcessingEngineInfo.segment(),
                pQueueFamilyDataGraphProcessingEngineProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM.html"><code>vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceQueueFamilyDataGraphPropertiesARM(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        @Unsigned IntPtr pQueueFamilyDataGraphPropertyCount,
        @Nullable @Pointer IVkQueueFamilyDataGraphPropertiesARM pQueueFamilyDataGraphProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                pQueueFamilyDataGraphPropertyCount.segment(),
                (MemorySegment) (pQueueFamilyDataGraphProperties != null ? pQueueFamilyDataGraphProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR.html"><code>vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR</code></a>
    public void getPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkQueryPoolPerformanceCreateInfoKHR pPerformanceQueryCreateInfo,
        @Unsigned IntPtr pNumPasses
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pPerformanceQueryCreateInfo.segment(),
                pNumPasses.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyProperties.html"><code>vkGetPhysicalDeviceQueueFamilyProperties</code></a>
    public void getPhysicalDeviceQueueFamilyProperties(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pQueueFamilyPropertyCount,
        @Nullable @Pointer IVkQueueFamilyProperties pQueueFamilyProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pQueueFamilyPropertyCount.segment(),
                (MemorySegment) (pQueueFamilyProperties != null ? pQueueFamilyProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyProperties2.html"><code>vkGetPhysicalDeviceQueueFamilyProperties2</code></a>
    public void getPhysicalDeviceQueueFamilyProperties2(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pQueueFamilyPropertyCount,
        @Nullable @Pointer IVkQueueFamilyProperties2 pQueueFamilyProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyProperties2);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pQueueFamilyPropertyCount.segment(),
                (MemorySegment) (pQueueFamilyProperties != null ? pQueueFamilyProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceQueueFamilyProperties2KHR.html"><code>vkGetPhysicalDeviceQueueFamilyProperties2KHR</code></a>
    public void getPhysicalDeviceQueueFamilyProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pQueueFamilyPropertyCount,
        @Nullable @Pointer IVkQueueFamilyProperties2 pQueueFamilyProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceQueueFamilyProperties2KHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pQueueFamilyPropertyCount.segment(),
                (MemorySegment) (pQueueFamilyProperties != null ? pQueueFamilyProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceRefreshableObjectTypesKHR.html"><code>vkGetPhysicalDeviceRefreshableObjectTypesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceRefreshableObjectTypesKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pRefreshableObjectTypeCount,
        @Nullable @EnumType(VkObjectType.class) IntPtr pRefreshableObjectTypes
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceRefreshableObjectTypesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pRefreshableObjectTypeCount.segment(),
                (MemorySegment) (pRefreshableObjectTypes != null ? pRefreshableObjectTypes.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSciBufAttributesNV.html"><code>vkGetPhysicalDeviceSciBufAttributesNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSciBufAttributesNV(
        VkPhysicalDevice physicalDevice,
        @Pointer(comment="NvSciBufAttrList") @NotNull MemorySegment pAttributes
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSciBufAttributesNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pAttributes
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSciSyncAttributesNV.html"><code>vkGetPhysicalDeviceSciSyncAttributesNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSciSyncAttributesNV(
        VkPhysicalDevice physicalDevice,
        @Pointer VkSciSyncAttributesInfoNV pSciSyncAttributesInfo,
        @Pointer(comment="NvSciSyncAttrList") @NotNull MemorySegment pAttributes
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSciSyncAttributesNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pSciSyncAttributesInfo.segment(),
                pAttributes
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceScreenPresentationSupportQNX.html"><code>vkGetPhysicalDeviceScreenPresentationSupportQNX</code></a>
    public @NativeType("VkBool32") @Unsigned int getPhysicalDeviceScreenPresentationSupportQNX(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        PointerPtr window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceScreenPresentationSupportQNX);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                window.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSparseImageFormatProperties.html"><code>vkGetPhysicalDeviceSparseImageFormatProperties</code></a>
    public void getPhysicalDeviceSparseImageFormatProperties(
        VkPhysicalDevice physicalDevice,
        @EnumType(VkFormat.class) int format,
        @EnumType(VkImageType.class) int type,
        @Bitmask(VkSampleCountFlags.class) int samples,
        @Bitmask(VkImageUsageFlags.class) int usage,
        @EnumType(VkImageTiling.class) int tiling,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkSparseImageFormatProperties pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                format,
                type,
                samples,
                usage,
                tiling,
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSparseImageFormatProperties2.html"><code>vkGetPhysicalDeviceSparseImageFormatProperties2</code></a>
    public void getPhysicalDeviceSparseImageFormatProperties2(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceSparseImageFormatInfo2 pFormatInfo,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkSparseImageFormatProperties2 pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties2);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pFormatInfo.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSparseImageFormatProperties2KHR.html"><code>vkGetPhysicalDeviceSparseImageFormatProperties2KHR</code></a>
    public void getPhysicalDeviceSparseImageFormatProperties2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceSparseImageFormatInfo2 pFormatInfo,
        @Unsigned IntPtr pPropertyCount,
        @Nullable @Pointer IVkSparseImageFormatProperties2 pProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties2KHR);
        try {
            hFunction.invokeExact(
                physicalDevice.segment(),
                pFormatInfo.segment(),
                pPropertyCount.segment(),
                (MemorySegment) (pProperties != null ? pProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV.html"><code>vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pCombinationCount,
        @Nullable @Pointer IVkFramebufferMixedSamplesCombinationNV pCombinations
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pCombinationCount.segment(),
                (MemorySegment) (pCombinations != null ? pCombinations.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfaceCapabilities2EXT.html"><code>vkGetPhysicalDeviceSurfaceCapabilities2EXT</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfaceCapabilities2EXT(
        VkPhysicalDevice physicalDevice,
        VkSurfaceKHR surface,
        @Pointer VkSurfaceCapabilities2EXT pSurfaceCapabilities
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfaceCapabilities2EXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                surface.segment(),
                pSurfaceCapabilities.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfaceCapabilities2KHR.html"><code>vkGetPhysicalDeviceSurfaceCapabilities2KHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfaceCapabilities2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceSurfaceInfo2KHR pSurfaceInfo,
        @Pointer VkSurfaceCapabilities2KHR pSurfaceCapabilities
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfaceCapabilities2KHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pSurfaceInfo.segment(),
                pSurfaceCapabilities.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfaceCapabilitiesKHR.html"><code>vkGetPhysicalDeviceSurfaceCapabilitiesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfaceCapabilitiesKHR(
        VkPhysicalDevice physicalDevice,
        VkSurfaceKHR surface,
        @Pointer VkSurfaceCapabilitiesKHR pSurfaceCapabilities
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfaceCapabilitiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                surface.segment(),
                pSurfaceCapabilities.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfaceFormats2KHR.html"><code>vkGetPhysicalDeviceSurfaceFormats2KHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfaceFormats2KHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceSurfaceInfo2KHR pSurfaceInfo,
        @Unsigned IntPtr pSurfaceFormatCount,
        @Nullable @Pointer IVkSurfaceFormat2KHR pSurfaceFormats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfaceFormats2KHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pSurfaceInfo.segment(),
                pSurfaceFormatCount.segment(),
                (MemorySegment) (pSurfaceFormats != null ? pSurfaceFormats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfaceFormatsKHR.html"><code>vkGetPhysicalDeviceSurfaceFormatsKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfaceFormatsKHR(
        VkPhysicalDevice physicalDevice,
        @Nullable VkSurfaceKHR surface,
        @Unsigned IntPtr pSurfaceFormatCount,
        @Nullable @Pointer IVkSurfaceFormatKHR pSurfaceFormats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfaceFormatsKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                (MemorySegment) (surface != null ? surface.segment() : MemorySegment.NULL),
                pSurfaceFormatCount.segment(),
                (MemorySegment) (pSurfaceFormats != null ? pSurfaceFormats.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfacePresentModes2EXT.html"><code>vkGetPhysicalDeviceSurfacePresentModes2EXT</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfacePresentModes2EXT(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceSurfaceInfo2KHR pSurfaceInfo,
        @Unsigned IntPtr pPresentModeCount,
        @Nullable @EnumType(VkPresentModeKHR.class) IntPtr pPresentModes
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfacePresentModes2EXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pSurfaceInfo.segment(),
                pPresentModeCount.segment(),
                (MemorySegment) (pPresentModes != null ? pPresentModes.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfacePresentModesKHR.html"><code>vkGetPhysicalDeviceSurfacePresentModesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfacePresentModesKHR(
        VkPhysicalDevice physicalDevice,
        @Nullable VkSurfaceKHR surface,
        @Unsigned IntPtr pPresentModeCount,
        @Nullable @EnumType(VkPresentModeKHR.class) IntPtr pPresentModes
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfacePresentModesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                (MemorySegment) (surface != null ? surface.segment() : MemorySegment.NULL),
                pPresentModeCount.segment(),
                (MemorySegment) (pPresentModes != null ? pPresentModes.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceSurfaceSupportKHR.html"><code>vkGetPhysicalDeviceSurfaceSupportKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceSurfaceSupportKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        VkSurfaceKHR surface,
        @Pointer(comment="VkBool32") @Unsigned IntPtr pSupported
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceSurfaceSupportKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                surface.segment(),
                pSupported.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceToolProperties.html"><code>vkGetPhysicalDeviceToolProperties</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceToolProperties(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pToolCount,
        @Nullable @Pointer IVkPhysicalDeviceToolProperties pToolProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceToolProperties);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pToolCount.segment(),
                (MemorySegment) (pToolProperties != null ? pToolProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceToolPropertiesEXT.html"><code>vkGetPhysicalDeviceToolPropertiesEXT</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceToolPropertiesEXT(
        VkPhysicalDevice physicalDevice,
        @Unsigned IntPtr pToolCount,
        @Nullable @Pointer IVkPhysicalDeviceToolProperties pToolProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceToolPropertiesEXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pToolCount.segment(),
                (MemorySegment) (pToolProperties != null ? pToolProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceUbmPresentationSupportSEC.html"><code>vkGetPhysicalDeviceUbmPresentationSupportSEC</code></a>
    public @NativeType("VkBool32") @Unsigned int getPhysicalDeviceUbmPresentationSupportSEC(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        @Pointer(comment="void*") @NotNull MemorySegment device
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceUbmPresentationSupportSEC);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                device
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceVideoCapabilitiesKHR.html"><code>vkGetPhysicalDeviceVideoCapabilitiesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceVideoCapabilitiesKHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkVideoProfileInfoKHR pVideoProfile,
        @Pointer VkVideoCapabilitiesKHR pCapabilities
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceVideoCapabilitiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pVideoProfile.segment(),
                pCapabilities.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR.html"><code>vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR pQualityLevelInfo,
        @Pointer VkVideoEncodeQualityLevelPropertiesKHR pQualityLevelProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pQualityLevelInfo.segment(),
                pQualityLevelProperties.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceVideoFormatPropertiesKHR.html"><code>vkGetPhysicalDeviceVideoFormatPropertiesKHR</code></a>
    public @EnumType(VkResult.class) int getPhysicalDeviceVideoFormatPropertiesKHR(
        VkPhysicalDevice physicalDevice,
        @Pointer VkPhysicalDeviceVideoFormatInfoKHR pVideoFormatInfo,
        @Unsigned IntPtr pVideoFormatPropertyCount,
        @Nullable @Pointer IVkVideoFormatPropertiesKHR pVideoFormatProperties
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceVideoFormatPropertiesKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                pVideoFormatInfo.segment(),
                pVideoFormatPropertyCount.segment(),
                (MemorySegment) (pVideoFormatProperties != null ? pVideoFormatProperties.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceWaylandPresentationSupportKHR.html"><code>vkGetPhysicalDeviceWaylandPresentationSupportKHR</code></a>
    public @NativeType("VkBool32") @Unsigned int getPhysicalDeviceWaylandPresentationSupportKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        PointerPtr display
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceWaylandPresentationSupportKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                display.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceWin32PresentationSupportKHR.html"><code>vkGetPhysicalDeviceWin32PresentationSupportKHR</code></a>
    public @NativeType("VkBool32") @Unsigned int getPhysicalDeviceWin32PresentationSupportKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceWin32PresentationSupportKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceXcbPresentationSupportKHR.html"><code>vkGetPhysicalDeviceXcbPresentationSupportKHR</code></a>
    public @NativeType("VkBool32") @Unsigned int getPhysicalDeviceXcbPresentationSupportKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        @Pointer(comment="void*") @NotNull MemorySegment connection,
        @NativeType("xcb_visualid_t") @Unsigned int visual_id
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceXcbPresentationSupportKHR);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                queueFamilyIndex,
                connection,
                visual_id
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetPhysicalDeviceXlibPresentationSupportKHR.html"><code>vkGetPhysicalDeviceXlibPresentationSupportKHR</code></a>
    public @NativeType("VkBool32") @Unsigned int getPhysicalDeviceXlibPresentationSupportKHR(
        VkPhysicalDevice physicalDevice,
        @Unsigned int queueFamilyIndex,
        PointerPtr dpy,
        @NativeType("VisualID") long visualID
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetPhysicalDeviceXlibPresentationSupportKHR);
        try {
            return (int) hFunction.invoke(
                physicalDevice.segment(),
                queueFamilyIndex,
                dpy.segment(),
                (NativeLayout.C_LONG_SIZE == 4) ? ((Object)(int) visualID) : ((Object)(long) visualID)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetRandROutputDisplayEXT.html"><code>vkGetRandROutputDisplayEXT</code></a>
    public @EnumType(VkResult.class) int getRandROutputDisplayEXT(
        VkPhysicalDevice physicalDevice,
        PointerPtr dpy,
        @NativeType("RROutput") long rrOutput,
        @Pointer VkDisplayKHR.Ptr pDisplay
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetRandROutputDisplayEXT);
        try {
            return (int) hFunction.invoke(
                physicalDevice.segment(),
                dpy.segment(),
                (NativeLayout.C_LONG_SIZE == 4) ? ((Object)(int) rrOutput) : ((Object)(long) rrOutput),
                pDisplay.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkGetWinrtDisplayNV.html"><code>vkGetWinrtDisplayNV</code></a>
    public @EnumType(VkResult.class) int getWinrtDisplayNV(
        VkPhysicalDevice physicalDevice,
        @Unsigned int deviceRelativeId,
        @Pointer VkDisplayKHR.Ptr pDisplay
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkGetWinrtDisplayNV);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                deviceRelativeId,
                pDisplay.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkQueueBeginDebugUtilsLabelEXT.html"><code>vkQueueBeginDebugUtilsLabelEXT</code></a>
    public void queueBeginDebugUtilsLabelEXT(
        VkQueue queue,
        @Pointer VkDebugUtilsLabelEXT pLabelInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkQueueBeginDebugUtilsLabelEXT);
        try {
            hFunction.invokeExact(
                queue.segment(),
                pLabelInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkQueueEndDebugUtilsLabelEXT.html"><code>vkQueueEndDebugUtilsLabelEXT</code></a>
    public void queueEndDebugUtilsLabelEXT(
        VkQueue queue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkQueueEndDebugUtilsLabelEXT);
        try {
            hFunction.invokeExact(
                queue.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkQueueInsertDebugUtilsLabelEXT.html"><code>vkQueueInsertDebugUtilsLabelEXT</code></a>
    public void queueInsertDebugUtilsLabelEXT(
        VkQueue queue,
        @Pointer VkDebugUtilsLabelEXT pLabelInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkQueueInsertDebugUtilsLabelEXT);
        try {
            hFunction.invokeExact(
                queue.segment(),
                pLabelInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkReleaseDisplayEXT.html"><code>vkReleaseDisplayEXT</code></a>
    public @EnumType(VkResult.class) int releaseDisplayEXT(
        VkPhysicalDevice physicalDevice,
        VkDisplayKHR display
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkReleaseDisplayEXT);
        try {
            return (int) hFunction.invokeExact(
                physicalDevice.segment(),
                display.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkSetDebugUtilsObjectNameEXT.html"><code>vkSetDebugUtilsObjectNameEXT</code></a>
    public @EnumType(VkResult.class) int setDebugUtilsObjectNameEXT(
        VkDevice device,
        @Pointer VkDebugUtilsObjectNameInfoEXT pNameInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkSetDebugUtilsObjectNameEXT);
        try {
            return (int) hFunction.invokeExact(
                device.segment(),
                pNameInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkSetDebugUtilsObjectTagEXT.html"><code>vkSetDebugUtilsObjectTagEXT</code></a>
    public @EnumType(VkResult.class) int setDebugUtilsObjectTagEXT(
        VkDevice device,
        @Pointer VkDebugUtilsObjectTagInfoEXT pTagInfo
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkSetDebugUtilsObjectTagEXT);
        try {
            return (int) hFunction.invokeExact(
                device.segment(),
                pTagInfo.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/vkSubmitDebugUtilsMessageEXT.html"><code>vkSubmitDebugUtilsMessageEXT</code></a>
    public void submitDebugUtilsMessageEXT(
        VkInstance instance,
        @Bitmask(VkDebugUtilsMessageSeverityFlagsEXT.class) int messageSeverity,
        @Bitmask(VkDebugUtilsMessageTypeFlagsEXT.class) int messageTypes,
        @Pointer VkDebugUtilsMessengerCallbackDataEXT pCallbackData
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$vkSubmitDebugUtilsMessageEXT);
        try {
            hFunction.invokeExact(
                instance.segment(),
                messageSeverity,
                messageTypes,
                pCallbackData.segment()
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$vkAcquireDrmDisplayEXT;
    public final @Nullable MemorySegment SEGMENT$vkAcquireWinrtDisplayNV;
    public final @Nullable MemorySegment SEGMENT$vkAcquireXlibDisplayEXT;
    public final @Nullable MemorySegment SEGMENT$vkCmdBeginDebugUtilsLabelEXT;
    public final @Nullable MemorySegment SEGMENT$vkCmdEndDebugUtilsLabelEXT;
    public final @Nullable MemorySegment SEGMENT$vkCmdInsertDebugUtilsLabelEXT;
    public final @Nullable MemorySegment SEGMENT$vkCreateAndroidSurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$vkCreateDebugReportCallbackEXT;
    public final @Nullable MemorySegment SEGMENT$vkCreateDebugUtilsMessengerEXT;
    public final @Nullable MemorySegment SEGMENT$vkCreateDevice;
    public final @Nullable MemorySegment SEGMENT$vkCreateDirectFBSurfaceEXT;
    public final @Nullable MemorySegment SEGMENT$vkCreateDisplayModeKHR;
    public final @Nullable MemorySegment SEGMENT$vkCreateDisplayPlaneSurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$vkCreateHeadlessSurfaceEXT;
    public final @Nullable MemorySegment SEGMENT$vkCreateIOSSurfaceMVK;
    public final @Nullable MemorySegment SEGMENT$vkCreateImagePipeSurfaceFUCHSIA;
    public final @Nullable MemorySegment SEGMENT$vkCreateMacOSSurfaceMVK;
    public final @Nullable MemorySegment SEGMENT$vkCreateMetalSurfaceEXT;
    public final @Nullable MemorySegment SEGMENT$vkCreateScreenSurfaceQNX;
    public final @Nullable MemorySegment SEGMENT$vkCreateStreamDescriptorSurfaceGGP;
    public final @Nullable MemorySegment SEGMENT$vkCreateSurfaceOHOS;
    public final @Nullable MemorySegment SEGMENT$vkCreateUbmSurfaceSEC;
    public final @Nullable MemorySegment SEGMENT$vkCreateViSurfaceNN;
    public final @Nullable MemorySegment SEGMENT$vkCreateWaylandSurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$vkCreateWin32SurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$vkCreateXcbSurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$vkCreateXlibSurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$vkDebugReportMessageEXT;
    public final @Nullable MemorySegment SEGMENT$vkDestroyDebugReportCallbackEXT;
    public final @Nullable MemorySegment SEGMENT$vkDestroyDebugUtilsMessengerEXT;
    public final @Nullable MemorySegment SEGMENT$vkDestroyInstance;
    public final @Nullable MemorySegment SEGMENT$vkDestroySurfaceKHR;
    public final @Nullable MemorySegment SEGMENT$vkEnumerateDeviceExtensionProperties;
    public final @Nullable MemorySegment SEGMENT$vkEnumerateDeviceLayerProperties;
    public final @Nullable MemorySegment SEGMENT$vkEnumeratePhysicalDeviceGroups;
    public final @Nullable MemorySegment SEGMENT$vkEnumeratePhysicalDeviceGroupsKHR;
    public final @Nullable MemorySegment SEGMENT$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM;
    public final @Nullable MemorySegment SEGMENT$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR;
    public final @Nullable MemorySegment SEGMENT$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM;
    public final @Nullable MemorySegment SEGMENT$vkEnumeratePhysicalDevices;
    public final @Nullable MemorySegment SEGMENT$vkGetDisplayModeProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetDisplayModePropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetDisplayPlaneCapabilities2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetDisplayPlaneCapabilitiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetDisplayPlaneSupportedDisplaysKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetDrmDisplayEXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceCalibrateableTimeDomainsEXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceCooperativeVectorPropertiesNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceDescriptorSizeEXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceDirectFBPresentationSupportEXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceDisplayPlaneProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceDisplayPlanePropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceDisplayProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceDisplayPropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalBufferProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalBufferPropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalFenceProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalFencePropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalImageFormatPropertiesNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalSemaphoreProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalSemaphorePropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceExternalTensorPropertiesARM;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceFeatures;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceFeatures2;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceFeatures2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceFormatProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceFormatProperties2;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceFormatProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceFragmentShadingRatesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceImageFormatProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceImageFormatProperties2;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceImageFormatProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceMemoryProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceMemoryProperties2;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceMemoryProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceMultisamplePropertiesEXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceOpticalFlowImageFormatsNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDevicePresentRectanglesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceProperties2;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties2;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceQueueFamilyProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceRefreshableObjectTypesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSciBufAttributesNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSciSyncAttributesNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceScreenPresentationSupportQNX;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties2;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSparseImageFormatProperties2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfaceCapabilities2EXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfaceCapabilities2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfaceCapabilitiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfaceFormats2KHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfaceFormatsKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfacePresentModes2EXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfacePresentModesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceSurfaceSupportKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceToolProperties;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceToolPropertiesEXT;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceUbmPresentationSupportSEC;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceVideoCapabilitiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceVideoFormatPropertiesKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceWaylandPresentationSupportKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceWin32PresentationSupportKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceXcbPresentationSupportKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetPhysicalDeviceXlibPresentationSupportKHR;
    public final @Nullable MemorySegment SEGMENT$vkGetRandROutputDisplayEXT;
    public final @Nullable MemorySegment SEGMENT$vkGetWinrtDisplayNV;
    public final @Nullable MemorySegment SEGMENT$vkQueueBeginDebugUtilsLabelEXT;
    public final @Nullable MemorySegment SEGMENT$vkQueueEndDebugUtilsLabelEXT;
    public final @Nullable MemorySegment SEGMENT$vkQueueInsertDebugUtilsLabelEXT;
    public final @Nullable MemorySegment SEGMENT$vkReleaseDisplayEXT;
    public final @Nullable MemorySegment SEGMENT$vkSetDebugUtilsObjectNameEXT;
    public final @Nullable MemorySegment SEGMENT$vkSetDebugUtilsObjectTagEXT;
    public final @Nullable MemorySegment SEGMENT$vkSubmitDebugUtilsMessageEXT;
    public final @Nullable MethodHandle HANDLE$vkAcquireDrmDisplayEXT;
    public final @Nullable MethodHandle HANDLE$vkAcquireWinrtDisplayNV;
    public final @Nullable MethodHandle HANDLE$vkAcquireXlibDisplayEXT;
    public final @Nullable MethodHandle HANDLE$vkCmdBeginDebugUtilsLabelEXT;
    public final @Nullable MethodHandle HANDLE$vkCmdEndDebugUtilsLabelEXT;
    public final @Nullable MethodHandle HANDLE$vkCmdInsertDebugUtilsLabelEXT;
    public final @Nullable MethodHandle HANDLE$vkCreateAndroidSurfaceKHR;
    public final @Nullable MethodHandle HANDLE$vkCreateDebugReportCallbackEXT;
    public final @Nullable MethodHandle HANDLE$vkCreateDebugUtilsMessengerEXT;
    public final @Nullable MethodHandle HANDLE$vkCreateDevice;
    public final @Nullable MethodHandle HANDLE$vkCreateDirectFBSurfaceEXT;
    public final @Nullable MethodHandle HANDLE$vkCreateDisplayModeKHR;
    public final @Nullable MethodHandle HANDLE$vkCreateDisplayPlaneSurfaceKHR;
    public final @Nullable MethodHandle HANDLE$vkCreateHeadlessSurfaceEXT;
    public final @Nullable MethodHandle HANDLE$vkCreateIOSSurfaceMVK;
    public final @Nullable MethodHandle HANDLE$vkCreateImagePipeSurfaceFUCHSIA;
    public final @Nullable MethodHandle HANDLE$vkCreateMacOSSurfaceMVK;
    public final @Nullable MethodHandle HANDLE$vkCreateMetalSurfaceEXT;
    public final @Nullable MethodHandle HANDLE$vkCreateScreenSurfaceQNX;
    public final @Nullable MethodHandle HANDLE$vkCreateStreamDescriptorSurfaceGGP;
    public final @Nullable MethodHandle HANDLE$vkCreateSurfaceOHOS;
    public final @Nullable MethodHandle HANDLE$vkCreateUbmSurfaceSEC;
    public final @Nullable MethodHandle HANDLE$vkCreateViSurfaceNN;
    public final @Nullable MethodHandle HANDLE$vkCreateWaylandSurfaceKHR;
    public final @Nullable MethodHandle HANDLE$vkCreateWin32SurfaceKHR;
    public final @Nullable MethodHandle HANDLE$vkCreateXcbSurfaceKHR;
    public final @Nullable MethodHandle HANDLE$vkCreateXlibSurfaceKHR;
    public final @Nullable MethodHandle HANDLE$vkDebugReportMessageEXT;
    public final @Nullable MethodHandle HANDLE$vkDestroyDebugReportCallbackEXT;
    public final @Nullable MethodHandle HANDLE$vkDestroyDebugUtilsMessengerEXT;
    public final @Nullable MethodHandle HANDLE$vkDestroyInstance;
    public final @Nullable MethodHandle HANDLE$vkDestroySurfaceKHR;
    public final @Nullable MethodHandle HANDLE$vkEnumerateDeviceExtensionProperties;
    public final @Nullable MethodHandle HANDLE$vkEnumerateDeviceLayerProperties;
    public final @Nullable MethodHandle HANDLE$vkEnumeratePhysicalDeviceGroups;
    public final @Nullable MethodHandle HANDLE$vkEnumeratePhysicalDeviceGroupsKHR;
    public final @Nullable MethodHandle HANDLE$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM;
    public final @Nullable MethodHandle HANDLE$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR;
    public final @Nullable MethodHandle HANDLE$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM;
    public final @Nullable MethodHandle HANDLE$vkEnumeratePhysicalDevices;
    public final @Nullable MethodHandle HANDLE$vkGetDisplayModeProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetDisplayModePropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetDisplayPlaneCapabilities2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetDisplayPlaneCapabilitiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetDisplayPlaneSupportedDisplaysKHR;
    public final @Nullable MethodHandle HANDLE$vkGetDrmDisplayEXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceCalibrateableTimeDomainsEXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceCooperativeVectorPropertiesNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceDescriptorSizeEXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceDirectFBPresentationSupportEXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceDisplayPlaneProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceDisplayPlanePropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceDisplayProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceDisplayPropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalBufferProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalBufferPropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalFenceProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalFencePropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalImageFormatPropertiesNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalSemaphoreProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalSemaphorePropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceExternalTensorPropertiesARM;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceFeatures;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceFeatures2;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceFeatures2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceFormatProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceFormatProperties2;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceFormatProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceFragmentShadingRatesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceImageFormatProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceImageFormatProperties2;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceImageFormatProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceMemoryProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceMemoryProperties2;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceMemoryProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceMultisamplePropertiesEXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceOpticalFlowImageFormatsNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDevicePresentRectanglesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceProperties2;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyProperties2;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceQueueFamilyProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceRefreshableObjectTypesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSciBufAttributesNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSciSyncAttributesNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceScreenPresentationSupportQNX;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties2;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSparseImageFormatProperties2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfaceCapabilities2EXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfaceCapabilities2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfaceCapabilitiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfaceFormats2KHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfaceFormatsKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfacePresentModes2EXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfacePresentModesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceSurfaceSupportKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceToolProperties;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceToolPropertiesEXT;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceUbmPresentationSupportSEC;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceVideoCapabilitiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceVideoFormatPropertiesKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceWaylandPresentationSupportKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceWin32PresentationSupportKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceXcbPresentationSupportKHR;
    public final @Nullable MethodHandle HANDLE$vkGetPhysicalDeviceXlibPresentationSupportKHR;
    public final @Nullable MethodHandle HANDLE$vkGetRandROutputDisplayEXT;
    public final @Nullable MethodHandle HANDLE$vkGetWinrtDisplayNV;
    public final @Nullable MethodHandle HANDLE$vkQueueBeginDebugUtilsLabelEXT;
    public final @Nullable MethodHandle HANDLE$vkQueueEndDebugUtilsLabelEXT;
    public final @Nullable MethodHandle HANDLE$vkQueueInsertDebugUtilsLabelEXT;
    public final @Nullable MethodHandle HANDLE$vkReleaseDisplayEXT;
    public final @Nullable MethodHandle HANDLE$vkSetDebugUtilsObjectNameEXT;
    public final @Nullable MethodHandle HANDLE$vkSetDebugUtilsObjectTagEXT;
    public final @Nullable MethodHandle HANDLE$vkSubmitDebugUtilsMessageEXT;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$vkAcquireDrmDisplayEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkAcquireWinrtDisplayNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkAcquireXlibDisplayEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCmdBeginDebugUtilsLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsLabelEXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCmdEndDebugUtilsLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCmdInsertDebugUtilsLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsLabelEXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateAndroidSurfaceKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkAndroidSurfaceCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateDebugReportCallbackEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugReportCallbackCreateInfoEXT.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateDebugUtilsMessengerEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsMessengerCreateInfoEXT.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateDevice = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDeviceCreateInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateDirectFBSurfaceEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDirectFBSurfaceCreateInfoEXT.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateDisplayModeKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayModeCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateDisplayPlaneSurfaceKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDisplaySurfaceCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateHeadlessSurfaceEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkHeadlessSurfaceCreateInfoEXT.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateIOSSurfaceMVK = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkIOSSurfaceCreateInfoMVK.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateImagePipeSurfaceFUCHSIA = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkImagePipeSurfaceCreateInfoFUCHSIA.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateMacOSSurfaceMVK = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkMacOSSurfaceCreateInfoMVK.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateMetalSurfaceEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkMetalSurfaceCreateInfoEXT.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateScreenSurfaceQNX = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkScreenSurfaceCreateInfoQNX.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateStreamDescriptorSurfaceGGP = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkStreamDescriptorSurfaceCreateInfoGGP.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateSurfaceOHOS = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkSurfaceCreateInfoOHOS.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateUbmSurfaceSEC = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkUbmSurfaceCreateInfoSEC.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateViSurfaceNN = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkViSurfaceCreateInfoNN.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateWaylandSurfaceKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkWaylandSurfaceCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateWin32SurfaceKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkWin32SurfaceCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateXcbSurfaceKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkXcbSurfaceCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkCreateXlibSurfaceKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkXlibSurfaceCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkDebugReportMessageEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkDestroyDebugReportCallbackEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkDestroyDebugUtilsMessengerEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkDestroyInstance = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkDestroySurfaceKHR = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumerateDeviceExtensionProperties = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkExtensionProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumerateDeviceLayerProperties = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkLayerProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumeratePhysicalDeviceGroups = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceGroupProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumeratePhysicalDeviceQueueFamilyPerformanceCountersByRegionARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkPerformanceCounterARM.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkPerformanceCounterDescriptionARM.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkPerformanceCounterKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkPerformanceCounterDescriptionKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumeratePhysicalDeviceShaderInstrumentationMetricsARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkShaderInstrumentationMetricDescriptionARM.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkEnumeratePhysicalDevices = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetDisplayModeProperties2KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayModeProperties2KHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetDisplayModePropertiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayModePropertiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetDisplayPlaneCapabilities2KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayPlaneInfo2KHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayPlaneCapabilities2KHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetDisplayPlaneCapabilitiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayPlaneCapabilitiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetDisplayPlaneSupportedDisplaysKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetDrmDisplayEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceCalibrateableTimeDomainsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixFlexibleDimensionsPropertiesNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkCooperativeMatrixFlexibleDimensionsPropertiesNV.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixProperties2EXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceCooperativeMatrixInfo2EXT.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkCooperativeMatrixProperties2EXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixPropertiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkCooperativeMatrixPropertiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceCooperativeMatrixPropertiesNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkCooperativeMatrixPropertiesNV.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceCooperativeVectorPropertiesNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkCooperativeVectorPropertiesNV.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceDescriptorSizeEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_LONG,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceDirectFBPresentationSupportEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceDisplayPlaneProperties2KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayPlaneProperties2KHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceDisplayPlanePropertiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayPlanePropertiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceDisplayProperties2KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayProperties2KHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceDisplayPropertiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkDisplayPropertiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceExternalBufferProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceExternalBufferInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkExternalBufferProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceExternalFenceProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceExternalFenceInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkExternalFenceProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceExternalImageFormatPropertiesNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkExternalImageFormatPropertiesNV.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceExternalMemorySciBufPropertiesNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkMemorySciBufPropertiesNV.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceExternalSemaphoreProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceExternalSemaphoreInfo.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkExternalSemaphoreProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceExternalTensorPropertiesARM = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceExternalTensorInfoARM.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkExternalTensorPropertiesARM.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceFeatures = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceFeatures.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceFeatures2 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceFeatures2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceFormatProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkFormatProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceFormatProperties2 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkFormatProperties2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceFragmentShadingRatesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceFragmentShadingRateKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceImageFormatProperties = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkImageFormatProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceImageFormatProperties2 = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceImageFormatInfo2.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkImageFormatProperties2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceMemoryProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceMemoryProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceMemoryProperties2 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceMemoryProperties2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceMultisamplePropertiesEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkMultisamplePropertiesEXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceOpticalFlowImageFormatsNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkOpticalFlowImageFormatInfoNV.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkOpticalFlowImageFormatPropertiesNV.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDevicePresentRectanglesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkRect2D.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceProperties2 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceProperties2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphEngineOperationPropertiesARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkQueueFamilyDataGraphPropertiesARM.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkBaseOutStructure.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphOpticalFlowImageFormatsARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkQueueFamilyDataGraphPropertiesARM.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkDataGraphOpticalFlowImageFormatInfoARM.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkDataGraphOpticalFlowImageFormatPropertiesARM.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphProcessingEnginePropertiesARM = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkQueueFamilyDataGraphProcessingEnginePropertiesARM.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyDataGraphPropertiesARM = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkQueueFamilyDataGraphPropertiesARM.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkQueryPoolPerformanceCreateInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkQueueFamilyProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceQueueFamilyProperties2 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkQueueFamilyProperties2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceRefreshableObjectTypesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSciBufAttributesNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSciSyncAttributesNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkSciSyncAttributesInfoNV.LAYOUT),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceScreenPresentationSupportQNX = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSparseImageFormatProperties = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkSparseImageFormatProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSparseImageFormatProperties2 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceSparseImageFormatInfo2.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkSparseImageFormatProperties2.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkFramebufferMixedSamplesCombinationNV.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfaceCapabilities2EXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkSurfaceCapabilities2EXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfaceCapabilities2KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceSurfaceInfo2KHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkSurfaceCapabilities2KHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfaceCapabilitiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkSurfaceCapabilitiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfaceFormats2KHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceSurfaceInfo2KHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkSurfaceFormat2KHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfaceFormatsKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkSurfaceFormatKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfacePresentModes2EXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceSurfaceInfo2KHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfacePresentModesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceSurfaceSupportKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceToolProperties = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceToolProperties.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceUbmPresentationSupportSEC = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceVideoCapabilitiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkVideoProfileInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkVideoCapabilitiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceVideoEncodeQualityLevelPropertiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(VkVideoEncodeQualityLevelPropertiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceVideoFormatPropertiesKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkPhysicalDeviceVideoFormatInfoKHR.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(VkVideoFormatPropertiesKHR.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceWaylandPresentationSupportKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceWin32PresentationSupportKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceXcbPresentationSupportKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetPhysicalDeviceXlibPresentationSupportKHR = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            NativeLayout.C_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetRandROutputDisplayEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            NativeLayout.C_LONG,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkGetWinrtDisplayNV = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkQueueBeginDebugUtilsLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsLabelEXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkQueueEndDebugUtilsLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkQueueInsertDebugUtilsLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsLabelEXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkReleaseDisplayEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$vkSetDebugUtilsObjectNameEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsObjectNameInfoEXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkSetDebugUtilsObjectTagEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsObjectTagInfoEXT.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$vkSubmitDebugUtilsMessageEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsMessengerCallbackDataEXT.LAYOUT)
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
