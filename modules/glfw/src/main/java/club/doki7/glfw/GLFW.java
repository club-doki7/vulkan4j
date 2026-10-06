package club.doki7.glfw;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.glfw.datatype.*;
import club.doki7.glfw.handle.*;
import static club.doki7.glfw.GLFWFunctionTypes.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

public final class GLFW implements GLFWConstants {
    public GLFW(RawFunctionLoader loader) {
        SEGMENT$glfwCreateCursor = loader.apply("glfwCreateCursor");
        HANDLE$glfwCreateCursor = RawFunctionLoader.link(SEGMENT$glfwCreateCursor, Descriptors.DESCRIPTOR$glfwCreateCursor);
        SEGMENT$glfwCreateStandardCursor = loader.apply("glfwCreateStandardCursor");
        HANDLE$glfwCreateStandardCursor = RawFunctionLoader.link(SEGMENT$glfwCreateStandardCursor, Descriptors.DESCRIPTOR$glfwCreateStandardCursor);
        SEGMENT$glfwCreateWindow = loader.apply("glfwCreateWindow");
        HANDLE$glfwCreateWindow = RawFunctionLoader.link(SEGMENT$glfwCreateWindow, Descriptors.DESCRIPTOR$glfwCreateWindow);
        SEGMENT$glfwCreateWindowSurface = loader.apply("glfwCreateWindowSurface");
        HANDLE$glfwCreateWindowSurface = RawFunctionLoader.link(SEGMENT$glfwCreateWindowSurface, Descriptors.DESCRIPTOR$glfwCreateWindowSurface);
        SEGMENT$glfwDefaultWindowHints = loader.apply("glfwDefaultWindowHints");
        HANDLE$glfwDefaultWindowHints = RawFunctionLoader.link(SEGMENT$glfwDefaultWindowHints, Descriptors.DESCRIPTOR$glfwDefaultWindowHints);
        SEGMENT$glfwDestroyCursor = loader.apply("glfwDestroyCursor");
        HANDLE$glfwDestroyCursor = RawFunctionLoader.link(SEGMENT$glfwDestroyCursor, Descriptors.DESCRIPTOR$glfwDestroyCursor);
        SEGMENT$glfwDestroyWindow = loader.apply("glfwDestroyWindow");
        HANDLE$glfwDestroyWindow = RawFunctionLoader.link(SEGMENT$glfwDestroyWindow, Descriptors.DESCRIPTOR$glfwDestroyWindow);
        SEGMENT$glfwExtensionSupported = loader.apply("glfwExtensionSupported");
        HANDLE$glfwExtensionSupported = RawFunctionLoader.link(SEGMENT$glfwExtensionSupported, Descriptors.DESCRIPTOR$glfwExtensionSupported);
        SEGMENT$glfwFocusWindow = loader.apply("glfwFocusWindow");
        HANDLE$glfwFocusWindow = RawFunctionLoader.link(SEGMENT$glfwFocusWindow, Descriptors.DESCRIPTOR$glfwFocusWindow);
        SEGMENT$glfwGetClipboardString = loader.apply("glfwGetClipboardString");
        HANDLE$glfwGetClipboardString = RawFunctionLoader.link(SEGMENT$glfwGetClipboardString, Descriptors.DESCRIPTOR$glfwGetClipboardString);
        SEGMENT$glfwGetCocoaMonitor = loader.apply("glfwGetCocoaMonitor");
        HANDLE$glfwGetCocoaMonitor = RawFunctionLoader.link(SEGMENT$glfwGetCocoaMonitor, Descriptors.DESCRIPTOR$glfwGetCocoaMonitor);
        SEGMENT$glfwGetCocoaView = loader.apply("glfwGetCocoaView");
        HANDLE$glfwGetCocoaView = RawFunctionLoader.link(SEGMENT$glfwGetCocoaView, Descriptors.DESCRIPTOR$glfwGetCocoaView);
        SEGMENT$glfwGetCocoaWindow = loader.apply("glfwGetCocoaWindow");
        HANDLE$glfwGetCocoaWindow = RawFunctionLoader.link(SEGMENT$glfwGetCocoaWindow, Descriptors.DESCRIPTOR$glfwGetCocoaWindow);
        SEGMENT$glfwGetCurrentContext = loader.apply("glfwGetCurrentContext");
        HANDLE$glfwGetCurrentContext = RawFunctionLoader.link(SEGMENT$glfwGetCurrentContext, Descriptors.DESCRIPTOR$glfwGetCurrentContext);
        SEGMENT$glfwGetCursorPos = loader.apply("glfwGetCursorPos");
        HANDLE$glfwGetCursorPos = RawFunctionLoader.link(SEGMENT$glfwGetCursorPos, Descriptors.DESCRIPTOR$glfwGetCursorPos);
        SEGMENT$glfwGetEGLConfig = loader.apply("glfwGetEGLConfig");
        HANDLE$glfwGetEGLConfig = RawFunctionLoader.link(SEGMENT$glfwGetEGLConfig, Descriptors.DESCRIPTOR$glfwGetEGLConfig);
        SEGMENT$glfwGetEGLContext = loader.apply("glfwGetEGLContext");
        HANDLE$glfwGetEGLContext = RawFunctionLoader.link(SEGMENT$glfwGetEGLContext, Descriptors.DESCRIPTOR$glfwGetEGLContext);
        SEGMENT$glfwGetEGLDisplay = loader.apply("glfwGetEGLDisplay");
        HANDLE$glfwGetEGLDisplay = RawFunctionLoader.link(SEGMENT$glfwGetEGLDisplay, Descriptors.DESCRIPTOR$glfwGetEGLDisplay);
        SEGMENT$glfwGetEGLSurface = loader.apply("glfwGetEGLSurface");
        HANDLE$glfwGetEGLSurface = RawFunctionLoader.link(SEGMENT$glfwGetEGLSurface, Descriptors.DESCRIPTOR$glfwGetEGLSurface);
        SEGMENT$glfwGetError = loader.apply("glfwGetError");
        HANDLE$glfwGetError = RawFunctionLoader.link(SEGMENT$glfwGetError, Descriptors.DESCRIPTOR$glfwGetError);
        SEGMENT$glfwGetFramebufferSize = loader.apply("glfwGetFramebufferSize");
        HANDLE$glfwGetFramebufferSize = RawFunctionLoader.link(SEGMENT$glfwGetFramebufferSize, Descriptors.DESCRIPTOR$glfwGetFramebufferSize);
        SEGMENT$glfwGetGLXContext = loader.apply("glfwGetGLXContext");
        HANDLE$glfwGetGLXContext = RawFunctionLoader.link(SEGMENT$glfwGetGLXContext, Descriptors.DESCRIPTOR$glfwGetGLXContext);
        SEGMENT$glfwGetGLXFBConfig = loader.apply("glfwGetGLXFBConfig");
        HANDLE$glfwGetGLXFBConfig = RawFunctionLoader.link(SEGMENT$glfwGetGLXFBConfig, Descriptors.DESCRIPTOR$glfwGetGLXFBConfig);
        SEGMENT$glfwGetGLXWindow = loader.apply("glfwGetGLXWindow");
        HANDLE$glfwGetGLXWindow = RawFunctionLoader.link(SEGMENT$glfwGetGLXWindow, Descriptors.DESCRIPTOR$glfwGetGLXWindow);
        SEGMENT$glfwGetGamepadName = loader.apply("glfwGetGamepadName");
        HANDLE$glfwGetGamepadName = RawFunctionLoader.link(SEGMENT$glfwGetGamepadName, Descriptors.DESCRIPTOR$glfwGetGamepadName);
        SEGMENT$glfwGetGamepadState = loader.apply("glfwGetGamepadState");
        HANDLE$glfwGetGamepadState = RawFunctionLoader.link(SEGMENT$glfwGetGamepadState, Descriptors.DESCRIPTOR$glfwGetGamepadState);
        SEGMENT$glfwGetGammaRamp = loader.apply("glfwGetGammaRamp");
        HANDLE$glfwGetGammaRamp = RawFunctionLoader.link(SEGMENT$glfwGetGammaRamp, Descriptors.DESCRIPTOR$glfwGetGammaRamp);
        SEGMENT$glfwGetInputMode = loader.apply("glfwGetInputMode");
        HANDLE$glfwGetInputMode = RawFunctionLoader.link(SEGMENT$glfwGetInputMode, Descriptors.DESCRIPTOR$glfwGetInputMode);
        SEGMENT$glfwGetInstanceProcAddress = loader.apply("glfwGetInstanceProcAddress");
        HANDLE$glfwGetInstanceProcAddress = RawFunctionLoader.link(SEGMENT$glfwGetInstanceProcAddress, Descriptors.DESCRIPTOR$glfwGetInstanceProcAddress);
        SEGMENT$glfwGetJoystickAxes = loader.apply("glfwGetJoystickAxes");
        HANDLE$glfwGetJoystickAxes = RawFunctionLoader.link(SEGMENT$glfwGetJoystickAxes, Descriptors.DESCRIPTOR$glfwGetJoystickAxes);
        SEGMENT$glfwGetJoystickButtons = loader.apply("glfwGetJoystickButtons");
        HANDLE$glfwGetJoystickButtons = RawFunctionLoader.link(SEGMENT$glfwGetJoystickButtons, Descriptors.DESCRIPTOR$glfwGetJoystickButtons);
        SEGMENT$glfwGetJoystickGUID = loader.apply("glfwGetJoystickGUID");
        HANDLE$glfwGetJoystickGUID = RawFunctionLoader.link(SEGMENT$glfwGetJoystickGUID, Descriptors.DESCRIPTOR$glfwGetJoystickGUID);
        SEGMENT$glfwGetJoystickHats = loader.apply("glfwGetJoystickHats");
        HANDLE$glfwGetJoystickHats = RawFunctionLoader.link(SEGMENT$glfwGetJoystickHats, Descriptors.DESCRIPTOR$glfwGetJoystickHats);
        SEGMENT$glfwGetJoystickName = loader.apply("glfwGetJoystickName");
        HANDLE$glfwGetJoystickName = RawFunctionLoader.link(SEGMENT$glfwGetJoystickName, Descriptors.DESCRIPTOR$glfwGetJoystickName);
        SEGMENT$glfwGetJoystickUserPointer = loader.apply("glfwGetJoystickUserPointer");
        HANDLE$glfwGetJoystickUserPointer = RawFunctionLoader.link(SEGMENT$glfwGetJoystickUserPointer, Descriptors.DESCRIPTOR$glfwGetJoystickUserPointer);
        SEGMENT$glfwGetKey = loader.apply("glfwGetKey");
        HANDLE$glfwGetKey = RawFunctionLoader.link(SEGMENT$glfwGetKey, Descriptors.DESCRIPTOR$glfwGetKey);
        SEGMENT$glfwGetKeyName = loader.apply("glfwGetKeyName");
        HANDLE$glfwGetKeyName = RawFunctionLoader.link(SEGMENT$glfwGetKeyName, Descriptors.DESCRIPTOR$glfwGetKeyName);
        SEGMENT$glfwGetKeyScancode = loader.apply("glfwGetKeyScancode");
        HANDLE$glfwGetKeyScancode = RawFunctionLoader.link(SEGMENT$glfwGetKeyScancode, Descriptors.DESCRIPTOR$glfwGetKeyScancode);
        SEGMENT$glfwGetMonitorContentScale = loader.apply("glfwGetMonitorContentScale");
        HANDLE$glfwGetMonitorContentScale = RawFunctionLoader.link(SEGMENT$glfwGetMonitorContentScale, Descriptors.DESCRIPTOR$glfwGetMonitorContentScale);
        SEGMENT$glfwGetMonitorName = loader.apply("glfwGetMonitorName");
        HANDLE$glfwGetMonitorName = RawFunctionLoader.link(SEGMENT$glfwGetMonitorName, Descriptors.DESCRIPTOR$glfwGetMonitorName);
        SEGMENT$glfwGetMonitorPhysicalSize = loader.apply("glfwGetMonitorPhysicalSize");
        HANDLE$glfwGetMonitorPhysicalSize = RawFunctionLoader.link(SEGMENT$glfwGetMonitorPhysicalSize, Descriptors.DESCRIPTOR$glfwGetMonitorPhysicalSize);
        SEGMENT$glfwGetMonitorPos = loader.apply("glfwGetMonitorPos");
        HANDLE$glfwGetMonitorPos = RawFunctionLoader.link(SEGMENT$glfwGetMonitorPos, Descriptors.DESCRIPTOR$glfwGetMonitorPos);
        SEGMENT$glfwGetMonitorUserPointer = loader.apply("glfwGetMonitorUserPointer");
        HANDLE$glfwGetMonitorUserPointer = RawFunctionLoader.link(SEGMENT$glfwGetMonitorUserPointer, Descriptors.DESCRIPTOR$glfwGetMonitorUserPointer);
        SEGMENT$glfwGetMonitorWorkarea = loader.apply("glfwGetMonitorWorkarea");
        HANDLE$glfwGetMonitorWorkarea = RawFunctionLoader.link(SEGMENT$glfwGetMonitorWorkarea, Descriptors.DESCRIPTOR$glfwGetMonitorWorkarea);
        SEGMENT$glfwGetMonitors = loader.apply("glfwGetMonitors");
        HANDLE$glfwGetMonitors = RawFunctionLoader.link(SEGMENT$glfwGetMonitors, Descriptors.DESCRIPTOR$glfwGetMonitors);
        SEGMENT$glfwGetMouseButton = loader.apply("glfwGetMouseButton");
        HANDLE$glfwGetMouseButton = RawFunctionLoader.link(SEGMENT$glfwGetMouseButton, Descriptors.DESCRIPTOR$glfwGetMouseButton);
        SEGMENT$glfwGetNSGLContext = loader.apply("glfwGetNSGLContext");
        HANDLE$glfwGetNSGLContext = RawFunctionLoader.link(SEGMENT$glfwGetNSGLContext, Descriptors.DESCRIPTOR$glfwGetNSGLContext);
        SEGMENT$glfwGetOSMesaColorBuffer = loader.apply("glfwGetOSMesaColorBuffer");
        HANDLE$glfwGetOSMesaColorBuffer = RawFunctionLoader.link(SEGMENT$glfwGetOSMesaColorBuffer, Descriptors.DESCRIPTOR$glfwGetOSMesaColorBuffer);
        SEGMENT$glfwGetOSMesaContext = loader.apply("glfwGetOSMesaContext");
        HANDLE$glfwGetOSMesaContext = RawFunctionLoader.link(SEGMENT$glfwGetOSMesaContext, Descriptors.DESCRIPTOR$glfwGetOSMesaContext);
        SEGMENT$glfwGetOSMesaDepthBuffer = loader.apply("glfwGetOSMesaDepthBuffer");
        HANDLE$glfwGetOSMesaDepthBuffer = RawFunctionLoader.link(SEGMENT$glfwGetOSMesaDepthBuffer, Descriptors.DESCRIPTOR$glfwGetOSMesaDepthBuffer);
        SEGMENT$glfwGetPhysicalDevicePresentationSupport = loader.apply("glfwGetPhysicalDevicePresentationSupport");
        HANDLE$glfwGetPhysicalDevicePresentationSupport = RawFunctionLoader.link(SEGMENT$glfwGetPhysicalDevicePresentationSupport, Descriptors.DESCRIPTOR$glfwGetPhysicalDevicePresentationSupport);
        SEGMENT$glfwGetPlatform = loader.apply("glfwGetPlatform");
        HANDLE$glfwGetPlatform = RawFunctionLoader.link(SEGMENT$glfwGetPlatform, Descriptors.DESCRIPTOR$glfwGetPlatform);
        SEGMENT$glfwGetPrimaryMonitor = loader.apply("glfwGetPrimaryMonitor");
        HANDLE$glfwGetPrimaryMonitor = RawFunctionLoader.link(SEGMENT$glfwGetPrimaryMonitor, Descriptors.DESCRIPTOR$glfwGetPrimaryMonitor);
        SEGMENT$glfwGetProcAddress = loader.apply("glfwGetProcAddress");
        HANDLE$glfwGetProcAddress = RawFunctionLoader.link(SEGMENT$glfwGetProcAddress, Descriptors.DESCRIPTOR$glfwGetProcAddress);
        SEGMENT$glfwGetRequiredInstanceExtensions = loader.apply("glfwGetRequiredInstanceExtensions");
        HANDLE$glfwGetRequiredInstanceExtensions = RawFunctionLoader.link(SEGMENT$glfwGetRequiredInstanceExtensions, Descriptors.DESCRIPTOR$glfwGetRequiredInstanceExtensions);
        SEGMENT$glfwGetTime = loader.apply("glfwGetTime");
        HANDLE$glfwGetTime = RawFunctionLoader.link(SEGMENT$glfwGetTime, Descriptors.DESCRIPTOR$glfwGetTime);
        SEGMENT$glfwGetTimerFrequency = loader.apply("glfwGetTimerFrequency");
        HANDLE$glfwGetTimerFrequency = RawFunctionLoader.link(SEGMENT$glfwGetTimerFrequency, Descriptors.DESCRIPTOR$glfwGetTimerFrequency);
        SEGMENT$glfwGetTimerValue = loader.apply("glfwGetTimerValue");
        HANDLE$glfwGetTimerValue = RawFunctionLoader.link(SEGMENT$glfwGetTimerValue, Descriptors.DESCRIPTOR$glfwGetTimerValue);
        SEGMENT$glfwGetVersion = loader.apply("glfwGetVersion");
        HANDLE$glfwGetVersion = RawFunctionLoader.link(SEGMENT$glfwGetVersion, Descriptors.DESCRIPTOR$glfwGetVersion);
        SEGMENT$glfwGetVersionString = loader.apply("glfwGetVersionString");
        HANDLE$glfwGetVersionString = RawFunctionLoader.link(SEGMENT$glfwGetVersionString, Descriptors.DESCRIPTOR$glfwGetVersionString);
        SEGMENT$glfwGetVideoMode = loader.apply("glfwGetVideoMode");
        HANDLE$glfwGetVideoMode = RawFunctionLoader.link(SEGMENT$glfwGetVideoMode, Descriptors.DESCRIPTOR$glfwGetVideoMode);
        SEGMENT$glfwGetVideoModes = loader.apply("glfwGetVideoModes");
        HANDLE$glfwGetVideoModes = RawFunctionLoader.link(SEGMENT$glfwGetVideoModes, Descriptors.DESCRIPTOR$glfwGetVideoModes);
        SEGMENT$glfwGetWGLContext = loader.apply("glfwGetWGLContext");
        HANDLE$glfwGetWGLContext = RawFunctionLoader.link(SEGMENT$glfwGetWGLContext, Descriptors.DESCRIPTOR$glfwGetWGLContext);
        SEGMENT$glfwGetWaylandDisplay = loader.apply("glfwGetWaylandDisplay");
        HANDLE$glfwGetWaylandDisplay = RawFunctionLoader.link(SEGMENT$glfwGetWaylandDisplay, Descriptors.DESCRIPTOR$glfwGetWaylandDisplay);
        SEGMENT$glfwGetWaylandMonitor = loader.apply("glfwGetWaylandMonitor");
        HANDLE$glfwGetWaylandMonitor = RawFunctionLoader.link(SEGMENT$glfwGetWaylandMonitor, Descriptors.DESCRIPTOR$glfwGetWaylandMonitor);
        SEGMENT$glfwGetWaylandWindow = loader.apply("glfwGetWaylandWindow");
        HANDLE$glfwGetWaylandWindow = RawFunctionLoader.link(SEGMENT$glfwGetWaylandWindow, Descriptors.DESCRIPTOR$glfwGetWaylandWindow);
        SEGMENT$glfwGetWin32Adapter = loader.apply("glfwGetWin32Adapter");
        HANDLE$glfwGetWin32Adapter = RawFunctionLoader.link(SEGMENT$glfwGetWin32Adapter, Descriptors.DESCRIPTOR$glfwGetWin32Adapter);
        SEGMENT$glfwGetWin32Monitor = loader.apply("glfwGetWin32Monitor");
        HANDLE$glfwGetWin32Monitor = RawFunctionLoader.link(SEGMENT$glfwGetWin32Monitor, Descriptors.DESCRIPTOR$glfwGetWin32Monitor);
        SEGMENT$glfwGetWin32Window = loader.apply("glfwGetWin32Window");
        HANDLE$glfwGetWin32Window = RawFunctionLoader.link(SEGMENT$glfwGetWin32Window, Descriptors.DESCRIPTOR$glfwGetWin32Window);
        SEGMENT$glfwGetWindowAttrib = loader.apply("glfwGetWindowAttrib");
        HANDLE$glfwGetWindowAttrib = RawFunctionLoader.link(SEGMENT$glfwGetWindowAttrib, Descriptors.DESCRIPTOR$glfwGetWindowAttrib);
        SEGMENT$glfwGetWindowContentScale = loader.apply("glfwGetWindowContentScale");
        HANDLE$glfwGetWindowContentScale = RawFunctionLoader.link(SEGMENT$glfwGetWindowContentScale, Descriptors.DESCRIPTOR$glfwGetWindowContentScale);
        SEGMENT$glfwGetWindowFrameSize = loader.apply("glfwGetWindowFrameSize");
        HANDLE$glfwGetWindowFrameSize = RawFunctionLoader.link(SEGMENT$glfwGetWindowFrameSize, Descriptors.DESCRIPTOR$glfwGetWindowFrameSize);
        SEGMENT$glfwGetWindowMonitor = loader.apply("glfwGetWindowMonitor");
        HANDLE$glfwGetWindowMonitor = RawFunctionLoader.link(SEGMENT$glfwGetWindowMonitor, Descriptors.DESCRIPTOR$glfwGetWindowMonitor);
        SEGMENT$glfwGetWindowOpacity = loader.apply("glfwGetWindowOpacity");
        HANDLE$glfwGetWindowOpacity = RawFunctionLoader.link(SEGMENT$glfwGetWindowOpacity, Descriptors.DESCRIPTOR$glfwGetWindowOpacity);
        SEGMENT$glfwGetWindowPos = loader.apply("glfwGetWindowPos");
        HANDLE$glfwGetWindowPos = RawFunctionLoader.link(SEGMENT$glfwGetWindowPos, Descriptors.DESCRIPTOR$glfwGetWindowPos);
        SEGMENT$glfwGetWindowSize = loader.apply("glfwGetWindowSize");
        HANDLE$glfwGetWindowSize = RawFunctionLoader.link(SEGMENT$glfwGetWindowSize, Descriptors.DESCRIPTOR$glfwGetWindowSize);
        SEGMENT$glfwGetWindowTitle = loader.apply("glfwGetWindowTitle");
        HANDLE$glfwGetWindowTitle = RawFunctionLoader.link(SEGMENT$glfwGetWindowTitle, Descriptors.DESCRIPTOR$glfwGetWindowTitle);
        SEGMENT$glfwGetWindowUserPointer = loader.apply("glfwGetWindowUserPointer");
        HANDLE$glfwGetWindowUserPointer = RawFunctionLoader.link(SEGMENT$glfwGetWindowUserPointer, Descriptors.DESCRIPTOR$glfwGetWindowUserPointer);
        SEGMENT$glfwGetX11Adapter = loader.apply("glfwGetX11Adapter");
        HANDLE$glfwGetX11Adapter = RawFunctionLoader.link(SEGMENT$glfwGetX11Adapter, Descriptors.DESCRIPTOR$glfwGetX11Adapter);
        SEGMENT$glfwGetX11Display = loader.apply("glfwGetX11Display");
        HANDLE$glfwGetX11Display = RawFunctionLoader.link(SEGMENT$glfwGetX11Display, Descriptors.DESCRIPTOR$glfwGetX11Display);
        SEGMENT$glfwGetX11Monitor = loader.apply("glfwGetX11Monitor");
        HANDLE$glfwGetX11Monitor = RawFunctionLoader.link(SEGMENT$glfwGetX11Monitor, Descriptors.DESCRIPTOR$glfwGetX11Monitor);
        SEGMENT$glfwGetX11SelectionString = loader.apply("glfwGetX11SelectionString");
        HANDLE$glfwGetX11SelectionString = RawFunctionLoader.link(SEGMENT$glfwGetX11SelectionString, Descriptors.DESCRIPTOR$glfwGetX11SelectionString);
        SEGMENT$glfwGetX11Window = loader.apply("glfwGetX11Window");
        HANDLE$glfwGetX11Window = RawFunctionLoader.link(SEGMENT$glfwGetX11Window, Descriptors.DESCRIPTOR$glfwGetX11Window);
        SEGMENT$glfwHideWindow = loader.apply("glfwHideWindow");
        HANDLE$glfwHideWindow = RawFunctionLoader.link(SEGMENT$glfwHideWindow, Descriptors.DESCRIPTOR$glfwHideWindow);
        SEGMENT$glfwIconifyWindow = loader.apply("glfwIconifyWindow");
        HANDLE$glfwIconifyWindow = RawFunctionLoader.link(SEGMENT$glfwIconifyWindow, Descriptors.DESCRIPTOR$glfwIconifyWindow);
        SEGMENT$glfwInit = loader.apply("glfwInit");
        HANDLE$glfwInit = RawFunctionLoader.link(SEGMENT$glfwInit, Descriptors.DESCRIPTOR$glfwInit);
        SEGMENT$glfwInitAllocator = loader.apply("glfwInitAllocator");
        HANDLE$glfwInitAllocator = RawFunctionLoader.link(SEGMENT$glfwInitAllocator, Descriptors.DESCRIPTOR$glfwInitAllocator);
        SEGMENT$glfwInitHint = loader.apply("glfwInitHint");
        HANDLE$glfwInitHint = RawFunctionLoader.link(SEGMENT$glfwInitHint, Descriptors.DESCRIPTOR$glfwInitHint);
        SEGMENT$glfwInitVulkanLoader = loader.apply("glfwInitVulkanLoader");
        HANDLE$glfwInitVulkanLoader = RawFunctionLoader.link(SEGMENT$glfwInitVulkanLoader, Descriptors.DESCRIPTOR$glfwInitVulkanLoader);
        SEGMENT$glfwJoystickIsGamepad = loader.apply("glfwJoystickIsGamepad");
        HANDLE$glfwJoystickIsGamepad = RawFunctionLoader.link(SEGMENT$glfwJoystickIsGamepad, Descriptors.DESCRIPTOR$glfwJoystickIsGamepad);
        SEGMENT$glfwJoystickPresent = loader.apply("glfwJoystickPresent");
        HANDLE$glfwJoystickPresent = RawFunctionLoader.link(SEGMENT$glfwJoystickPresent, Descriptors.DESCRIPTOR$glfwJoystickPresent);
        SEGMENT$glfwMakeContextCurrent = loader.apply("glfwMakeContextCurrent");
        HANDLE$glfwMakeContextCurrent = RawFunctionLoader.link(SEGMENT$glfwMakeContextCurrent, Descriptors.DESCRIPTOR$glfwMakeContextCurrent);
        SEGMENT$glfwMaximizeWindow = loader.apply("glfwMaximizeWindow");
        HANDLE$glfwMaximizeWindow = RawFunctionLoader.link(SEGMENT$glfwMaximizeWindow, Descriptors.DESCRIPTOR$glfwMaximizeWindow);
        SEGMENT$glfwPlatformSupported = loader.apply("glfwPlatformSupported");
        HANDLE$glfwPlatformSupported = RawFunctionLoader.link(SEGMENT$glfwPlatformSupported, Descriptors.DESCRIPTOR$glfwPlatformSupported);
        SEGMENT$glfwPollEvents = loader.apply("glfwPollEvents");
        HANDLE$glfwPollEvents = RawFunctionLoader.link(SEGMENT$glfwPollEvents, Descriptors.DESCRIPTOR$glfwPollEvents);
        SEGMENT$glfwPostEmptyEvent = loader.apply("glfwPostEmptyEvent");
        HANDLE$glfwPostEmptyEvent = RawFunctionLoader.link(SEGMENT$glfwPostEmptyEvent, Descriptors.DESCRIPTOR$glfwPostEmptyEvent);
        SEGMENT$glfwRawMouseMotionSupported = loader.apply("glfwRawMouseMotionSupported");
        HANDLE$glfwRawMouseMotionSupported = RawFunctionLoader.link(SEGMENT$glfwRawMouseMotionSupported, Descriptors.DESCRIPTOR$glfwRawMouseMotionSupported);
        SEGMENT$glfwRequestWindowAttention = loader.apply("glfwRequestWindowAttention");
        HANDLE$glfwRequestWindowAttention = RawFunctionLoader.link(SEGMENT$glfwRequestWindowAttention, Descriptors.DESCRIPTOR$glfwRequestWindowAttention);
        SEGMENT$glfwRestoreWindow = loader.apply("glfwRestoreWindow");
        HANDLE$glfwRestoreWindow = RawFunctionLoader.link(SEGMENT$glfwRestoreWindow, Descriptors.DESCRIPTOR$glfwRestoreWindow);
        SEGMENT$glfwSetCharCallback = loader.apply("glfwSetCharCallback");
        HANDLE$glfwSetCharCallback = RawFunctionLoader.link(SEGMENT$glfwSetCharCallback, Descriptors.DESCRIPTOR$glfwSetCharCallback);
        SEGMENT$glfwSetCharModsCallback = loader.apply("glfwSetCharModsCallback");
        HANDLE$glfwSetCharModsCallback = RawFunctionLoader.link(SEGMENT$glfwSetCharModsCallback, Descriptors.DESCRIPTOR$glfwSetCharModsCallback);
        SEGMENT$glfwSetClipboardString = loader.apply("glfwSetClipboardString");
        HANDLE$glfwSetClipboardString = RawFunctionLoader.link(SEGMENT$glfwSetClipboardString, Descriptors.DESCRIPTOR$glfwSetClipboardString);
        SEGMENT$glfwSetCursor = loader.apply("glfwSetCursor");
        HANDLE$glfwSetCursor = RawFunctionLoader.link(SEGMENT$glfwSetCursor, Descriptors.DESCRIPTOR$glfwSetCursor);
        SEGMENT$glfwSetCursorEnterCallback = loader.apply("glfwSetCursorEnterCallback");
        HANDLE$glfwSetCursorEnterCallback = RawFunctionLoader.link(SEGMENT$glfwSetCursorEnterCallback, Descriptors.DESCRIPTOR$glfwSetCursorEnterCallback);
        SEGMENT$glfwSetCursorPos = loader.apply("glfwSetCursorPos");
        HANDLE$glfwSetCursorPos = RawFunctionLoader.link(SEGMENT$glfwSetCursorPos, Descriptors.DESCRIPTOR$glfwSetCursorPos);
        SEGMENT$glfwSetCursorPosCallback = loader.apply("glfwSetCursorPosCallback");
        HANDLE$glfwSetCursorPosCallback = RawFunctionLoader.link(SEGMENT$glfwSetCursorPosCallback, Descriptors.DESCRIPTOR$glfwSetCursorPosCallback);
        SEGMENT$glfwSetDropCallback = loader.apply("glfwSetDropCallback");
        HANDLE$glfwSetDropCallback = RawFunctionLoader.link(SEGMENT$glfwSetDropCallback, Descriptors.DESCRIPTOR$glfwSetDropCallback);
        SEGMENT$glfwSetErrorCallback = loader.apply("glfwSetErrorCallback");
        HANDLE$glfwSetErrorCallback = RawFunctionLoader.link(SEGMENT$glfwSetErrorCallback, Descriptors.DESCRIPTOR$glfwSetErrorCallback);
        SEGMENT$glfwSetFramebufferSizeCallback = loader.apply("glfwSetFramebufferSizeCallback");
        HANDLE$glfwSetFramebufferSizeCallback = RawFunctionLoader.link(SEGMENT$glfwSetFramebufferSizeCallback, Descriptors.DESCRIPTOR$glfwSetFramebufferSizeCallback);
        SEGMENT$glfwSetGamma = loader.apply("glfwSetGamma");
        HANDLE$glfwSetGamma = RawFunctionLoader.link(SEGMENT$glfwSetGamma, Descriptors.DESCRIPTOR$glfwSetGamma);
        SEGMENT$glfwSetGammaRamp = loader.apply("glfwSetGammaRamp");
        HANDLE$glfwSetGammaRamp = RawFunctionLoader.link(SEGMENT$glfwSetGammaRamp, Descriptors.DESCRIPTOR$glfwSetGammaRamp);
        SEGMENT$glfwSetInputMode = loader.apply("glfwSetInputMode");
        HANDLE$glfwSetInputMode = RawFunctionLoader.link(SEGMENT$glfwSetInputMode, Descriptors.DESCRIPTOR$glfwSetInputMode);
        SEGMENT$glfwSetJoystickCallback = loader.apply("glfwSetJoystickCallback");
        HANDLE$glfwSetJoystickCallback = RawFunctionLoader.link(SEGMENT$glfwSetJoystickCallback, Descriptors.DESCRIPTOR$glfwSetJoystickCallback);
        SEGMENT$glfwSetJoystickUserPointer = loader.apply("glfwSetJoystickUserPointer");
        HANDLE$glfwSetJoystickUserPointer = RawFunctionLoader.link(SEGMENT$glfwSetJoystickUserPointer, Descriptors.DESCRIPTOR$glfwSetJoystickUserPointer);
        SEGMENT$glfwSetKeyCallback = loader.apply("glfwSetKeyCallback");
        HANDLE$glfwSetKeyCallback = RawFunctionLoader.link(SEGMENT$glfwSetKeyCallback, Descriptors.DESCRIPTOR$glfwSetKeyCallback);
        SEGMENT$glfwSetMonitorCallback = loader.apply("glfwSetMonitorCallback");
        HANDLE$glfwSetMonitorCallback = RawFunctionLoader.link(SEGMENT$glfwSetMonitorCallback, Descriptors.DESCRIPTOR$glfwSetMonitorCallback);
        SEGMENT$glfwSetMonitorUserPointer = loader.apply("glfwSetMonitorUserPointer");
        HANDLE$glfwSetMonitorUserPointer = RawFunctionLoader.link(SEGMENT$glfwSetMonitorUserPointer, Descriptors.DESCRIPTOR$glfwSetMonitorUserPointer);
        SEGMENT$glfwSetMouseButtonCallback = loader.apply("glfwSetMouseButtonCallback");
        HANDLE$glfwSetMouseButtonCallback = RawFunctionLoader.link(SEGMENT$glfwSetMouseButtonCallback, Descriptors.DESCRIPTOR$glfwSetMouseButtonCallback);
        SEGMENT$glfwSetScrollCallback = loader.apply("glfwSetScrollCallback");
        HANDLE$glfwSetScrollCallback = RawFunctionLoader.link(SEGMENT$glfwSetScrollCallback, Descriptors.DESCRIPTOR$glfwSetScrollCallback);
        SEGMENT$glfwSetTime = loader.apply("glfwSetTime");
        HANDLE$glfwSetTime = RawFunctionLoader.link(SEGMENT$glfwSetTime, Descriptors.DESCRIPTOR$glfwSetTime);
        SEGMENT$glfwSetWindowAspectRatio = loader.apply("glfwSetWindowAspectRatio");
        HANDLE$glfwSetWindowAspectRatio = RawFunctionLoader.link(SEGMENT$glfwSetWindowAspectRatio, Descriptors.DESCRIPTOR$glfwSetWindowAspectRatio);
        SEGMENT$glfwSetWindowAttrib = loader.apply("glfwSetWindowAttrib");
        HANDLE$glfwSetWindowAttrib = RawFunctionLoader.link(SEGMENT$glfwSetWindowAttrib, Descriptors.DESCRIPTOR$glfwSetWindowAttrib);
        SEGMENT$glfwSetWindowCloseCallback = loader.apply("glfwSetWindowCloseCallback");
        HANDLE$glfwSetWindowCloseCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowCloseCallback, Descriptors.DESCRIPTOR$glfwSetWindowCloseCallback);
        SEGMENT$glfwSetWindowContentScaleCallback = loader.apply("glfwSetWindowContentScaleCallback");
        HANDLE$glfwSetWindowContentScaleCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowContentScaleCallback, Descriptors.DESCRIPTOR$glfwSetWindowContentScaleCallback);
        SEGMENT$glfwSetWindowFocusCallback = loader.apply("glfwSetWindowFocusCallback");
        HANDLE$glfwSetWindowFocusCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowFocusCallback, Descriptors.DESCRIPTOR$glfwSetWindowFocusCallback);
        SEGMENT$glfwSetWindowIcon = loader.apply("glfwSetWindowIcon");
        HANDLE$glfwSetWindowIcon = RawFunctionLoader.link(SEGMENT$glfwSetWindowIcon, Descriptors.DESCRIPTOR$glfwSetWindowIcon);
        SEGMENT$glfwSetWindowIconifyCallback = loader.apply("glfwSetWindowIconifyCallback");
        HANDLE$glfwSetWindowIconifyCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowIconifyCallback, Descriptors.DESCRIPTOR$glfwSetWindowIconifyCallback);
        SEGMENT$glfwSetWindowMaximizeCallback = loader.apply("glfwSetWindowMaximizeCallback");
        HANDLE$glfwSetWindowMaximizeCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowMaximizeCallback, Descriptors.DESCRIPTOR$glfwSetWindowMaximizeCallback);
        SEGMENT$glfwSetWindowMonitor = loader.apply("glfwSetWindowMonitor");
        HANDLE$glfwSetWindowMonitor = RawFunctionLoader.link(SEGMENT$glfwSetWindowMonitor, Descriptors.DESCRIPTOR$glfwSetWindowMonitor);
        SEGMENT$glfwSetWindowOpacity = loader.apply("glfwSetWindowOpacity");
        HANDLE$glfwSetWindowOpacity = RawFunctionLoader.link(SEGMENT$glfwSetWindowOpacity, Descriptors.DESCRIPTOR$glfwSetWindowOpacity);
        SEGMENT$glfwSetWindowPos = loader.apply("glfwSetWindowPos");
        HANDLE$glfwSetWindowPos = RawFunctionLoader.link(SEGMENT$glfwSetWindowPos, Descriptors.DESCRIPTOR$glfwSetWindowPos);
        SEGMENT$glfwSetWindowPosCallback = loader.apply("glfwSetWindowPosCallback");
        HANDLE$glfwSetWindowPosCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowPosCallback, Descriptors.DESCRIPTOR$glfwSetWindowPosCallback);
        SEGMENT$glfwSetWindowRefreshCallback = loader.apply("glfwSetWindowRefreshCallback");
        HANDLE$glfwSetWindowRefreshCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowRefreshCallback, Descriptors.DESCRIPTOR$glfwSetWindowRefreshCallback);
        SEGMENT$glfwSetWindowShouldClose = loader.apply("glfwSetWindowShouldClose");
        HANDLE$glfwSetWindowShouldClose = RawFunctionLoader.link(SEGMENT$glfwSetWindowShouldClose, Descriptors.DESCRIPTOR$glfwSetWindowShouldClose);
        SEGMENT$glfwSetWindowSize = loader.apply("glfwSetWindowSize");
        HANDLE$glfwSetWindowSize = RawFunctionLoader.link(SEGMENT$glfwSetWindowSize, Descriptors.DESCRIPTOR$glfwSetWindowSize);
        SEGMENT$glfwSetWindowSizeCallback = loader.apply("glfwSetWindowSizeCallback");
        HANDLE$glfwSetWindowSizeCallback = RawFunctionLoader.link(SEGMENT$glfwSetWindowSizeCallback, Descriptors.DESCRIPTOR$glfwSetWindowSizeCallback);
        SEGMENT$glfwSetWindowSizeLimits = loader.apply("glfwSetWindowSizeLimits");
        HANDLE$glfwSetWindowSizeLimits = RawFunctionLoader.link(SEGMENT$glfwSetWindowSizeLimits, Descriptors.DESCRIPTOR$glfwSetWindowSizeLimits);
        SEGMENT$glfwSetWindowTitle = loader.apply("glfwSetWindowTitle");
        HANDLE$glfwSetWindowTitle = RawFunctionLoader.link(SEGMENT$glfwSetWindowTitle, Descriptors.DESCRIPTOR$glfwSetWindowTitle);
        SEGMENT$glfwSetWindowUserPointer = loader.apply("glfwSetWindowUserPointer");
        HANDLE$glfwSetWindowUserPointer = RawFunctionLoader.link(SEGMENT$glfwSetWindowUserPointer, Descriptors.DESCRIPTOR$glfwSetWindowUserPointer);
        SEGMENT$glfwSetX11SelectionString = loader.apply("glfwSetX11SelectionString");
        HANDLE$glfwSetX11SelectionString = RawFunctionLoader.link(SEGMENT$glfwSetX11SelectionString, Descriptors.DESCRIPTOR$glfwSetX11SelectionString);
        SEGMENT$glfwShowWindow = loader.apply("glfwShowWindow");
        HANDLE$glfwShowWindow = RawFunctionLoader.link(SEGMENT$glfwShowWindow, Descriptors.DESCRIPTOR$glfwShowWindow);
        SEGMENT$glfwSwapBuffers = loader.apply("glfwSwapBuffers");
        HANDLE$glfwSwapBuffers = RawFunctionLoader.link(SEGMENT$glfwSwapBuffers, Descriptors.DESCRIPTOR$glfwSwapBuffers);
        SEGMENT$glfwSwapInterval = loader.apply("glfwSwapInterval");
        HANDLE$glfwSwapInterval = RawFunctionLoader.link(SEGMENT$glfwSwapInterval, Descriptors.DESCRIPTOR$glfwSwapInterval);
        SEGMENT$glfwTerminate = loader.apply("glfwTerminate");
        HANDLE$glfwTerminate = RawFunctionLoader.link(SEGMENT$glfwTerminate, Descriptors.DESCRIPTOR$glfwTerminate);
        SEGMENT$glfwUpdateGamepadMappings = loader.apply("glfwUpdateGamepadMappings");
        HANDLE$glfwUpdateGamepadMappings = RawFunctionLoader.link(SEGMENT$glfwUpdateGamepadMappings, Descriptors.DESCRIPTOR$glfwUpdateGamepadMappings);
        SEGMENT$glfwVulkanSupported = loader.apply("glfwVulkanSupported");
        HANDLE$glfwVulkanSupported = RawFunctionLoader.link(SEGMENT$glfwVulkanSupported, Descriptors.DESCRIPTOR$glfwVulkanSupported);
        SEGMENT$glfwWaitEvents = loader.apply("glfwWaitEvents");
        HANDLE$glfwWaitEvents = RawFunctionLoader.link(SEGMENT$glfwWaitEvents, Descriptors.DESCRIPTOR$glfwWaitEvents);
        SEGMENT$glfwWaitEventsTimeout = loader.apply("glfwWaitEventsTimeout");
        HANDLE$glfwWaitEventsTimeout = RawFunctionLoader.link(SEGMENT$glfwWaitEventsTimeout, Descriptors.DESCRIPTOR$glfwWaitEventsTimeout);
        SEGMENT$glfwWindowHint = loader.apply("glfwWindowHint");
        HANDLE$glfwWindowHint = RawFunctionLoader.link(SEGMENT$glfwWindowHint, Descriptors.DESCRIPTOR$glfwWindowHint);
        SEGMENT$glfwWindowHintString = loader.apply("glfwWindowHintString");
        HANDLE$glfwWindowHintString = RawFunctionLoader.link(SEGMENT$glfwWindowHintString, Descriptors.DESCRIPTOR$glfwWindowHintString);
        SEGMENT$glfwWindowShouldClose = loader.apply("glfwWindowShouldClose");
        HANDLE$glfwWindowShouldClose = RawFunctionLoader.link(SEGMENT$glfwWindowShouldClose, Descriptors.DESCRIPTOR$glfwWindowShouldClose);
    }

    // region command wrappers

    ///  @brief Creates a custom cursor.
    ///
    ///  Creates a new custom cursor image that can be set for a window with @ref
    ///  glfwSetCursor.  The cursor can be destroyed with @ref glfwDestroyCursor.
    ///  Any remaining cursors are destroyed by @ref glfwTerminate.
    ///
    ///  The pixels are 32-bit, little-endian, non-premultiplied RGBA, i.e. eight
    ///  bits per channel with the red channel first.  They are arranged canonically
    ///  as packed sequential rows, starting from the top-left corner.
    ///
    ///  The cursor hotspot is specified in pixels, relative to the upper-left corner
    ///  of the cursor image.  Like all other coordinate systems in GLFW, the X-axis
    ///  points to the right and the Y-axis points down.
    ///
    ///  @param[in] image The desired cursor image.
    ///  @param[in] xhot The desired x-coordinate, in pixels, of the cursor hotspot.
    ///  @param[in] yhot The desired y-coordinate, in pixels, of the cursor hotspot.
    ///  @return The handle of the created cursor, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_VALUE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The specified image data is copied before this function
    ///  returns.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_object
    ///  @sa @ref glfwDestroyCursor
    ///  @sa @ref glfwCreateStandardCursor
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup input
    public @Nullable GLFWcursor createCursor(
        @Nullable @Pointer IGLFWimage image,
        int xhot,
        int yhot
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwCreateCursor);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (image != null ? image.segment() : MemorySegment.NULL),
                xhot,
                yhot
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWcursor(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Creates a cursor with a standard shape.
    ///
    ///  Returns a cursor with a standard shape, that can be set for a window with
    ///  @ref glfwSetCursor.  The images for these cursors come from the system
    ///  cursor theme and their exact appearance will vary between platforms.
    ///
    ///  Most of these shapes are guaranteed to exist on every supported platform but
    ///  a few may not be present.  See the table below for details.
    ///
    ///  Cursor shape                   | Windows | macOS | X11    | Wayland
    ///  ------------------------------ | ------- | ----- | ------ | -------
    ///  @ref GLFW_ARROW_CURSOR         | Yes     | Yes   | Yes    | Yes
    ///  @ref GLFW_IBEAM_CURSOR         | Yes     | Yes   | Yes    | Yes
    ///  @ref GLFW_CROSSHAIR_CURSOR     | Yes     | Yes   | Yes    | Yes
    ///  @ref GLFW_POINTING_HAND_CURSOR | Yes     | Yes   | Yes    | Yes
    ///  @ref GLFW_RESIZE_EW_CURSOR     | Yes     | Yes   | Yes    | Yes
    ///  @ref GLFW_RESIZE_NS_CURSOR     | Yes     | Yes   | Yes    | Yes
    ///  @ref GLFW_RESIZE_NWSE_CURSOR   | Yes     | Yes<sup>1</sup> | Maybe<sup>2</sup> | Maybe<sup>2</sup>
    ///  @ref GLFW_RESIZE_NESW_CURSOR   | Yes     | Yes<sup>1</sup> | Maybe<sup>2</sup> | Maybe<sup>2</sup>
    ///  @ref GLFW_RESIZE_ALL_CURSOR    | Yes     | Yes   | Yes    | Yes
    ///  @ref GLFW_NOT_ALLOWED_CURSOR   | Yes     | Yes   | Maybe<sup>2</sup> | Maybe<sup>2</sup>
    ///
    ///  1) This uses a private system API and may fail in the future.
    ///
    ///  2) This uses a newer standard that not all cursor themes support.
    ///
    ///  If the requested shape is not available, this function emits a @ref
    ///  GLFW_CURSOR_UNAVAILABLE error and returns `NULL`.
    ///
    ///  @param[in] shape One of the [standard shapes](@ref shapes).
    ///  @return A new cursor ready to use or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM, @ref GLFW_CURSOR_UNAVAILABLE and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_standard
    ///  @sa @ref glfwCreateCursor
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup input
    public @Nullable GLFWcursor createStandardCursor(
        int shape
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwCreateStandardCursor);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                shape
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWcursor(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Creates a window and its associated context.
    ///
    ///  This function creates a window and its associated OpenGL or OpenGL ES
    ///  context.  Most of the options controlling how the window and its context
    ///  should be created are specified with [window hints](@ref window_hints).
    ///
    ///  Successful creation does not change which context is current.  Before you
    ///  can use the newly created context, you need to
    ///  [make it current](@ref context_current).  For information about the `share`
    ///  parameter, see @ref context_sharing.
    ///
    ///  The created window, framebuffer and context may differ from what you
    ///  requested, as not all parameters and hints are
    ///  [hard constraints](@ref window_hints_hard).  This includes the size of the
    ///  window, especially for full screen windows.  To query the actual attributes
    ///  of the created window, framebuffer and context, see @ref
    ///  glfwGetWindowAttrib, @ref glfwGetWindowSize and @ref glfwGetFramebufferSize.
    ///
    ///  To create a full screen window, you need to specify the monitor the window
    ///  will cover.  If no monitor is specified, the window will be windowed mode.
    ///  Unless you have a way for the user to choose a specific monitor, it is
    ///  recommended that you pick the primary monitor.  For more information on how
    ///  to query connected monitors, see @ref monitor_monitors.
    ///
    ///  For full screen windows, the specified size becomes the resolution of the
    ///  window's _desired video mode_.  As long as a full screen window is not
    ///  iconified, the supported video mode most closely matching the desired video
    ///  mode is set for the specified monitor.  For more information about full
    ///  screen windows, including the creation of so called _windowed full screen_
    ///  or _borderless full screen_ windows, see @ref window_windowed_full_screen.
    ///
    ///  Once you have created the window, you can switch it between windowed and
    ///  full screen mode with @ref glfwSetWindowMonitor.  This will not affect its
    ///  OpenGL or OpenGL ES context.
    ///
    ///  By default, newly created windows use the placement recommended by the
    ///  window system.  To create the window at a specific position, set the @ref
    ///  GLFW_POSITION_X and @ref GLFW_POSITION_Y window hints before creation.  To
    ///  restore the default behavior, set either or both hints back to
    ///  `GLFW_ANY_POSITION`.
    ///
    ///  As long as at least one full screen window is not iconified, the screensaver
    ///  is prohibited from starting.
    ///
    ///  Window systems put limits on window sizes.  Very large or very small window
    ///  dimensions may be overridden by the window system on creation.  Check the
    ///  actual [size](@ref window_size) after creation.
    ///
    ///  The [swap interval](@ref buffer_swap) is not set during window creation and
    ///  the initial value may vary depending on driver settings and defaults.
    ///
    ///  @param[in] width The desired width, in screen coordinates, of the window.
    ///  This must be greater than zero.
    ///  @param[in] height The desired height, in screen coordinates, of the window.
    ///  This must be greater than zero.
    ///  @param[in] title The initial, UTF-8 encoded window title.
    ///  @param[in] monitor The monitor to use for full screen mode, or `NULL` for
    ///  windowed mode.
    ///  @param[in] share The window whose context to share resources with, or `NULL`
    ///  to not share resources.
    ///  @return The handle of the created window, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM, @ref GLFW_INVALID_VALUE, @ref GLFW_API_UNAVAILABLE, @ref
    ///  GLFW_VERSION_UNAVAILABLE, @ref GLFW_FORMAT_UNAVAILABLE, @ref
    ///  GLFW_NO_WINDOW_CONTEXT and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @win32 Window creation will fail if the Microsoft GDI software
    ///  OpenGL implementation is the only one available.
    ///
    ///  @remark @win32 If the executable has an icon resource named `GLFW_ICON,` it
    ///  will be set as the initial icon for the window.  If no such icon is present,
    ///  the `IDI_APPLICATION` icon will be used instead.  To set a different icon,
    ///  see @ref glfwSetWindowIcon.
    ///
    ///  @remark @win32 The context to share resources with must not be current on
    ///  any other thread.
    ///
    ///  @remark @macos The OS only supports core profile contexts for OpenGL
    ///  versions 3.2 and later.  Before creating an OpenGL context of version 3.2 or
    ///  later you must set the [GLFW_OPENGL_PROFILE](@ref GLFW_OPENGL_PROFILE_hint)
    ///  hint accordingly.  OpenGL 3.0 and 3.1 contexts are not supported at all
    ///  on macOS.
    ///
    ///  @remark @macos The GLFW window has no icon, as it is not a document
    ///  window, but the dock icon will be the same as the application bundle's icon.
    ///  For more information on bundles, see the
    ///  [Bundle Programming Guide][bundle-guide] in the Mac Developer Library.
    ///
    ///  [bundle-guide]: https://developer.apple.com/library/mac/documentation/CoreFoundation/Conceptual/CFBundles/
    ///
    ///  @remark @macos On OS X 10.10 and later the window frame will not be rendered
    ///  at full resolution on Retina displays unless the
    ///  [GLFW_SCALE_FRAMEBUFFER](@ref GLFW_SCALE_FRAMEBUFFER_hint)
    ///  hint is `GLFW_TRUE` and the `NSHighResolutionCapable` key is enabled in the
    ///  application bundle's `Info.plist`.  For more information, see
    ///  [High Resolution Guidelines for OS X][hidpi-guide] in the Mac Developer
    ///  Library.  The GLFW test and example programs use a custom `Info.plist`
    ///  template for this, which can be found as `CMake/Info.plist.in` in the source
    ///  tree.
    ///
    ///  [hidpi-guide]: https://developer.apple.com/library/mac/documentation/GraphicsAnimation/Conceptual/HighResolutionOSX/Explained/Explained.html
    ///
    ///  @remark @macos When activating frame autosaving with
    ///  [GLFW_COCOA_FRAME_NAME](@ref GLFW_COCOA_FRAME_NAME_hint), the specified
    ///  window size and position may be overridden by previously saved values.
    ///
    ///  @remark @wayland GLFW uses [libdecor][] where available to create its window
    ///  decorations.  This in turn uses server-side XDG decorations where available
    ///  and provides high quality client-side decorations on compositors like GNOME.
    ///  If both XDG decorations and libdecor are unavailable, GLFW falls back to
    ///  a very simple set of window decorations that only support moving, resizing
    ///  and the window manager's right-click menu.
    ///
    ///  [libdecor]: https://gitlab.freedesktop.org/libdecor/libdecor
    ///
    ///  @remark @x11 Some window managers will not respect the placement of
    ///  initially hidden windows.
    ///
    ///  @remark @x11 Due to the asynchronous nature of X11, it may take a moment for
    ///  a window to reach its requested state.  This means you may not be able to
    ///  query the final size, position or other attributes directly after window
    ///  creation.
    ///
    ///  @remark @x11 The class part of the `WM_CLASS` window property will by
    ///  default be set to the window title passed to this function.  The instance
    ///  part will use the contents of the `RESOURCE_NAME` environment variable, if
    ///  present and not empty, or fall back to the window title.  Set the
    ///  [GLFW_X11_CLASS_NAME](@ref GLFW_X11_CLASS_NAME_hint) and
    ///  [GLFW_X11_INSTANCE_NAME](@ref GLFW_X11_INSTANCE_NAME_hint) window hints to
    ///  override this.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_creation
    ///  @sa @ref glfwDestroyWindow
    ///
    ///  @since Added in version 3.0.  Replaces `glfwOpenWindow`.
    ///
    ///  @ingroup window
    public @Nullable GLFWwindow createWindow(
        int width,
        int height,
        @Nullable BytePtr title,
        @Nullable GLFWmonitor monitor,
        @Nullable GLFWwindow share
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwCreateWindow);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                width,
                height,
                (MemorySegment) (title != null ? title.segment() : MemorySegment.NULL),
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                (MemorySegment) (share != null ? share.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWwindow(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Creates a Vulkan surface for the specified window.
    ///
    ///  This function creates a Vulkan surface for the specified window.
    ///
    ///  If the Vulkan loader or at least one minimally functional ICD were not found,
    ///  this function returns `VK_ERROR_INITIALIZATION_FAILED` and generates a @ref
    ///  GLFW_API_UNAVAILABLE error.  Call @ref glfwVulkanSupported to check whether
    ///  Vulkan is at least minimally available.
    ///
    ///  If the required window surface creation instance extensions are not
    ///  available or if the specified instance was not created with these extensions
    ///  enabled, this function returns `VK_ERROR_EXTENSION_NOT_PRESENT` and
    ///  generates a @ref GLFW_API_UNAVAILABLE error.  Call @ref
    ///  glfwGetRequiredInstanceExtensions to check what instance extensions are
    ///  required.
    ///
    ///  The window surface cannot be shared with another API so the window must
    ///  have been created with the [client api hint](@ref GLFW_CLIENT_API_attrib)
    ///  set to `GLFW_NO_API` otherwise it generates a @ref GLFW_INVALID_VALUE error
    ///  and returns `VK_ERROR_NATIVE_WINDOW_IN_USE_KHR`.
    ///
    ///  The window surface must be destroyed before the specified Vulkan instance.
    ///  It is the responsibility of the caller to destroy the window surface.  GLFW
    ///  does not destroy it for you.  Call `vkDestroySurfaceKHR` to destroy the
    ///  surface.
    ///
    ///  @param[in] instance The Vulkan instance to create the surface in.
    ///  @param[in] window The window to create the surface for.
    ///  @param[in] allocator The allocator to use, or `NULL` to use the default
    ///  allocator.
    ///  @param[out] surface Where to store the handle of the surface.  This is set
    ///  to `VK_NULL_HANDLE` if an error occurred.
    ///  @return `VK_SUCCESS` if successful, or a Vulkan error code if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_API_UNAVAILABLE, @ref GLFW_PLATFORM_ERROR and @ref GLFW_INVALID_VALUE
    ///
    ///  @remark If an error occurs before the creation call is made, GLFW returns
    ///  the Vulkan error code most appropriate for the error.  Appropriate use of
    ///  @ref glfwVulkanSupported and @ref glfwGetRequiredInstanceExtensions should
    ///  eliminate almost all occurrences of these errors.
    ///
    ///  @remark @macos GLFW prefers the `VK_EXT_metal_surface` extension, with the
    ///  `VK_MVK_macos_surface` extension as a fallback.  The name of the selected
    ///  extension, if any, is included in the array returned by @ref
    ///  glfwGetRequiredInstanceExtensions.
    ///
    ///  @remark @macos This function creates and sets a `CAMetalLayer` instance for
    ///  the window content view, which is required for MoltenVK to function.
    ///
    ///  @remark @x11 By default GLFW prefers the `VK_KHR_xcb_surface` extension,
    ///  with the `VK_KHR_xlib_surface` extension as a fallback.  You can make
    ///  `VK_KHR_xlib_surface` the preferred extension by setting the
    ///  [GLFW_X11_XCB_VULKAN_SURFACE](@ref GLFW_X11_XCB_VULKAN_SURFACE_hint) init
    ///  hint.  The name of the selected extension, if any, is included in the array
    ///  returned by @ref glfwGetRequiredInstanceExtensions.
    ///
    ///  @thread_safety This function may be called from any thread.  For
    ///  synchronization details of Vulkan objects, see the Vulkan specification.
    ///
    ///  @sa @ref vulkan_surface
    ///  @sa @ref glfwGetRequiredInstanceExtensions
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup vulkan
    public @EnumType(VkResult.class) int createWindowSurface(
        @Nullable VkInstance instance,
        @Nullable GLFWwindow window,
        @Nullable @Pointer IVkAllocationCallbacks allocator,
        @Nullable @Pointer VkSurfaceKHR.Ptr surface
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwCreateWindowSurface);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (instance != null ? instance.segment() : MemorySegment.NULL),
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (allocator != null ? allocator.segment() : MemorySegment.NULL),
                (MemorySegment) (surface != null ? surface.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Resets all window hints to their default values.
    ///
    ///  This function resets all window hints to their
    ///  [default values](@ref window_hints_values).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_hints
    ///  @sa @ref glfwWindowHint
    ///  @sa @ref glfwWindowHintString
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public void defaultWindowHints() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwDefaultWindowHints);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Destroys a cursor.
    ///
    ///  This function destroys a cursor previously created with @ref
    ///  glfwCreateCursor.  Any remaining cursors will be destroyed by @ref
    ///  glfwTerminate.
    ///
    ///  If the specified cursor is current for any window, that window will be
    ///  reverted to the default cursor.  This does not affect the cursor mode.
    ///
    ///  @param[in] cursor The cursor object to destroy.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @reentrancy This function must not be called from a callback.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_object
    ///  @sa @ref glfwCreateCursor
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup input
    public void destroyCursor(
        @Nullable GLFWcursor cursor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwDestroyCursor);
        try {
            hFunction.invokeExact(
                (MemorySegment) (cursor != null ? cursor.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Destroys the specified window and its context.
    ///
    ///  This function destroys the specified window and its context.  On calling
    ///  this function, no further callbacks will be called for that window.
    ///
    ///  If the context of the specified window is current on the main thread, it is
    ///  detached before being destroyed.
    ///
    ///  @param[in] window The window to destroy.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @note The context of the specified window must not be current on any other
    ///  thread when this function is called.
    ///
    ///  @reentrancy This function must not be called from a callback.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_creation
    ///  @sa @ref glfwCreateWindow
    ///
    ///  @since Added in version 3.0.  Replaces `glfwCloseWindow`.
    ///
    ///  @ingroup window
    public void destroyWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwDestroyWindow);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns whether the specified extension is available.
    ///
    ///  This function returns whether the specified
    ///  [API extension](@ref context_glext) is supported by the current OpenGL or
    ///  OpenGL ES context.  It searches both for client API extension and context
    ///  creation API extensions.
    ///
    ///  A context must be current on the calling thread.  Calling this function
    ///  without a current context will cause a @ref GLFW_NO_CURRENT_CONTEXT error.
    ///
    ///  As this functions retrieves and searches one or more extension strings each
    ///  call, it is recommended that you cache its results if it is going to be used
    ///  frequently.  The extension strings will not change during the lifetime of
    ///  a context, so there is no danger in doing this.
    ///
    ///  This function does not apply to Vulkan.  If you are using Vulkan, see @ref
    ///  glfwGetRequiredInstanceExtensions, `vkEnumerateInstanceExtensionProperties`
    ///  and `vkEnumerateDeviceExtensionProperties` instead.
    ///
    ///  @param[in] extension The ASCII encoded name of the extension.
    ///  @return `GLFW_TRUE` if the extension is available, or `GLFW_FALSE`
    ///  otherwise.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_CURRENT_CONTEXT, @ref GLFW_INVALID_VALUE and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref context_glext
    ///  @sa @ref glfwGetProcAddress
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup context
    public int extensionSupported(
        @Nullable BytePtr extension
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwExtensionSupported);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (extension != null ? extension.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Brings the specified window to front and sets input focus.
    ///
    ///  This function brings the specified window to front and sets input focus.
    ///  The window should already be visible and not iconified.
    ///
    ///  By default, both windowed and full screen mode windows are focused when
    ///  initially created.  Set the [GLFW_FOCUSED](@ref GLFW_FOCUSED_hint) to
    ///  disable this behavior.
    ///
    ///  Also by default, windowed mode windows are focused when shown
    ///  with @ref glfwShowWindow. Set the
    ///  [GLFW_FOCUS_ON_SHOW](@ref GLFW_FOCUS_ON_SHOW_hint) to disable this behavior.
    ///
    ///  __Do not use this function__ to steal focus from other applications unless
    ///  you are certain that is what the user wants.  Focus stealing can be
    ///  extremely disruptive.
    ///
    ///  For a less disruptive way of getting the user's attention, see
    ///  [attention requests](@ref window_attention).
    ///
    ///  @param[in] window The window to give input focus.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @wayland The compositor will likely ignore focus requests unless
    ///  another window created by the same application already has input focus.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_focus
    ///  @sa @ref window_attention
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup window
    public void focusWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwFocusWindow);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the contents of the clipboard as a string.
    ///
    ///  This function returns the contents of the system clipboard, if it contains
    ///  or is convertible to a UTF-8 encoded string.  If the clipboard is empty or
    ///  if its contents cannot be converted, `NULL` is returned and a @ref
    ///  GLFW_FORMAT_UNAVAILABLE error is generated.
    ///
    ///  @param[in] window Deprecated.  Any valid window or `NULL`.
    ///  @return The contents of the clipboard as a UTF-8 encoded string, or `NULL`
    ///  if an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_FORMAT_UNAVAILABLE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @win32 The clipboard on Windows has a single global lock for reading and
    ///  writing.  GLFW tries to acquire it a few times, which is almost always enough.  If it
    ///  cannot acquire the lock then this function emits @ref GLFW_PLATFORM_ERROR and returns.
    ///  It is safe to try this multiple times.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the next call to @ref
    ///  glfwGetClipboardString or @ref glfwSetClipboardString, or until the library
    ///  is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref clipboard
    ///  @sa @ref glfwSetClipboardString
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup input
    public @Nullable BytePtr getClipboardString(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetClipboardString);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `CGDirectDisplayID` of the specified monitor.
    ///
    ///  @return The `CGDirectDisplayID` of the specified monitor, or
    ///  `kCGNullDirectDisplay` if an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup native
    public @NativeType("CGDirectDisplayID") @Unsigned int getCocoaMonitor(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetCocoaMonitor);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `NSView` of the specified window.
    ///
    ///  @return The `NSView` of the specified window, or `nil` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.4.
    ///
    ///  @ingroup native
    public @Pointer(comment="id") @NotNull MemorySegment getCocoaView(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetCocoaView);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `NSWindow` of the specified window.
    ///
    ///  @return The `NSWindow` of the specified window, or `nil` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="id") @NotNull MemorySegment getCocoaWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetCocoaWindow);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the window whose context is current on the calling thread.
    ///
    ///  This function returns the window whose OpenGL or OpenGL ES context is
    ///  current on the calling thread.
    ///
    ///  @return The window whose context is current, or `NULL` if no window's
    ///  context is current.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref context_current
    ///  @sa @ref glfwMakeContextCurrent
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup context
    public @Nullable GLFWwindow getCurrentContext() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetCurrentContext);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWwindow(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the position of the cursor relative to the content area of
    ///  the window.
    ///
    ///  This function returns the position of the cursor, in screen coordinates,
    ///  relative to the upper-left corner of the content area of the specified
    ///  window.
    ///
    ///  If the cursor is disabled (with `GLFW_CURSOR_DISABLED`) then the cursor
    ///  position is unbounded and limited only by the minimum and maximum values of
    ///  a `double`.
    ///
    ///  The coordinate can be converted to their integer equivalents with the
    ///  `floor` function.  Casting directly to an integer type works for positive
    ///  coordinates, but fails for negative ones.
    ///
    ///  Any or all of the position arguments may be `NULL`.  If an error occurs, all
    ///  non-`NULL` position arguments will be set to zero.
    ///
    ///  @param[in] window The desired window.
    ///  @param[out] xpos Where to store the cursor x-coordinate, relative to the
    ///  left edge of the content area, or `NULL`.
    ///  @param[out] ypos Where to store the cursor y-coordinate, relative to the to
    ///  top edge of the content area, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_pos
    ///  @sa @ref glfwSetCursorPos
    ///
    ///  @since Added in version 3.0.  Replaces `glfwGetMousePos`.
    ///
    ///  @ingroup input
    public void getCursorPos(
        @Nullable GLFWwindow window,
        @Nullable DoublePtr xpos,
        @Nullable DoublePtr ypos
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetCursorPos);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (xpos != null ? xpos.segment() : MemorySegment.NULL),
                (MemorySegment) (ypos != null ? ypos.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the `EGLConfig` of the specified window's `EGLSurface`.
    ///
    ///  @param[in] window The window whose `EGLSurface` to query.
    ///  @param[out] config The `EGLConfig` of the window `EGLSurface`, if available.
    ///  @return `GLFW_TRUE` if successful, or `GLFW_FALSE` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @remark `EGLConfig` is an opaque type.  Unlike other GLFW functions, the @p
    ///  config out parameter is not cleared on error, as core EGL does not define
    ///  any invalid value.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.5.
    ///
    ///  @ingroup native
    public int getEGLConfig(
        @Nullable GLFWwindow window,
        @Nullable PointerPtr config
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetEGLConfig);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (config != null ? config.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `EGLContext` of the specified window.
    ///
    ///  @return The `EGLContext` of the specified window, or `EGL_NO_CONTEXT` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="EGLContext") @NotNull MemorySegment getEGLContext(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetEGLContext);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `EGLDisplay` used by GLFW.
    ///
    ///  @return The `EGLDisplay` used by GLFW, or `EGL_NO_DISPLAY` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @remark Because EGL is initialized on demand, this function will return
    ///  `EGL_NO_DISPLAY` until the first context has been created via EGL.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="EGLDisplay") @NotNull MemorySegment getEGLDisplay() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetEGLDisplay);
        try {
            return (MemorySegment) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `EGLSurface` of the specified window.
    ///
    ///  @return The `EGLSurface` of the specified window, or `EGL_NO_SURFACE` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="EGLSurface") @NotNull MemorySegment getEGLSurface(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetEGLSurface);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns and clears the last error for the calling thread.
    ///
    ///  This function returns and clears the [error code](@ref errors) of the last
    ///  error that occurred on the calling thread, and optionally a UTF-8 encoded
    ///  human-readable description of it.  If no error has occurred since the last
    ///  call, it returns @ref GLFW_NO_ERROR (zero) and the description pointer is
    ///  set to `NULL`.
    ///
    ///  @param[in] description Where to store the error description pointer, or `NULL`.
    ///  @return The last error code for the calling thread, or @ref GLFW_NO_ERROR
    ///  (zero).
    ///
    ///  @errors None.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is guaranteed to be valid only until the
    ///  next error occurs or the library is terminated.
    ///
    ///  @remark This function may be called before @ref glfwInit.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref error_handling
    ///  @sa @ref glfwSetErrorCallback
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup init
    public int getError(
        @Nullable PointerPtr description
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetError);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (description != null ? description.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the size of the framebuffer of the specified window.
    ///
    ///  This function retrieves the size, in pixels, of the framebuffer of the
    ///  specified window.  If you wish to retrieve the size of the window in screen
    ///  coordinates, see @ref glfwGetWindowSize.
    ///
    ///  Any or all of the size arguments may be `NULL`.  If an error occurs, all
    ///  non-`NULL` size arguments will be set to zero.
    ///
    ///  @param[in] window The window whose framebuffer to query.
    ///  @param[out] width Where to store the width, in pixels, of the framebuffer,
    ///  or `NULL`.
    ///  @param[out] height Where to store the height, in pixels, of the framebuffer,
    ///  or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_fbsize
    ///  @sa @ref glfwSetFramebufferSizeCallback
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public void getFramebufferSize(
        @Nullable GLFWwindow window,
        @Nullable IntPtr width,
        @Nullable IntPtr height
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetFramebufferSize);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (width != null ? width.segment() : MemorySegment.NULL),
                (MemorySegment) (height != null ? height.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `GLXContext` of the specified window.
    ///
    ///  @return The `GLXContext` of the specified window, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_WINDOW_CONTEXT and @ref GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="GLXContext") @NotNull MemorySegment getGLXContext(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetGLXContext);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the `GLXFBConfig` of the specified window's `GLXWindow`.
    ///
    ///  @param[in] window The window whose `GLXWindow` to query.
    ///  @param[out] config The `GLXFBConfig` of the window `GLXWindow`, if available.
    ///  @return `GLFW_TRUE` if successful, or `GLFW_FALSE` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_WINDOW_CONTEXT and @ref GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @remark `GLXFBConfig` is an opaque type.  Unlike other GLFW functions, the
    ///  @p config out parameter is not cleared on error, as core GLX does not define
    ///  any invalid value.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.5
    ///
    ///  @ingroup native
    public int getGLXFBConfig(
        @Nullable GLFWwindow window,
        @Nullable PointerPtr config
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetGLXFBConfig);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (config != null ? config.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `GLXWindow` of the specified window.
    ///
    ///  @return The `GLXWindow` of the specified window, or `None` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_WINDOW_CONTEXT and @ref GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup native
    public @NativeType("GLXWindow") long getGLXWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetGLXWindow);
        try {
            Object t = hFunction.invoke(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
            return (NativeLayout.C_LONG_SIZE == 4) ? (int) t : (long) t;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the human-readable gamepad name for the specified joystick.
    ///
    ///  This function returns the human-readable name of the gamepad from the
    ///  gamepad mapping assigned to the specified joystick.
    ///
    ///  If the specified joystick is not present or does not have a gamepad mapping
    ///  this function will return `NULL` but will not generate an error.  Call
    ///  @ref glfwJoystickPresent to check whether it is present regardless of
    ///  whether it has a mapping.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @return The UTF-8 encoded name of the gamepad, or `NULL` if the
    ///  joystick is not present, does not have a mapping or an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref GLFW_INVALID_ENUM.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified joystick is
    ///  disconnected, the gamepad mappings are updated or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref gamepad
    ///  @sa @ref glfwJoystickIsGamepad
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public @Nullable BytePtr getGamepadName(
        int jid
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetGamepadName);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                jid
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the state of the specified joystick remapped as a gamepad.
    ///
    ///  This function retrieves the state of the specified joystick remapped to
    ///  an Xbox-like gamepad.
    ///
    ///  If the specified joystick is not present or does not have a gamepad mapping
    ///  this function will return `GLFW_FALSE` but will not generate an error.  Call
    ///  @ref glfwJoystickPresent to check whether it is present regardless of
    ///  whether it has a mapping.
    ///
    ///  The Guide button may not be available for input as it is often hooked by the
    ///  system or the Steam client.
    ///
    ///  Not all devices have all the buttons or axes provided by @ref
    ///  GLFWgamepadstate.  Unavailable buttons and axes will always report
    ///  `GLFW_RELEASE` and 0.0 respectively.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @param[out] state The gamepad input state of the joystick.
    ///  @return `GLFW_TRUE` if successful, or `GLFW_FALSE` if no joystick is
    ///  connected, it has no gamepad mapping or an [error](@ref error_handling)
    ///  occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref gamepad
    ///  @sa @ref glfwUpdateGamepadMappings
    ///  @sa @ref glfwJoystickIsGamepad
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public int getGamepadState(
        int jid,
        @Nullable @Pointer IGLFWgamepadstate state
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetGamepadState);
        try {
            return (int) hFunction.invokeExact(
                jid,
                (MemorySegment) (state != null ? state.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the current gamma ramp for the specified monitor.
    ///
    ///  This function returns the current gamma ramp of the specified monitor.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @return The current gamma ramp, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref GLFW_PLATFORM_ERROR
    ///  and @ref GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark @wayland Gamma handling is a privileged protocol, this function
    ///  will thus never be implemented and emits @ref GLFW_FEATURE_UNAVAILABLE while
    ///  returning `NULL`.
    ///
    ///  @pointer_lifetime The returned structure and its arrays are allocated and
    ///  freed by GLFW.  You should not free them yourself.  They are valid until the
    ///  specified monitor is disconnected, this function is called again for that
    ///  monitor or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_gamma
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public @Nullable @Pointer IGLFWgammaramp getGammaRamp(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetGammaRamp);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWgammaramp(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the value of an input option for the specified window.
    ///
    ///  This function returns the value of an input option for the specified window.
    ///  The mode must be one of @ref GLFW_CURSOR, @ref GLFW_STICKY_KEYS,
    ///  @ref GLFW_STICKY_MOUSE_BUTTONS, @ref GLFW_LOCK_KEY_MODS or
    ///  @ref GLFW_RAW_MOUSE_MOTION.
    ///
    ///  @param[in] window The window to query.
    ///  @param[in] mode One of `GLFW_CURSOR`, `GLFW_STICKY_KEYS`,
    ///  `GLFW_STICKY_MOUSE_BUTTONS`, `GLFW_LOCK_KEY_MODS` or
    ///  `GLFW_RAW_MOUSE_MOTION`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref glfwSetInputMode
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup input
    public int getInputMode(
        @Nullable GLFWwindow window,
        int mode
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetInputMode);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                mode
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the address of the specified Vulkan instance function.
    ///
    ///  This function returns the address of the specified Vulkan core or extension
    ///  function for the specified instance.  If instance is set to `NULL` it can
    ///  return any function exported from the Vulkan loader, including at least the
    ///  following functions:
    ///
    ///  - `vkEnumerateInstanceExtensionProperties`
    ///  - `vkEnumerateInstanceLayerProperties`
    ///  - `vkCreateInstance`
    ///  - `vkGetInstanceProcAddr`
    ///
    ///  If Vulkan is not available on the machine, this function returns `NULL` and
    ///  generates a @ref GLFW_API_UNAVAILABLE error.  Call @ref glfwVulkanSupported
    ///  to check whether Vulkan is at least minimally available.
    ///
    ///  This function is equivalent to calling `vkGetInstanceProcAddr` with
    ///  a platform-specific query of the Vulkan loader as a fallback.
    ///
    ///  @param[in] instance The Vulkan instance to query, or `NULL` to retrieve
    ///  functions related to instance creation.
    ///  @param[in] procname The ASCII encoded name of the function.
    ///  @return The address of the function, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_API_UNAVAILABLE.
    ///
    ///  @pointer_lifetime The returned function pointer is valid until the library
    ///  is terminated.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref vulkan_proc
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup vulkan
    public @Pointer(comment="GLFWvkproc") @NotNull MemorySegment getInstanceProcAddress(
        @Nullable VkInstance instance,
        @Nullable BytePtr procname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetInstanceProcAddress);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (instance != null ? instance.segment() : MemorySegment.NULL),
                (MemorySegment) (procname != null ? procname.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the values of all axes of the specified joystick.
    ///
    ///  This function returns the values of all axes of the specified joystick.
    ///  Each element in the array is a value between -1.0 and 1.0.
    ///
    ///  If the specified joystick is not present this function will return `NULL`
    ///  but will not generate an error.  This can be used instead of first calling
    ///  @ref glfwJoystickPresent.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @param[out] count Where to store the number of axis values in the returned
    ///  array.  This is set to zero if the joystick is not present or an error
    ///  occurred.
    ///  @return An array of axis values, or `NULL` if the joystick is not present or
    ///  an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned array is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified joystick is
    ///  disconnected or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref joystick_axis
    ///
    ///  @since Added in version 3.0.  Replaces `glfwGetJoystickPos`.
    ///
    ///  @ingroup input
    public @Nullable FloatPtr getJoystickAxes(
        int jid,
        @Nullable IntPtr count
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetJoystickAxes);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                jid,
                (MemorySegment) (count != null ? count.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new FloatPtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the state of all buttons of the specified joystick.
    ///
    ///  This function returns the state of all buttons of the specified joystick.
    ///  Each element in the array is either `GLFW_PRESS` or `GLFW_RELEASE`.
    ///
    ///  For backward compatibility with earlier versions that did not have @ref
    ///  glfwGetJoystickHats, the button array also includes all hats, each
    ///  represented as four buttons.  The hats are in the same order as returned by
    ///  __glfwGetJoystickHats__ and are in the order _up_, _right_, _down_ and
    ///  _left_.  To disable these extra buttons, set the @ref
    ///  GLFW_JOYSTICK_HAT_BUTTONS init hint before initialization.
    ///
    ///  If the specified joystick is not present this function will return `NULL`
    ///  but will not generate an error.  This can be used instead of first calling
    ///  @ref glfwJoystickPresent.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @param[out] count Where to store the number of button states in the returned
    ///  array.  This is set to zero if the joystick is not present or an error
    ///  occurred.
    ///  @return An array of button states, or `NULL` if the joystick is not present
    ///  or an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned array is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified joystick is
    ///  disconnected or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref joystick_button
    ///
    ///  @since Added in version 2.2.
    ///  @glfw3 Changed to return a dynamic array.
    ///
    ///  @ingroup input
    public @Nullable BytePtr getJoystickButtons(
        int jid,
        @Nullable IntPtr count
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetJoystickButtons);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                jid,
                (MemorySegment) (count != null ? count.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the SDL compatible GUID of the specified joystick.
    ///
    ///  This function returns the SDL compatible GUID, as a UTF-8 encoded
    ///  hexadecimal string, of the specified joystick.  The returned string is
    ///  allocated and freed by GLFW.  You should not free it yourself.
    ///
    ///  The GUID is what connects a joystick to a gamepad mapping.  A connected
    ///  joystick will always have a GUID even if there is no gamepad mapping
    ///  assigned to it.
    ///
    ///  If the specified joystick is not present this function will return `NULL`
    ///  but will not generate an error.  This can be used instead of first calling
    ///  @ref glfwJoystickPresent.
    ///
    ///  The GUID uses the format introduced in SDL 2.0.5.  This GUID tries to
    ///  uniquely identify the make and model of a joystick but does not identify
    ///  a specific unit, e.g. all wired Xbox 360 controllers will have the same
    ///  GUID on that platform.  The GUID for a unit may vary between platforms
    ///  depending on what hardware information the platform specific APIs provide.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @return The UTF-8 encoded GUID of the joystick, or `NULL` if the joystick
    ///  is not present or an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified joystick is
    ///  disconnected or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref gamepad
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public @Nullable BytePtr getJoystickGUID(
        int jid
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetJoystickGUID);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                jid
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the state of all hats of the specified joystick.
    ///
    ///  This function returns the state of all hats of the specified joystick.
    ///  Each element in the array is one of the following values:
    ///
    ///  Name                  | Value
    ///  ----                  | -----
    ///  `GLFW_HAT_CENTERED`   | 0
    ///  `GLFW_HAT_UP`         | 1
    ///  `GLFW_HAT_RIGHT`      | 2
    ///  `GLFW_HAT_DOWN`       | 4
    ///  `GLFW_HAT_LEFT`       | 8
    ///  `GLFW_HAT_RIGHT_UP`   | `GLFW_HAT_RIGHT` \| `GLFW_HAT_UP`
    ///  `GLFW_HAT_RIGHT_DOWN` | `GLFW_HAT_RIGHT` \| `GLFW_HAT_DOWN`
    ///  `GLFW_HAT_LEFT_UP`    | `GLFW_HAT_LEFT` \| `GLFW_HAT_UP`
    ///  `GLFW_HAT_LEFT_DOWN`  | `GLFW_HAT_LEFT` \| `GLFW_HAT_DOWN`
    ///
    ///  The diagonal directions are bitwise combinations of the primary (up, right,
    ///  down and left) directions and you can test for these individually by ANDing
    ///  it with the corresponding direction.
    ///
    ///  @code
    ///  if (hats[2] & GLFW_HAT_RIGHT)
    ///  {
    ///      // State of hat 2 could be right-up, right or right-down
    ///  }
    ///  @endcode
    ///
    ///  If the specified joystick is not present this function will return `NULL`
    ///  but will not generate an error.  This can be used instead of first calling
    ///  @ref glfwJoystickPresent.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @param[out] count Where to store the number of hat states in the returned
    ///  array.  This is set to zero if the joystick is not present or an error
    ///  occurred.
    ///  @return An array of hat states, or `NULL` if the joystick is not present
    ///  or an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned array is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified joystick is
    ///  disconnected, this function is called again for that joystick or the library
    ///  is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref joystick_hat
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public @Nullable BytePtr getJoystickHats(
        int jid,
        @Nullable IntPtr count
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetJoystickHats);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                jid,
                (MemorySegment) (count != null ? count.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the name of the specified joystick.
    ///
    ///  This function returns the name, encoded as UTF-8, of the specified joystick.
    ///  The returned string is allocated and freed by GLFW.  You should not free it
    ///  yourself.
    ///
    ///  If the specified joystick is not present this function will return `NULL`
    ///  but will not generate an error.  This can be used instead of first calling
    ///  @ref glfwJoystickPresent.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @return The UTF-8 encoded name of the joystick, or `NULL` if the joystick
    ///  is not present or an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified joystick is
    ///  disconnected or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref joystick_name
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup input
    public @Nullable BytePtr getJoystickName(
        int jid
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetJoystickName);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                jid
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the user pointer of the specified joystick.
    ///
    ///  This function returns the current value of the user-defined pointer of the
    ///  specified joystick.  The initial value is `NULL`.
    ///
    ///  This function may be called from the joystick callback, even for a joystick
    ///  that is being disconnected.
    ///
    ///  @param[in] jid The joystick whose pointer to return.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref joystick_userptr
    ///  @sa @ref glfwSetJoystickUserPointer
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public @Pointer(comment="void*") @NotNull MemorySegment getJoystickUserPointer(
        int jid
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetJoystickUserPointer);
        try {
            return (MemorySegment) hFunction.invokeExact(
                jid
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the last reported state of a keyboard key for the specified
    ///  window.
    ///
    ///  This function returns the last state reported for the specified key to the
    ///  specified window.  The returned state is one of `GLFW_PRESS` or
    ///  `GLFW_RELEASE`.  The action `GLFW_REPEAT` is only reported to the key callback.
    ///
    ///  If the @ref GLFW_STICKY_KEYS input mode is enabled, this function returns
    ///  `GLFW_PRESS` the first time you call it for a key that was pressed, even if
    ///  that key has already been released.
    ///
    ///  The key functions deal with physical keys, with [key tokens](@ref keys)
    ///  named after their use on the standard US keyboard layout.  If you want to
    ///  input text, use the Unicode character callback instead.
    ///
    ///  The [modifier key bit masks](@ref mods) are not key tokens and cannot be
    ///  used with this function.
    ///
    ///  __Do not use this function__ to implement [text input](@ref input_char).
    ///
    ///  @param[in] window The desired window.
    ///  @param[in] key The desired [keyboard key](@ref keys).  `GLFW_KEY_UNKNOWN` is
    ///  not a valid key for this function.
    ///  @return One of `GLFW_PRESS` or `GLFW_RELEASE`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref input_key
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup input
    public int getKey(
        @Nullable GLFWwindow window,
        int key
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetKey);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                key
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the layout-specific name of the specified printable key.
    ///
    ///  This function returns the name of the specified printable key, encoded as
    ///  UTF-8.  This is typically the character that key would produce without any
    ///  modifier keys, intended for displaying key bindings to the user.  For dead
    ///  keys, it is typically the diacritic it would add to a character.
    ///
    ///  __Do not use this function__ for [text input](@ref input_char).  You will
    ///  break text input for many languages even if it happens to work for yours.
    ///
    ///  If the key is `GLFW_KEY_UNKNOWN`, the scancode is used to identify the key,
    ///  otherwise the scancode is ignored.  If you specify a non-printable key, or
    ///  `GLFW_KEY_UNKNOWN` and a scancode that maps to a non-printable key, this
    ///  function returns `NULL` but does not emit an error.
    ///
    ///  This behavior allows you to always pass in the arguments in the
    ///  [key callback](@ref input_key) without modification.
    ///
    ///  The printable keys are:
    ///  - `GLFW_KEY_APOSTROPHE`
    ///  - `GLFW_KEY_COMMA`
    ///  - `GLFW_KEY_MINUS`
    ///  - `GLFW_KEY_PERIOD`
    ///  - `GLFW_KEY_SLASH`
    ///  - `GLFW_KEY_SEMICOLON`
    ///  - `GLFW_KEY_EQUAL`
    ///  - `GLFW_KEY_LEFT_BRACKET`
    ///  - `GLFW_KEY_RIGHT_BRACKET`
    ///  - `GLFW_KEY_BACKSLASH`
    ///  - `GLFW_KEY_WORLD_1`
    ///  - `GLFW_KEY_WORLD_2`
    ///  - `GLFW_KEY_0` to `GLFW_KEY_9`
    ///  - `GLFW_KEY_A` to `GLFW_KEY_Z`
    ///  - `GLFW_KEY_KP_0` to `GLFW_KEY_KP_9`
    ///  - `GLFW_KEY_KP_DECIMAL`
    ///  - `GLFW_KEY_KP_DIVIDE`
    ///  - `GLFW_KEY_KP_MULTIPLY`
    ///  - `GLFW_KEY_KP_SUBTRACT`
    ///  - `GLFW_KEY_KP_ADD`
    ///  - `GLFW_KEY_KP_EQUAL`
    ///
    ///  Names for printable keys depend on keyboard layout, while names for
    ///  non-printable keys are the same across layouts but depend on the application
    ///  language and should be localized along with other user interface text.
    ///
    ///  @param[in] key The key to query, or `GLFW_KEY_UNKNOWN`.
    ///  @param[in] scancode The scancode of the key to query.
    ///  @return The UTF-8 encoded, layout-specific name of the key, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_VALUE, @ref GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark The contents of the returned string may change when a keyboard
    ///  layout change event is received.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref input_key_name
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup input
    public @Nullable BytePtr getKeyName(
        int key,
        int scancode
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetKeyName);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                key,
                scancode
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the platform-specific scancode of the specified key.
    ///
    ///  This function returns the platform-specific scancode of the specified key.
    ///
    ///  If the specified [key token](@ref keys) corresponds to a physical key not
    ///  supported on the current platform then this method will return `-1`.
    ///  Calling this function with anything other than a key token will return `-1`
    ///  and generate a @ref GLFW_INVALID_ENUM error.
    ///
    ///  @param[in] key Any [key token](@ref keys).
    ///  @return The platform-specific scancode for the key, or `-1` if the key is
    ///  not supported on the current platform or an [error](@ref error_handling)
    ///  occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref input_key
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public int getKeyScancode(
        int key
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetKeyScancode);
        try {
            return (int) hFunction.invokeExact(
                key
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the content scale for the specified monitor.
    ///
    ///  This function retrieves the content scale for the specified monitor.  The
    ///  content scale is the ratio between the current DPI and the platform's
    ///  default DPI.  This is especially important for text and any UI elements.  If
    ///  the pixel dimensions of your UI scaled by this look appropriate on your
    ///  machine then it should appear at a reasonable size on other machines
    ///  regardless of their DPI and scaling settings.  This relies on the system DPI
    ///  and scaling settings being somewhat correct.
    ///
    ///  The content scale may depend on both the monitor resolution and pixel
    ///  density and on user settings.  It may be very different from the raw DPI
    ///  calculated from the physical size and current resolution.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @param[out] xscale Where to store the x-axis content scale, or `NULL`.
    ///  @param[out] yscale Where to store the y-axis content scale, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @wayland Fractional scaling information is not yet available for
    ///  monitors, so this function only returns integer content scales.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_scale
    ///  @sa @ref glfwGetWindowContentScale
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup monitor
    public void getMonitorContentScale(
        @Nullable GLFWmonitor monitor,
        @Nullable FloatPtr xscale,
        @Nullable FloatPtr yscale
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMonitorContentScale);
        try {
            hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                (MemorySegment) (xscale != null ? xscale.segment() : MemorySegment.NULL),
                (MemorySegment) (yscale != null ? yscale.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the name of the specified monitor.
    ///
    ///  This function returns a human-readable name, encoded as UTF-8, of the
    ///  specified monitor.  The name typically reflects the make and model of the
    ///  monitor and is not guaranteed to be unique among the connected monitors.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @return The UTF-8 encoded name of the monitor, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified monitor is
    ///  disconnected or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_properties
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public @Nullable BytePtr getMonitorName(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMonitorName);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the physical size of the monitor.
    ///
    ///  This function returns the size, in millimetres, of the display area of the
    ///  specified monitor.
    ///
    ///  Some platforms do not provide accurate monitor size information, either
    ///  because the monitor [EDID][] data is incorrect or because the driver does
    ///  not report it accurately.
    ///
    ///  [EDID]: https://en.wikipedia.org/wiki/Extended_display_identification_data
    ///
    ///  Any or all of the size arguments may be `NULL`.  If an error occurs, all
    ///  non-`NULL` size arguments will be set to zero.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @param[out] widthMM Where to store the width, in millimetres, of the
    ///  monitor's display area, or `NULL`.
    ///  @param[out] heightMM Where to store the height, in millimetres, of the
    ///  monitor's display area, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @remark @win32 On Windows 8 and earlier the physical size is calculated from
    ///  the current resolution and system DPI instead of querying the monitor EDID data.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_properties
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public void getMonitorPhysicalSize(
        @Nullable GLFWmonitor monitor,
        @Nullable IntPtr widthMM,
        @Nullable IntPtr heightMM
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMonitorPhysicalSize);
        try {
            hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                (MemorySegment) (widthMM != null ? widthMM.segment() : MemorySegment.NULL),
                (MemorySegment) (heightMM != null ? heightMM.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the position of the monitor's viewport on the virtual screen.
    ///
    ///  This function returns the position, in screen coordinates, of the upper-left
    ///  corner of the specified monitor.
    ///
    ///  Any or all of the position arguments may be `NULL`.  If an error occurs, all
    ///  non-`NULL` position arguments will be set to zero.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @param[out] xpos Where to store the monitor x-coordinate, or `NULL`.
    ///  @param[out] ypos Where to store the monitor y-coordinate, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_properties
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public void getMonitorPos(
        @Nullable GLFWmonitor monitor,
        @Nullable IntPtr xpos,
        @Nullable IntPtr ypos
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMonitorPos);
        try {
            hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                (MemorySegment) (xpos != null ? xpos.segment() : MemorySegment.NULL),
                (MemorySegment) (ypos != null ? ypos.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the user pointer of the specified monitor.
    ///
    ///  This function returns the current value of the user-defined pointer of the
    ///  specified monitor.  The initial value is `NULL`.
    ///
    ///  This function may be called from the monitor callback, even for a monitor
    ///  that is being disconnected.
    ///
    ///  @param[in] monitor The monitor whose pointer to return.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref monitor_userptr
    ///  @sa @ref glfwSetMonitorUserPointer
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup monitor
    public @Pointer(comment="void*") @NotNull MemorySegment getMonitorUserPointer(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMonitorUserPointer);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the work area of the monitor.
    ///
    ///  This function returns the position, in screen coordinates, of the upper-left
    ///  corner of the work area of the specified monitor along with the work area
    ///  size in screen coordinates. The work area is defined as the area of the
    ///  monitor not occluded by the window system task bar where present. If no
    ///  task bar exists then the work area is the monitor resolution in screen
    ///  coordinates.
    ///
    ///  Any or all of the position and size arguments may be `NULL`.  If an error
    ///  occurs, all non-`NULL` position and size arguments will be set to zero.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @param[out] xpos Where to store the monitor x-coordinate, or `NULL`.
    ///  @param[out] ypos Where to store the monitor y-coordinate, or `NULL`.
    ///  @param[out] width Where to store the monitor width, or `NULL`.
    ///  @param[out] height Where to store the monitor height, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_workarea
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup monitor
    public void getMonitorWorkarea(
        @Nullable GLFWmonitor monitor,
        @Nullable IntPtr xpos,
        @Nullable IntPtr ypos,
        @Nullable IntPtr width,
        @Nullable IntPtr height
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMonitorWorkarea);
        try {
            hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                (MemorySegment) (xpos != null ? xpos.segment() : MemorySegment.NULL),
                (MemorySegment) (ypos != null ? ypos.segment() : MemorySegment.NULL),
                (MemorySegment) (width != null ? width.segment() : MemorySegment.NULL),
                (MemorySegment) (height != null ? height.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the currently connected monitors.
    ///
    ///  This function returns an array of handles for all currently connected
    ///  monitors.  The primary monitor is always first in the returned array.  If no
    ///  monitors were found, this function returns `NULL`.
    ///
    ///  @param[out] count Where to store the number of monitors in the returned
    ///  array.  This is set to zero if an error occurred.
    ///  @return An array of monitor handles, or `NULL` if no monitors were found or
    ///  if an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @pointer_lifetime The returned array is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is guaranteed to be valid only until the
    ///  monitor configuration changes or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_monitors
    ///  @sa @ref monitor_event
    ///  @sa @ref glfwGetPrimaryMonitor
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public @Nullable @Pointer GLFWmonitor.Ptr getMonitors(
        @Nullable IntPtr count
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMonitors);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (count != null ? count.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWmonitor.Ptr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the last reported state of a mouse button for the specified
    ///  window.
    ///
    ///  This function returns the last state reported for the specified mouse button
    ///  to the specified window.  The returned state is one of `GLFW_PRESS` or
    ///  `GLFW_RELEASE`.
    ///
    ///  If the @ref GLFW_STICKY_MOUSE_BUTTONS input mode is enabled, this function
    ///  returns `GLFW_PRESS` the first time you call it for a mouse button that was
    ///  pressed, even if that mouse button has already been released.
    ///
    ///  @param[in] window The desired window.
    ///  @param[in] button The desired [mouse button](@ref buttons).
    ///  @return One of `GLFW_PRESS` or `GLFW_RELEASE`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref input_mouse_button
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup input
    public int getMouseButton(
        @Nullable GLFWwindow window,
        int button
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetMouseButton);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                button
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `NSOpenGLContext` of the specified window.
    ///
    ///  @return The `NSOpenGLContext` of the specified window, or `nil` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_UNAVAILABLE and @ref GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="id") @NotNull MemorySegment getNSGLContext(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetNSGLContext);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the color buffer associated with the specified window.
    ///
    ///  @param[in] window The window whose color buffer to retrieve.
    ///  @param[out] width Where to store the width of the color buffer, or `NULL`.
    ///  @param[out] height Where to store the height of the color buffer, or `NULL`.
    ///  @param[out] format Where to store the OSMesa pixel format of the color
    ///  buffer, or `NULL`.
    ///  @param[out] buffer Where to store the address of the color buffer, or
    ///  `NULL`.
    ///  @return `GLFW_TRUE` if successful, or `GLFW_FALSE` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup native
    public int getOSMesaColorBuffer(
        @Nullable GLFWwindow window,
        @Nullable IntPtr width,
        @Nullable IntPtr height,
        @Nullable IntPtr format,
        @Nullable PointerPtr buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetOSMesaColorBuffer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (width != null ? width.segment() : MemorySegment.NULL),
                (MemorySegment) (height != null ? height.segment() : MemorySegment.NULL),
                (MemorySegment) (format != null ? format.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `OSMesaContext` of the specified window.
    ///
    ///  @return The `OSMesaContext` of the specified window, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup native
    public @Pointer(comment="OSMesaContext") @NotNull MemorySegment getOSMesaContext(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetOSMesaContext);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the depth buffer associated with the specified window.
    ///
    ///  @param[in] window The window whose depth buffer to retrieve.
    ///  @param[out] width Where to store the width of the depth buffer, or `NULL`.
    ///  @param[out] height Where to store the height of the depth buffer, or `NULL`.
    ///  @param[out] bytesPerValue Where to store the number of bytes per depth
    ///  buffer element, or `NULL`.
    ///  @param[out] buffer Where to store the address of the depth buffer, or
    ///  `NULL`.
    ///  @return `GLFW_TRUE` if successful, or `GLFW_FALSE` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup native
    public int getOSMesaDepthBuffer(
        @Nullable GLFWwindow window,
        @Nullable IntPtr width,
        @Nullable IntPtr height,
        @Nullable IntPtr bytesPerValue,
        @Nullable PointerPtr buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetOSMesaDepthBuffer);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (width != null ? width.segment() : MemorySegment.NULL),
                (MemorySegment) (height != null ? height.segment() : MemorySegment.NULL),
                (MemorySegment) (bytesPerValue != null ? bytesPerValue.segment() : MemorySegment.NULL),
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns whether the specified queue family can present images.
    ///
    ///  This function returns whether the specified queue family of the specified
    ///  physical device supports presentation to the platform GLFW was built for.
    ///
    ///  If Vulkan or the required window surface creation instance extensions are
    ///  not available on the machine, or if the specified instance was not created
    ///  with the required extensions, this function returns `GLFW_FALSE` and
    ///  generates a @ref GLFW_API_UNAVAILABLE error.  Call @ref glfwVulkanSupported
    ///  to check whether Vulkan is at least minimally available and @ref
    ///  glfwGetRequiredInstanceExtensions to check what instance extensions are
    ///  required.
    ///
    ///  @param[in] instance The instance that the physical device belongs to.
    ///  @param[in] device The physical device that the queue family belongs to.
    ///  @param[in] queuefamily The index of the queue family to query.
    ///  @return `GLFW_TRUE` if the queue family supports presentation, or
    ///  `GLFW_FALSE` otherwise.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_API_UNAVAILABLE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @macos This function currently always returns `GLFW_TRUE`, as the
    ///  `VK_MVK_macos_surface` and `VK_EXT_metal_surface` extensions do not provide
    ///  a `vkGetPhysicalDevice*PresentationSupport` type function.
    ///
    ///  @thread_safety This function may be called from any thread.  For
    ///  synchronization details of Vulkan objects, see the Vulkan specification.
    ///
    ///  @sa @ref vulkan_present
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup vulkan
    public int getPhysicalDevicePresentationSupport(
        @Nullable VkInstance instance,
        @Nullable VkPhysicalDevice device,
        @Unsigned int queuefamily
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetPhysicalDevicePresentationSupport);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (instance != null ? instance.segment() : MemorySegment.NULL),
                (MemorySegment) (device != null ? device.segment() : MemorySegment.NULL),
                queuefamily
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the currently selected platform.
    ///
    ///  This function returns the platform that was selected during initialization.  The
    ///  returned value will be one of `GLFW_PLATFORM_WIN32`, `GLFW_PLATFORM_COCOA`,
    ///  `GLFW_PLATFORM_WAYLAND`, `GLFW_PLATFORM_X11` or `GLFW_PLATFORM_NULL`.
    ///
    ///  @return The currently selected platform, or zero if an error occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref platform
    ///  @sa @ref glfwPlatformSupported
    ///
    ///  @since Added in version 3.4.
    ///
    ///  @ingroup init
    public int getPlatform() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetPlatform);
        try {
            return (int) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the primary monitor.
    ///
    ///  This function returns the primary monitor.  This is usually the monitor
    ///  where elements like the task bar or global menu bar are located.
    ///
    ///  @return The primary monitor, or `NULL` if no monitors were found or if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @remark The primary monitor is always first in the array returned by @ref
    ///  glfwGetMonitors.
    ///
    ///  @sa @ref monitor_monitors
    ///  @sa @ref glfwGetMonitors
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public @Nullable GLFWmonitor getPrimaryMonitor() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetPrimaryMonitor);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWmonitor(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the address of the specified function for the current
    ///  context.
    ///
    ///  This function returns the address of the specified OpenGL or OpenGL ES
    ///  [core or extension function](@ref context_glext), if it is supported
    ///  by the current context.
    ///
    ///  A context must be current on the calling thread.  Calling this function
    ///  without a current context will cause a @ref GLFW_NO_CURRENT_CONTEXT error.
    ///
    ///  This function does not apply to Vulkan.  If you are rendering with Vulkan,
    ///  see @ref glfwGetInstanceProcAddress, `vkGetInstanceProcAddr` and
    ///  `vkGetDeviceProcAddr` instead.
    ///
    ///  @param[in] procname The ASCII encoded name of the function.
    ///  @return The address of the function, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_CURRENT_CONTEXT and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark The address of a given function is not guaranteed to be the same
    ///  between contexts.
    ///
    ///  @remark This function may return a non-`NULL` address despite the
    ///  associated version or extension not being available.  Always check the
    ///  context version or extension string first.
    ///
    ///  @pointer_lifetime The returned function pointer is valid until the context
    ///  is destroyed or the library is terminated.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref context_glext
    ///  @sa @ref glfwExtensionSupported
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup context
    public @Pointer(comment="GLFWglproc") @NotNull MemorySegment getProcAddress(
        @Nullable BytePtr procname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetProcAddress);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (procname != null ? procname.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the Vulkan instance extensions required by GLFW.
    ///
    ///  This function returns an array of names of Vulkan instance extensions required
    ///  by GLFW for creating Vulkan surfaces for GLFW windows.  If successful, the
    ///  list will always contain `VK_KHR_surface`, so if you don't require any
    ///  additional extensions you can pass this list directly to the
    ///  `VkInstanceCreateInfo` struct.
    ///
    ///  If Vulkan is not available on the machine, this function returns `NULL` and
    ///  generates a @ref GLFW_API_UNAVAILABLE error.  Call @ref glfwVulkanSupported
    ///  to check whether Vulkan is at least minimally available.
    ///
    ///  If Vulkan is available but no set of extensions allowing window surface
    ///  creation was found, this function returns `NULL`.  You may still use Vulkan
    ///  for off-screen rendering and compute work.
    ///
    ///  @param[out] count Where to store the number of extensions in the returned
    ///  array.  This is set to zero if an error occurred.
    ///  @return An array of ASCII encoded extension names, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_API_UNAVAILABLE.
    ///
    ///  @remark Additional extensions may be required by future versions of GLFW.
    ///  You should check if any extensions you wish to enable are already in the
    ///  returned array, as it is an error to specify an extension more than once in
    ///  the `VkInstanceCreateInfo` struct.
    ///
    ///  @pointer_lifetime The returned array is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is guaranteed to be valid only until the
    ///  library is terminated.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref vulkan_ext
    ///  @sa @ref glfwCreateWindowSurface
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup vulkan
    public @Nullable PointerPtr getRequiredInstanceExtensions(
        @Nullable @Unsigned IntPtr count
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetRequiredInstanceExtensions);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (count != null ? count.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new PointerPtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the GLFW time.
    ///
    ///  This function returns the current GLFW time, in seconds.  Unless the time
    ///  has been set using @ref glfwSetTime it measures time elapsed since GLFW was
    ///  initialized.
    ///
    ///  This function and @ref glfwSetTime are helper functions on top of @ref
    ///  glfwGetTimerFrequency and @ref glfwGetTimerValue.
    ///
    ///  The resolution of the timer is system dependent, but is usually on the order
    ///  of a few micro- or nanoseconds.  It uses the highest-resolution monotonic
    ///  time source on each operating system.
    ///
    ///  @return The current time, in seconds, or zero if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Reading and
    ///  writing of the internal base time is not atomic, so it needs to be
    ///  externally synchronized with calls to @ref glfwSetTime.
    ///
    ///  @sa @ref time
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup input
    public double getTime() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetTime);
        try {
            return (double) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the frequency, in Hz, of the raw timer.
    ///
    ///  This function returns the frequency, in Hz, of the raw timer.
    ///
    ///  @return The frequency of the timer, in Hz, or zero if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref time
    ///  @sa @ref glfwGetTimerValue
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup input
    public @Unsigned long getTimerFrequency() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetTimerFrequency);
        try {
            return (long) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the current value of the raw timer.
    ///
    ///  This function returns the current value of the raw timer, measured in
    ///  1&nbsp;/&nbsp;frequency seconds.  To get the frequency, call @ref
    ///  glfwGetTimerFrequency.
    ///
    ///  @return The value of the timer, or zero if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref time
    ///  @sa @ref glfwGetTimerFrequency
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup input
    public @Unsigned long getTimerValue() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetTimerValue);
        try {
            return (long) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the version of the GLFW library.
    ///
    ///  This function retrieves the major, minor and revision numbers of the GLFW
    ///  library.  It is intended for when you are using GLFW as a shared library and
    ///  want to ensure that you are using the minimum required version.
    ///
    ///  Any or all of the version arguments may be `NULL`.
    ///
    ///  @param[out] major Where to store the major version number, or `NULL`.
    ///  @param[out] minor Where to store the minor version number, or `NULL`.
    ///  @param[out] rev Where to store the revision number, or `NULL`.
    ///
    ///  @errors None.
    ///
    ///  @remark This function may be called before @ref glfwInit.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref intro_version
    ///  @sa @ref glfwGetVersionString
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup init
    public void getVersion(
        @Nullable IntPtr major,
        @Nullable IntPtr minor,
        @Nullable IntPtr rev
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetVersion);
        try {
            hFunction.invokeExact(
                (MemorySegment) (major != null ? major.segment() : MemorySegment.NULL),
                (MemorySegment) (minor != null ? minor.segment() : MemorySegment.NULL),
                (MemorySegment) (rev != null ? rev.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns a string describing the compile-time configuration.
    ///
    ///  This function returns the compile-time generated
    ///  [version string](@ref intro_version_string) of the GLFW library binary.  It describes
    ///  the version, platforms, compiler and any platform or operating system specific
    ///  compile-time options.  It should not be confused with the OpenGL or OpenGL ES version
    ///  string, queried with `glGetString`.
    ///
    ///  __Do not use the version string__ to parse the GLFW library version.  The
    ///  @ref glfwGetVersion function provides the version of the running library
    ///  binary in numerical format.
    ///
    ///  __Do not use the version string__ to parse what platforms are supported.  The @ref
    ///  glfwPlatformSupported function lets you query platform support.
    ///
    ///  @return The ASCII encoded GLFW version string.
    ///
    ///  @errors None.
    ///
    ///  @remark This function may be called before @ref glfwInit.
    ///
    ///  @pointer_lifetime The returned string is static and compile-time generated.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref intro_version
    ///  @sa @ref glfwGetVersion
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup init
    public @Nullable BytePtr getVersionString() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetVersionString);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the current mode of the specified monitor.
    ///
    ///  This function returns the current video mode of the specified monitor.  If
    ///  you have created a full screen window for that monitor, the return value
    ///  will depend on whether that window is iconified.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @return The current mode of the monitor, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned array is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified monitor is
    ///  disconnected or the library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_modes
    ///  @sa @ref glfwGetVideoModes
    ///
    ///  @since Added in version 3.0.  Replaces `glfwGetDesktopMode`.
    ///
    ///  @ingroup monitor
    public @Nullable @Pointer IGLFWvidmode getVideoMode(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetVideoMode);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWvidmode(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the available video modes for the specified monitor.
    ///
    ///  This function returns an array of all video modes supported by the specified
    ///  monitor.  The returned array is sorted in ascending order, first by color
    ///  bit depth (the sum of all channel depths), then by resolution area (the
    ///  product of width and height), then resolution width and finally by refresh
    ///  rate.
    ///
    ///  @param[in] monitor The monitor to query.
    ///  @param[out] count Where to store the number of video modes in the returned
    ///  array.  This is set to zero if an error occurred.
    ///  @return An array of video modes, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned array is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the specified monitor is
    ///  disconnected, this function is called again for that monitor or the library
    ///  is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_modes
    ///  @sa @ref glfwGetVideoMode
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Changed to return an array of modes for a specific monitor.
    ///
    ///  @ingroup monitor
    public @Nullable @Pointer IGLFWvidmode getVideoModes(
        @Nullable GLFWmonitor monitor,
        @Nullable IntPtr count
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetVideoModes);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                (MemorySegment) (count != null ? count.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWvidmode(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `HGLRC` of the specified window.
    ///
    ///  @return The `HGLRC` of the specified window, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_UNAVAILABLE and @ref GLFW_NO_WINDOW_CONTEXT.
    ///
    ///  @remark The `HDC` associated with the window can be queried with the
    ///  [GetDC](https://docs.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-getdc)
    ///  function.
    ///  @code
    ///  HDC dc = GetDC(glfwGetWin32Window(window));
    ///  @endcode
    ///  This DC is private and does not need to be released.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="HGLRC") @NotNull MemorySegment getWGLContext(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWGLContext);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `struct wl_display*` used by GLFW.
    ///
    ///  @return The `struct wl_display*` used by GLFW, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup native
    public @Nullable PointerPtr getWaylandDisplay() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWaylandDisplay);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new PointerPtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `struct wl_output*` of the specified monitor.
    ///
    ///  @return The `struct wl_output*` of the specified monitor, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup native
    public @Pointer(comment="void*") @NotNull MemorySegment getWaylandMonitor(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWaylandMonitor);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the main `struct wl_surface*` of the specified window.
    ///
    ///  @return The main `struct wl_surface*` of the specified window, or `NULL` if
    ///  an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup native
    public @Nullable PointerPtr getWaylandWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWaylandWindow);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new PointerPtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the adapter device name of the specified monitor.
    ///
    ///  @return The UTF-8 encoded adapter device name (for example `\\.\DISPLAY1`)
    ///  of the specified monitor, or `NULL` if an [error](@ref error_handling)
    ///  occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup native
    public @Nullable BytePtr getWin32Adapter(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWin32Adapter);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the display device name of the specified monitor.
    ///
    ///  @return The UTF-8 encoded display device name (for example
    ///  `\\.\DISPLAY1\Monitor0`) of the specified monitor, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup native
    public @Nullable BytePtr getWin32Monitor(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWin32Monitor);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `HWND` of the specified window.
    ///
    ///  @return The `HWND` of the specified window, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @remark The `HDC` associated with the window can be queried with the
    ///  [GetDC](https://docs.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-getdc)
    ///  function.
    ///  @code
    ///  HDC dc = GetDC(glfwGetWin32Window(window));
    ///  @endcode
    ///  This DC is private and does not need to be released.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Pointer(comment="HWND") @NotNull MemorySegment getWin32Window(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWin32Window);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns an attribute of the specified window.
    ///
    ///  This function returns the value of an attribute of the specified window or
    ///  its OpenGL or OpenGL ES context.
    ///
    ///  @param[in] window The window to query.
    ///  @param[in] attrib The [window attribute](@ref window_attribs) whose value to
    ///  return.
    ///  @return The value of the attribute, or zero if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark Framebuffer related hints are not window attributes.  See @ref
    ///  window_attribs_fb for more information.
    ///
    ///  @remark Zero is a valid value for many window and context related
    ///  attributes so you cannot use a return value of zero as an indication of
    ///  errors.  However, this function should not fail as long as it is passed
    ///  valid arguments and the library has been [initialized](@ref intro_init).
    ///
    ///  @remark @wayland The Wayland protocol provides no way to check whether a
    ///  window is iconfied, so @ref GLFW_ICONIFIED always returns `GLFW_FALSE`.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_attribs
    ///  @sa @ref glfwSetWindowAttrib
    ///
    ///  @since Added in version 3.0.  Replaces `glfwGetWindowParam` and
    ///  `glfwGetGLVersion`.
    ///
    ///  @ingroup window
    public int getWindowAttrib(
        @Nullable GLFWwindow window,
        int attrib
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowAttrib);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                attrib
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the content scale for the specified window.
    ///
    ///  This function retrieves the content scale for the specified window.  The
    ///  content scale is the ratio between the current DPI and the platform's
    ///  default DPI.  This is especially important for text and any UI elements.  If
    ///  the pixel dimensions of your UI scaled by this look appropriate on your
    ///  machine then it should appear at a reasonable size on other machines
    ///  regardless of their DPI and scaling settings.  This relies on the system DPI
    ///  and scaling settings being somewhat correct.
    ///
    ///  On platforms where each monitors can have its own content scale, the window
    ///  content scale will depend on which monitor the system considers the window
    ///  to be on.
    ///
    ///  @param[in] window The window to query.
    ///  @param[out] xscale Where to store the x-axis content scale, or `NULL`.
    ///  @param[out] yscale Where to store the y-axis content scale, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_scale
    ///  @sa @ref glfwSetWindowContentScaleCallback
    ///  @sa @ref glfwGetMonitorContentScale
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public void getWindowContentScale(
        @Nullable GLFWwindow window,
        @Nullable FloatPtr xscale,
        @Nullable FloatPtr yscale
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowContentScale);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (xscale != null ? xscale.segment() : MemorySegment.NULL),
                (MemorySegment) (yscale != null ? yscale.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the size of the frame of the window.
    ///
    ///  This function retrieves the size, in screen coordinates, of each edge of the
    ///  frame of the specified window.  This size includes the title bar, if the
    ///  window has one.  The size of the frame may vary depending on the
    ///  [window-related hints](@ref window_hints_wnd) used to create it.
    ///
    ///  Because this function retrieves the size of each window frame edge and not
    ///  the offset along a particular coordinate axis, the retrieved values will
    ///  always be zero or positive.
    ///
    ///  Any or all of the size arguments may be `NULL`.  If an error occurs, all
    ///  non-`NULL` size arguments will be set to zero.
    ///
    ///  @param[in] window The window whose frame size to query.
    ///  @param[out] left Where to store the size, in screen coordinates, of the left
    ///  edge of the window frame, or `NULL`.
    ///  @param[out] top Where to store the size, in screen coordinates, of the top
    ///  edge of the window frame, or `NULL`.
    ///  @param[out] right Where to store the size, in screen coordinates, of the
    ///  right edge of the window frame, or `NULL`.
    ///  @param[out] bottom Where to store the size, in screen coordinates, of the
    ///  bottom edge of the window frame, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_size
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup window
    public void getWindowFrameSize(
        @Nullable GLFWwindow window,
        @Nullable IntPtr left,
        @Nullable IntPtr top,
        @Nullable IntPtr right,
        @Nullable IntPtr bottom
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowFrameSize);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (left != null ? left.segment() : MemorySegment.NULL),
                (MemorySegment) (top != null ? top.segment() : MemorySegment.NULL),
                (MemorySegment) (right != null ? right.segment() : MemorySegment.NULL),
                (MemorySegment) (bottom != null ? bottom.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the monitor that the window uses for full screen mode.
    ///
    ///  This function returns the handle of the monitor that the specified window is
    ///  in full screen on.
    ///
    ///  @param[in] window The window to query.
    ///  @return The monitor, or `NULL` if the window is in windowed mode or an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_monitor
    ///  @sa @ref glfwSetWindowMonitor
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public @Nullable GLFWmonitor getWindowMonitor(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowMonitor);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new GLFWmonitor(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the opacity of the whole window.
    ///
    ///  This function returns the opacity of the window, including any decorations.
    ///
    ///  The opacity (or alpha) value is a positive finite number between zero and
    ///  one, where zero is fully transparent and one is fully opaque.  If the system
    ///  does not support whole window transparency, this function always returns one.
    ///
    ///  The initial opacity value for newly created windows is one.
    ///
    ///  @param[in] window The window to query.
    ///  @return The opacity value of the specified window.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_transparency
    ///  @sa @ref glfwSetWindowOpacity
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public float getWindowOpacity(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowOpacity);
        try {
            return (float) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the position of the content area of the specified window.
    ///
    ///  This function retrieves the position, in screen coordinates, of the
    ///  upper-left corner of the content area of the specified window.
    ///
    ///  Any or all of the position arguments may be `NULL`.  If an error occurs, all
    ///  non-`NULL` position arguments will be set to zero.
    ///
    ///  @param[in] window The window to query.
    ///  @param[out] xpos Where to store the x-coordinate of the upper-left corner of
    ///  the content area, or `NULL`.
    ///  @param[out] ypos Where to store the y-coordinate of the upper-left corner of
    ///  the content area, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_ERROR and @ref GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark @wayland There is no way for an application to retrieve the global
    ///  position of its windows.  This function will emit @ref
    ///  GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_pos
    ///  @sa @ref glfwSetWindowPos
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public void getWindowPos(
        @Nullable GLFWwindow window,
        @Nullable IntPtr xpos,
        @Nullable IntPtr ypos
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowPos);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (xpos != null ? xpos.segment() : MemorySegment.NULL),
                (MemorySegment) (ypos != null ? ypos.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Retrieves the size of the content area of the specified window.
    ///
    ///  This function retrieves the size, in screen coordinates, of the content area
    ///  of the specified window.  If you wish to retrieve the size of the
    ///  framebuffer of the window in pixels, see @ref glfwGetFramebufferSize.
    ///
    ///  Any or all of the size arguments may be `NULL`.  If an error occurs, all
    ///  non-`NULL` size arguments will be set to zero.
    ///
    ///  @param[in] window The window whose size to retrieve.
    ///  @param[out] width Where to store the width, in screen coordinates, of the
    ///  content area, or `NULL`.
    ///  @param[out] height Where to store the height, in screen coordinates, of the
    ///  content area, or `NULL`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_size
    ///  @sa @ref glfwSetWindowSize
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup window
    public void getWindowSize(
        @Nullable GLFWwindow window,
        @Nullable IntPtr width,
        @Nullable IntPtr height
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowSize);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (width != null ? width.segment() : MemorySegment.NULL),
                (MemorySegment) (height != null ? height.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the title of the specified window.
    ///
    ///  This function returns the window title, encoded as UTF-8, of the specified
    ///  window.  This is the title set previously by @ref glfwCreateWindow
    ///  or @ref glfwSetWindowTitle.
    ///
    ///  @param[in] window The window to query.
    ///  @return The UTF-8 encoded window title, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @remark The returned title is currently a copy of the title last set by @ref
    ///  glfwCreateWindow or @ref glfwSetWindowTitle.  It does not include any
    ///  additional text which may be appended by the platform or another program.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW.  You
    ///  should not free it yourself.  It is valid until the next call to @ref
    ///  glfwGetWindowTitle or @ref glfwSetWindowTitle, or until the library is
    ///  terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_title
    ///  @sa @ref glfwSetWindowTitle
    ///
    ///  @since Added in version 3.4.
    ///
    ///  @ingroup window
    public @Nullable BytePtr getWindowTitle(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowTitle);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the user pointer of the specified window.
    ///
    ///  This function returns the current value of the user-defined pointer of the
    ///  specified window.  The initial value is `NULL`.
    ///
    ///  @param[in] window The window whose pointer to return.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref window_userptr
    ///  @sa @ref glfwSetWindowUserPointer
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public @Pointer(comment="void*") @NotNull MemorySegment getWindowUserPointer(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetWindowUserPointer);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `RRCrtc` of the specified monitor.
    ///
    ///  @return The `RRCrtc` of the specified monitor, or `None` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup native
    public @NativeType("RRCrtc") long getX11Adapter(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetX11Adapter);
        try {
            Object t = hFunction.invoke(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
            return (NativeLayout.C_LONG_SIZE == 4) ? (int) t : (long) t;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `Display` used by GLFW.
    ///
    ///  @return The `Display` used by GLFW, or `NULL` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @Nullable PointerPtr getX11Display() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetX11Display);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new PointerPtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `RROutput` of the specified monitor.
    ///
    ///  @return The `RROutput` of the specified monitor, or `None` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup native
    public @NativeType("RROutput") long getX11Monitor(
        @Nullable GLFWmonitor monitor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetX11Monitor);
        try {
            Object t = hFunction.invoke(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL)
            );
            return (NativeLayout.C_LONG_SIZE == 4) ? (int) t : (long) t;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the contents of the current primary selection as a string.
    ///
    ///  If the selection is empty or if its contents cannot be converted, `NULL`
    ///  is returned and a @ref GLFW_FORMAT_UNAVAILABLE error is generated.
    ///
    ///  @return The contents of the selection as a UTF-8 encoded string, or `NULL`
    ///  if an [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_UNAVAILABLE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The returned string is allocated and freed by GLFW. You
    ///  should not free it yourself. It is valid until the next call to @ref
    ///  glfwGetX11SelectionString or @ref glfwSetX11SelectionString, or until the
    ///  library is terminated.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref clipboard
    ///  @sa glfwSetX11SelectionString
    ///  @sa glfwGetClipboardString
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup native
    public @Nullable BytePtr getX11SelectionString() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetX11SelectionString);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns the `Window` of the specified window.
    ///
    ///  @return The `Window` of the specified window, or `None` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_UNAVAILABLE.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup native
    public @NativeType("Window") long getX11Window(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwGetX11Window);
        try {
            Object t = hFunction.invoke(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
            return (NativeLayout.C_LONG_SIZE == 4) ? (int) t : (long) t;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Hides the specified window.
    ///
    ///  This function hides the specified window if it was previously visible.  If
    ///  the window is already hidden or is in full screen mode, this function does
    ///  nothing.
    ///
    ///  @param[in] window The window to hide.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_hide
    ///  @sa @ref glfwShowWindow
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public void hideWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwHideWindow);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Iconifies the specified window.
    ///
    ///  This function iconifies (minimizes) the specified window if it was
    ///  previously restored.  If the window is already iconified, this function does
    ///  nothing.
    ///
    ///  If the specified window is a full screen window, GLFW restores the original
    ///  video mode of the monitor.  The window's desired video mode is set again
    ///  when the window is restored.
    ///
    ///  @param[in] window The window to iconify.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @wayland Once a window is iconified, @ref glfwRestoreWindow won’t
    ///  be able to restore it.  This is a design decision of the xdg-shell
    ///  protocol.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_iconify
    ///  @sa @ref glfwRestoreWindow
    ///  @sa @ref glfwMaximizeWindow
    ///
    ///  @since Added in version 2.1.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup window
    public void iconifyWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwIconifyWindow);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Initializes the GLFW library.
    ///
    ///  This function initializes the GLFW library.  Before most GLFW functions can
    ///  be used, GLFW must be initialized, and before an application terminates GLFW
    ///  should be terminated in order to free any resources allocated during or
    ///  after initialization.
    ///
    ///  If this function fails, it calls @ref glfwTerminate before returning.  If it
    ///  succeeds, you should call @ref glfwTerminate before the application exits.
    ///
    ///  Additional calls to this function after successful initialization but before
    ///  termination will return `GLFW_TRUE` immediately.
    ///
    ///  The @ref GLFW_PLATFORM init hint controls which platforms are considered during
    ///  initialization.  This also depends on which platforms the library was compiled to
    ///  support.
    ///
    ///  @return `GLFW_TRUE` if successful, or `GLFW_FALSE` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_PLATFORM_UNAVAILABLE and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @macos This function will change the current directory of the
    ///  application to the `Contents/Resources` subdirectory of the application's
    ///  bundle, if present.  This can be disabled with the @ref
    ///  GLFW_COCOA_CHDIR_RESOURCES init hint.
    ///
    ///  @remark @macos This function will create the main menu and dock icon for the
    ///  application.  If GLFW finds a `MainMenu.nib` it is loaded and assumed to
    ///  contain a menu bar.  Otherwise a minimal menu bar is created manually with
    ///  common commands like Hide, Quit and About.  The About entry opens a minimal
    ///  about dialog with information from the application's bundle.  The menu bar
    ///  and dock icon can be disabled entirely with the @ref GLFW_COCOA_MENUBAR init
    ///  hint.
    ///
    ///  @remark __Wayland, X11:__ If the library was compiled with support for both
    ///  Wayland and X11, and the @ref GLFW_PLATFORM init hint is set to
    ///  `GLFW_ANY_PLATFORM`, the `XDG_SESSION_TYPE` environment variable affects
    ///  which platform is picked.  If the environment variable is not set, or is set
    ///  to something other than `wayland` or `x11`, the regular detection mechanism
    ///  will be used instead.
    ///
    ///  @remark @x11 This function will set the `LC_CTYPE` category of the
    ///  application locale according to the current environment if that category is
    ///  still "C".  This is because the "C" locale breaks Unicode text input.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref intro_init
    ///  @sa @ref glfwInitHint
    ///  @sa @ref glfwInitAllocator
    ///  @sa @ref glfwTerminate
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup init
    public int init() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwInit);
        try {
            return (int) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the init allocator to the desired value.
    ///
    ///  To use the default allocator, call this function with a `NULL` argument.
    ///
    ///  If you specify an allocator struct, every member must be a valid function
    ///  pointer.  If any member is `NULL`, this function will emit @ref
    ///  GLFW_INVALID_VALUE and the init allocator will be unchanged.
    ///
    ///  The functions in the allocator must fulfil a number of requirements.  See the
    ///  documentation for @ref GLFWallocatefun, @ref GLFWreallocatefun and @ref
    ///  GLFWdeallocatefun for details.
    ///
    ///  @param[in] allocator The allocator to use at the next initialization, or
    ///  `NULL` to use the default one.
    ///
    ///  @errors Possible errors include @ref GLFW_INVALID_VALUE.
    ///
    ///  @pointer_lifetime The specified allocator is copied before this function
    ///  returns.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref init_allocator
    ///  @sa @ref glfwInit
    ///
    ///  @since Added in version 3.4.
    ///
    ///  @ingroup init
    public void initAllocator(
        @Nullable @Pointer IGLFWallocator allocator
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwInitAllocator);
        try {
            hFunction.invokeExact(
                (MemorySegment) (allocator != null ? allocator.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the specified init hint to the desired value.
    ///
    ///  This function sets hints for the next initialization of GLFW.
    ///
    ///  The values you set hints to are never reset by GLFW, but they only take
    ///  effect during initialization.  Once GLFW has been initialized, any values
    ///  you set will be ignored until the library is terminated and initialized
    ///  again.
    ///
    ///  Some hints are platform specific.  These may be set on any platform but they
    ///  will only affect their specific platform.  Other platforms will ignore them.
    ///  Setting these hints requires no platform specific headers or functions.
    ///
    ///  @param[in] hint The [init hint](@ref init_hints) to set.
    ///  @param[in] value The new value of the init hint.
    ///
    ///  @errors Possible errors include @ref GLFW_INVALID_ENUM and @ref
    ///  GLFW_INVALID_VALUE.
    ///
    ///  @remarks This function may be called before @ref glfwInit.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa init_hints
    ///  @sa glfwInit
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup init
    public void initHint(
        int hint,
        int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwInitHint);
        try {
            hFunction.invokeExact(
                hint,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the desired Vulkan `vkGetInstanceProcAddr` function.
    ///
    ///  This function sets the `vkGetInstanceProcAddr` function that GLFW will use for all
    ///  Vulkan related entry point queries.
    ///
    ///  This feature is mostly useful on macOS, if your copy of the Vulkan loader is in
    ///  a location where GLFW cannot find it through dynamic loading, or if you are still
    ///  using the static library version of the loader.
    ///
    ///  If set to `NULL`, GLFW will try to load the Vulkan loader dynamically by its standard
    ///  name and get this function from there.  This is the default behavior.
    ///
    ///  The standard name of the loader is `vulkan-1.dll` on Windows, `libvulkan.so.1` on
    ///  Linux and other Unix-like systems and `libvulkan.1.dylib` on macOS.  If your code is
    ///  also loading it via these names then you probably don't need to use this function.
    ///
    ///  The function address you set is never reset by GLFW, but it only takes effect during
    ///  initialization.  Once GLFW has been initialized, any updates will be ignored until the
    ///  library is terminated and initialized again.
    ///
    ///  @param[in] loader The address of the function to use, or `NULL`.
    ///
    ///  @par Loader function signature
    ///  @code
    ///  PFN_vkVoidFunction vkGetInstanceProcAddr(VkInstance instance, const char* name)
    ///  @endcode
    ///  For more information about this function, see the
    ///  [Vulkan Registry](https://www.khronos.org/registry/vulkan/).
    ///
    ///  @errors None.
    ///
    ///  @remark This function may be called before @ref glfwInit.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref vulkan_loader
    ///  @sa @ref glfwInit
    ///
    ///  @since Added in version 3.4.
    ///
    ///  @ingroup init
    public void initVulkanLoader(
        @Pointer(comment="PFN_vkGetInstanceProcAddr") @NotNull MemorySegment loader
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwInitVulkanLoader);
        try {
            hFunction.invokeExact(
                loader
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns whether the specified joystick has a gamepad mapping.
    ///
    ///  This function returns whether the specified joystick is both present and has
    ///  a gamepad mapping.
    ///
    ///  If the specified joystick is present but does not have a gamepad mapping
    ///  this function will return `GLFW_FALSE` but will not generate an error.  Call
    ///  @ref glfwJoystickPresent to check if a joystick is present regardless of
    ///  whether it has a mapping.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @return `GLFW_TRUE` if a joystick is both present and has a gamepad mapping,
    ///  or `GLFW_FALSE` otherwise.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref gamepad
    ///  @sa @ref glfwGetGamepadState
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public int joystickIsGamepad(
        int jid
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwJoystickIsGamepad);
        try {
            return (int) hFunction.invokeExact(
                jid
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns whether the specified joystick is present.
    ///
    ///  This function returns whether the specified joystick is present.
    ///
    ///  There is no need to call this function before other functions that accept
    ///  a joystick ID, as they all check for presence before performing any other
    ///  work.
    ///
    ///  @param[in] jid The [joystick](@ref joysticks) to query.
    ///  @return `GLFW_TRUE` if the joystick is present, or `GLFW_FALSE` otherwise.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref joystick
    ///
    ///  @since Added in version 3.0.  Replaces `glfwGetJoystickParam`.
    ///
    ///  @ingroup input
    public int joystickPresent(
        int jid
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwJoystickPresent);
        try {
            return (int) hFunction.invokeExact(
                jid
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Makes the context of the specified window current for the calling
    ///  thread.
    ///
    ///  This function makes the OpenGL or OpenGL ES context of the specified window
    ///  current on the calling thread.  It can also detach the current context from
    ///  the calling thread without making a new one current by passing in `NULL`.
    ///
    ///  A context must only be made current on a single thread at a time and each
    ///  thread can have only a single current context at a time.  Making a context
    ///  current detaches any previously current context on the calling thread.
    ///
    ///  When moving a context between threads, you must detach it (make it
    ///  non-current) on the old thread before making it current on the new one.
    ///
    ///  By default, making a context non-current implicitly forces a pipeline flush.
    ///  On machines that support `GL_KHR_context_flush_control`, you can control
    ///  whether a context performs this flush by setting the
    ///  [GLFW_CONTEXT_RELEASE_BEHAVIOR](@ref GLFW_CONTEXT_RELEASE_BEHAVIOR_hint)
    ///  hint.
    ///
    ///  The specified window must have an OpenGL or OpenGL ES context.  Specifying
    ///  a window without a context will generate a @ref GLFW_NO_WINDOW_CONTEXT
    ///  error.
    ///
    ///  @param[in] window The window whose context to make current, or `NULL` to
    ///  detach the current context.
    ///
    ///  @remarks If the previously current context was created via a different
    ///  context creation API than the one passed to this function, GLFW will still
    ///  detach the previous one from its API before making the new one current.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_WINDOW_CONTEXT and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref context_current
    ///  @sa @ref glfwGetCurrentContext
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup context
    public void makeContextCurrent(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwMakeContextCurrent);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Maximizes the specified window.
    ///
    ///  This function maximizes the specified window if it was previously not
    ///  maximized.  If the window is already maximized, this function does nothing.
    ///
    ///  If the specified window is a full screen window, this function does nothing.
    ///
    ///  @param[in] window The window to maximize.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @par Thread Safety
    ///  This function may only be called from the main thread.
    ///
    ///  @sa @ref window_iconify
    ///  @sa @ref glfwIconifyWindow
    ///  @sa @ref glfwRestoreWindow
    ///
    ///  @since Added in GLFW 3.2.
    ///
    ///  @ingroup window
    public void maximizeWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwMaximizeWindow);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns whether the library includes support for the specified platform.
    ///
    ///  This function returns whether the library was compiled with support for the specified
    ///  platform.  The platform must be one of `GLFW_PLATFORM_WIN32`, `GLFW_PLATFORM_COCOA`,
    ///  `GLFW_PLATFORM_WAYLAND`, `GLFW_PLATFORM_X11` or `GLFW_PLATFORM_NULL`.
    ///
    ///  @param[in] platform The platform to query.
    ///  @return `GLFW_TRUE` if the platform is supported, or `GLFW_FALSE` otherwise.
    ///
    ///  @errors Possible errors include @ref GLFW_INVALID_ENUM.
    ///
    ///  @remark This function may be called before @ref glfwInit.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref platform
    ///  @sa @ref glfwGetPlatform
    ///
    ///  @since Added in version 3.4.
    ///
    ///  @ingroup init
    public int platformSupported(
        int platform
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwPlatformSupported);
        try {
            return (int) hFunction.invokeExact(
                platform
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Processes all pending events.
    ///
    ///  This function processes only those events that are already in the event
    ///  queue and then returns immediately.  Processing events will cause the window
    ///  and input callbacks associated with those events to be called.
    ///
    ///  On some platforms, a window move, resize or menu operation will cause event
    ///  processing to block.  This is due to how event processing is designed on
    ///  those platforms.  You can use the
    ///  [window refresh callback](@ref window_refresh) to redraw the contents of
    ///  your window when necessary during such operations.
    ///
    ///  Do not assume that callbacks you set will _only_ be called in response to
    ///  event processing functions like this one.  While it is necessary to poll for
    ///  events, window systems that require GLFW to register callbacks of its own
    ///  can pass events to GLFW in response to many window system function calls.
    ///  GLFW will pass those events on to the application callbacks before
    ///  returning.
    ///
    ///  Event processing is not required for joystick input to work.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @reentrancy This function must not be called from a callback.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref events
    ///  @sa @ref glfwWaitEvents
    ///  @sa @ref glfwWaitEventsTimeout
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup window
    public void pollEvents() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwPollEvents);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Posts an empty event to the event queue.
    ///
    ///  This function posts an empty event from the current thread to the event
    ///  queue, causing @ref glfwWaitEvents or @ref glfwWaitEventsTimeout to return.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref events
    ///  @sa @ref glfwWaitEvents
    ///  @sa @ref glfwWaitEventsTimeout
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup window
    public void postEmptyEvent() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwPostEmptyEvent);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns whether raw mouse motion is supported.
    ///
    ///  This function returns whether raw mouse motion is supported on the current
    ///  system.  This status does not change after GLFW has been initialized so you
    ///  only need to check this once.  If you attempt to enable raw motion on
    ///  a system that does not support it, @ref GLFW_PLATFORM_ERROR will be emitted.
    ///
    ///  Raw mouse motion is closer to the actual motion of the mouse across
    ///  a surface.  It is not affected by the scaling and acceleration applied to
    ///  the motion of the desktop cursor.  That processing is suitable for a cursor
    ///  while raw motion is better for controlling for example a 3D camera.  Because
    ///  of this, raw mouse motion is only provided when the cursor is disabled.
    ///
    ///  @return `GLFW_TRUE` if raw mouse motion is supported on the current machine,
    ///  or `GLFW_FALSE` otherwise.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref raw_mouse_motion
    ///  @sa @ref glfwSetInputMode
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public int rawMouseMotionSupported() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwRawMouseMotionSupported);
        try {
            return (int) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Requests user attention to the specified window.
    ///
    ///  This function requests user attention to the specified window.  On
    ///  platforms where this is not supported, attention is requested to the
    ///  application as a whole.
    ///
    ///  Once the user has given attention, usually by focusing the window or
    ///  application, the system will end the request automatically.
    ///
    ///  @param[in] window The window to request attention to.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @macos Attention is requested to the application as a whole, not the
    ///  specific window.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_attention
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public void requestWindowAttention(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwRequestWindowAttention);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Restores the specified window.
    ///
    ///  This function restores the specified window if it was previously iconified
    ///  (minimized) or maximized.  If the window is already restored, this function
    ///  does nothing.
    ///
    ///  If the specified window is an iconified full screen window, its desired
    ///  video mode is set again for its monitor when the window is restored.
    ///
    ///  @param[in] window The window to restore.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_iconify
    ///  @sa @ref glfwIconifyWindow
    ///  @sa @ref glfwMaximizeWindow
    ///
    ///  @since Added in version 2.1.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup window
    public void restoreWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwRestoreWindow);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the Unicode character callback.
    ///
    ///  This function sets the character callback of the specified window, which is
    ///  called when a Unicode character is input.
    ///
    ///  The character callback is intended for Unicode text input.  As it deals with
    ///  characters, it is keyboard layout dependent, whereas the
    ///  [key callback](@ref glfwSetKeyCallback) is not.  Characters do not map 1:1
    ///  to physical keys, as a key may produce zero, one or more characters.  If you
    ///  want to know whether a specific physical key was pressed or released, see
    ///  the key callback instead.
    ///
    ///  The character callback behaves as system text input normally does and will
    ///  not be called if modifier keys are held down that would prevent normal text
    ///  input on that platform, for example a Super (Command) key on macOS or Alt key
    ///  on Windows.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, unsigned int codepoint)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWcharfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref input_char
    ///
    ///  @since Added in version 2.4.
    ///  @glfw3 Added window handle parameter and return value.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWcharfun") @NotNull MemorySegment setCharCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWcharfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetCharCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWcharfun") @NotNull MemorySegment setCharCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWcharfun callback
    ) {
        return setCharCallback(
            window,
            IGLFWcharfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWcharfun") @NotNull MemorySegment setCharCallback(
        @Nullable GLFWwindow window,
        IGLFWcharfun callback
    ) {
        return setCharCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the Unicode character with modifiers callback.
    ///
    ///  This function sets the character with modifiers callback of the specified
    ///  window, which is called when a Unicode character is input regardless of what
    ///  modifier keys are used.
    ///
    ///  The character with modifiers callback is intended for implementing custom
    ///  Unicode character input.  For regular Unicode text input, see the
    ///  [character callback](@ref glfwSetCharCallback).  Like the character
    ///  callback, the character with modifiers callback deals with characters and is
    ///  keyboard layout dependent.  Characters do not map 1:1 to physical keys, as
    ///  a key may produce zero, one or more characters.  If you want to know whether
    ///  a specific physical key was pressed or released, see the
    ///  [key callback](@ref glfwSetKeyCallback) instead.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, unsigned int codepoint, int mods)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWcharmodsfun).
    ///
    ///  @deprecated Scheduled for removal in version 4.0.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref input_char
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWcharmodsfun") @NotNull MemorySegment setCharModsCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWcharmodsfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetCharModsCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWcharmodsfun") @NotNull MemorySegment setCharModsCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWcharmodsfun callback
    ) {
        return setCharModsCallback(
            window,
            IGLFWcharmodsfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWcharmodsfun") @NotNull MemorySegment setCharModsCallback(
        @Nullable GLFWwindow window,
        IGLFWcharmodsfun callback
    ) {
        return setCharModsCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the clipboard to the specified string.
    ///
    ///  This function sets the system clipboard to the specified, UTF-8 encoded
    ///  string.
    ///
    ///  @param[in] window Deprecated.  Any valid window or `NULL`.
    ///  @param[in] string A UTF-8 encoded string.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @win32 The clipboard on Windows has a single global lock for reading and
    ///  writing.  GLFW tries to acquire it a few times, which is almost always enough.  If it
    ///  cannot acquire the lock then this function emits @ref GLFW_PLATFORM_ERROR and returns.
    ///  It is safe to try this multiple times.
    ///
    ///  @pointer_lifetime The specified string is copied before this function
    ///  returns.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref clipboard
    ///  @sa @ref glfwGetClipboardString
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup input
    public void setClipboardString(
        @Nullable GLFWwindow window,
        @Nullable BytePtr string
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetClipboardString);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (string != null ? string.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the cursor for the window.
    ///
    ///  This function sets the cursor image to be used when the cursor is over the
    ///  content area of the specified window.  The set cursor will only be visible
    ///  when the [cursor mode](@ref cursor_mode) of the window is
    ///  `GLFW_CURSOR_NORMAL`.
    ///
    ///  On some platforms, the set cursor may not be visible unless the window also
    ///  has input focus.
    ///
    ///  @param[in] window The window to set the cursor for.
    ///  @param[in] cursor The cursor to set, or `NULL` to switch back to the default
    ///  arrow cursor.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_object
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup input
    public void setCursor(
        @Nullable GLFWwindow window,
        @Nullable GLFWcursor cursor
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetCursor);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (cursor != null ? cursor.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the cursor enter/leave callback.
    ///
    ///  This function sets the cursor boundary crossing callback of the specified
    ///  window, which is called when the cursor enters or leaves the content area of
    ///  the window.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int entered)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWcursorenterfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_enter
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWcursorenterfun") @NotNull MemorySegment setCursorEnterCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWcursorenterfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetCursorEnterCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWcursorenterfun") @NotNull MemorySegment setCursorEnterCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWcursorenterfun callback
    ) {
        return setCursorEnterCallback(
            window,
            IGLFWcursorenterfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWcursorenterfun") @NotNull MemorySegment setCursorEnterCallback(
        @Nullable GLFWwindow window,
        IGLFWcursorenterfun callback
    ) {
        return setCursorEnterCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the position of the cursor, relative to the content area of the
    ///  window.
    ///
    ///  This function sets the position, in screen coordinates, of the cursor
    ///  relative to the upper-left corner of the content area of the specified
    ///  window.  The window must have input focus.  If the window does not have
    ///  input focus when this function is called, it fails silently.
    ///
    ///  __Do not use this function__ to implement things like camera controls.  GLFW
    ///  already provides the `GLFW_CURSOR_DISABLED` cursor mode that hides the
    ///  cursor, transparently re-centers it and provides unconstrained cursor
    ///  motion.  See @ref glfwSetInputMode for more information.
    ///
    ///  If the cursor mode is `GLFW_CURSOR_DISABLED` then the cursor position is
    ///  unconstrained and limited only by the minimum and maximum values of
    ///  a `double`.
    ///
    ///  @param[in] window The desired window.
    ///  @param[in] xpos The desired x-coordinate, relative to the left edge of the
    ///  content area.
    ///  @param[in] ypos The desired y-coordinate, relative to the top edge of the
    ///  content area.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_ERROR and @ref GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark @wayland This function will only work when the cursor mode is
    ///  `GLFW_CURSOR_DISABLED`, otherwise it will emit @ref GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_pos
    ///  @sa @ref glfwGetCursorPos
    ///
    ///  @since Added in version 3.0.  Replaces `glfwSetMousePos`.
    ///
    ///  @ingroup input
    public void setCursorPos(
        @Nullable GLFWwindow window,
        double xpos,
        double ypos
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetCursorPos);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                xpos,
                ypos
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the cursor position callback.
    ///
    ///  This function sets the cursor position callback of the specified window,
    ///  which is called when the cursor is moved.  The callback is provided with the
    ///  position, in screen coordinates, relative to the upper-left corner of the
    ///  content area of the window.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, double xpos, double ypos);
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWcursorposfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref cursor_pos
    ///
    ///  @since Added in version 3.0.  Replaces `glfwSetMousePosCallback`.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWcursorposfun") @NotNull MemorySegment setCursorPosCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWcursorposfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetCursorPosCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWcursorposfun") @NotNull MemorySegment setCursorPosCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWcursorposfun callback
    ) {
        return setCursorPosCallback(
            window,
            IGLFWcursorposfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWcursorposfun") @NotNull MemorySegment setCursorPosCallback(
        @Nullable GLFWwindow window,
        IGLFWcursorposfun callback
    ) {
        return setCursorPosCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the path drop callback.
    ///
    ///  This function sets the path drop callback of the specified window, which is
    ///  called when one or more dragged paths are dropped on the window.
    ///
    ///  Because the path array and its strings may have been generated specifically
    ///  for that event, they are not guaranteed to be valid after the callback has
    ///  returned.  If you wish to use them after the callback returns, you need to
    ///  make a deep copy.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new file drop callback, or `NULL` to remove the
    ///  currently set callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int path_count, const char* paths[])
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWdropfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref path_drop
    ///
    ///  @since Added in version 3.1.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWdropfun") @NotNull MemorySegment setDropCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWdropfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetDropCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWdropfun") @NotNull MemorySegment setDropCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWdropfun callback
    ) {
        return setDropCallback(
            window,
            IGLFWdropfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWdropfun") @NotNull MemorySegment setDropCallback(
        @Nullable GLFWwindow window,
        IGLFWdropfun callback
    ) {
        return setDropCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the error callback.
    ///
    ///  This function sets the error callback, which is called with an error code
    ///  and a human-readable description each time a GLFW error occurs.
    ///
    ///  The error code is set before the callback is called.  Calling @ref
    ///  glfwGetError from the error callback will return the same value as the error
    ///  code argument.
    ///
    ///  The error callback is called on the thread where the error occurred.  If you
    ///  are using GLFW from multiple threads, your error callback needs to be
    ///  written accordingly.
    ///
    ///  Because the description string may have been generated specifically for that
    ///  error, it is not guaranteed to be valid after the callback has returned.  If
    ///  you wish to use it after the callback returns, you need to make a copy.
    ///
    ///  Once set, the error callback remains set even after the library has been
    ///  terminated.
    ///
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set.
    ///
    ///  @callback_signature
    ///  @code
    ///  void callback_name(int error_code, const char* description)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [callback pointer type](@ref GLFWerrorfun).
    ///
    ///  @errors None.
    ///
    ///  @remark This function may be called before @ref glfwInit.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref error_handling
    ///  @sa @ref glfwGetError
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup init
    public @Pointer(comment="GLFWerrorfun") @NotNull MemorySegment setErrorCallback(
        @Pointer(comment="GLFWerrorfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetErrorCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWerrorfun") @NotNull MemorySegment setErrorCallback(
        Arena arena,
        IGLFWerrorfun callback
    ) {
        return setErrorCallback(
            IGLFWerrorfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWerrorfun") @NotNull MemorySegment setErrorCallback(
        IGLFWerrorfun callback
    ) {
        return setErrorCallback(
            Arena.global(),
            callback
        );
    }

    ///  @brief Sets the framebuffer resize callback for the specified window.
    ///
    ///  This function sets the framebuffer resize callback of the specified window,
    ///  which is called when the framebuffer of the specified window is resized.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int width, int height)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWframebuffersizefun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_fbsize
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWframebuffersizefun") @NotNull MemorySegment setFramebufferSizeCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWframebuffersizefun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetFramebufferSizeCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWframebuffersizefun") @NotNull MemorySegment setFramebufferSizeCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWframebuffersizefun callback
    ) {
        return setFramebufferSizeCallback(
            window,
            IGLFWframebuffersizefun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWframebuffersizefun") @NotNull MemorySegment setFramebufferSizeCallback(
        @Nullable GLFWwindow window,
        IGLFWframebuffersizefun callback
    ) {
        return setFramebufferSizeCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Generates a gamma ramp and sets it for the specified monitor.
    ///
    ///  This function generates an appropriately sized gamma ramp from the specified
    ///  exponent and then calls @ref glfwSetGammaRamp with it.  The value must be
    ///  a finite number greater than zero.
    ///
    ///  The software controlled gamma ramp is applied _in addition_ to the hardware
    ///  gamma correction, which today is usually an approximation of sRGB gamma.
    ///  This means that setting a perfectly linear ramp, or gamma 1.0, will produce
    ///  the default (usually sRGB-like) behavior.
    ///
    ///  For gamma correct rendering with OpenGL or OpenGL ES, see the @ref
    ///  GLFW_SRGB_CAPABLE hint.
    ///
    ///  @param[in] monitor The monitor whose gamma ramp to set.
    ///  @param[in] gamma The desired exponent.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref GLFW_INVALID_VALUE,
    ///  @ref GLFW_PLATFORM_ERROR and @ref GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark @wayland Gamma handling is a privileged protocol, this function
    ///  will thus never be implemented and emits @ref GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_gamma
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public void setGamma(
        @Nullable GLFWmonitor monitor,
        float gamma
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetGamma);
        try {
            hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                gamma
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the current gamma ramp for the specified monitor.
    ///
    ///  This function sets the current gamma ramp for the specified monitor.  The
    ///  original gamma ramp for that monitor is saved by GLFW the first time this
    ///  function is called and is restored by @ref glfwTerminate.
    ///
    ///  The software controlled gamma ramp is applied _in addition_ to the hardware
    ///  gamma correction, which today is usually an approximation of sRGB gamma.
    ///  This means that setting a perfectly linear ramp, or gamma 1.0, will produce
    ///  the default (usually sRGB-like) behavior.
    ///
    ///  For gamma correct rendering with OpenGL or OpenGL ES, see the @ref
    ///  GLFW_SRGB_CAPABLE hint.
    ///
    ///  @param[in] monitor The monitor whose gamma ramp to set.
    ///  @param[in] ramp The gamma ramp to use.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref GLFW_PLATFORM_ERROR
    ///  and @ref GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark The size of the specified gamma ramp should match the size of the
    ///  current ramp for that monitor.
    ///
    ///  @remark @win32 The gamma ramp size must be 256.
    ///
    ///  @remark @wayland Gamma handling is a privileged protocol, this function
    ///  will thus never be implemented and emits @ref GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @pointer_lifetime The specified gamma ramp is copied before this function
    ///  returns.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_gamma
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public void setGammaRamp(
        @Nullable GLFWmonitor monitor,
        @Nullable @Pointer IGLFWgammaramp ramp
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetGammaRamp);
        try {
            hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                (MemorySegment) (ramp != null ? ramp.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets an input option for the specified window.
    ///
    ///  This function sets an input mode option for the specified window.  The mode
    ///  must be one of @ref GLFW_CURSOR, @ref GLFW_STICKY_KEYS,
    ///  @ref GLFW_STICKY_MOUSE_BUTTONS, @ref GLFW_LOCK_KEY_MODS or
    ///  @ref GLFW_RAW_MOUSE_MOTION.
    ///
    ///  If the mode is `GLFW_CURSOR`, the value must be one of the following cursor
    ///  modes:
    ///  - `GLFW_CURSOR_NORMAL` makes the cursor visible and behaving normally.
    ///  - `GLFW_CURSOR_HIDDEN` makes the cursor invisible when it is over the
    ///    content area of the window but does not restrict the cursor from leaving.
    ///  - `GLFW_CURSOR_DISABLED` hides and grabs the cursor, providing virtual
    ///    and unlimited cursor movement.  This is useful for implementing for
    ///    example 3D camera controls.
    ///  - `GLFW_CURSOR_CAPTURED` makes the cursor visible and confines it to the
    ///    content area of the window.
    ///
    ///  If the mode is `GLFW_STICKY_KEYS`, the value must be either `GLFW_TRUE` to
    ///  enable sticky keys, or `GLFW_FALSE` to disable it.  If sticky keys are
    ///  enabled, a key press will ensure that @ref glfwGetKey returns `GLFW_PRESS`
    ///  the next time it is called even if the key had been released before the
    ///  call.  This is useful when you are only interested in whether keys have been
    ///  pressed but not when or in which order.
    ///
    ///  If the mode is `GLFW_STICKY_MOUSE_BUTTONS`, the value must be either
    ///  `GLFW_TRUE` to enable sticky mouse buttons, or `GLFW_FALSE` to disable it.
    ///  If sticky mouse buttons are enabled, a mouse button press will ensure that
    ///  @ref glfwGetMouseButton returns `GLFW_PRESS` the next time it is called even
    ///  if the mouse button had been released before the call.  This is useful when
    ///  you are only interested in whether mouse buttons have been pressed but not
    ///  when or in which order.
    ///
    ///  If the mode is `GLFW_LOCK_KEY_MODS`, the value must be either `GLFW_TRUE` to
    ///  enable lock key modifier bits, or `GLFW_FALSE` to disable them.  If enabled,
    ///  callbacks that receive modifier bits will also have the @ref
    ///  GLFW_MOD_CAPS_LOCK bit set when the event was generated with Caps Lock on,
    ///  and the @ref GLFW_MOD_NUM_LOCK bit when Num Lock was on.
    ///
    ///  If the mode is `GLFW_RAW_MOUSE_MOTION`, the value must be either `GLFW_TRUE`
    ///  to enable raw (unscaled and unaccelerated) mouse motion when the cursor is
    ///  disabled, or `GLFW_FALSE` to disable it.  If raw motion is not supported,
    ///  attempting to set this will emit @ref GLFW_FEATURE_UNAVAILABLE.  Call @ref
    ///  glfwRawMouseMotionSupported to check for support.
    ///
    ///  @param[in] window The window whose input mode to set.
    ///  @param[in] mode One of `GLFW_CURSOR`, `GLFW_STICKY_KEYS`,
    ///  `GLFW_STICKY_MOUSE_BUTTONS`, `GLFW_LOCK_KEY_MODS` or
    ///  `GLFW_RAW_MOUSE_MOTION`.
    ///  @param[in] value The new value of the specified input mode.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM, @ref GLFW_PLATFORM_ERROR and @ref
    ///  GLFW_FEATURE_UNAVAILABLE (see above).
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref glfwGetInputMode
    ///
    ///  @since Added in version 3.0.  Replaces `glfwEnable` and `glfwDisable`.
    ///
    ///  @ingroup input
    public void setInputMode(
        @Nullable GLFWwindow window,
        int mode,
        int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetInputMode);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                mode,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the joystick configuration callback.
    ///
    ///  This function sets the joystick configuration callback, or removes the
    ///  currently set callback.  This is called when a joystick is connected to or
    ///  disconnected from the system.
    ///
    ///  For joystick connection and disconnection events to be delivered on all
    ///  platforms, you need to call one of the [event processing](@ref events)
    ///  functions.  Joystick disconnection may also be detected and the callback
    ///  called by joystick functions.  The function will then return whatever it
    ///  returns if the joystick is not present.
    ///
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(int jid, int event)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWjoystickfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref joystick_event
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWjoystickfun") @NotNull MemorySegment setJoystickCallback(
        @Pointer(comment="GLFWjoystickfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetJoystickCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWjoystickfun") @NotNull MemorySegment setJoystickCallback(
        Arena arena,
        IGLFWjoystickfun callback
    ) {
        return setJoystickCallback(
            IGLFWjoystickfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWjoystickfun") @NotNull MemorySegment setJoystickCallback(
        IGLFWjoystickfun callback
    ) {
        return setJoystickCallback(
            Arena.global(),
            callback
        );
    }

    ///  @brief Sets the user pointer of the specified joystick.
    ///
    ///  This function sets the user-defined pointer of the specified joystick.  The
    ///  current value is retained until the joystick is disconnected.  The initial
    ///  value is `NULL`.
    ///
    ///  This function may be called from the joystick callback, even for a joystick
    ///  that is being disconnected.
    ///
    ///  @param[in] jid The joystick whose pointer to set.
    ///  @param[in] pointer The new value.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref joystick_userptr
    ///  @sa @ref glfwGetJoystickUserPointer
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public void setJoystickUserPointer(
        int jid,
        @Pointer(comment="void*") @NotNull MemorySegment pointer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetJoystickUserPointer);
        try {
            hFunction.invokeExact(
                jid,
                pointer
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the key callback.
    ///
    ///  This function sets the key callback of the specified window, which is called
    ///  when a key is pressed, repeated or released.
    ///
    ///  The key functions deal with physical keys, with layout independent
    ///  [key tokens](@ref keys) named after their values in the standard US keyboard
    ///  layout.  If you want to input text, use the
    ///  [character callback](@ref glfwSetCharCallback) instead.
    ///
    ///  When a window loses input focus, it will generate synthetic key release
    ///  events for all pressed keys with associated key tokens.  You can tell these
    ///  events from user-generated events by the fact that the synthetic ones are
    ///  generated after the focus loss event has been processed, i.e. after the
    ///  [window focus callback](@ref glfwSetWindowFocusCallback) has been called.
    ///
    ///  The scancode of a key is specific to that platform or sometimes even to that
    ///  machine.  Scancodes are intended to allow users to bind keys that don't have
    ///  a GLFW key token.  Such keys have `key` set to `GLFW_KEY_UNKNOWN`, their
    ///  state is not saved and so it cannot be queried with @ref glfwGetKey.
    ///
    ///  Sometimes GLFW needs to generate synthetic key events, in which case the
    ///  scancode may be zero.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new key callback, or `NULL` to remove the currently
    ///  set callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int key, int scancode, int action, int mods)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWkeyfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref input_key
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter and return value.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWkeyfun") @NotNull MemorySegment setKeyCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWkeyfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetKeyCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWkeyfun") @NotNull MemorySegment setKeyCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWkeyfun callback
    ) {
        return setKeyCallback(
            window,
            IGLFWkeyfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWkeyfun") @NotNull MemorySegment setKeyCallback(
        @Nullable GLFWwindow window,
        IGLFWkeyfun callback
    ) {
        return setKeyCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the monitor configuration callback.
    ///
    ///  This function sets the monitor configuration callback, or removes the
    ///  currently set callback.  This is called when a monitor is connected to or
    ///  disconnected from the system.
    ///
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWmonitor* monitor, int event)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWmonitorfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref monitor_event
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup monitor
    public @Pointer(comment="GLFWmonitorfun") @NotNull MemorySegment setMonitorCallback(
        @Pointer(comment="GLFWmonitorfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetMonitorCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWmonitorfun") @NotNull MemorySegment setMonitorCallback(
        Arena arena,
        IGLFWmonitorfun callback
    ) {
        return setMonitorCallback(
            IGLFWmonitorfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWmonitorfun") @NotNull MemorySegment setMonitorCallback(
        IGLFWmonitorfun callback
    ) {
        return setMonitorCallback(
            Arena.global(),
            callback
        );
    }

    ///  @brief Sets the user pointer of the specified monitor.
    ///
    ///  This function sets the user-defined pointer of the specified monitor.  The
    ///  current value is retained until the monitor is disconnected.  The initial
    ///  value is `NULL`.
    ///
    ///  This function may be called from the monitor callback, even for a monitor
    ///  that is being disconnected.
    ///
    ///  @param[in] monitor The monitor whose pointer to set.
    ///  @param[in] pointer The new value.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref monitor_userptr
    ///  @sa @ref glfwGetMonitorUserPointer
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup monitor
    public void setMonitorUserPointer(
        @Nullable GLFWmonitor monitor,
        @Pointer(comment="void*") @NotNull MemorySegment pointer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetMonitorUserPointer);
        try {
            hFunction.invokeExact(
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                pointer
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the mouse button callback.
    ///
    ///  This function sets the mouse button callback of the specified window, which
    ///  is called when a mouse button is pressed or released.
    ///
    ///  When a window loses input focus, it will generate synthetic mouse button
    ///  release events for all pressed mouse buttons.  You can tell these events
    ///  from user-generated events by the fact that the synthetic ones are generated
    ///  after the focus loss event has been processed, i.e. after the
    ///  [window focus callback](@ref glfwSetWindowFocusCallback) has been called.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int button, int action, int mods)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWmousebuttonfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref input_mouse_button
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter and return value.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWmousebuttonfun") @NotNull MemorySegment setMouseButtonCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWmousebuttonfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetMouseButtonCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWmousebuttonfun") @NotNull MemorySegment setMouseButtonCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWmousebuttonfun callback
    ) {
        return setMouseButtonCallback(
            window,
            IGLFWmousebuttonfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWmousebuttonfun") @NotNull MemorySegment setMouseButtonCallback(
        @Nullable GLFWwindow window,
        IGLFWmousebuttonfun callback
    ) {
        return setMouseButtonCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the scroll callback.
    ///
    ///  This function sets the scroll callback of the specified window, which is
    ///  called when a scrolling device is used, such as a mouse wheel or scrolling
    ///  area of a touchpad.
    ///
    ///  The scroll callback receives all scrolling input, like that from a mouse
    ///  wheel or a touchpad scrolling area.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new scroll callback, or `NULL` to remove the
    ///  currently set callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, double xoffset, double yoffset)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWscrollfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref scrolling
    ///
    ///  @since Added in version 3.0.  Replaces `glfwSetMouseWheelCallback`.
    ///
    ///  @ingroup input
    public @Pointer(comment="GLFWscrollfun") @NotNull MemorySegment setScrollCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWscrollfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetScrollCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWscrollfun") @NotNull MemorySegment setScrollCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWscrollfun callback
    ) {
        return setScrollCallback(
            window,
            IGLFWscrollfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWscrollfun") @NotNull MemorySegment setScrollCallback(
        @Nullable GLFWwindow window,
        IGLFWscrollfun callback
    ) {
        return setScrollCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the GLFW time.
    ///
    ///  This function sets the current GLFW time, in seconds.  The value must be
    ///  a positive finite number less than or equal to 18446744073.0, which is
    ///  approximately 584.5 years.
    ///
    ///  This function and @ref glfwGetTime are helper functions on top of @ref
    ///  glfwGetTimerFrequency and @ref glfwGetTimerValue.
    ///
    ///  @param[in] time The new value, in seconds.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_VALUE.
    ///
    ///  @remark The upper limit of GLFW time is calculated as
    ///  floor((2<sup>64</sup> - 1) / 10<sup>9</sup>) and is due to implementations
    ///  storing nanoseconds in 64 bits.  The limit may be increased in the future.
    ///
    ///  @thread_safety This function may be called from any thread.  Reading and
    ///  writing of the internal base time is not atomic, so it needs to be
    ///  externally synchronized with calls to @ref glfwGetTime.
    ///
    ///  @sa @ref time
    ///
    ///  @since Added in version 2.2.
    ///
    ///  @ingroup input
    public void setTime(
        double time
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetTime);
        try {
            hFunction.invokeExact(
                time
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the aspect ratio of the specified window.
    ///
    ///  This function sets the required aspect ratio of the content area of the
    ///  specified window.  If the window is full screen, the aspect ratio only takes
    ///  effect once it is made windowed.  If the window is not resizable, this
    ///  function does nothing.
    ///
    ///  The aspect ratio is specified as a numerator and a denominator and both
    ///  values must be greater than zero.  For example, the common 16:9 aspect ratio
    ///  is specified as 16 and 9, respectively.
    ///
    ///  If the numerator and denominator is set to `GLFW_DONT_CARE` then the aspect
    ///  ratio limit is disabled.
    ///
    ///  The aspect ratio is applied immediately to a windowed mode window and may
    ///  cause it to be resized.
    ///
    ///  @param[in] window The window to set limits for.
    ///  @param[in] numer The numerator of the desired aspect ratio, or
    ///  `GLFW_DONT_CARE`.
    ///  @param[in] denom The denominator of the desired aspect ratio, or
    ///  `GLFW_DONT_CARE`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_VALUE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark If you set size limits and an aspect ratio that conflict, the
    ///  results are undefined.
    ///
    ///  @remark @wayland The aspect ratio will not be applied until the window is
    ///  actually resized, either by the user or by the compositor.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_sizelimits
    ///  @sa @ref glfwSetWindowSizeLimits
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup window
    public void setWindowAspectRatio(
        @Nullable GLFWwindow window,
        int numer,
        int denom
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowAspectRatio);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                numer,
                denom
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets an attribute of the specified window.
    ///
    ///  This function sets the value of an attribute of the specified window.
    ///
    ///  The supported attributes are [GLFW_DECORATED](@ref GLFW_DECORATED_attrib),
    ///  [GLFW_RESIZABLE](@ref GLFW_RESIZABLE_attrib),
    ///  [GLFW_FLOATING](@ref GLFW_FLOATING_attrib),
    ///  [GLFW_AUTO_ICONIFY](@ref GLFW_AUTO_ICONIFY_attrib) and
    ///  [GLFW_FOCUS_ON_SHOW](@ref GLFW_FOCUS_ON_SHOW_attrib).
    ///  [GLFW_MOUSE_PASSTHROUGH](@ref GLFW_MOUSE_PASSTHROUGH_attrib)
    ///
    ///  Some of these attributes are ignored for full screen windows.  The new
    ///  value will take effect if the window is later made windowed.
    ///
    ///  Some of these attributes are ignored for windowed mode windows.  The new
    ///  value will take effect if the window is later made full screen.
    ///
    ///  @param[in] window The window to set the attribute for.
    ///  @param[in] attrib A supported window attribute.
    ///  @param[in] value `GLFW_TRUE` or `GLFW_FALSE`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_ENUM, @ref GLFW_INVALID_VALUE, @ref GLFW_PLATFORM_ERROR and @ref
    ///  GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark Calling @ref glfwGetWindowAttrib will always return the latest
    ///  value, even if that value is ignored by the current mode of the window.
    ///
    ///  @remark @wayland The [GLFW_FLOATING](@ref GLFW_FLOATING_attrib) window attribute is
    ///  not supported.  Setting this will emit @ref GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_attribs
    ///  @sa @ref glfwGetWindowAttrib
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public void setWindowAttrib(
        @Nullable GLFWwindow window,
        int attrib,
        int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowAttrib);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                attrib,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the close callback for the specified window.
    ///
    ///  This function sets the close callback of the specified window, which is
    ///  called when the user attempts to close the window, for example by clicking
    ///  the close widget in the title bar.
    ///
    ///  The close flag is set before this callback is called, but you can modify it
    ///  at any time with @ref glfwSetWindowShouldClose.
    ///
    ///  The close callback is not triggered by @ref glfwDestroyWindow.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowclosefun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @remark @macos Selecting Quit from the application menu will trigger the
    ///  close callback for all windows.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_close
    ///
    ///  @since Added in version 2.5.
    ///  @glfw3 Added window handle parameter and return value.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowclosefun") @NotNull MemorySegment setWindowCloseCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowclosefun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowCloseCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowclosefun") @NotNull MemorySegment setWindowCloseCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowclosefun callback
    ) {
        return setWindowCloseCallback(
            window,
            IGLFWwindowclosefun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowclosefun") @NotNull MemorySegment setWindowCloseCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowclosefun callback
    ) {
        return setWindowCloseCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the window content scale callback for the specified window.
    ///
    ///  This function sets the window content scale callback of the specified window,
    ///  which is called when the content scale of the specified window changes.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, float xscale, float yscale)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowcontentscalefun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_scale
    ///  @sa @ref glfwGetWindowContentScale
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowcontentscalefun") @NotNull MemorySegment setWindowContentScaleCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowcontentscalefun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowContentScaleCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowcontentscalefun") @NotNull MemorySegment setWindowContentScaleCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowcontentscalefun callback
    ) {
        return setWindowContentScaleCallback(
            window,
            IGLFWwindowcontentscalefun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowcontentscalefun") @NotNull MemorySegment setWindowContentScaleCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowcontentscalefun callback
    ) {
        return setWindowContentScaleCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the focus callback for the specified window.
    ///
    ///  This function sets the focus callback of the specified window, which is
    ///  called when the window gains or loses input focus.
    ///
    ///  After the focus callback is called for a window that lost input focus,
    ///  synthetic key and mouse button release events will be generated for all such
    ///  that had been pressed.  For more information, see @ref glfwSetKeyCallback
    ///  and @ref glfwSetMouseButtonCallback.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int focused)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowfocusfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_focus
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowfocusfun") @NotNull MemorySegment setWindowFocusCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowfocusfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowFocusCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowfocusfun") @NotNull MemorySegment setWindowFocusCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowfocusfun callback
    ) {
        return setWindowFocusCallback(
            window,
            IGLFWwindowfocusfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowfocusfun") @NotNull MemorySegment setWindowFocusCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowfocusfun callback
    ) {
        return setWindowFocusCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the icon for the specified window.
    ///
    ///  This function sets the icon of the specified window.  If passed an array of
    ///  candidate images, those of or closest to the sizes desired by the system are
    ///  selected.  If no images are specified, the window reverts to its default
    ///  icon.
    ///
    ///  The pixels are 32-bit, little-endian, non-premultiplied RGBA, i.e. eight
    ///  bits per channel with the red channel first.  They are arranged canonically
    ///  as packed sequential rows, starting from the top-left corner.
    ///
    ///  The desired image sizes varies depending on platform and system settings.
    ///  The selected images will be rescaled as needed.  Good sizes include 16x16,
    ///  32x32 and 48x48.
    ///
    ///  @param[in] window The window whose icon to set.
    ///  @param[in] count The number of images in the specified array, or zero to
    ///  revert to the default window icon.
    ///  @param[in] images The images to create the icon from.  This is ignored if
    ///  count is zero.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_VALUE, @ref GLFW_PLATFORM_ERROR and @ref
    ///  GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @pointer_lifetime The specified image data is copied before this function
    ///  returns.
    ///
    ///  @remark @macos Regular windows do not have icons on macOS.  This function
    ///  will emit @ref GLFW_FEATURE_UNAVAILABLE.  The dock icon will be the same as
    ///  the application bundle's icon.  For more information on bundles, see the
    ///  [Bundle Programming Guide][bundle-guide] in the Mac Developer Library.
    ///
    ///  [bundle-guide]: https://developer.apple.com/library/mac/documentation/CoreFoundation/Conceptual/CFBundles/
    ///
    ///  @remark @wayland There is no existing protocol to change an icon, the
    ///  window will thus inherit the one defined in the application's desktop file.
    ///  This function will emit @ref GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_icon
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup window
    public void setWindowIcon(
        @Nullable GLFWwindow window,
        int count,
        @Nullable @Pointer IGLFWimage images
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowIcon);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                count,
                (MemorySegment) (images != null ? images.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the iconify callback for the specified window.
    ///
    ///  This function sets the iconification callback of the specified window, which
    ///  is called when the window is iconified or restored.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int iconified)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowiconifyfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_iconify
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowiconifyfun") @NotNull MemorySegment setWindowIconifyCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowiconifyfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowIconifyCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowiconifyfun") @NotNull MemorySegment setWindowIconifyCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowiconifyfun callback
    ) {
        return setWindowIconifyCallback(
            window,
            IGLFWwindowiconifyfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowiconifyfun") @NotNull MemorySegment setWindowIconifyCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowiconifyfun callback
    ) {
        return setWindowIconifyCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the maximize callback for the specified window.
    ///
    ///  This function sets the maximization callback of the specified window, which
    ///  is called when the window is maximized or restored.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int maximized)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowmaximizefun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_maximize
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowmaximizefun") @NotNull MemorySegment setWindowMaximizeCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowmaximizefun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowMaximizeCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowmaximizefun") @NotNull MemorySegment setWindowMaximizeCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowmaximizefun callback
    ) {
        return setWindowMaximizeCallback(
            window,
            IGLFWwindowmaximizefun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowmaximizefun") @NotNull MemorySegment setWindowMaximizeCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowmaximizefun callback
    ) {
        return setWindowMaximizeCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the mode, monitor, video mode and placement of a window.
    ///
    ///  This function sets the monitor that the window uses for full screen mode or,
    ///  if the monitor is `NULL`, makes it windowed mode.
    ///
    ///  When setting a monitor, this function updates the width, height and refresh
    ///  rate of the desired video mode and switches to the video mode closest to it.
    ///  The window position is ignored when setting a monitor.
    ///
    ///  When the monitor is `NULL`, the position, width and height are used to
    ///  place the window content area.  The refresh rate is ignored when no monitor
    ///  is specified.
    ///
    ///  If you only wish to update the resolution of a full screen window or the
    ///  size of a windowed mode window, see @ref glfwSetWindowSize.
    ///
    ///  When a window transitions from full screen to windowed mode, this function
    ///  restores any previous window settings such as whether it is decorated,
    ///  floating, resizable, has size or aspect ratio limits, etc.
    ///
    ///  @param[in] window The window whose monitor, size or video mode to set.
    ///  @param[in] monitor The desired monitor, or `NULL` to set windowed mode.
    ///  @param[in] xpos The desired x-coordinate of the upper-left corner of the
    ///  content area.
    ///  @param[in] ypos The desired y-coordinate of the upper-left corner of the
    ///  content area.
    ///  @param[in] width The desired with, in screen coordinates, of the content
    ///  area or video mode.
    ///  @param[in] height The desired height, in screen coordinates, of the content
    ///  area or video mode.
    ///  @param[in] refreshRate The desired refresh rate, in Hz, of the video mode,
    ///  or `GLFW_DONT_CARE`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark The OpenGL or OpenGL ES context will not be destroyed or otherwise
    ///  affected by any resizing or mode switching, although you may need to update
    ///  your viewport if the framebuffer size has changed.
    ///
    ///  @remark @wayland The desired window position is ignored, as there is no way
    ///  for an application to set this property.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_monitor
    ///  @sa @ref window_full_screen
    ///  @sa @ref glfwGetWindowMonitor
    ///  @sa @ref glfwSetWindowSize
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup window
    public void setWindowMonitor(
        @Nullable GLFWwindow window,
        @Nullable GLFWmonitor monitor,
        int xpos,
        int ypos,
        int width,
        int height,
        int refreshRate
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowMonitor);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (monitor != null ? monitor.segment() : MemorySegment.NULL),
                xpos,
                ypos,
                width,
                height,
                refreshRate
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the opacity of the whole window.
    ///
    ///  This function sets the opacity of the window, including any decorations.
    ///
    ///  The opacity (or alpha) value is a positive finite number between zero and
    ///  one, where zero is fully transparent and one is fully opaque.
    ///
    ///  The initial opacity value for newly created windows is one.
    ///
    ///  A window created with framebuffer transparency may not use whole window
    ///  transparency.  The results of doing this are undefined.
    ///
    ///  @param[in] window The window to set the opacity for.
    ///  @param[in] opacity The desired opacity of the specified window.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_ERROR and @ref GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark @wayland There is no way to set an opacity factor for a window.
    ///  This function will emit @ref GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_transparency
    ///  @sa @ref glfwGetWindowOpacity
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public void setWindowOpacity(
        @Nullable GLFWwindow window,
        float opacity
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowOpacity);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                opacity
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the position of the content area of the specified window.
    ///
    ///  This function sets the position, in screen coordinates, of the upper-left
    ///  corner of the content area of the specified windowed mode window.  If the
    ///  window is a full screen window, this function does nothing.
    ///
    ///  __Do not use this function__ to move an already visible window unless you
    ///  have very good reasons for doing so, as it will confuse and annoy the user.
    ///
    ///  The window manager may put limits on what positions are allowed.  GLFW
    ///  cannot and should not override these limits.
    ///
    ///  @param[in] window The window to query.
    ///  @param[in] xpos The x-coordinate of the upper-left corner of the content area.
    ///  @param[in] ypos The y-coordinate of the upper-left corner of the content area.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_ERROR and @ref GLFW_FEATURE_UNAVAILABLE (see remarks).
    ///
    ///  @remark @wayland There is no way for an application to set the global
    ///  position of its windows.  This function will emit @ref
    ///  GLFW_FEATURE_UNAVAILABLE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_pos
    ///  @sa @ref glfwGetWindowPos
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup window
    public void setWindowPos(
        @Nullable GLFWwindow window,
        int xpos,
        int ypos
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowPos);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                xpos,
                ypos
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the position callback for the specified window.
    ///
    ///  This function sets the position callback of the specified window, which is
    ///  called when the window is moved.  The callback is provided with the
    ///  position, in screen coordinates, of the upper-left corner of the content
    ///  area of the window.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int xpos, int ypos)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowposfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @remark @wayland This callback will never be called, as there is no way for
    ///  an application to know its global position.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_pos
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowposfun") @NotNull MemorySegment setWindowPosCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowposfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowPosCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowposfun") @NotNull MemorySegment setWindowPosCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowposfun callback
    ) {
        return setWindowPosCallback(
            window,
            IGLFWwindowposfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowposfun") @NotNull MemorySegment setWindowPosCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowposfun callback
    ) {
        return setWindowPosCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the refresh callback for the specified window.
    ///
    ///  This function sets the refresh callback of the specified window, which is
    ///  called when the content area of the window needs to be redrawn, for example
    ///  if the window has been exposed after having been covered by another window.
    ///
    ///  On compositing window systems such as Aero, Compiz, Aqua or Wayland, where
    ///  the window contents are saved off-screen, this callback may be called only
    ///  very infrequently or never at all.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window);
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowrefreshfun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_refresh
    ///
    ///  @since Added in version 2.5.
    ///  @glfw3 Added window handle parameter and return value.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowrefreshfun") @NotNull MemorySegment setWindowRefreshCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowrefreshfun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowRefreshCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowrefreshfun") @NotNull MemorySegment setWindowRefreshCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowrefreshfun callback
    ) {
        return setWindowRefreshCallback(
            window,
            IGLFWwindowrefreshfun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowrefreshfun") @NotNull MemorySegment setWindowRefreshCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowrefreshfun callback
    ) {
        return setWindowRefreshCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the close flag of the specified window.
    ///
    ///  This function sets the value of the close flag of the specified window.
    ///  This can be used to override the user's attempt to close the window, or
    ///  to signal that it should be closed.
    ///
    ///  @param[in] window The window whose flag to change.
    ///  @param[in] value The new value.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref window_close
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public void setWindowShouldClose(
        @Nullable GLFWwindow window,
        int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowShouldClose);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the size of the content area of the specified window.
    ///
    ///  This function sets the size, in screen coordinates, of the content area of
    ///  the specified window.
    ///
    ///  For full screen windows, this function updates the resolution of its desired
    ///  video mode and switches to the video mode closest to it, without affecting
    ///  the window's context.  As the context is unaffected, the bit depths of the
    ///  framebuffer remain unchanged.
    ///
    ///  If you wish to update the refresh rate of the desired video mode in addition
    ///  to its resolution, see @ref glfwSetWindowMonitor.
    ///
    ///  The window manager may put limits on what sizes are allowed.  GLFW cannot
    ///  and should not override these limits.
    ///
    ///  @param[in] window The window to resize.
    ///  @param[in] width The desired width, in screen coordinates, of the window
    ///  content area.
    ///  @param[in] height The desired height, in screen coordinates, of the window
    ///  content area.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_size
    ///  @sa @ref glfwGetWindowSize
    ///  @sa @ref glfwSetWindowMonitor
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup window
    public void setWindowSize(
        @Nullable GLFWwindow window,
        int width,
        int height
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowSize);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                width,
                height
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the size callback for the specified window.
    ///
    ///  This function sets the size callback of the specified window, which is
    ///  called when the window is resized.  The callback is provided with the size,
    ///  in screen coordinates, of the content area of the window.
    ///
    ///  @param[in] window The window whose callback to set.
    ///  @param[in] callback The new callback, or `NULL` to remove the currently set
    ///  callback.
    ///  @return The previously set callback, or `NULL` if no callback was set or the
    ///  library had not been [initialized](@ref intro_init).
    ///
    ///  @callback_signature
    ///  @code
    ///  void function_name(GLFWwindow* window, int width, int height)
    ///  @endcode
    ///  For more information about the callback parameters, see the
    ///  [function pointer type](@ref GLFWwindowsizefun).
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_size
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter and return value.
    ///
    ///  @ingroup window
    public @Pointer(comment="GLFWwindowsizefun") @NotNull MemorySegment setWindowSizeCallback(
        @Nullable GLFWwindow window,
        @Pointer(comment="GLFWwindowsizefun") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowSizeCallback);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="GLFWwindowsizefun") @NotNull MemorySegment setWindowSizeCallback(
        Arena arena,
        @Nullable GLFWwindow window,
        IGLFWwindowsizefun callback
    ) {
        return setWindowSizeCallback(
            window,
            IGLFWwindowsizefun.ofNative(arena, callback)
        );
    }

    public @Pointer(comment="GLFWwindowsizefun") @NotNull MemorySegment setWindowSizeCallback(
        @Nullable GLFWwindow window,
        IGLFWwindowsizefun callback
    ) {
        return setWindowSizeCallback(
            Arena.global(),
            window,
            callback
        );
    }

    ///  @brief Sets the size limits of the specified window.
    ///
    ///  This function sets the size limits of the content area of the specified
    ///  window.  If the window is full screen, the size limits only take effect
    ///  once it is made windowed.  If the window is not resizable, this function
    ///  does nothing.
    ///
    ///  The size limits are applied immediately to a windowed mode window and may
    ///  cause it to be resized.
    ///
    ///  The maximum dimensions must be greater than or equal to the minimum
    ///  dimensions and all must be greater than or equal to zero.
    ///
    ///  @param[in] window The window to set limits for.
    ///  @param[in] minwidth The minimum width, in screen coordinates, of the content
    ///  area, or `GLFW_DONT_CARE`.
    ///  @param[in] minheight The minimum height, in screen coordinates, of the
    ///  content area, or `GLFW_DONT_CARE`.
    ///  @param[in] maxwidth The maximum width, in screen coordinates, of the content
    ///  area, or `GLFW_DONT_CARE`.
    ///  @param[in] maxheight The maximum height, in screen coordinates, of the
    ///  content area, or `GLFW_DONT_CARE`.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_VALUE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark If you set size limits and an aspect ratio that conflict, the
    ///  results are undefined.
    ///
    ///  @remark @wayland The size limits will not be applied until the window is
    ///  actually resized, either by the user or by the compositor.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_sizelimits
    ///  @sa @ref glfwSetWindowAspectRatio
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup window
    public void setWindowSizeLimits(
        @Nullable GLFWwindow window,
        int minwidth,
        int minheight,
        int maxwidth,
        int maxheight
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowSizeLimits);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                minwidth,
                minheight,
                maxwidth,
                maxheight
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the title of the specified window.
    ///
    ///  This function sets the window title, encoded as UTF-8, of the specified
    ///  window.
    ///
    ///  @param[in] window The window whose title to change.
    ///  @param[in] title The UTF-8 encoded window title.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @macos The window title will not be updated until the next time you
    ///  process events.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_title
    ///  @sa @ref glfwGetWindowTitle
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup window
    public void setWindowTitle(
        @Nullable GLFWwindow window,
        @Nullable BytePtr title
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowTitle);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                (MemorySegment) (title != null ? title.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the user pointer of the specified window.
    ///
    ///  This function sets the user-defined pointer of the specified window.  The
    ///  current value is retained until the window is destroyed.  The initial value
    ///  is `NULL`.
    ///
    ///  @param[in] window The window whose pointer to set.
    ///  @param[in] pointer The new value.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref window_userptr
    ///  @sa @ref glfwGetWindowUserPointer
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public void setWindowUserPointer(
        @Nullable GLFWwindow window,
        @Pointer(comment="void*") @NotNull MemorySegment pointer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetWindowUserPointer);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL),
                pointer
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the current primary selection to the specified string.
    ///
    ///  @param[in] string A UTF-8 encoded string.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_PLATFORM_UNAVAILABLE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @pointer_lifetime The specified string is copied before this function
    ///  returns.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref clipboard
    ///  @sa glfwGetX11SelectionString
    ///  @sa glfwSetClipboardString
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup native
    public void setX11SelectionString(
        @Nullable BytePtr string
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSetX11SelectionString);
        try {
            hFunction.invokeExact(
                (MemorySegment) (string != null ? string.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Makes the specified window visible.
    ///
    ///  This function makes the specified window visible if it was previously
    ///  hidden.  If the window is already visible or is in full screen mode, this
    ///  function does nothing.
    ///
    ///  By default, windowed mode windows are focused when shown
    ///  Set the [GLFW_FOCUS_ON_SHOW](@ref GLFW_FOCUS_ON_SHOW_hint) window hint
    ///  to change this behavior for all newly created windows, or change the
    ///  behavior for an existing window with @ref glfwSetWindowAttrib.
    ///
    ///  @param[in] window The window to make visible.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @remark @wayland Because Wayland wants every frame of the desktop to be
    ///  complete, this function does not immediately make the window visible.
    ///  Instead it will become visible the next time the window framebuffer is
    ///  updated after this call.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_hide
    ///  @sa @ref glfwHideWindow
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public void showWindow(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwShowWindow);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Swaps the front and back buffers of the specified window.
    ///
    ///  This function swaps the front and back buffers of the specified window when
    ///  rendering with OpenGL or OpenGL ES.  If the swap interval is greater than
    ///  zero, the GPU driver waits the specified number of screen updates before
    ///  swapping the buffers.
    ///
    ///  The specified window must have an OpenGL or OpenGL ES context.  Specifying
    ///  a window without a context will generate a @ref GLFW_NO_WINDOW_CONTEXT
    ///  error.
    ///
    ///  This function does not apply to Vulkan.  If you are rendering with Vulkan,
    ///  see `vkQueuePresentKHR` instead.
    ///
    ///  @param[in] window The window whose buffers to swap.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_WINDOW_CONTEXT and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark __EGL:__ The context of the specified window must be current on the
    ///  calling thread.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref buffer_swap
    ///  @sa @ref glfwSwapInterval
    ///
    ///  @since Added in version 1.0.
    ///  @glfw3 Added window handle parameter.
    ///
    ///  @ingroup window
    public void swapBuffers(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSwapBuffers);
        try {
            hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the swap interval for the current context.
    ///
    ///  This function sets the swap interval for the current OpenGL or OpenGL ES
    ///  context, i.e. the number of screen updates to wait from the time @ref
    ///  glfwSwapBuffers was called before swapping the buffers and returning.  This
    ///  is sometimes called _vertical synchronization_, _vertical retrace
    ///  synchronization_ or just _vsync_.
    ///
    ///  A context that supports either of the `WGL_EXT_swap_control_tear` and
    ///  `GLX_EXT_swap_control_tear` extensions also accepts _negative_ swap
    ///  intervals, which allows the driver to swap immediately even if a frame
    ///  arrives a little bit late.  You can check for these extensions with @ref
    ///  glfwExtensionSupported.
    ///
    ///  A context must be current on the calling thread.  Calling this function
    ///  without a current context will cause a @ref GLFW_NO_CURRENT_CONTEXT error.
    ///
    ///  This function does not apply to Vulkan.  If you are rendering with Vulkan,
    ///  see the present mode of your swapchain instead.
    ///
    ///  @param[in] interval The minimum number of screen updates to wait for
    ///  until the buffers are swapped by @ref glfwSwapBuffers.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_NO_CURRENT_CONTEXT and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark This function is not called during context creation, leaving the
    ///  swap interval set to whatever is the default for that API.  This is done
    ///  because some swap interval extensions used by GLFW do not allow the swap
    ///  interval to be reset to zero once it has been set to a non-zero value.
    ///
    ///  @remark Some GPU drivers do not honor the requested swap interval, either
    ///  because of a user setting that overrides the application's request or due to
    ///  bugs in the driver.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref buffer_swap
    ///  @sa @ref glfwSwapBuffers
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup context
    public void swapInterval(
        int interval
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwSwapInterval);
        try {
            hFunction.invokeExact(
                interval
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Terminates the GLFW library.
    ///
    ///  This function destroys all remaining windows and cursors, restores any
    ///  modified gamma ramps and frees any other allocated resources.  Once this
    ///  function is called, you must again call @ref glfwInit successfully before
    ///  you will be able to use most GLFW functions.
    ///
    ///  If GLFW has been successfully initialized, this function should be called
    ///  before the application exits.  If initialization fails, there is no need to
    ///  call this function, as it is called by @ref glfwInit before it returns
    ///  failure.
    ///
    ///  This function has no effect if GLFW is not initialized.
    ///
    ///  @errors Possible errors include @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @remark This function may be called before @ref glfwInit.
    ///
    ///  @warning The contexts of any remaining windows must not be current on any
    ///  other thread when this function is called.
    ///
    ///  @reentrancy This function must not be called from a callback.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref intro_init
    ///  @sa @ref glfwInit
    ///
    ///  @since Added in version 1.0.
    ///
    ///  @ingroup init
    public void terminate() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwTerminate);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Adds the specified SDL_GameControllerDB gamepad mappings.
    ///
    ///  This function parses the specified ASCII encoded string and updates the
    ///  internal list with any gamepad mappings it finds.  This string may
    ///  contain either a single gamepad mapping or many mappings separated by
    ///  newlines.  The parser supports the full format of the `gamecontrollerdb.txt`
    ///  source file including empty lines and comments.
    ///
    ///  See @ref gamepad_mapping for a description of the format.
    ///
    ///  If there is already a gamepad mapping for a given GUID in the internal list,
    ///  it will be replaced by the one passed to this function.  If the library is
    ///  terminated and re-initialized the internal list will revert to the built-in
    ///  default.
    ///
    ///  @param[in] string The string containing the gamepad mappings.
    ///  @return `GLFW_TRUE` if successful, or `GLFW_FALSE` if an
    ///  [error](@ref error_handling) occurred.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_VALUE.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref gamepad
    ///  @sa @ref glfwJoystickIsGamepad
    ///  @sa @ref glfwGetGamepadName
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup input
    public int updateGamepadMappings(
        @Nullable BytePtr string
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwUpdateGamepadMappings);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (string != null ? string.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Returns whether the Vulkan loader and an ICD have been found.
    ///
    ///  This function returns whether the Vulkan loader and any minimally functional
    ///  ICD have been found.
    ///
    ///  The availability of a Vulkan loader and even an ICD does not by itself guarantee that
    ///  surface creation or even instance creation is possible.  Call @ref
    ///  glfwGetRequiredInstanceExtensions to check whether the extensions necessary for Vulkan
    ///  surface creation are available and @ref glfwGetPhysicalDevicePresentationSupport to
    ///  check whether a queue family of a physical device supports image presentation.
    ///
    ///  @return `GLFW_TRUE` if Vulkan is minimally available, or `GLFW_FALSE`
    ///  otherwise.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.
    ///
    ///  @sa @ref vulkan_support
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup vulkan
    public int vulkanSupported() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwVulkanSupported);
        try {
            return (int) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Waits until events are queued and processes them.
    ///
    ///  This function puts the calling thread to sleep until at least one event is
    ///  available in the event queue.  Once one or more events are available,
    ///  it behaves exactly like @ref glfwPollEvents, i.e. the events in the queue
    ///  are processed and the function then returns immediately.  Processing events
    ///  will cause the window and input callbacks associated with those events to be
    ///  called.
    ///
    ///  Since not all events are associated with callbacks, this function may return
    ///  without a callback having been called even if you are monitoring all
    ///  callbacks.
    ///
    ///  On some platforms, a window move, resize or menu operation will cause event
    ///  processing to block.  This is due to how event processing is designed on
    ///  those platforms.  You can use the
    ///  [window refresh callback](@ref window_refresh) to redraw the contents of
    ///  your window when necessary during such operations.
    ///
    ///  Do not assume that callbacks you set will _only_ be called in response to
    ///  event processing functions like this one.  While it is necessary to poll for
    ///  events, window systems that require GLFW to register callbacks of its own
    ///  can pass events to GLFW in response to many window system function calls.
    ///  GLFW will pass those events on to the application callbacks before
    ///  returning.
    ///
    ///  Event processing is not required for joystick input to work.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_PLATFORM_ERROR.
    ///
    ///  @reentrancy This function must not be called from a callback.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref events
    ///  @sa @ref glfwPollEvents
    ///  @sa @ref glfwWaitEventsTimeout
    ///
    ///  @since Added in version 2.5.
    ///
    ///  @ingroup window
    public void waitEvents() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwWaitEvents);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Waits with timeout until events are queued and processes them.
    ///
    ///  This function puts the calling thread to sleep until at least one event is
    ///  available in the event queue, or until the specified timeout is reached.  If
    ///  one or more events are available, it behaves exactly like @ref
    ///  glfwPollEvents, i.e. the events in the queue are processed and the function
    ///  then returns immediately.  Processing events will cause the window and input
    ///  callbacks associated with those events to be called.
    ///
    ///  The timeout value must be a positive finite number.
    ///
    ///  Since not all events are associated with callbacks, this function may return
    ///  without a callback having been called even if you are monitoring all
    ///  callbacks.
    ///
    ///  On some platforms, a window move, resize or menu operation will cause event
    ///  processing to block.  This is due to how event processing is designed on
    ///  those platforms.  You can use the
    ///  [window refresh callback](@ref window_refresh) to redraw the contents of
    ///  your window when necessary during such operations.
    ///
    ///  Do not assume that callbacks you set will _only_ be called in response to
    ///  event processing functions like this one.  While it is necessary to poll for
    ///  events, window systems that require GLFW to register callbacks of its own
    ///  can pass events to GLFW in response to many window system function calls.
    ///  GLFW will pass those events on to the application callbacks before
    ///  returning.
    ///
    ///  Event processing is not required for joystick input to work.
    ///
    ///  @param[in] timeout The maximum amount of time, in seconds, to wait.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED, @ref
    ///  GLFW_INVALID_VALUE and @ref GLFW_PLATFORM_ERROR.
    ///
    ///  @reentrancy This function must not be called from a callback.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref events
    ///  @sa @ref glfwPollEvents
    ///  @sa @ref glfwWaitEvents
    ///
    ///  @since Added in version 3.2.
    ///
    ///  @ingroup window
    public void waitEventsTimeout(
        double timeout
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwWaitEventsTimeout);
        try {
            hFunction.invokeExact(
                timeout
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the specified window hint to the desired value.
    ///
    ///  This function sets hints for the next call to @ref glfwCreateWindow.  The
    ///  hints, once set, retain their values until changed by a call to this
    ///  function or @ref glfwDefaultWindowHints, or until the library is terminated.
    ///
    ///  Only integer value hints can be set with this function.  String value hints
    ///  are set with @ref glfwWindowHintString.
    ///
    ///  This function does not check whether the specified hint values are valid.
    ///  If you set hints to invalid values this will instead be reported by the next
    ///  call to @ref glfwCreateWindow.
    ///
    ///  Some hints are platform specific.  These may be set on any platform but they
    ///  will only affect their specific platform.  Other platforms will ignore them.
    ///  Setting these hints requires no platform specific headers or functions.
    ///
    ///  @param[in] hint The [window hint](@ref window_hints) to set.
    ///  @param[in] value The new value of the window hint.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_hints
    ///  @sa @ref glfwWindowHintString
    ///  @sa @ref glfwDefaultWindowHints
    ///
    ///  @since Added in version 3.0.  Replaces `glfwOpenWindowHint`.
    ///
    ///  @ingroup window
    public void windowHint(
        int hint,
        int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwWindowHint);
        try {
            hFunction.invokeExact(
                hint,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Sets the specified window hint to the desired value.
    ///
    ///  This function sets hints for the next call to @ref glfwCreateWindow.  The
    ///  hints, once set, retain their values until changed by a call to this
    ///  function or @ref glfwDefaultWindowHints, or until the library is terminated.
    ///
    ///  Only string type hints can be set with this function.  Integer value hints
    ///  are set with @ref glfwWindowHint.
    ///
    ///  This function does not check whether the specified hint values are valid.
    ///  If you set hints to invalid values this will instead be reported by the next
    ///  call to @ref glfwCreateWindow.
    ///
    ///  Some hints are platform specific.  These may be set on any platform but they
    ///  will only affect their specific platform.  Other platforms will ignore them.
    ///  Setting these hints requires no platform specific headers or functions.
    ///
    ///  @param[in] hint The [window hint](@ref window_hints) to set.
    ///  @param[in] value The new value of the window hint.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED and @ref
    ///  GLFW_INVALID_ENUM.
    ///
    ///  @pointer_lifetime The specified string is copied before this function
    ///  returns.
    ///
    ///  @thread_safety This function must only be called from the main thread.
    ///
    ///  @sa @ref window_hints
    ///  @sa @ref glfwWindowHint
    ///  @sa @ref glfwDefaultWindowHints
    ///
    ///  @since Added in version 3.3.
    ///
    ///  @ingroup window
    public void windowHintString(
        int hint,
        @Nullable BytePtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwWindowHintString);
        try {
            hFunction.invokeExact(
                hint,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  @brief Checks the close flag of the specified window.
    ///
    ///  This function returns the value of the close flag of the specified window.
    ///
    ///  @param[in] window The window to query.
    ///  @return The value of the close flag.
    ///
    ///  @errors Possible errors include @ref GLFW_NOT_INITIALIZED.
    ///
    ///  @thread_safety This function may be called from any thread.  Access is not
    ///  synchronized.
    ///
    ///  @sa @ref window_close
    ///
    ///  @since Added in version 3.0.
    ///
    ///  @ingroup window
    public int windowShouldClose(
        @Nullable GLFWwindow window
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$glfwWindowShouldClose);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (window != null ? window.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$glfwCreateCursor;
    public final @Nullable MemorySegment SEGMENT$glfwCreateStandardCursor;
    public final @Nullable MemorySegment SEGMENT$glfwCreateWindow;
    public final @Nullable MemorySegment SEGMENT$glfwCreateWindowSurface;
    public final @Nullable MemorySegment SEGMENT$glfwDefaultWindowHints;
    public final @Nullable MemorySegment SEGMENT$glfwDestroyCursor;
    public final @Nullable MemorySegment SEGMENT$glfwDestroyWindow;
    public final @Nullable MemorySegment SEGMENT$glfwExtensionSupported;
    public final @Nullable MemorySegment SEGMENT$glfwFocusWindow;
    public final @Nullable MemorySegment SEGMENT$glfwGetClipboardString;
    public final @Nullable MemorySegment SEGMENT$glfwGetCocoaMonitor;
    public final @Nullable MemorySegment SEGMENT$glfwGetCocoaView;
    public final @Nullable MemorySegment SEGMENT$glfwGetCocoaWindow;
    public final @Nullable MemorySegment SEGMENT$glfwGetCurrentContext;
    public final @Nullable MemorySegment SEGMENT$glfwGetCursorPos;
    public final @Nullable MemorySegment SEGMENT$glfwGetEGLConfig;
    public final @Nullable MemorySegment SEGMENT$glfwGetEGLContext;
    public final @Nullable MemorySegment SEGMENT$glfwGetEGLDisplay;
    public final @Nullable MemorySegment SEGMENT$glfwGetEGLSurface;
    public final @Nullable MemorySegment SEGMENT$glfwGetError;
    public final @Nullable MemorySegment SEGMENT$glfwGetFramebufferSize;
    public final @Nullable MemorySegment SEGMENT$glfwGetGLXContext;
    public final @Nullable MemorySegment SEGMENT$glfwGetGLXFBConfig;
    public final @Nullable MemorySegment SEGMENT$glfwGetGLXWindow;
    public final @Nullable MemorySegment SEGMENT$glfwGetGamepadName;
    public final @Nullable MemorySegment SEGMENT$glfwGetGamepadState;
    public final @Nullable MemorySegment SEGMENT$glfwGetGammaRamp;
    public final @Nullable MemorySegment SEGMENT$glfwGetInputMode;
    public final @Nullable MemorySegment SEGMENT$glfwGetInstanceProcAddress;
    public final @Nullable MemorySegment SEGMENT$glfwGetJoystickAxes;
    public final @Nullable MemorySegment SEGMENT$glfwGetJoystickButtons;
    public final @Nullable MemorySegment SEGMENT$glfwGetJoystickGUID;
    public final @Nullable MemorySegment SEGMENT$glfwGetJoystickHats;
    public final @Nullable MemorySegment SEGMENT$glfwGetJoystickName;
    public final @Nullable MemorySegment SEGMENT$glfwGetJoystickUserPointer;
    public final @Nullable MemorySegment SEGMENT$glfwGetKey;
    public final @Nullable MemorySegment SEGMENT$glfwGetKeyName;
    public final @Nullable MemorySegment SEGMENT$glfwGetKeyScancode;
    public final @Nullable MemorySegment SEGMENT$glfwGetMonitorContentScale;
    public final @Nullable MemorySegment SEGMENT$glfwGetMonitorName;
    public final @Nullable MemorySegment SEGMENT$glfwGetMonitorPhysicalSize;
    public final @Nullable MemorySegment SEGMENT$glfwGetMonitorPos;
    public final @Nullable MemorySegment SEGMENT$glfwGetMonitorUserPointer;
    public final @Nullable MemorySegment SEGMENT$glfwGetMonitorWorkarea;
    public final @Nullable MemorySegment SEGMENT$glfwGetMonitors;
    public final @Nullable MemorySegment SEGMENT$glfwGetMouseButton;
    public final @Nullable MemorySegment SEGMENT$glfwGetNSGLContext;
    public final @Nullable MemorySegment SEGMENT$glfwGetOSMesaColorBuffer;
    public final @Nullable MemorySegment SEGMENT$glfwGetOSMesaContext;
    public final @Nullable MemorySegment SEGMENT$glfwGetOSMesaDepthBuffer;
    public final @Nullable MemorySegment SEGMENT$glfwGetPhysicalDevicePresentationSupport;
    public final @Nullable MemorySegment SEGMENT$glfwGetPlatform;
    public final @Nullable MemorySegment SEGMENT$glfwGetPrimaryMonitor;
    public final @Nullable MemorySegment SEGMENT$glfwGetProcAddress;
    public final @Nullable MemorySegment SEGMENT$glfwGetRequiredInstanceExtensions;
    public final @Nullable MemorySegment SEGMENT$glfwGetTime;
    public final @Nullable MemorySegment SEGMENT$glfwGetTimerFrequency;
    public final @Nullable MemorySegment SEGMENT$glfwGetTimerValue;
    public final @Nullable MemorySegment SEGMENT$glfwGetVersion;
    public final @Nullable MemorySegment SEGMENT$glfwGetVersionString;
    public final @Nullable MemorySegment SEGMENT$glfwGetVideoMode;
    public final @Nullable MemorySegment SEGMENT$glfwGetVideoModes;
    public final @Nullable MemorySegment SEGMENT$glfwGetWGLContext;
    public final @Nullable MemorySegment SEGMENT$glfwGetWaylandDisplay;
    public final @Nullable MemorySegment SEGMENT$glfwGetWaylandMonitor;
    public final @Nullable MemorySegment SEGMENT$glfwGetWaylandWindow;
    public final @Nullable MemorySegment SEGMENT$glfwGetWin32Adapter;
    public final @Nullable MemorySegment SEGMENT$glfwGetWin32Monitor;
    public final @Nullable MemorySegment SEGMENT$glfwGetWin32Window;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowAttrib;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowContentScale;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowFrameSize;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowMonitor;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowOpacity;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowPos;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowSize;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowTitle;
    public final @Nullable MemorySegment SEGMENT$glfwGetWindowUserPointer;
    public final @Nullable MemorySegment SEGMENT$glfwGetX11Adapter;
    public final @Nullable MemorySegment SEGMENT$glfwGetX11Display;
    public final @Nullable MemorySegment SEGMENT$glfwGetX11Monitor;
    public final @Nullable MemorySegment SEGMENT$glfwGetX11SelectionString;
    public final @Nullable MemorySegment SEGMENT$glfwGetX11Window;
    public final @Nullable MemorySegment SEGMENT$glfwHideWindow;
    public final @Nullable MemorySegment SEGMENT$glfwIconifyWindow;
    public final @Nullable MemorySegment SEGMENT$glfwInit;
    public final @Nullable MemorySegment SEGMENT$glfwInitAllocator;
    public final @Nullable MemorySegment SEGMENT$glfwInitHint;
    public final @Nullable MemorySegment SEGMENT$glfwInitVulkanLoader;
    public final @Nullable MemorySegment SEGMENT$glfwJoystickIsGamepad;
    public final @Nullable MemorySegment SEGMENT$glfwJoystickPresent;
    public final @Nullable MemorySegment SEGMENT$glfwMakeContextCurrent;
    public final @Nullable MemorySegment SEGMENT$glfwMaximizeWindow;
    public final @Nullable MemorySegment SEGMENT$glfwPlatformSupported;
    public final @Nullable MemorySegment SEGMENT$glfwPollEvents;
    public final @Nullable MemorySegment SEGMENT$glfwPostEmptyEvent;
    public final @Nullable MemorySegment SEGMENT$glfwRawMouseMotionSupported;
    public final @Nullable MemorySegment SEGMENT$glfwRequestWindowAttention;
    public final @Nullable MemorySegment SEGMENT$glfwRestoreWindow;
    public final @Nullable MemorySegment SEGMENT$glfwSetCharCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetCharModsCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetClipboardString;
    public final @Nullable MemorySegment SEGMENT$glfwSetCursor;
    public final @Nullable MemorySegment SEGMENT$glfwSetCursorEnterCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetCursorPos;
    public final @Nullable MemorySegment SEGMENT$glfwSetCursorPosCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetDropCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetErrorCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetFramebufferSizeCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetGamma;
    public final @Nullable MemorySegment SEGMENT$glfwSetGammaRamp;
    public final @Nullable MemorySegment SEGMENT$glfwSetInputMode;
    public final @Nullable MemorySegment SEGMENT$glfwSetJoystickCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetJoystickUserPointer;
    public final @Nullable MemorySegment SEGMENT$glfwSetKeyCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetMonitorCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetMonitorUserPointer;
    public final @Nullable MemorySegment SEGMENT$glfwSetMouseButtonCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetScrollCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetTime;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowAspectRatio;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowAttrib;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowCloseCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowContentScaleCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowFocusCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowIcon;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowIconifyCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowMaximizeCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowMonitor;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowOpacity;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowPos;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowPosCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowRefreshCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowShouldClose;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowSize;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowSizeCallback;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowSizeLimits;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowTitle;
    public final @Nullable MemorySegment SEGMENT$glfwSetWindowUserPointer;
    public final @Nullable MemorySegment SEGMENT$glfwSetX11SelectionString;
    public final @Nullable MemorySegment SEGMENT$glfwShowWindow;
    public final @Nullable MemorySegment SEGMENT$glfwSwapBuffers;
    public final @Nullable MemorySegment SEGMENT$glfwSwapInterval;
    public final @Nullable MemorySegment SEGMENT$glfwTerminate;
    public final @Nullable MemorySegment SEGMENT$glfwUpdateGamepadMappings;
    public final @Nullable MemorySegment SEGMENT$glfwVulkanSupported;
    public final @Nullable MemorySegment SEGMENT$glfwWaitEvents;
    public final @Nullable MemorySegment SEGMENT$glfwWaitEventsTimeout;
    public final @Nullable MemorySegment SEGMENT$glfwWindowHint;
    public final @Nullable MemorySegment SEGMENT$glfwWindowHintString;
    public final @Nullable MemorySegment SEGMENT$glfwWindowShouldClose;
    public final @Nullable MethodHandle HANDLE$glfwCreateCursor;
    public final @Nullable MethodHandle HANDLE$glfwCreateStandardCursor;
    public final @Nullable MethodHandle HANDLE$glfwCreateWindow;
    public final @Nullable MethodHandle HANDLE$glfwCreateWindowSurface;
    public final @Nullable MethodHandle HANDLE$glfwDefaultWindowHints;
    public final @Nullable MethodHandle HANDLE$glfwDestroyCursor;
    public final @Nullable MethodHandle HANDLE$glfwDestroyWindow;
    public final @Nullable MethodHandle HANDLE$glfwExtensionSupported;
    public final @Nullable MethodHandle HANDLE$glfwFocusWindow;
    public final @Nullable MethodHandle HANDLE$glfwGetClipboardString;
    public final @Nullable MethodHandle HANDLE$glfwGetCocoaMonitor;
    public final @Nullable MethodHandle HANDLE$glfwGetCocoaView;
    public final @Nullable MethodHandle HANDLE$glfwGetCocoaWindow;
    public final @Nullable MethodHandle HANDLE$glfwGetCurrentContext;
    public final @Nullable MethodHandle HANDLE$glfwGetCursorPos;
    public final @Nullable MethodHandle HANDLE$glfwGetEGLConfig;
    public final @Nullable MethodHandle HANDLE$glfwGetEGLContext;
    public final @Nullable MethodHandle HANDLE$glfwGetEGLDisplay;
    public final @Nullable MethodHandle HANDLE$glfwGetEGLSurface;
    public final @Nullable MethodHandle HANDLE$glfwGetError;
    public final @Nullable MethodHandle HANDLE$glfwGetFramebufferSize;
    public final @Nullable MethodHandle HANDLE$glfwGetGLXContext;
    public final @Nullable MethodHandle HANDLE$glfwGetGLXFBConfig;
    public final @Nullable MethodHandle HANDLE$glfwGetGLXWindow;
    public final @Nullable MethodHandle HANDLE$glfwGetGamepadName;
    public final @Nullable MethodHandle HANDLE$glfwGetGamepadState;
    public final @Nullable MethodHandle HANDLE$glfwGetGammaRamp;
    public final @Nullable MethodHandle HANDLE$glfwGetInputMode;
    public final @Nullable MethodHandle HANDLE$glfwGetInstanceProcAddress;
    public final @Nullable MethodHandle HANDLE$glfwGetJoystickAxes;
    public final @Nullable MethodHandle HANDLE$glfwGetJoystickButtons;
    public final @Nullable MethodHandle HANDLE$glfwGetJoystickGUID;
    public final @Nullable MethodHandle HANDLE$glfwGetJoystickHats;
    public final @Nullable MethodHandle HANDLE$glfwGetJoystickName;
    public final @Nullable MethodHandle HANDLE$glfwGetJoystickUserPointer;
    public final @Nullable MethodHandle HANDLE$glfwGetKey;
    public final @Nullable MethodHandle HANDLE$glfwGetKeyName;
    public final @Nullable MethodHandle HANDLE$glfwGetKeyScancode;
    public final @Nullable MethodHandle HANDLE$glfwGetMonitorContentScale;
    public final @Nullable MethodHandle HANDLE$glfwGetMonitorName;
    public final @Nullable MethodHandle HANDLE$glfwGetMonitorPhysicalSize;
    public final @Nullable MethodHandle HANDLE$glfwGetMonitorPos;
    public final @Nullable MethodHandle HANDLE$glfwGetMonitorUserPointer;
    public final @Nullable MethodHandle HANDLE$glfwGetMonitorWorkarea;
    public final @Nullable MethodHandle HANDLE$glfwGetMonitors;
    public final @Nullable MethodHandle HANDLE$glfwGetMouseButton;
    public final @Nullable MethodHandle HANDLE$glfwGetNSGLContext;
    public final @Nullable MethodHandle HANDLE$glfwGetOSMesaColorBuffer;
    public final @Nullable MethodHandle HANDLE$glfwGetOSMesaContext;
    public final @Nullable MethodHandle HANDLE$glfwGetOSMesaDepthBuffer;
    public final @Nullable MethodHandle HANDLE$glfwGetPhysicalDevicePresentationSupport;
    public final @Nullable MethodHandle HANDLE$glfwGetPlatform;
    public final @Nullable MethodHandle HANDLE$glfwGetPrimaryMonitor;
    public final @Nullable MethodHandle HANDLE$glfwGetProcAddress;
    public final @Nullable MethodHandle HANDLE$glfwGetRequiredInstanceExtensions;
    public final @Nullable MethodHandle HANDLE$glfwGetTime;
    public final @Nullable MethodHandle HANDLE$glfwGetTimerFrequency;
    public final @Nullable MethodHandle HANDLE$glfwGetTimerValue;
    public final @Nullable MethodHandle HANDLE$glfwGetVersion;
    public final @Nullable MethodHandle HANDLE$glfwGetVersionString;
    public final @Nullable MethodHandle HANDLE$glfwGetVideoMode;
    public final @Nullable MethodHandle HANDLE$glfwGetVideoModes;
    public final @Nullable MethodHandle HANDLE$glfwGetWGLContext;
    public final @Nullable MethodHandle HANDLE$glfwGetWaylandDisplay;
    public final @Nullable MethodHandle HANDLE$glfwGetWaylandMonitor;
    public final @Nullable MethodHandle HANDLE$glfwGetWaylandWindow;
    public final @Nullable MethodHandle HANDLE$glfwGetWin32Adapter;
    public final @Nullable MethodHandle HANDLE$glfwGetWin32Monitor;
    public final @Nullable MethodHandle HANDLE$glfwGetWin32Window;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowAttrib;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowContentScale;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowFrameSize;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowMonitor;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowOpacity;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowPos;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowSize;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowTitle;
    public final @Nullable MethodHandle HANDLE$glfwGetWindowUserPointer;
    public final @Nullable MethodHandle HANDLE$glfwGetX11Adapter;
    public final @Nullable MethodHandle HANDLE$glfwGetX11Display;
    public final @Nullable MethodHandle HANDLE$glfwGetX11Monitor;
    public final @Nullable MethodHandle HANDLE$glfwGetX11SelectionString;
    public final @Nullable MethodHandle HANDLE$glfwGetX11Window;
    public final @Nullable MethodHandle HANDLE$glfwHideWindow;
    public final @Nullable MethodHandle HANDLE$glfwIconifyWindow;
    public final @Nullable MethodHandle HANDLE$glfwInit;
    public final @Nullable MethodHandle HANDLE$glfwInitAllocator;
    public final @Nullable MethodHandle HANDLE$glfwInitHint;
    public final @Nullable MethodHandle HANDLE$glfwInitVulkanLoader;
    public final @Nullable MethodHandle HANDLE$glfwJoystickIsGamepad;
    public final @Nullable MethodHandle HANDLE$glfwJoystickPresent;
    public final @Nullable MethodHandle HANDLE$glfwMakeContextCurrent;
    public final @Nullable MethodHandle HANDLE$glfwMaximizeWindow;
    public final @Nullable MethodHandle HANDLE$glfwPlatformSupported;
    public final @Nullable MethodHandle HANDLE$glfwPollEvents;
    public final @Nullable MethodHandle HANDLE$glfwPostEmptyEvent;
    public final @Nullable MethodHandle HANDLE$glfwRawMouseMotionSupported;
    public final @Nullable MethodHandle HANDLE$glfwRequestWindowAttention;
    public final @Nullable MethodHandle HANDLE$glfwRestoreWindow;
    public final @Nullable MethodHandle HANDLE$glfwSetCharCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetCharModsCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetClipboardString;
    public final @Nullable MethodHandle HANDLE$glfwSetCursor;
    public final @Nullable MethodHandle HANDLE$glfwSetCursorEnterCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetCursorPos;
    public final @Nullable MethodHandle HANDLE$glfwSetCursorPosCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetDropCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetErrorCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetFramebufferSizeCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetGamma;
    public final @Nullable MethodHandle HANDLE$glfwSetGammaRamp;
    public final @Nullable MethodHandle HANDLE$glfwSetInputMode;
    public final @Nullable MethodHandle HANDLE$glfwSetJoystickCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetJoystickUserPointer;
    public final @Nullable MethodHandle HANDLE$glfwSetKeyCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetMonitorCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetMonitorUserPointer;
    public final @Nullable MethodHandle HANDLE$glfwSetMouseButtonCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetScrollCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetTime;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowAspectRatio;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowAttrib;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowCloseCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowContentScaleCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowFocusCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowIcon;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowIconifyCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowMaximizeCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowMonitor;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowOpacity;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowPos;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowPosCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowRefreshCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowShouldClose;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowSize;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowSizeCallback;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowSizeLimits;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowTitle;
    public final @Nullable MethodHandle HANDLE$glfwSetWindowUserPointer;
    public final @Nullable MethodHandle HANDLE$glfwSetX11SelectionString;
    public final @Nullable MethodHandle HANDLE$glfwShowWindow;
    public final @Nullable MethodHandle HANDLE$glfwSwapBuffers;
    public final @Nullable MethodHandle HANDLE$glfwSwapInterval;
    public final @Nullable MethodHandle HANDLE$glfwTerminate;
    public final @Nullable MethodHandle HANDLE$glfwUpdateGamepadMappings;
    public final @Nullable MethodHandle HANDLE$glfwVulkanSupported;
    public final @Nullable MethodHandle HANDLE$glfwWaitEvents;
    public final @Nullable MethodHandle HANDLE$glfwWaitEventsTimeout;
    public final @Nullable MethodHandle HANDLE$glfwWindowHint;
    public final @Nullable MethodHandle HANDLE$glfwWindowHintString;
    public final @Nullable MethodHandle HANDLE$glfwWindowShouldClose;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$glfwCreateCursor = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(GLFWimage.LAYOUT),
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwCreateStandardCursor = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwCreateWindow = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwCreateWindowSurface = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwDefaultWindowHints = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwDestroyCursor = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwDestroyWindow = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwExtensionSupported = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwFocusWindow = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetClipboardString = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetCocoaMonitor = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetCocoaView = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetCocoaWindow = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetCurrentContext = FunctionDescriptor.of(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetCursorPos = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetEGLConfig = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetEGLContext = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetEGLDisplay = FunctionDescriptor.of(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetEGLSurface = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetError = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE))
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetFramebufferSize = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetGLXContext = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetGLXFBConfig = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetGLXWindow = FunctionDescriptor.of(
            NativeLayout.C_LONG,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetGamepadName = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetGamepadState = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(GLFWgamepadstate.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetGammaRamp = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(GLFWgammaramp.LAYOUT),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetInputMode = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetInstanceProcAddress = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetJoystickAxes = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetJoystickButtons = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetJoystickGUID = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetJoystickHats = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetJoystickName = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetJoystickUserPointer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetKey = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetKeyName = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetKeyScancode = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMonitorContentScale = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMonitorName = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMonitorPhysicalSize = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMonitorPos = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMonitorUserPointer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMonitorWorkarea = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMonitors = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetMouseButton = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetNSGLContext = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetOSMesaColorBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetOSMesaContext = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetOSMesaDepthBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetPhysicalDevicePresentationSupport = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetPlatform = FunctionDescriptor.of(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetPrimaryMonitor = FunctionDescriptor.of(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetProcAddress = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetRequiredInstanceExtensions = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetTime = FunctionDescriptor.of(
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetTimerFrequency = FunctionDescriptor.of(
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetTimerValue = FunctionDescriptor.of(
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetVersion = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetVersionString = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetVideoMode = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(GLFWvidmode.LAYOUT),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetVideoModes = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(GLFWvidmode.LAYOUT),
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWGLContext = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWaylandDisplay = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWaylandMonitor = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWaylandWindow = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWin32Adapter = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWin32Monitor = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWin32Window = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowAttrib = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowContentScale = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowFrameSize = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowMonitor = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowOpacity = FunctionDescriptor.of(
            ValueLayout.JAVA_FLOAT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowPos = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowSize = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowTitle = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetWindowUserPointer = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetX11Adapter = FunctionDescriptor.of(
            NativeLayout.C_LONG,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetX11Display = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetX11Monitor = FunctionDescriptor.of(
            NativeLayout.C_LONG,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetX11SelectionString = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwGetX11Window = FunctionDescriptor.of(
            NativeLayout.C_LONG,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwHideWindow = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwIconifyWindow = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwInit = FunctionDescriptor.of(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwInitAllocator = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS.withTargetLayout(GLFWallocator.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwInitHint = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwInitVulkanLoader = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwJoystickIsGamepad = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwJoystickPresent = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwMakeContextCurrent = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwMaximizeWindow = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwPlatformSupported = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwPollEvents = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwPostEmptyEvent = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwRawMouseMotionSupported = FunctionDescriptor.of(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwRequestWindowAttention = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwRestoreWindow = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetCharCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetCharModsCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetClipboardString = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetCursor = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetCursorEnterCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetCursorPos = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_DOUBLE,
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetCursorPosCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetDropCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetErrorCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetFramebufferSizeCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetGamma = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetGammaRamp = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(GLFWgammaramp.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetInputMode = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetJoystickCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetJoystickUserPointer = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetKeyCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetMonitorCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetMonitorUserPointer = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetMouseButtonCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetScrollCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetTime = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowAspectRatio = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowAttrib = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowCloseCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowContentScaleCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowFocusCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowIcon = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(GLFWimage.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowIconifyCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowMaximizeCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowMonitor = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowOpacity = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowPos = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowPosCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowRefreshCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowShouldClose = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowSize = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowSizeCallback = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowSizeLimits = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowTitle = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetWindowUserPointer = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSetX11SelectionString = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwShowWindow = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSwapBuffers = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwSwapInterval = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwTerminate = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwUpdateGamepadMappings = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwVulkanSupported = FunctionDescriptor.of(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwWaitEvents = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwWaitEventsTimeout = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwWindowHint = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwWindowHintString = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$glfwWindowShouldClose = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
