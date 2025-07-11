package club.doki7.stb.vorbis;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.stb.vorbis.datatype.*;
import club.doki7.stb.vorbis.enumtype.*;
import club.doki7.stb.vorbis.handle.*;

public final class STBVorbis {
    public STBVorbis(RawFunctionLoader loader) {
        SEGMENT$stb_vorbis_close = loader.apply("stb_vorbis_close");
        HANDLE$stb_vorbis_close = RawFunctionLoader.link(SEGMENT$stb_vorbis_close, Descriptors.DESCRIPTOR$stb_vorbis_close);
        SEGMENT$stb_vorbis_decode_filename = loader.apply("stb_vorbis_decode_filename");
        HANDLE$stb_vorbis_decode_filename = RawFunctionLoader.link(SEGMENT$stb_vorbis_decode_filename, Descriptors.DESCRIPTOR$stb_vorbis_decode_filename);
        SEGMENT$stb_vorbis_decode_frame_pushdata = loader.apply("stb_vorbis_decode_frame_pushdata");
        HANDLE$stb_vorbis_decode_frame_pushdata = RawFunctionLoader.link(SEGMENT$stb_vorbis_decode_frame_pushdata, Descriptors.DESCRIPTOR$stb_vorbis_decode_frame_pushdata);
        SEGMENT$stb_vorbis_decode_memory = loader.apply("stb_vorbis_decode_memory");
        HANDLE$stb_vorbis_decode_memory = RawFunctionLoader.link(SEGMENT$stb_vorbis_decode_memory, Descriptors.DESCRIPTOR$stb_vorbis_decode_memory);
        SEGMENT$stb_vorbis_flush_pushdata = loader.apply("stb_vorbis_flush_pushdata");
        HANDLE$stb_vorbis_flush_pushdata = RawFunctionLoader.link(SEGMENT$stb_vorbis_flush_pushdata, Descriptors.DESCRIPTOR$stb_vorbis_flush_pushdata);
        SEGMENT$stb_vorbis_get_comment = loader.apply("stb_vorbis_get_comment");
        HANDLE$stb_vorbis_get_comment = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_comment, Descriptors.DESCRIPTOR$stb_vorbis_get_comment);
        SEGMENT$stb_vorbis_get_error = loader.apply("stb_vorbis_get_error");
        HANDLE$stb_vorbis_get_error = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_error, Descriptors.DESCRIPTOR$stb_vorbis_get_error);
        SEGMENT$stb_vorbis_get_file_offset = loader.apply("stb_vorbis_get_file_offset");
        HANDLE$stb_vorbis_get_file_offset = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_file_offset, Descriptors.DESCRIPTOR$stb_vorbis_get_file_offset);
        SEGMENT$stb_vorbis_get_frame_float = loader.apply("stb_vorbis_get_frame_float");
        HANDLE$stb_vorbis_get_frame_float = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_frame_float, Descriptors.DESCRIPTOR$stb_vorbis_get_frame_float);
        SEGMENT$stb_vorbis_get_frame_short = loader.apply("stb_vorbis_get_frame_short");
        HANDLE$stb_vorbis_get_frame_short = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_frame_short, Descriptors.DESCRIPTOR$stb_vorbis_get_frame_short);
        SEGMENT$stb_vorbis_get_frame_short_interleaved = loader.apply("stb_vorbis_get_frame_short_interleaved");
        HANDLE$stb_vorbis_get_frame_short_interleaved = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_frame_short_interleaved, Descriptors.DESCRIPTOR$stb_vorbis_get_frame_short_interleaved);
        SEGMENT$stb_vorbis_get_info = loader.apply("stb_vorbis_get_info");
        HANDLE$stb_vorbis_get_info = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_info, Descriptors.DESCRIPTOR$stb_vorbis_get_info);
        SEGMENT$stb_vorbis_get_sample_offset = loader.apply("stb_vorbis_get_sample_offset");
        HANDLE$stb_vorbis_get_sample_offset = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_sample_offset, Descriptors.DESCRIPTOR$stb_vorbis_get_sample_offset);
        SEGMENT$stb_vorbis_get_samples_float = loader.apply("stb_vorbis_get_samples_float");
        HANDLE$stb_vorbis_get_samples_float = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_samples_float, Descriptors.DESCRIPTOR$stb_vorbis_get_samples_float);
        SEGMENT$stb_vorbis_get_samples_float_interleaved = loader.apply("stb_vorbis_get_samples_float_interleaved");
        HANDLE$stb_vorbis_get_samples_float_interleaved = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_samples_float_interleaved, Descriptors.DESCRIPTOR$stb_vorbis_get_samples_float_interleaved);
        SEGMENT$stb_vorbis_get_samples_short = loader.apply("stb_vorbis_get_samples_short");
        HANDLE$stb_vorbis_get_samples_short = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_samples_short, Descriptors.DESCRIPTOR$stb_vorbis_get_samples_short);
        SEGMENT$stb_vorbis_get_samples_short_interleaved = loader.apply("stb_vorbis_get_samples_short_interleaved");
        HANDLE$stb_vorbis_get_samples_short_interleaved = RawFunctionLoader.link(SEGMENT$stb_vorbis_get_samples_short_interleaved, Descriptors.DESCRIPTOR$stb_vorbis_get_samples_short_interleaved);
        SEGMENT$stb_vorbis_open_filename = loader.apply("stb_vorbis_open_filename");
        HANDLE$stb_vorbis_open_filename = RawFunctionLoader.link(SEGMENT$stb_vorbis_open_filename, Descriptors.DESCRIPTOR$stb_vorbis_open_filename);
        SEGMENT$stb_vorbis_open_memory = loader.apply("stb_vorbis_open_memory");
        HANDLE$stb_vorbis_open_memory = RawFunctionLoader.link(SEGMENT$stb_vorbis_open_memory, Descriptors.DESCRIPTOR$stb_vorbis_open_memory);
        SEGMENT$stb_vorbis_open_pushdata = loader.apply("stb_vorbis_open_pushdata");
        HANDLE$stb_vorbis_open_pushdata = RawFunctionLoader.link(SEGMENT$stb_vorbis_open_pushdata, Descriptors.DESCRIPTOR$stb_vorbis_open_pushdata);
        SEGMENT$stb_vorbis_seek = loader.apply("stb_vorbis_seek");
        HANDLE$stb_vorbis_seek = RawFunctionLoader.link(SEGMENT$stb_vorbis_seek, Descriptors.DESCRIPTOR$stb_vorbis_seek);
        SEGMENT$stb_vorbis_seek_frame = loader.apply("stb_vorbis_seek_frame");
        HANDLE$stb_vorbis_seek_frame = RawFunctionLoader.link(SEGMENT$stb_vorbis_seek_frame, Descriptors.DESCRIPTOR$stb_vorbis_seek_frame);
        SEGMENT$stb_vorbis_seek_start = loader.apply("stb_vorbis_seek_start");
        HANDLE$stb_vorbis_seek_start = RawFunctionLoader.link(SEGMENT$stb_vorbis_seek_start, Descriptors.DESCRIPTOR$stb_vorbis_seek_start);
        SEGMENT$stb_vorbis_stream_length_in_samples = loader.apply("stb_vorbis_stream_length_in_samples");
        HANDLE$stb_vorbis_stream_length_in_samples = RawFunctionLoader.link(SEGMENT$stb_vorbis_stream_length_in_samples, Descriptors.DESCRIPTOR$stb_vorbis_stream_length_in_samples);
        SEGMENT$stb_vorbis_stream_length_in_seconds = loader.apply("stb_vorbis_stream_length_in_seconds");
        HANDLE$stb_vorbis_stream_length_in_seconds = RawFunctionLoader.link(SEGMENT$stb_vorbis_stream_length_in_seconds, Descriptors.DESCRIPTOR$stb_vorbis_stream_length_in_seconds);
    }

    // region command wrappers

    public void close(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_close);
        try {
            hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int decodeFilename(
        @Nullable BytePtr filename,
        @Nullable IntPtr channels,
        @Nullable IntPtr sampleRate,
        @Nullable PointerPtr output
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_decode_filename);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (filename != null ? filename.segment() : MemorySegment.NULL),
                (MemorySegment) (channels != null ? channels.segment() : MemorySegment.NULL),
                (MemorySegment) (sampleRate != null ? sampleRate.segment() : MemorySegment.NULL),
                (MemorySegment) (output != null ? output.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int decodeFramePushdata(
        @Nullable STB_Vorbis f,
        @Nullable BytePtr datablock,
        int datablockLengthInBytes,
        @Nullable IntPtr channels,
        @Nullable PointerPtr output,
        @Nullable IntPtr samples
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_decode_frame_pushdata);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                (MemorySegment) (datablock != null ? datablock.segment() : MemorySegment.NULL),
                datablockLengthInBytes,
                (MemorySegment) (channels != null ? channels.segment() : MemorySegment.NULL),
                (MemorySegment) (output != null ? output.segment() : MemorySegment.NULL),
                (MemorySegment) (samples != null ? samples.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int decodeMemory(
        @Nullable BytePtr mem,
        int len,
        @Nullable IntPtr channels,
        @Nullable IntPtr sampleRate,
        @Nullable PointerPtr output
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_decode_memory);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (mem != null ? mem.segment() : MemorySegment.NULL),
                len,
                (MemorySegment) (channels != null ? channels.segment() : MemorySegment.NULL),
                (MemorySegment) (sampleRate != null ? sampleRate.segment() : MemorySegment.NULL),
                (MemorySegment) (output != null ? output.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void flushPushdata(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_flush_pushdata);
        try {
            hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public STB_VorbisComment getComment(
        SegmentAllocator allocator,
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_comment);
        try {
            return new STB_VorbisComment((MemorySegment) hFunction.invokeExact(
                allocator,
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            ));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getError(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_error);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getFileOffset(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_file_offset);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getFrameFloat(
        @Nullable STB_Vorbis f,
        @Nullable IntPtr channels,
        @Nullable PointerPtr output
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_frame_float);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                (MemorySegment) (channels != null ? channels.segment() : MemorySegment.NULL),
                (MemorySegment) (output != null ? output.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getFrameShort(
        @Nullable STB_Vorbis f,
        int numC,
        @Nullable PointerPtr buffer,
        int numSamples
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_frame_short);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                numC,
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                numSamples
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getFrameShortInterleaved(
        @Nullable STB_Vorbis f,
        int numC,
        @Nullable ShortPtr buffer,
        int numShorts
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_frame_short_interleaved);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                numC,
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                numShorts
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public STB_VorbisInfo getInfo(
        SegmentAllocator allocator,
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_info);
        try {
            return new STB_VorbisInfo((MemorySegment) hFunction.invokeExact(
                allocator,
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            ));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getSampleOffset(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_sample_offset);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getSamplesFloat(
        @Nullable STB_Vorbis f,
        int channels,
        @Nullable PointerPtr buffer,
        int numSamples
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_samples_float);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                channels,
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                numSamples
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getSamplesFloatInterleaved(
        @Nullable STB_Vorbis f,
        int channels,
        @Nullable FloatPtr buffer,
        int numFloats
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_samples_float_interleaved);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                channels,
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                numFloats
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getSamplesShort(
        @Nullable STB_Vorbis f,
        int channels,
        @Nullable PointerPtr buffer,
        int numSamples
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_samples_short);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                channels,
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                numSamples
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int getSamplesShortInterleaved(
        @Nullable STB_Vorbis f,
        int channels,
        @Nullable ShortPtr buffer,
        int numShorts
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_get_samples_short_interleaved);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                channels,
                (MemorySegment) (buffer != null ? buffer.segment() : MemorySegment.NULL),
                numShorts
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable STB_Vorbis openFilename(
        @Nullable BytePtr filename,
        @Nullable IntPtr error,
        @Nullable @Pointer ISTB_VorbisAlloc allocBuffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_open_filename);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (filename != null ? filename.segment() : MemorySegment.NULL),
                (MemorySegment) (error != null ? error.segment() : MemorySegment.NULL),
                (MemorySegment) (allocBuffer != null ? allocBuffer.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new STB_Vorbis(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable STB_Vorbis openMemory(
        @Nullable BytePtr data,
        int len,
        @Nullable IntPtr error,
        @Nullable @Pointer ISTB_VorbisAlloc allocBuffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_open_memory);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (data != null ? data.segment() : MemorySegment.NULL),
                len,
                (MemorySegment) (error != null ? error.segment() : MemorySegment.NULL),
                (MemorySegment) (allocBuffer != null ? allocBuffer.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new STB_Vorbis(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable STB_Vorbis openPushdata(
        @Nullable BytePtr datablock,
        int datablockLengthInBytes,
        @Nullable IntPtr datablockMemoryConsumedInBytes,
        @Nullable IntPtr error,
        @Nullable @Pointer ISTB_VorbisAlloc allocBuffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_open_pushdata);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (datablock != null ? datablock.segment() : MemorySegment.NULL),
                datablockLengthInBytes,
                (MemorySegment) (datablockMemoryConsumedInBytes != null ? datablockMemoryConsumedInBytes.segment() : MemorySegment.NULL),
                (MemorySegment) (error != null ? error.segment() : MemorySegment.NULL),
                (MemorySegment) (allocBuffer != null ? allocBuffer.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new STB_Vorbis(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int seek(
        @Nullable STB_Vorbis f,
        int sampleNumber
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_seek);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                sampleNumber
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int seekFrame(
        @Nullable STB_Vorbis f,
        int sampleNumber
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_seek_frame);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL),
                sampleNumber
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int seekStart(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_seek_start);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int streamLengthInSamples(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_stream_length_in_samples);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public float streamLengthInSeconds(
        @Nullable STB_Vorbis f
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$stb_vorbis_stream_length_in_seconds);
        try {
            return (float) hFunction.invokeExact(
                (MemorySegment) (f != null ? f.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_close;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_decode_filename;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_decode_frame_pushdata;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_decode_memory;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_flush_pushdata;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_comment;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_error;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_file_offset;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_frame_float;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_frame_short;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_frame_short_interleaved;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_info;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_sample_offset;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_samples_float;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_samples_float_interleaved;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_samples_short;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_get_samples_short_interleaved;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_open_filename;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_open_memory;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_open_pushdata;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_seek;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_seek_frame;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_seek_start;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_stream_length_in_samples;
    public final @Nullable MemorySegment SEGMENT$stb_vorbis_stream_length_in_seconds;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_close;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_decode_filename;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_decode_frame_pushdata;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_decode_memory;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_flush_pushdata;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_comment;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_error;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_file_offset;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_frame_float;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_frame_short;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_frame_short_interleaved;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_info;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_sample_offset;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_samples_float;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_samples_float_interleaved;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_samples_short;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_get_samples_short_interleaved;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_open_filename;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_open_memory;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_open_pushdata;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_seek;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_seek_frame;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_seek_start;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_stream_length_in_samples;
    public final @Nullable MethodHandle HANDLE$stb_vorbis_stream_length_in_seconds;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_close = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_decode_filename = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT))
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_decode_frame_pushdata = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT))),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_decode_memory = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT))
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_flush_pushdata = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_comment = FunctionDescriptor.of(
            STB_VorbisComment.LAYOUT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_error = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_file_offset = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_frame_float = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)))
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_frame_short = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT)),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_frame_short_interleaved = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_info = FunctionDescriptor.of(
            STB_VorbisInfo.LAYOUT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_sample_offset = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_samples_float = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_samples_float_interleaved = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_samples_short = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT)),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_get_samples_short_interleaved = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_SHORT),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_open_filename = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(STB_VorbisAlloc.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_open_memory = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(STB_VorbisAlloc.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_open_pushdata = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(STB_VorbisAlloc.LAYOUT)
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_seek = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_seek_frame = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_seek_start = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_stream_length_in_samples = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$stb_vorbis_stream_length_in_seconds = FunctionDescriptor.of(
            ValueLayout.JAVA_FLOAT,
            ValueLayout.ADDRESS
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
