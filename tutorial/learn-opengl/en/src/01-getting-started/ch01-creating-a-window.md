# Creating a window

> [C++ version](https://learnopengl.com/Getting-started/Creating-a-window)

The first thing we need to do before we start creating stunning graphics is to create an OpenGL context and an application window to draw in. However, those operations are specific per operating system and OpenGL purposefully tries to abstract itself from these operations. This means we have to create a window, define a context, and handle user input all by ourselves. 

Luckily, there are quite a few libraries out there that provide the functionality we seek, some specifically aimed at OpenGL. Those libraries save us all the operation-system specific work and give us a window and an OpenGL context to render in. Some of the more popular libraries are GLUT, SDL, SFML and GLFW. On LearnOpenGL we will be using **GLFW**.

Feel free to try any of the other libraries, the setup for most is similar to GLFW's setup. But not all libraries have a `vulkan4j` ecosystem binding. `vulkan4j` ecosystem is somewhat designed to work with prior FFI practices (JNI + `java.nio`), so if you really wants a different library, you just need a little bit of work to make it work with `vulkan4j`.

## Maven project

Create a Maven project and add the following dependencies to your `pom.xml` file:

```xml
<dependency>
    <groupId>club.doki7</groupId>
    <artifactId>ffm-plus</artifactId>
    <version>0.2.7</version>
</dependency>
<dependency>
    <groupId>club.doki7</groupId>
    <artifactId>opengl</artifactId>
    <version>0.4.4</version>
</dependency>
<dependency>
    <groupId>club.doki7</groupId>
    <artifactId>glfw</artifactId>
    <version>0.4.4</version>
</dependency>
<dependency>
    <groupId>org.joml</groupId>
    <artifactId>joml</artifactId>
    <version>1.10.8</version>
</dependency>
<dependency>
    <groupId>de.javagl</groupId>
    <artifactId>obj</artifactId>
    <version>0.4.4</version>
</dependency>
```

`club.doki7.opengl` is the OpenGL binding for Java, `club.doki7.ffm-plus` is a library that provides a thin wrapper over the Java 22 FFM APIs to make them easier and more type-safe to use. `club.doki7.glfw` is a Java binding for the GLFW library, which we'll use for window creation. `org.joml` is a math library that we'll use for vector and matrix operations. `de.javagl.obj` is a library for loading Wavefront OBJ files, which we'll use for loading 3D models.

## GLFW setup

Unlike `lwjgl-glfw` and other Java bindings for GLFW, `club.doki7.glfw` does not come up with the native binaries.

> Chuigda did not bundle the native libraries with `club.doki7.glfw` because he doesn't know what's the best practice in Java world, <del>definitely not because he's lazy</del>. If you have a good idea, a pull request is always welcome.

### Set up GLFW yourself

To set up GLFW yourself, you need to download the GLFW binaries for your operating system and architecture, either from the [official website](https://www.glfw.org/download.html), or using your favorite package manager.Add commentMore actions

If you're using a package manager, all things should be set up for you automatically. However, if you're downloading the binaries manually, you'll need a bit more effort to make JVM find the native libraries. There are two ways to do this:

- Copy (or link) the native library file (`glfw3.dll`) to some directory that is included by `PATH` environment variable.
- Set the `java.library.path` system property to the directory containing the native libraries. This can be done by adding the following line to JVM arguments: `-Djava.library.path=/path/to/glfw/native/libs`. If you're using IDEs, you can usually set this in the run configuration. Consult your IDE documentation for more information.

In realworld production you may want to bundle the native libraries with your application (usually a JAR file), in that case you may use some solution like [native-utils](https://github.com/adamheinrich/native-utils).

### Using `lwjgl-natives`

LWJGL comes with a handy bundle of native library binaries, which can also be used by `vulkan4j`. The setup is a little bit tricky, but also helps avoiding some complications.

Open the [Customize LWJGL](https://www.lwjgl.org/customize) page, choose Maven mode, and pick natives from the left column according to your need. Select only `GLFW` from contents. After doing these, the web page may look like such:

![](../../images/lwjgl_natives_setup.png)

And you will get your Maven configuration below:

![](../../images/lwjgl_generated_maven_config.png)

Copy the configuration to your project's `pom.xml`, but remove the `org.lwjgl.lwjgl-glfw` dependency: we only need the native binaries and library loader provided by LWJGL, not the GLFW wrapper. The content you need to copy may look like:

```xml
<properties>
    <lwjgl.version>3.3.4</lwjgl.version>
</properties>

<profiles>
    <!-- your selected profiles here -->
</profiles>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.lwjgl</groupId>
            <artifactId>lwjgl-bom</artifactId>
            <version>${lwjgl.version}</version>
            <scope>import</scope>
            <type>pom</type>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>org.lwjgl</groupId>
        <artifactId>lwjgl</artifactId>
    </dependency>
    <dependency>
        <groupId>org.lwjgl</groupId>
        <artifactId>lwjgl</artifactId>
        <classifier>${lwjgl.natives}</classifier>
    </dependency>
    <dependency>
        <groupId>org.lwjgl</groupId>
        <artifactId>lwjgl-glfw</artifactId>
        <classifier>${lwjgl.natives}</classifier>
    </dependency>
</dependencies>
```

Then you can load GLFW from `lwjgl-natives`.

## Base code

Let's start with the following code:

```java
import club.doki7.glfw.GLFW;
import club.doki7.opengl.GL;

class Application {
    private GLFW glfw;
    
    public Application(GLFW glfw) {
        this.glfw = glfw;
    }
    
    public void run() {
    }
}

public class Main {
    public static void main(String[] args) {
    }

    private static void applicationStart(GLFW glfw) {
    }
}
```

### Loading GLFW

Unlike in LWJGL or some other wrappers, with vulkan4j, you need to manually load both library and the library functions. If you are setting up GLFW manually:

```java
import club.doki7.glfw.GLFWLoader;

// ...

public class Main {
    public static void main(String[] args) {
        try (ISharedLibrary libGLFW = GLFWLoader.loadGLFWLibrary()) {
            GLFW glfw = GLFWLoader.loadGLFW(libGLFW);
        }
    }
}

```

You may read the JavaDoc and the implementation of `GLFWLoader` to see how it works.

If you are using `lwjgl-natives`, you will need the following code instead:

```java
import org.lwjgl.system.Library;
import org.lwjgl.system.SharedLibrary;

public class Main {
    public static void main(String[] args) {
        try (SharedLibrary libGLFW = Library.loadNative(Library.class, "org.lwjgl.glfw", "glfw", true)) {
            GLFW glfw = new GLFW(name -> MemorySegment.ofAddress(libGLFW.getFunctionAddress(name)));
        }
    }
}
```

Finally, create an instance of `Application` and call its `run` method:

```java
public class Main {
    public static void main(String[] args) {
        GLFW glfw = ...;
        
        Application app = new Application(glfw);
        app.run();
    }
}
```

Hitting the compile button shouldn't give you any errors, at which point we're set to go for the [next chapter](./ch02-hello-window.md) where we'll discuss how we can actually use GLFW to configure an OpenGL context and spawn a window. Be sure to check that all your include and library directories are correct and that the library names in the linker settings match the corresponding libraries. 
