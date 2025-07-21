# vulkan4j

[![CI status](https://github.com/club-doki7/vulkan4j/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/club-doki7/vulkan4j/actions/workflows/ci.yml)
[![Maven Central Version](https://img.shields.io/maven-central/v/club.doki7/vulkan?label=vulkan)](https://repo1.maven.org/maven2/club/doki7/vulkan/)
[![Maven Central Version](https://img.shields.io/maven-central/v/club.doki7/ffm-plus?label=ffm-plus)](https://repo1.maven.org/maven2/club/doki7/ffm-plus/)

> [Website & JavaDoc](https://vulkan4j.doki7.club) | [Module Customizer](https://vulkan4j.doki7.club/module-customizer.html) | [Vulkan Tutorial port](https://vulkan4j.doki7.club/tutorial/en/) | [LearnOpenGL port](https://vulkan4j.doki7.club/learnopengl/en/) | [Examples](https://github.com/club-doki7/vulkan4j/tree/master/modules/example/src/main/java/example) | [Discord](https://discord.gg/UsmRvrt4gg)

*This project is heavily inspired by the [`vulkanalia`](https://github.com/KyleMayes/vulkanalia) crate.*

`vulkan4j` is a series of graphics and relevant API binding for Java, implemented with Java 22 [Project Panama](https://openjdk.org/projects/panama/) `java.lang.foreign` APIs. This project initially focuses on [Vulkan](https://www.vulkan.org/), but soon we expanded to other graphics APIs such as [OpenGL](https://www.opengl.org/) and [OpenGL ES](https://www.khronos.org/opengles/). More APIs will be added in the future, **feature requests and contributions are welcome!**

## Bindings Available

- [Vulkan](https://www.khronos.org/vulkan/) ([`vulkan`](https://github.com/club-doki7/vulkan4j/tree/master/modules/vulkan) module): Generated from [`vk.xml`](https://github.com/KhronosGroup/Vulkan-Docs/blob/main/xml/vk.xml) and [`video.xml`](https://github.com/KhronosGroup/Vulkan-Docs/blob/main/xml/video.xml).
- [Vulkan Memory Allocator](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator) ([`vma`](https://github.com/club-doki7/vulkan4j/tree/master/modules/vma) module): Generated from [`vk_mem_alloc.h`](https://github.com/GPUOpen-LibrariesAndSDKs/VulkanMemoryAllocator/blob/master/include/vk_mem_alloc.h). If you use a specific build supporting `vk4jSetJavaTrace`, you can enjoy Java stacktrace on VMA assertion failures. Check out the [`vma_build`](https://github.com/club-doki7/vulkan4j/tree/master/modules/vma/vma_build) directory for more information.
- [OpenGL](https://www.opengl.org/) ([`opengl`](https://github.com/club-doki7/vulkan4j/tree/master/modules/opengl) module): Generated from [`gl.xml`](https://github.com/KhronosGroup/OpenGL-Registry/blob/main/xml/gl.xml). Our supported extension list is copied from LWJGL, and not all extensions are included (since some OpenGL extensions are completely useless nowadays). Name your desired extension in the issue tracker!
- [OpenCL](https://www.khronos.org/opencl/) ([`opencl`](https://github.com/club-doki7/vulkan4j/tree/master/modules/opencl) module): Generated from OpenCL [`cl.xml`](https://github.com/KhronosGroup/OpenCL-Docs/blob/main/xml/cl.xml).
- [OpenAL](https://www.openal.org/) ([`openal`](https://github.com/club-doki7/vulkan4j/tree/master/modules/openal) module): Generated from OpenAL-soft header files. This module is based on OpenAL-soft 1.2, and provides a complete set of OpenAL features, including all extensions supported by OpenAL-soft.
- [GLFW](https://www.glfw.org/) ([`glfw`](https://github.com/club-doki7/vulkan4j/tree/master/modules/glfw) module): Generated from GLFW header files.
- [libshaderc](https://github.com/google/shaderc) ([`shaderc`](https://github.com/club-doki7/vulkan4j/tree/master/modules/shaderc) module): Generated from `libshaderc` header files. This module also provides a useful `ShadercUtil` class to assist you with including files.
- [STB](https://github.com/nothings/stb) ([`stb`](https://github.com/club-doki7/vulkan4j/tree/master/modules/stb) module): Generated from STB header files, currently contains `stb_image`, `stb_image_write`, `stb_image_resize`, `stb_truetype` and `stb_vorbis`. If you use a specific build supporting `vk4jSetSTBJavaTrace`, you can enjoy Java stacktrace on STB assertion failures. Check out the [`stb_build`](https://github.com/club-doki7/vulkan4j/tree/master/modules/stb/stb_build) directory for more information.

### Experimental Bindings

- [WebGPU Native](https://www.w3.org/TR/webgpu/) ([`webgpu`](https://github.com/club-doki7/vulkan4j/tree/master/modules/webgpu) module): Generated from WebGPU YML IDL. This module is marked as experimental due to the unstable status of WebGPU Native APIs. Read module level documentation for more details.
- [OpenXR](https://www.khronos.org/openxr/) ([`openxr`](https://github.com/club-doki7/vulkan4j/tree/master/modules/openxr) module): Generated from OpenXR XML registry. This module should theoretically have no bugs, but because of the lacking of VR development experience, we haven't tested it thoroughly via a complete dog feeding OpenXR application yet. Report any issues you find, and pull requests are welcome.
- [SDL3](https://www.libsdl.org/) ([`sdl3`](https://github.com/club-doki7/vulkan4j/tree/master/modules/sdl3) module): Generated from SDL3 header files. This module is still under development, it has unimplemented functionalities, and **DOES contain known bugs**. We are planning to migrate to a better manner for parsing C header files, so the update of this module is **stalling** for now.

<details>
<summary>Obsolete bindings</summary>

- [OpenGL ES **2.0 only**](https://www.khronos.org/opengles/) ([`gles2`](https://github.com/club-doki7/vulkan4j/tree/master/modules/gles2) module): Also generated from `gl.xml`. This module only provides most fundamental OpenGL ES 2.0 features, and does not include any extensions. This package was initially created for the Chuigda's own use. This package will still get maintained since Chuigda wants.

</details>

## `ffm-plus`

To improve development experience using Java 22 FFM APIs, we created a small library [`ffm-plus`](https://github.com/club-doki7/vulkan4j/tree/master/modules/ffm-plus) that encapsulates most commonly used facilities, such as typed pointers and bitfield operations. All our bindings use `ffm-plus`.

## Documentation and Tutorials

### [JavaDoc](https://vulkan4j.doki7.club/)

*Our website itself is generated with JavaDoc, with a custom `overview.html`.*

### [Vulkan tutorial port](https://vulkan4j.doki7.club/tutorial/en/)
For users new to Vulkan, there is a (almost) complete adaptation of [https://vulkan-tutorial.com](https://vulkan-tutorial.com) by [Alexander Overvoorde](https://github.com/Overv) to use Java and `vulkan4j` instead of C++. The published version of this tutorial can be found [here](https://vulkan4j.doki7.club/tutorial/en/), and the sources for the tutorial (including standalone working code examples for each chapter) can be found under the `tutorial` directory.

### [LearnOpenGL tutorial port](https://vulkan4j.doki7.club/learnopengl/en/)
For OpenGL users, we ported the [LearnOpenGL](https://learnopengl.com) tutorial to use Java and `vulkan4j`. The published version of this tutorial can be found [here](https://vulkan4j.doki7.club/learnopengl/en/), and the sources for the tutorial can be found under the `tutorial` directory. Till now only the first several chapters are ported, which should be adequate to get you started with OpenGL in Java. The rest of the chapters will be ported in the future.

### [Examples](https://github.com/club-doki7/vulkan4j/tree/master/modules/example/src/main/java/example)
We provide a set of examples, which can be found under the `example` directory. These examples are intended to demonstrate how to use the bindings in practice, and can be used as a reference for your own projects.

## Donation

Doki Doki 7th Design Club! is not accepting any donation at the moment <del>though Chuigda thinks that the whole world owes him 27 billion 30 million CHF</del>. If you like this project, either using in production or got some inspiration, just star and thank author.
