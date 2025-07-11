/// OpenGL ES 2.0 Java bindings implemented with Java22 FFM (Project Panama) APIs.
///
/// OpenGL ES is royalty-free, cross-platform API for full-function 2D and 3D graphics on embedded
/// systems - including consoles, phones, appliances and vehicles. It consists of well-defined
/// subsets of desktop OpenGL, creating a flexible and powerful low-level interface between software
/// and graphics acceleration.
///
/// <b>Note</b> that this module only contains core APIs of OpenGL ES 2.0. Our team is still working
/// to figure out an ideal way of binding and delivering all OpenGL versions and extensions.
///
/// For OpenGL ES2 reference, see <a href="https://docs.gl/es2/glActiveTexture">docs.gl</a>.
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>gles2</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.gles2 {
    exports club.doki7.gles2;

    requires club.doki7.ffm;
    requires org.jetbrains.annotations;
}
