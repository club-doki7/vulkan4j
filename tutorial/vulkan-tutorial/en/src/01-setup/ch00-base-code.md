# Base code

> [Java code](https://github.com/club-doki7/vulkan4j/tree/master/modules/tutorial/src/main/java/tutorial/vulkan/part01/ch00/Main.java) | [C++ version](https://vulkan-tutorial.com/Drawing_a_triangle/Setup/Base_code)

## General structure

In the previous chapter you've created a Vulkan project with all the proper configuration and tested it with the sample code. In this chapter we're starting from scratch with the following code:

```java
class Application {
    public void run() {
        initVulkan();
        mainLoop();
        cleanup();
    }

    private void initVulkan() {
    }

    private void mainLoop() {
    }

    private void cleanup() {
    }
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
```

The program itself is wrapped into a class where we'll store the Vulkan objects as private class members and add functions to initiate each of them, which will be called from the `initVulkan` function. Once everything has been prepared, we enter the main loop to start rendering frames. We'll fill in the `mainLoop` function to include a loop that iterates until the window is closed in a moment. Once the window is closed and mainLoop returns, we'll make sure to deallocate the resources we've used in the `cleanup` function.

If any kind of fatal error occurs during execution then we'll throw a `RuntimeException` exception with a descriptive message, which will propagate back to the main function and be printed to the command prompt. To handle a variety of standard exception types as well, we catch the more general `java.lang.Throwable`. One example of an error that we will deal with soon is finding out that a certain required extension is not supported.

Roughly every chapter that follows after this one will add one new function that will be called from `initVulkan` and one or more new Vulkan objects to the private class members that need to be freed at the end in `cleanup`.

## Resource management

Just like each chunk of memory allocated with malloc requires a call to free, every Vulkan object that we create needs to be explicitly destroyed when we no longer need it. While in Java there are several ways to manage resources automatically, however, I've chosen to be explicit about allocation and deallocation of Vulkan objects in this tutorial. After all, Vulkan's niche is to be explicit about every operation to avoid mistakes, so it's good to be explicit about the lifetime of objects to learn how the API works. 

After following this tutorial, you could implement automatic resource management by writing Java classes that acquire Vulkan objects in their constructor and release them in maybe `Autoclosable::close`, depending on your ownership requirements. RAII is the recommended model for larger Vulkan programs, but for learning purposes it's always good to know what's going on behind the scenes.

Vulkan objects are either created directly with functions like `createXXX`, or allocated through another object with functions like `allocateXXX`. After making sure that an object is no longer used anywhere, you need to destroy it with the counterparts `destroyXXX` and `freeXXX`. The parameters for these functions generally vary for different types of objects, but there is one parameter that they all share: `pAllocator`. This is an optional parameter that allows you to specify callbacks for a custom memory allocator. We will ignore this parameter in the tutorial and always pass `null` as argument.

## Initializing GLFW

Vulkan works perfectly fine without creating a window if you want to use it for off-screen rendering, but it's a lot more exciting to actually show something! Add a `initWindow` function and add a call to it from the run function before the other calls. We'll use that function to initialize GLFW and create a window.

```java
public void run() {
    initWindow();
    initVulkan();
    mainLoop();
    cleanup();
}

private void initWindow() {
}
```

Unlike in LWJGL or some other wrappers, with `vulkan4j`, you need to manually load both library and the library functions. Firstly we need to load GLFW native library into the JVM. This can be done with a single line of code:

```java
private static final libGLFW = GLFWLoader.loadGLFWLibrary();
```

Then we want to load the GLFW functions. Add another private field to the `Application` class:

```java
private static final GLFW glfw = GLFWLoader.loadGLFW(libGLFW);
```

Then we can call `GLFW::init()` to initialize the GLFW library. If it fails, we'll throw an exception:

```java
if (glfw.init() != GLFW.TRUE) {
    throw new RuntimeException("Failed to initialize GLFW");
}
```

Then we will check Vulkan support with `GLFW::vulkanSupported()`:

```java
if (glfw.vulkanSupported() != GLFW.TRUE) {
    throw new RuntimeException("Vulkan is not supported");
}
```

Then we start giving GLFW hints about the window we want to create. Because GLFW was originally designed to create an OpenGL context, we need to tell it to not create an OpenGL context with a subsequent call:

```java
glfw.windowHint(GLFW.CLIENT_API, GLFW.NO_API);
```

Because handling resized windows takes special care that we'll look into later, disable it for now with another window hint call:

```java
glfw.windowHint(GLFW.RESIZABLE, GLFW.FALSE);
```

All that's left now is creating the actual window. Add a private class member to store the window handle:

```java
private GLFWwindow window;
``` 

And then initialize it with `GLFW::createWindow`:

```java
window = Objects.requireNonNull(glfw.createWindow(800, 600, ByteBuffer.allocateString(Arena.global(), "Vulkan"), null, null));
```

The first three parameters specify the width, height and title of the window. The fourth parameter allows you to optionally specify a monitor to open the window on and the last parameter is only relevant to OpenGL.

It's a good idea to use constants instead of hardcoded width and height numbers because we'll be referring to these values a couple of times in the future. Also, using constants helps reduce expression size. I've added the following constants in the `Application` class definition: 

```java
private static final int WIDTH = 800;
private static final int HEIGHT = 600;
private static final BytePtr WINDOW_TITLE = BytePtr.allocateString(Arena.global(), "Vulkan");
```

and replaced the window creation call with

```java
window = Objects.requireNonNull(glfw.createWindow(WIDTH, HEIGHT, WINDOW_TITLE, null, null));
```

You should now have a `initWindow` function that looks like this:

```java
private void initWindow() {
    GLFWLoader.loadGLFWLibrary();
    glfw = GLFWLoader.loadGLFW();

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
```

To keep the application running until either an error occurs or the window is closed, we need to add an event loop to the `mainLoop` function as follows:

```java
private void mainLoop() {
    while (glfw.windowShouldClose(window) == GLFW.FALSE) {
        glfw.pollEvents();
    }
}
```

This code should be fairly self-explanatory. It loops and checks for events like pressing the X button until the window has been closed by the user. This is also the loop where we'll later call a function to render a single frame.

Once the window is closed, we need to clean up resources by destroying it and terminating GLFW itself. This will be our first `cleanup` code:

```java
private void cleanup() {
    glfw.destroyWindow(window);
    glfw.terminate();
}
```

When you run the program now you should see a window titled Vulkan show up until the application is terminated by closing the window. Now that we have the skeleton for the Vulkan application, let's [create the first Vulkan object](ch01-instance.md)!
