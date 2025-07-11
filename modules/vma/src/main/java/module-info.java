/// Vulkan Memory Allocator (VMA) Java Bindings implemented with Java 22 FFM (Project Panama) APIs.
///
/// Vulkan Memory Allocator (VMA) is an easy to integrate library that help game developers to
/// manage memory allocations and resource creation.
///
/// For actual API documentation, see packages documentation. For Vulkan Memory Allocator
/// documentation, see <a href="https://gpuopen-librariesandsdks.github.io/VulkanMemoryAllocator/html/">VMA Doxygen documentation</a>.
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>vma</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.vma {
    exports club.doki7.vma;
    exports club.doki7.vma.bitmask;
    exports club.doki7.vma.datatype;
    exports club.doki7.vma.enumtype;
    exports club.doki7.vma.handle;

    requires org.jetbrains.annotations;
    requires club.doki7.ffm;
    requires club.doki7.vulkan;
}
