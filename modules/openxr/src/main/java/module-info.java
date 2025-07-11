/// **(Experimental)** OpenXR Java bindings implemented with Java22 FFM (Project Panama) APIs.
///
/// **This module is still experimental. It may contain bugs or incomplete features.**
///
/// For OpenXR reference, see <a href="https://www.khronos.org/registry/OpenXR/specs/1.1/html/xrspec.html">OpenXR Specification</a>.
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>openxr</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.openxr {
    exports club.doki7.openxr;
    exports club.doki7.openxr.bitmask;
    exports club.doki7.openxr.command;
    exports club.doki7.openxr.datatype;
    exports club.doki7.openxr.enumtype;
    exports club.doki7.openxr.handle;

    requires club.doki7.ffm;
    requires club.doki7.vulkan;
    requires org.jetbrains.annotations;
}
