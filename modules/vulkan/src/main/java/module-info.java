/// Vulkan Java bindings implemented with Java 22 FFM (Project Panama) APIs.
///
/// Vulkan is a new generation graphics and compute API that provides high-efficiency,
/// cross-platform access to modern GPUs used in a wide variety of devices from PCs and consoles to
/// mobile phones and embedded platforms.
///
/// For actual API documentation, see packages documentation. For vulkan documentation,
/// see <a href="https://docs.vulkan.org/spec/latest/index.html">Vulkan specification</a>.
/// For Vulkan tutorial using Java and {@code vulkan4j} ecosystem, see
/// <a href="https://vk-java.doki7.club">vk-java.doki7.club</a>
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>vulkan</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.vulkan {
    requires club.doki7.ffm;
    requires org.jetbrains.annotations;

    exports club.doki7.vulkan;
    exports club.doki7.vulkan.bitmask;
    exports club.doki7.vulkan.command;
    exports club.doki7.vulkan.datatype;
    exports club.doki7.vulkan.enumtype;
    exports club.doki7.vulkan.handle;
}
