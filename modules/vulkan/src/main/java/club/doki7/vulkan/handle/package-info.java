/// Opaque handle types of Vulkan API.
///
/// ## Quick start
///
/// An opaque handle is usually defined in native languages like such:
///
/// {@snippet lang=C :
/// typedef struct OpaqueStruct *OpaqueHandle;
/// }
///
/// In {@code vulkan4j} ecosystem, opaque handles are represented with a Java record type containing
/// a single {@link java.lang.foreign.MemorySegment MemorySegment} field. That segment is basically
/// the opaque handle itself You may think that it is pointing to a hypothetical
/// {@code OpaqueStruct} structure.
///
/// Handles themselves cannot be allocated, because the layout of the memory block it points to is
/// completely unknown: C APIs use opaque handles intentionally to hide these details. There are
/// two common C API designs:
///
/// {@snippet lang=C :
/// OpaqueHandle obtainOpaqueHandle(void);
/// }
///
/// and
///
/// {@snippet lang=C :
/// void obtainOpaqueHandles(OpaqueHandle *pHandle, int capacity);
/// }
///
/// In order to handle the second case, and to handle the cases you need to pass an array of
/// handles to C APIs:
///
/// {@snippet lang=C :
/// void useOpaqueHandles(OpaqueHandle const* pHandles, int count);
/// }
///
/// All the handle types defined have a {@code Ptr} subclass, which is a pointer to the handle
/// type.
///
/// ### `NULL` handles
///
/// {@code vulkan4j} ecosystem represents a {@code NULL} handle with a {@code null} Java reference
/// of that handle type, instead of a handle instance containing a {@code null} or
/// {@code MemorySegment.NULL}. We made this choice because it is always easier to analyse whether
/// a Java reference is {@code null} or not: there have been many tools (JSR305 for example) to
/// help you with that. See the documentation of
/// {@link club.doki7.ffm.IPointer#segment() IPointer#segment()} for more details.
package club.doki7.vulkan.handle;
