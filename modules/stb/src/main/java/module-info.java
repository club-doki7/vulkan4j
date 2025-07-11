/// STB Java bindings implemented with Java 22 FFM (Project Panama) APIs.
///
/// STB is a collection of single-file public domain libraries for C/C++ that provide
/// various utilities such as image loading, font rendering, and more.
///
/// The following bindings are now provided:
/// - `stb_image.h` (package {@link club.doki7.stb.image})
/// - `stb_image_write.h` (package {@link club.doki7.stb.imagewrite})
/// - `stb_image_resize2.h` (package {@link club.doki7.stb.imageresize})
/// - `stb_truetype.h` (package {@link club.doki7.stb.truetype})
/// - `stb_vorbis.c` (package {@link club.doki7.stb.vorbis})
///
/// ## Use in Maven
///
/// ```
/// <dependency>
///     <groupId>club.doki7</groupId>
///     <artifactId>stb</artifactId>
///     <version>0.4.3</version>
///     <scope>compile</scope>
/// </dependency>
/// ```
module club.doki7.stb {
    exports club.doki7.stb;

    exports club.doki7.stb.image;
    exports club.doki7.stb.image.datatype;

    exports club.doki7.stb.imagewrite;

    exports club.doki7.stb.imageresize;
    exports club.doki7.stb.imageresize.datatype;
    exports club.doki7.stb.imageresize.enumtype;
    exports club.doki7.stb.imageresize.handle;

    exports club.doki7.stb.truetype;
    exports club.doki7.stb.truetype.datatype;

    exports club.doki7.stb.vorbis;
    exports club.doki7.stb.vorbis.datatype;
    exports club.doki7.stb.vorbis.enumtype;
    exports club.doki7.stb.vorbis.handle;

    requires club.doki7.ffm;
    requires org.jetbrains.annotations;
}
