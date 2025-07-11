/// **(Experimental)** WebGPU Java bindings implemented with Java22 FFM (Project Panama) APIs.
///
/// **This module is still experimental. It may contain bugs or incomplete features.**
///
/// This binding is generated for `wgpu-rs`/`wgpu-native` v25.0.2.1, which in turn based on the API
/// defined in [bac5208](https://github.com/webgpu-native/webgpu-headers/blob/bac520839ff5ed2e2b648ed540bd9ec45edbccbc/webgpu.h)
/// version of WebGPU C API. `wgpu-rs` specific entities are also added. Note that the WebGPU API
/// is unstable and evolving fast, this binding may not work with lower or higher versions of
/// `wgpu-rs`/`wgpu-native`. Also, it's very likely that this binding will not work with Dawn.
///
/// Due to the unstable nature of WebGPU API and `webgpu-native`'s fragile connection with native
/// windowing system, we are currently not able to provide any help with windowing system. You may
/// need to set up WebGPU surfaces on yourself, or use some third-party libraries.
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>webgpu</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.webgpu {
    exports club.doki7.webgpu;
    exports club.doki7.webgpu.bitmask;
    exports club.doki7.webgpu.datatype;
    exports club.doki7.webgpu.enumtype;
    exports club.doki7.webgpu.handle;

    requires club.doki7.ffm;
    requires org.jetbrains.annotations;
}
