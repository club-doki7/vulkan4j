/// Bitmask (flags) types of Vulkan API.
///
/// ## Quick start
///
/// In {@code vulkan4j} ecosystem, we don't use Java class types to represent bitmask types.
/// We will be still using Java integers ({@code int} or {@code long}), also
/// {@link club.doki7.ffm.ptr} types when representing pointer to or array of bitmasks.
///
/// In order to tell what bitmask type an integral value represents, we use the annotation
/// {@link club.doki7.ffm.annotation.EnumType @EnumType}. For example:
///
/// {@snippet :
/// public record VkBufferCreateInfo(MemorySegment segment) {
///     @Bitmask(VkBufferUsageFlags.class) int usage() {
///         // implementation omitted
///     }
///
///     void usage(@Bitmask(VkBufferUsageFlags.class) int value) {
///         // implementation omitted
///     }
///
///     // ...
/// }
/// }
///
/// The {@link club.doki7.ffm.annotation.EnumType @EnumType} annotation provides useful in-IDE and
/// JavaDoc links, so you can Ctrl-Click on the annotation argument to jump to the definition of the
/// bitmask type.
///
/// Also, there's a handy {@code explain} function to explain a bitmask integral value. For example:
///
/// {@snippet :
/// VkBufferUsageFlags.explain(someFlags)
/// }
package club.doki7.vulkan.bitmask;
