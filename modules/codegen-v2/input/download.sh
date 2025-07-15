#!/usr/bin/env bash

# Note: we're restricting to GLFW 3.4. Update this when GLFW releases a new version.
echo Downloading GLFW header files
GLFW_VERSION="refs/tags/3.4"
curl -o glfw3.h https://raw.githubusercontent.com/glfw/glfw/$GLFW_VERSION/include/GLFW/glfw3.h
curl -o glfw3native.h https://raw.githubusercontent.com/glfw/glfw/$GLFW_VERSION/include/GLFW/glfw3native.h

echo Downloading Vulkan vk.xml
VK_VERSION="refs/tags/v1.4.313"
curl -o vk.xml https://raw.githubusercontent.com/KhronosGroup/Vulkan-Docs/$VK_VERSION/xml/vk.xml
curl -o video.xml https://raw.githubusercontent.com/KhronosGroup/Vulkan-Docs/$VK_VERSION/xml/video.xml

echo Downloading OpenGL gl.xml
GL_VERSION="main"
curl -o gl.xml https://raw.githubusercontent.com/KhronosGroup/OpenGL-Registry/$GL_VERSION/xml/gl.xml

echo Downloading OpenXR xr.vml
XR_VERSION="refs/tags/release-1.1.49"
curl -o xr.xml https://raw.githubusercontent.com/KhronosGroup/OpenXR-Docs/$XR_VERSION/specification/registry/xr.xml

# Note: we're restricting to VMA 3.2. Update this when VMA releases a new version.
echo Downloading VMA header file
VMA_VERSION="refs/tags/v3.2.0"
curl -o vk_mem_alloc.h https://raw.githubusercontent.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator/$VMA_VERSION/include/vk_mem_alloc.h

# Note: we're restricting to OpenAL 1.24.3 Update this when VMA releases a new version.
echo Downloading OpenAL header file
AL_VERSION="refs/tags/1.24.3"
curl -o al.h https://raw.githubusercontent.com/kcat/openal-soft/$AL_VERSION/include/AL/al.h
curl -o alc.h https://raw.githubusercontent.com/kcat/openal-soft/$AL_VERSION/include/AL/alc.h
curl -o alext.h https://raw.githubusercontent.com/kcat/openal-soft/$AL_VERSION/include/AL/alext.h
curl -o efx.h https://raw.githubusercontent.com/kcat/openal-soft/$AL_VERSION/include/AL/efx.h
curl -o efx-presets.h https://raw.githubusercontent.com/kcat/openal-soft/$AL_VERSION/include/AL/efx-presets.h
# efx-creative.h are empty
#curl -o efx-creative.h https://raw.githubusercontent.com/kcat/openal-soft/$AL_VERSION/include/AL/efx-creative.h

# echo Downloading SDL
# curl -o SDL3.tar.gz https://github.com/libsdl-org/SDL/releases/download/release-3.2.14/SDL3-3.2.14.tar.gz
# tar -xzf SDL3-3.2.14.tar.gz

echo Downloading OpenCL cl.xml
CL_VERSION="refs/tags/v3.0.19"
curl -o cl.xml https://raw.githubusercontent.com/KhronosGroup/OpenCL-Docs/$CL_VERSION/xml/cl.xml
