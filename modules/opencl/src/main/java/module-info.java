/// OpenCL Java Bindings implemented with Java 22 FFM (Project Panama) APIs.
///
/// OpenCL is the ultimate standard for cross-platform parallel programming on any hardware.
///
/// For more information about OpenCL, please refer to the
/// [official website](https://www.khronos.org/opencl/) and the
/// [OpenCL Specification](https://www.khronos.org/registry/OpenCL/specs/).
///
/// ## Use in Maven
///
/// ```xml
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>opencl</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.opencl {
    requires club.doki7.ffm;
    requires org.jetbrains.annotations;

    exports club.doki7.opencl;
    exports club.doki7.opencl.datatype;
    exports club.doki7.opencl.handle;
}
