/// OpenGL Java bindings implemented with Java22 FFM (Project Panama) APIs.
///
/// For OpenGL reference, see <a href="https://docs.gl">docs.gl</a>.
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>opengl</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.opengl {
    exports club.doki7.opengl;
    exports club.doki7.opengl.handle;

    requires club.doki7.ffm;
    requires org.jetbrains.annotations;
}
