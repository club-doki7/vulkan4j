package example.stb;

import club.doki7.ffm.library.ILibraryLoader;
import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.ptr.BytePtr;
import club.doki7.ffm.ptr.IntPtr;
import club.doki7.ffm.ptr.PointerPtr;
import club.doki7.ffm.ptr.ShortPtr;
import club.doki7.openal.AL;
import club.doki7.openal.ALC;
import club.doki7.openal.ALLoader;
import club.doki7.openal.handle.ALCcontext;
import club.doki7.openal.handle.ALCdevice;
import club.doki7.stb.STBJavaTraceUtil;
import club.doki7.stb.STBUtil;
import club.doki7.stb.vorbis.STBVorbis;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public final class OGG2PCM {
    private static final ISharedLibrary libSTB = ILibraryLoader.platformLoader().loadLibrary("stb");
    private static final ISharedLibrary libOpenAL = ALLoader.loadOpenALLibrary();
    static {
        STBJavaTraceUtil.enableJavaTraceForSTB(libSTB);
    }

    public static void main(String[] args) throws IOException {
        STBVorbis stbv = new STBVorbis(libSTB);
        STBUtil stbUtil = new STBUtil(libSTB);
        ALC alc = ALLoader.loadALC(libOpenAL);
        AL al = ALLoader.loadAL(libOpenAL);

        byte[] oggData = Files.readAllBytes(Path.of("example/resc/private-music.ogg"));

        try (Arena arena = Arena.ofConfined()) {
            BytePtr pOggData = BytePtr.allocate(arena, oggData);

            IntPtr pChannels = IntPtr.allocate(arena);
            IntPtr pSampleRate = IntPtr.allocate(arena);
            PointerPtr pPCMData = PointerPtr.allocate(arena);

            int samplesPerChannel = stbv.decodeMemory(
                    pOggData,
                    (int) pOggData.size(),
                    pChannels,
                    pSampleRate,
                    pPCMData
            );
            if (samplesPerChannel < 0) {
                throw new RuntimeException("Failed to decode OGG file private-music.ogg");
            }

            int channels = pChannels.read();
            int sampleRate = pSampleRate.read();

            System.out.println("Successfully decoded OGG file:");
            System.out.println(" - Channels: " + channels);
            System.out.println(" - Sample Rate: " + sampleRate + " Hz");
            System.out.println(" - Samples per channel: " + samplesPerChannel);

            long totalSamples = (long) samplesPerChannel * channels;
            System.out.println(" - Total sample count: " + totalSamples);
            ShortPtr pcmData = Objects.requireNonNull(ShortPtr.checked(pPCMData.read())).reinterpret(totalSamples);
            System.out.println(" - PCM Data Size: " + pcmData.size() + " bytes");

            ALCdevice device = Objects.requireNonNull(alc.openDevice(null));
            ALCcontext context = Objects.requireNonNull(alc.createContext(device, null));
            alc.makeContextCurrent(context);

            IntPtr pBuffer = IntPtr.allocate(arena);
            IntPtr pSource = IntPtr.allocate(arena);
            al.genBuffers(1, pBuffer);
            al.genSources(1, pSource);
            int buffer = pBuffer.read();
            int source = pSource.read();

            al.bufferData(
                    buffer,
                    channels == 2 ? AL.FORMAT_STEREO16 : AL.FORMAT_MONO16,
                    pcmData.segment(),
                    (int) pcmData.segment().byteSize(),
                    sampleRate
            );
            al.sourcei(source, AL.BUFFER, buffer);
            al.sourcePlay(source);

            IntPtr pState = IntPtr.allocate(arena);
            do {
                al.getSourcei(source, AL.SOURCE_STATE, pState);
            } while (pState.read() == AL.PLAYING);

            al.deleteSources(1, pSource);
            al.deleteBuffers(1, pBuffer);
            alc.makeContextCurrent(null);
            alc.destroyContext(context);
            alc.closeDevice(device);

            stbUtil.freeMemory(pcmData.segment());
        }
    }
}
