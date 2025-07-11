/// <code>libshaderc</code> Java bindings implemented with Java22 FFM (Project Panama) APIs.
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>shaderc</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.shaderc {
    requires club.doki7.ffm;
    requires org.jetbrains.annotations;

    exports club.doki7.shaderc;
    exports club.doki7.shaderc.datatype;
    exports club.doki7.shaderc.enumtype;
    exports club.doki7.shaderc.handle;
}
