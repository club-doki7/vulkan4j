/// Structure ({@code struct} or {@code union}) types of Vulkan API.
///
/// ## Quick start
///
/// In {@code vulkan4j} ecosystem, structures are represented with a Java record type containing
/// a single {@link java.lang.foreign.MemorySegment MemorySegment} field. That segment is the\
/// pointer to the first byte of the structure in native memory.
///
/// To allocate a structure, you can use the {@code allocate} series functions:
///
/// {@snippet :
/// try (Arena arena = Arena.ofConfined()) {
///     // Allocate one structure, sType will be initialized automatically by allocate function
///     VkBufferCreateInfo info = VkBufferCreateInfo.allocate(arena);
///     useSingleBufferCreateInfo(info);
///     // Single structure is also usable by C API intaking an array of / a pointer to structures.
///     // This is implemented via interface IVkBufferCreateInfo unifying both types.
///     useBufferCreateInfo(info, 1);
///
///     // Allocate multiple structures in a continuous memory block
///     // all the structures will be initialized automatically, too
///     VkBufferCreateInfo.Ptr infoArray = VkBufferCreateInfo.allocate(arena, 10);
///     // When interacting with C APIs, the address of the first structure is of course the address
///     // of the whole memory block.
///     useBufferCreateInfo(infoArray, 10);
/// }
///
/// // function taking only one structure
/// void useSingleBufferCreateInfo(VkBufferCreateInfo info) {
///     // implementation omitted
/// }
///
/// // A common C API pattern, accepting one or more structures. The first argument is the address
/// // of the first element in the array, the second argument is the number of elements.
/// void useBufferCreateInfo(IVkBufferCreateInfo info, int count) {
///     // implementation omitted
/// }
/// }
///
/// ## Single structure V.S. Array of / Pointer to structures
///
/// In C, a structure is a contiguous block of memory. An array of structure is just a larger
/// contiguous block of memory, containing multiple structures. As a result, when viewed from Java
/// side, a single structure itself is indistinguishable from an array of structures: they are both
/// {@link java.lang.foreign.MemorySegment MemorySegment}s. In order to improve API usability, we
/// use {@code Ptr} types to represent an array of / a pointer to structure(s).
///
/// Let's take {@link club.doki7.vulkan.datatype.VkRenderPassBeginInfo VkRenderPassBeginInfo} as an
/// example. the layout of that structure is basically:
///
/// {@snippet lang=c :
/// typedef struct VkRenderPassBeginInfo {
///     // ...
///     VkRect2D renderArea; // @link substring="VkRect2D" target="VkRect2D"
///     uint32_t clearValueCount;
///     VkClearValue const* pClearValues; // @link substring="VkClearValue" target="VkClearValue"
/// } VkRenderPassBeginInfo;
/// }
///
/// Here {@code renderArea} is a single structure, while {@code pClearValues} is a pointer to an
/// array of {@code VkClearValue} structures. Thus, we directly use
/// {@link club.doki7.vulkan.datatype.VkRect2D VkRect2D} to represent {@code renderArea}, while
/// {@link club.doki7.vulkan.datatype.VkClearValue.Ptr VkClearValue.Ptr} to represent
/// {@code pClearValues}.
///
/// For APIs that accept pointer to / array of structures, their corresponding {@code vulkan4j}
/// wrappers are designed to accept both {@code StructureType} and {@code StructureType.Ptr} via the
/// interface {@code IStructureType} interface, so you don't need to bother which type to allocate.
/// However, when the metadata explicitly indicates that the API accepts only one structure, the
/// wrapper enforces you to use the {@code StructureType}. This is to prevent accidental passing of
/// an array of structures to an API that only accepts a single structure.
package club.doki7.vulkan.datatype;
