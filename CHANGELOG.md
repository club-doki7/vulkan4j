## Unreleased v0.4.5

### New bindings

- (@HoshinoTented) Added `opencl` module, which provides bindings for OpenCL. This module is generated from Khronos OpenCL XML registry files.

### Bugfixes

- Mitigated a JDK FFM implementation issue (#163, [BUG Filed on JDK BUG System](https://bugs.openjdk.org/browse/JDK-8362169)) via manually resetting the memory session of `MemorySegment`s accepted in callback functions.

## v0.4.4

Upgrade `ffm-plus` to v0.2.7, and other wrapper modules to v0.4.4.

### New bindings

- (@CousinZe) Added `stb_vorbis` support in `stb` module, which provides bindings for `stb_vorbis.h`.

### Functionality updates

- (@CousinZe) Added `STBUtil.freeMemory` method to free memory allocated by `stb` libraries.
- (@CousinZe) Added `LibcArena.freeNonAllocated` method to free memory allocated by libc allocator but not via `LibcArena.allocate` method. This is an alternative to library specific `Util.freeMemory` methods with some risk.

### Quality of Life updates

- Supported auto-initialization of nested structures (#147). Now structures like `VkComputePipelineCreateInfo` will have their nested structures automatically initialized:

    ```java
    VkComputePipelineCreateInfo createInfo = VkComputePipelineCreateInfo.allocate(arena)
        .stage(it -> it
                // .sType(VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO) // <-- no more needed
                .stage(VkShaderStageFlags.COMPUTE)
                .module(computeShader.handle)
                .pName(entryName)
                .pSpecializationInfo(specInfo))
        .layout(layout.handle);
    ```

### Bugfixes

- Fixed a JavaDoc generation issue #158, where `union` types incorrectly have `struct` in their layout documentation.

## v0.4.3

Upgrade wrapper modules to v0.4.3.

### Quality of Life updates

- (@HoshinoTented + @chuigda) Implemented function pointer auto-wrapping mechanism, also `setter` shorthand methods for function pointer fields, and auto-wrapping for function-pointer type command parameters. This allows you to directly pass Java functions and lambdas to C function pointer fields and parameters, without needing to manually create an upcall `MethodHandle`s.

    Before:

    ```java
    private static final void callback(...) { ... }
    MethodHandle mh = MethodHandles.lookup().findStatic(...);
    MemorySegment segment = Linker.nativeLinker().upcallStub(...);
    library.commandThatUsesFunctionPointer(segment);
    ```
  
    After:

    ```java
    private static final void callback(...) { ... }
    library.commandThatUsesFunctionPointer(callback);
    // or just: library.commandThatUsesFunctionPointer((...) -> { ... });
    ```

### Bugfixes

- (@HoshinoTented + @chuigda) Fixed issue #131, where functions accepting and returning C `long` types were incorrectly generated. Since only X11 relevant APIs have been using `long` type as input and return types, this issue have little impact on most users.

## v0.4.2

Upgrade `ffm-plus` to v0.2.6, and other wrapper modules to v0.4.2.

### Breaking changes

- (@HoshinoTented) Added full support for `wchar_t`: now `wchar_t*` types are represented with `WCharPtr` instead of raw `MemorySegment`s. This will break some existing code but our new `WCharPtr` should be easy enough to use.

### New bindings

- (@lyra-planet + @chuigda) Added `webgpu` module, which provides bindings for **wgpu-rs 25.0.2.1**. This module is generated from the official WebGPU YML IDL files. We are able to do dog feeding via an offscreen rendering example. This module is marked as experimental due to the unstable status of WebGPU Native APIs. Please read the module level documentation for more details.

### Functionality updates

- (@CousinZe) `PrimitiveIterator`s are used for `IntPtr`, `LongPtr`, `DoublePtr`, `WCharPtr` and `CLongPtr` to reduce boxing-unboxing overhead.
- (@CousinZe) Deprecated `WindowsUtil.getLastError` method. Please use the Java's officially recommended `Linker.Option.captureCallState` instead.

### Bugfixes

- Fixed a bug in `CLongPtr::read(index)` and `CLongPtr::write(index, value)` methods, which did not correctly calculate the byte offset for input index.
- Returned pointers and handles are now correctly marked as `@Nullable` by default, providing much better null-safety.
- (@CousinZe) Fixed issue #126 by using `Linker.Option.captureCallState` to retrieve `GetLastError` code.
- In the static initializer of `UnixLibraryLoader`, `UnixUtil.forceLoad` is now called automatically to ensure that result of `dlerror` won't be overwritten by the loading of `dlerror` function itself.
- (@CousinZe) `LibcArena` now will fall back to `malloc` + manual alignment calculation if `aligned_alloc` is not available. This allows `LibcArena` to work on Windows platform.

## v0.4.1

Upgrade `ffm-plus` to v0.2.5, and other wrapper modules to v0.4.1.

### New bindings

- (@HoshinoTented + @chuigda) Added `openxr` module, which provides bindings for OpenXR 1.0 - 1.1. This module is generated from the official OpenXR XML registry files. **However, our team haven't tested it out thoroughly by writing a complete dog feeding OpenXR application due to lacking VR development experience. This module may contain bugs. Issus and PRs are welcome!**

### Quality of Life updates

- `allocate` functions now have a `allocate(Arena, Collection<T>)` overloading.
- `StructureType.Ptr.at` and `StructureType.arrayField` methods now also have an overloading accepting a `Consumer<T>`, thus also supporting LWJGL-alike `set` style methods. For example:
    ```c
    struct StructureType { int field1; int field2; } structures[2];
    structures[0].field1 = value00;
    structures[0].field2 = value01;
    structures[1].field1 = value10;
    structures[1].field2 = value11;
    ```
    can now be written as:
    ```java
    StructureType.Ptr structures = StructureType.allocate(arena, 2)
        .at(0, it -> it.field1(value00).field2(value01))
        .at(1, it -> it.field2(value10).field2(value11));
    ```
    while
    ```c
    struct StructureType { int arrayField[2] } structure;
    structure.arrayField[0] = value0;
    structure.arrayField[1] = value1;
    ```
    can now be written as:
    ```java
    StructureType structure = StructureType.allocate(arena)
        .arrayField(it -> {
            it.write(0, value0);
            it.write(1, value1);
        });
    ```
- Added a handy `writeString` method for `BytePtr`.
- Added a handy `allocateStrings` method for `PointerPtr` for conveniently allocating `char const**` arrays. Such arrays are widely used in Vulkan and OpenXR APIs.
- For array fields of structures, accessor `structure.field(PtrType ptr)` only copies `ptr.segment().byteSize()` bytes from `ptr` to the field, instead of attempting to copy the whole array. This makes it easier to work with C-style null-terminated strings, which would cause an overflow in previous versions.

### Bugfixes

- Fixed `BytePtr.checked` which was not previously marked as `static`.

### Minor changes

- (@ice1000) `LibcArena` and a few singleton library loaders are now implemented in terms of `enum` instead of `class`, in order to support well-behaved serialization.

## v0.4.0

Upgrade `ffm-plus` to v0.2.4, and other wrapper modules to v0.4.0.

### Breaking changes

- Add new annotation `@Bitmask` and use it to mark bitmask types. Original `@EnumType` annotation should only be applied to non-composable enums. This won't break build, but you'll see IDE warnings if you are using our [ffm-plus-inspection](https://github.com/club-doki7/ffm-plus-inspection) plugin.
- All `MemorySegment`s are now `@NotNull` by default. APIs previously accepts `null` `MemorySegment` will now throw `NullPointerException` if you pass `null`. Always use `MemorySegment.NULL`.
- Updated `VulkanLoader`, `GLFWLoader`, `VMAJavaTraceUtil` and `STBJavaTraceUtil` APIs to use `ILibraryLoader` and `ISharedLibrary` accordingly.

### New bindings

- (@ice1000 + @chuigda) Added `stb` module, which provides bindings for `stb` libraries. Currently the following components are supported:
  - `stb.image` (`stb_image.h`): Image loading library.
  - `stb.imagewrite` (`stb_image_write.h`): Image writing library.
  - `stb.imageresize` (`stb_image_resize2.h`): Image resizing library.
  - `stb.truetype` (`stb_truetype.h`): TrueType font rendering library.

### Functionality updates

- (@chuigda + @CousinZe) Added `ILibraryLoader` and `ISharedLibrary` interface to reduce global `System.load`/`System.loadLibrary` calls. This allows you to load libraries in a more controlled manner.
  - This feature uses `LoadLibraryW` + `GetProcAddress` on Windows platform, `dlopen` + `dlsym` on Linux/FreeBSD/macOS platform.
  - macOS library bundle (`.framework`) is not supported yet.
- (@chuigda + @CousinZe) Deprecated `Loader` class and its methods. If you need to load basic functions (like `libc` functions) from "global" scope, use `JavaSystemLibrary.INSTANCE.load` instead; if you need to load functions from a specific library, use `ILibraryLoader` and `ISharedLibrary` interface instead.

### Quality of Life updates

- PVOID type field setters accepting `MemorySegment`s now also returns `this` to allow chaining.
- Added `ALLoader` class to automatically deal with platform library name difference (`OpenAL32.dll` on Windows vs `libopenal.so` on Linux).

### Known issues

- `WindowsLibraryLoader` does not give correct Windows error code on library loading failure (#126). This issue is still under investigation.
- `LibcArena` does not work on Windows platform due to the lack of `aligned_alloc` support. `ShadercUtil` using `LibcArena` is also affected.

## v0.3.4

Upgrade `ffm-plus` to v0.2.2, and other wrapper modules to v0.3.4.

### New bindings

- Added `shaderc` module, which provides bindings for `libshaderc`.

### Bugfixes

- Fixed an issue causing memory allocation failure of `LibcArena`.
- Fixed an issue causing incorrect generation of return value retrieval for commands that returns `size_t`.

## v0.3.3

### Bugfixes

- Fixed an issue (#93) causing incorrect generation of `HandleType.Ptr.Iter.next` series methods.

## v0.3.2

Upgrade `ffm-plus` to v0.2.1, and other wrapper modules to v0.3.2,

### Breaking changes

- Made all the `Iter` types private to reduce disruptions in JavaDoc pages. Most code should not be affected. Existing code that really uses `T.Iter` type can migrate to `Iterator<T>` interface.

### New bindings

- (@whiterasbk) Added `opengl` module, which provides bindings for OpenGL 1.0 - 4.6 (both Core and Compatibility profiles).
- Added `openal` module, which provides bindings based on OpenAL-soft (1.2).

### Quality of Life updates

- Added `allocateV` and `writeV` series functions for `Ptr` types (both `ffm-plus` and other generated code), utilizing Java varargs to simplify specific write operations.
- Supported chaining `set` methods for structure types.
- Supported LWJGL-alike `set` style methods for structure member of structure types. For example:
    ```c
    struct { struct { int a; int b; } inner; } outer;
    outer.inner.a = 1;
    outer.inner.b = 2;
    ```
    can now be written as:
    ```java
    outer.inner(it -> it.a(1).b(2));
    ```
- For OpenGL, OpenAL and GLFW, we now allow accessing global constants via command wrapper classes (`GLConstants.COLOR_BUFFER_BIT` -> `GL.COLOR_BUFFER_BIT`, etc.) to avoid repetitive strain injury.

### Bugfixes

- Fixed issue (#12), where some instance level commands are wrongly categorized as device commands.

## v0.3.1

- Fixed an issue (#63) causing incorrect generation of `StructureType.Ptr.reinterpret` series methods.
- Fixed a documentation issue in `vma` module.

## v0.3.0

A fresh start

- Migrating all extraction and code generation to Kotlin `codegen-v2` module.
- Entities are renamed properly to reduce boilerplates.
- Improved usability and correctness of `ffm-plus` (previously `panama-plus`) module.
- Many other enhancements and bug fixes.

### *Development history before 0.3.0?*

See [vulkan4j-legacy](https://github.com/CousinZe/vulkan4j-legacy).
