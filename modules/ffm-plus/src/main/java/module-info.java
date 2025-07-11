/// Utility library for Java 22 FFM (Project Panama) APIs.
///
/// For actual API documentation, see packages documentation. For Java 22 FFM knowledge,
/// see <a href="https://openjdk.org/projects/panama/">OpenJDK projects page</a> or
/// <a href="https://www.baeldung.com/java-project-panama">Guide on www.baeldung.com</a>. The
/// following content is literary and not relevant to the API itself.
///
/// ## Use in Maven
///
/// ```xml
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>ffm-plus</artifactId>
///     <version>0.2.7</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.ffm {
    exports club.doki7.ffm;
    exports club.doki7.ffm.annotation;
    exports club.doki7.ffm.ptr;
    exports club.doki7.ffm.bits;
    exports club.doki7.ffm.library;
    exports club.doki7.ffm.util;

    requires org.jetbrains.annotations;
}
