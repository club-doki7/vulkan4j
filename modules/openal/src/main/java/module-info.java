/// OpenAL Java Bindings implemented with Java 22 FFM (Project Panama) APIs.
///
/// OpenAL is a cross-platform 3D audio API appropriate for use with gaming applications and many
/// other types of audio applications.
///
/// For more information about OpenAL, please refer to the official documentation:
/// - [OpenAL Official Documentation](https://www.openal.org/documentation/)
/// - [OpenAL Soft](https://www.openal-soft.org/)
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>openal</artifactId>
///     <version>0.4.4</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.openal {
    exports club.doki7.openal;
    exports club.doki7.openal.handle;

    requires org.jetbrains.annotations;
    requires club.doki7.ffm;
}
