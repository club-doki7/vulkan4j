# Introduction

> [C++ version](https://vulkan-tutorial.com/)

This tutorial is an adaptation of <https://vulkan-tutorial.com> to use Java instead of C++. The majority of the credit for this tutorial should go the author of the original tutorial ([Alexander Overvoorde](https://github.com/Overv)) and the [other contributors](https://github.com/Overv/VulkanTutorial/graphs/contributors).

## About

This tutorial will teach you the basics of using the [Vulkan](https://www.khronos.org/vulkan/) graphics and compute API. Vulkan is a new API by the [Khronos group](https://www.khronos.org/) (known for OpenGL) that provides a much better abstraction of modern graphics cards. This new interface allows you to better describe what your application intends to do, which can lead to better performance and less surprising driver behavior compared to existing APIs like [OpenGL](https://en.wikipedia.org/wiki/OpenGL) and [Direct3D](https://en.wikipedia.org/wiki/Direct3D). The ideas behind Vulkan are similar to those of [Direct3D 12](https://en.wikipedia.org/wiki/Direct3D#Direct3D_12) and [Metal](https://en.wikipedia.org/wiki/Metal_(API)), but Vulkan has the advantage of being cross-platform and allows you to develop for Windows, Linux and Android at the same time (and iOS and macOS via [MoltenVK](https://github.com/KhronosGroup/MoltenVK)).

However, the price you pay for these benefits is that you have to work with a significantly more verbose API. Every detail related to the graphics API needs to be set up from scratch by your application, including initial frame buffer creation and memory management for objects like buffers and texture images. The graphics driver will do a lot less hand holding, which means that you will have to do more work in your application to ensure correct behavior.

The takeaway message here is that Vulkan is not for everyone. It is targeted at programmers who are enthusiastic about high performance computer graphics, and are willing to put some work in. If you are more interested in game development, rather than computer graphics, then you may wish to stick to OpenGL or Direct3D, which will not be deprecated in favor of Vulkan anytime soon. Another alternative is to use an engine like [Unreal Engine](https://en.wikipedia.org/wiki/Unreal_Engine#Unreal_Engine_4) or [Unity](https://en.wikipedia.org/wiki/Unity_(game_engine)), which will be able to use Vulkan while exposing a much higher level API to you.

With that out of the way, let's cover some prerequisites for following this tutorial:

* A graphics card and driver compatible with Vulkan ([NVIDIA](https://developer.nvidia.com/vulkan-driver), [AMD](http://www.amd.com/en-us/innovations/software-technologies/technologies-gaming/vulkan), [Intel](https://software.intel.com/en-us/blogs/2016/03/14/new-intel-vulkan-beta-1540204404-graphics-driver-for-windows-78110-1540))
* Experience with Java
* JDK supporting Java 22
* A good IDE (mostly for auto importing dependencies)
* Some existing experience with 3D computer graphics

This tutorial will not assume knowledge of OpenGL or Direct3D concepts, but it does require you to know the basics of 3D computer graphics. It will not explain the math behind perspective projection, for example. See [this online book](https://paroj.github.io/gltut/) for a great introduction of computer graphics concepts. Some other great computer graphics resources are:

* [Ray tracing in one weekend](https://raytracing.github.io/books/RayTracingInOneWeekend.html)
* [Physically Based Rendering book](http://www.pbr-book.org/)
* Vulkan being used in a real engine in the open-source [Quake](https://github.com/Novum/vkQuake) and [DOOM 3](https://github.com/DustinHLand/vkDOOM3)

If you want a C++ tutorial instead, see the original tutorial: <https://vulkan-tutorial.com>

This tutorial uses the [`vulkan4j`](https://github.com/club-doki7/vulkan4j) package to provide access to the Vulkan API from Java. `vulkan4j` provides raw bindings to the Vulkan API as well as a thin wrapper over said bindings to make them easier and more idiomatic to use from Java. What's more, `vulkan4j` is built on top of the [`Java 22 FFM`](https://openjdk.java.net/projects/panama/) APIs, which is slightly more advanced.

If you want a Java vulkan tutorial that uses a more mature package, checkout these two LWJGL-based tutorials: [vulkanbook](https://github.com/lwjglgamedev/vulkanbook/tree/master), [Vulkan-Tutorial-Java](https://github.com/Naitsirc98/Vulkan-Tutorial-Java).

## Tutorial structure

We'll start with an overview of how Vulkan works and the work we'll have to do to get the first triangle on the screen. The purpose of all the smaller steps will make more sense after you've understood their basic role in the whole picture. Next, we'll set up the development environment with the [Vulkan SDK](https://lunarg.com/vulkan-sdk/).

After that we'll implement all the basic components of a Vulkan program that are necessary to render your first triangle. Each chapter will follow roughly the following structure:

* Introduce a new concept and its purpose
* Use all the relevant API calls to integrate it into your program
* Abstract parts of it into helper functions

Although each chapter is written as a follow-up on the previous one, it is also possible to read the chapters as standalone articles introducing a certain Vulkan feature. That means that the site is also useful as a reference. All the Vulkan functions and types are linked to the Vulkan specification, so you can click them to learn more. Vulkan is still a fairly young API, so there may be some shortcomings in the specification itself. You are encouraged to submit feedback to [this Khronos repository](https://github.com/KhronosGroup/Vulkan-Docs).

Every chapter will also start with a link to the final code for that chapter. You can refer to it if you have any doubts about the structure of the code, or if you're dealing with a bug and want to compare.

This tutorial is intended to be a community effort. Vulkan is still a fairly new API and best practices haven't been fully established. If you have any type of feedback on the tutorial and site itself, then please don't hesitate to submit an issue or pull request to the [GitHub repository](https://github.com/club-doki7/vulkan4j).

After you've gone through the ritual of drawing your very first Vulkan powered triangle onscreen, we'll start expanding the program to include linear transformations, textures and 3D models.

If you've played with graphics APIs before, then you'll know that there can be a lot of steps until the first geometry shows up on the screen. There are many of these initial steps in Vulkan, but you'll see that each of the individual steps is easy to understand and does not feel redundant. It's also important to keep in mind that once you have that boring looking triangle, drawing fully textured 3D models does not take that much extra work, and each step beyond that point is much more rewarding.

If you encounter any problems while following the tutorial, check the FAQ to see if your problem and its solution is already listed there. Next, you might find someone who had the same problem (if it is not Java-specific) in the comment section for the corresponding chapter in the [original tutorial](https://vulkan-tutorial.com/).
