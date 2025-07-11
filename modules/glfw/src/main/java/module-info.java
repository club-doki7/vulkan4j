/// GLFW Java bindings implemented with Java 22 FFM (Project Panama) APIs.
///
/// GLFW is an Open Source, multi-platform library for OpenGL, OpenGL ES and Vulkan development on
/// the desktop. It provides a simple API for creating windows, contexts and surfaces, receiving
/// input and events.
///
/// For actual API documentation, see packages documentation. For GLFW documentation, see
/// <a href="https://www.glfw.org/documentation.html">GLFW website</a>.
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>glfw</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.glfw {
    exports club.doki7.glfw;
    exports club.doki7.glfw.datatype;
    exports club.doki7.glfw.handle;

    requires club.doki7.ffm;
    requires club.doki7.vulkan;
    requires java.base;
    requires org.jetbrains.annotations;
}
