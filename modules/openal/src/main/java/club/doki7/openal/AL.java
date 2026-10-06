package club.doki7.openal;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.openal.handle.*;
import static club.doki7.openal.ALFunctionTypes.*;

public final class AL implements ALConstants {
    public AL(RawFunctionLoader loader) {
        SEGMENT$alEnable = loader.apply("alEnable");
        HANDLE$alEnable = RawFunctionLoader.link(SEGMENT$alEnable, Descriptors.DESCRIPTOR$alEnable);
        SEGMENT$alDisable = loader.apply("alDisable");
        HANDLE$alDisable = RawFunctionLoader.link(SEGMENT$alDisable, Descriptors.DESCRIPTOR$alDisable);
        SEGMENT$alIsEnabled = loader.apply("alIsEnabled");
        HANDLE$alIsEnabled = RawFunctionLoader.link(SEGMENT$alIsEnabled, Descriptors.DESCRIPTOR$alIsEnabled);
        SEGMENT$alDopplerFactor = loader.apply("alDopplerFactor");
        HANDLE$alDopplerFactor = RawFunctionLoader.link(SEGMENT$alDopplerFactor, Descriptors.DESCRIPTOR$alDopplerFactor);
        SEGMENT$alDopplerVelocity = loader.apply("alDopplerVelocity");
        HANDLE$alDopplerVelocity = RawFunctionLoader.link(SEGMENT$alDopplerVelocity, Descriptors.DESCRIPTOR$alDopplerVelocity);
        SEGMENT$alDistanceModel = loader.apply("alDistanceModel");
        HANDLE$alDistanceModel = RawFunctionLoader.link(SEGMENT$alDistanceModel, Descriptors.DESCRIPTOR$alDistanceModel);
        SEGMENT$alGetString = loader.apply("alGetString");
        HANDLE$alGetString = RawFunctionLoader.link(SEGMENT$alGetString, Descriptors.DESCRIPTOR$alGetString);
        SEGMENT$alGetBooleanv = loader.apply("alGetBooleanv");
        HANDLE$alGetBooleanv = RawFunctionLoader.link(SEGMENT$alGetBooleanv, Descriptors.DESCRIPTOR$alGetBooleanv);
        SEGMENT$alGetIntegerv = loader.apply("alGetIntegerv");
        HANDLE$alGetIntegerv = RawFunctionLoader.link(SEGMENT$alGetIntegerv, Descriptors.DESCRIPTOR$alGetIntegerv);
        SEGMENT$alGetFloatv = loader.apply("alGetFloatv");
        HANDLE$alGetFloatv = RawFunctionLoader.link(SEGMENT$alGetFloatv, Descriptors.DESCRIPTOR$alGetFloatv);
        SEGMENT$alGetDoublev = loader.apply("alGetDoublev");
        HANDLE$alGetDoublev = RawFunctionLoader.link(SEGMENT$alGetDoublev, Descriptors.DESCRIPTOR$alGetDoublev);
        SEGMENT$alGetBoolean = loader.apply("alGetBoolean");
        HANDLE$alGetBoolean = RawFunctionLoader.link(SEGMENT$alGetBoolean, Descriptors.DESCRIPTOR$alGetBoolean);
        SEGMENT$alGetInteger = loader.apply("alGetInteger");
        HANDLE$alGetInteger = RawFunctionLoader.link(SEGMENT$alGetInteger, Descriptors.DESCRIPTOR$alGetInteger);
        SEGMENT$alGetFloat = loader.apply("alGetFloat");
        HANDLE$alGetFloat = RawFunctionLoader.link(SEGMENT$alGetFloat, Descriptors.DESCRIPTOR$alGetFloat);
        SEGMENT$alGetDouble = loader.apply("alGetDouble");
        HANDLE$alGetDouble = RawFunctionLoader.link(SEGMENT$alGetDouble, Descriptors.DESCRIPTOR$alGetDouble);
        SEGMENT$alGetError = loader.apply("alGetError");
        HANDLE$alGetError = RawFunctionLoader.link(SEGMENT$alGetError, Descriptors.DESCRIPTOR$alGetError);
        SEGMENT$alIsExtensionPresent = loader.apply("alIsExtensionPresent");
        HANDLE$alIsExtensionPresent = RawFunctionLoader.link(SEGMENT$alIsExtensionPresent, Descriptors.DESCRIPTOR$alIsExtensionPresent);
        SEGMENT$alGetProcAddress = loader.apply("alGetProcAddress");
        HANDLE$alGetProcAddress = RawFunctionLoader.link(SEGMENT$alGetProcAddress, Descriptors.DESCRIPTOR$alGetProcAddress);
        SEGMENT$alGetEnumValue = loader.apply("alGetEnumValue");
        HANDLE$alGetEnumValue = RawFunctionLoader.link(SEGMENT$alGetEnumValue, Descriptors.DESCRIPTOR$alGetEnumValue);
        SEGMENT$alListenerf = loader.apply("alListenerf");
        HANDLE$alListenerf = RawFunctionLoader.link(SEGMENT$alListenerf, Descriptors.DESCRIPTOR$alListenerf);
        SEGMENT$alListener3f = loader.apply("alListener3f");
        HANDLE$alListener3f = RawFunctionLoader.link(SEGMENT$alListener3f, Descriptors.DESCRIPTOR$alListener3f);
        SEGMENT$alListenerfv = loader.apply("alListenerfv");
        HANDLE$alListenerfv = RawFunctionLoader.link(SEGMENT$alListenerfv, Descriptors.DESCRIPTOR$alListenerfv);
        SEGMENT$alListeneri = loader.apply("alListeneri");
        HANDLE$alListeneri = RawFunctionLoader.link(SEGMENT$alListeneri, Descriptors.DESCRIPTOR$alListeneri);
        SEGMENT$alListener3i = loader.apply("alListener3i");
        HANDLE$alListener3i = RawFunctionLoader.link(SEGMENT$alListener3i, Descriptors.DESCRIPTOR$alListener3i);
        SEGMENT$alListeneriv = loader.apply("alListeneriv");
        HANDLE$alListeneriv = RawFunctionLoader.link(SEGMENT$alListeneriv, Descriptors.DESCRIPTOR$alListeneriv);
        SEGMENT$alGetListenerf = loader.apply("alGetListenerf");
        HANDLE$alGetListenerf = RawFunctionLoader.link(SEGMENT$alGetListenerf, Descriptors.DESCRIPTOR$alGetListenerf);
        SEGMENT$alGetListener3f = loader.apply("alGetListener3f");
        HANDLE$alGetListener3f = RawFunctionLoader.link(SEGMENT$alGetListener3f, Descriptors.DESCRIPTOR$alGetListener3f);
        SEGMENT$alGetListenerfv = loader.apply("alGetListenerfv");
        HANDLE$alGetListenerfv = RawFunctionLoader.link(SEGMENT$alGetListenerfv, Descriptors.DESCRIPTOR$alGetListenerfv);
        SEGMENT$alGetListeneri = loader.apply("alGetListeneri");
        HANDLE$alGetListeneri = RawFunctionLoader.link(SEGMENT$alGetListeneri, Descriptors.DESCRIPTOR$alGetListeneri);
        SEGMENT$alGetListener3i = loader.apply("alGetListener3i");
        HANDLE$alGetListener3i = RawFunctionLoader.link(SEGMENT$alGetListener3i, Descriptors.DESCRIPTOR$alGetListener3i);
        SEGMENT$alGetListeneriv = loader.apply("alGetListeneriv");
        HANDLE$alGetListeneriv = RawFunctionLoader.link(SEGMENT$alGetListeneriv, Descriptors.DESCRIPTOR$alGetListeneriv);
        SEGMENT$alGenSources = loader.apply("alGenSources");
        HANDLE$alGenSources = RawFunctionLoader.link(SEGMENT$alGenSources, Descriptors.DESCRIPTOR$alGenSources);
        SEGMENT$alDeleteSources = loader.apply("alDeleteSources");
        HANDLE$alDeleteSources = RawFunctionLoader.link(SEGMENT$alDeleteSources, Descriptors.DESCRIPTOR$alDeleteSources);
        SEGMENT$alIsSource = loader.apply("alIsSource");
        HANDLE$alIsSource = RawFunctionLoader.link(SEGMENT$alIsSource, Descriptors.DESCRIPTOR$alIsSource);
        SEGMENT$alSourcef = loader.apply("alSourcef");
        HANDLE$alSourcef = RawFunctionLoader.link(SEGMENT$alSourcef, Descriptors.DESCRIPTOR$alSourcef);
        SEGMENT$alSource3f = loader.apply("alSource3f");
        HANDLE$alSource3f = RawFunctionLoader.link(SEGMENT$alSource3f, Descriptors.DESCRIPTOR$alSource3f);
        SEGMENT$alSourcefv = loader.apply("alSourcefv");
        HANDLE$alSourcefv = RawFunctionLoader.link(SEGMENT$alSourcefv, Descriptors.DESCRIPTOR$alSourcefv);
        SEGMENT$alSourcei = loader.apply("alSourcei");
        HANDLE$alSourcei = RawFunctionLoader.link(SEGMENT$alSourcei, Descriptors.DESCRIPTOR$alSourcei);
        SEGMENT$alSource3i = loader.apply("alSource3i");
        HANDLE$alSource3i = RawFunctionLoader.link(SEGMENT$alSource3i, Descriptors.DESCRIPTOR$alSource3i);
        SEGMENT$alSourceiv = loader.apply("alSourceiv");
        HANDLE$alSourceiv = RawFunctionLoader.link(SEGMENT$alSourceiv, Descriptors.DESCRIPTOR$alSourceiv);
        SEGMENT$alGetSourcef = loader.apply("alGetSourcef");
        HANDLE$alGetSourcef = RawFunctionLoader.link(SEGMENT$alGetSourcef, Descriptors.DESCRIPTOR$alGetSourcef);
        SEGMENT$alGetSource3f = loader.apply("alGetSource3f");
        HANDLE$alGetSource3f = RawFunctionLoader.link(SEGMENT$alGetSource3f, Descriptors.DESCRIPTOR$alGetSource3f);
        SEGMENT$alGetSourcefv = loader.apply("alGetSourcefv");
        HANDLE$alGetSourcefv = RawFunctionLoader.link(SEGMENT$alGetSourcefv, Descriptors.DESCRIPTOR$alGetSourcefv);
        SEGMENT$alGetSourcei = loader.apply("alGetSourcei");
        HANDLE$alGetSourcei = RawFunctionLoader.link(SEGMENT$alGetSourcei, Descriptors.DESCRIPTOR$alGetSourcei);
        SEGMENT$alGetSource3i = loader.apply("alGetSource3i");
        HANDLE$alGetSource3i = RawFunctionLoader.link(SEGMENT$alGetSource3i, Descriptors.DESCRIPTOR$alGetSource3i);
        SEGMENT$alGetSourceiv = loader.apply("alGetSourceiv");
        HANDLE$alGetSourceiv = RawFunctionLoader.link(SEGMENT$alGetSourceiv, Descriptors.DESCRIPTOR$alGetSourceiv);
        SEGMENT$alSourcePlay = loader.apply("alSourcePlay");
        HANDLE$alSourcePlay = RawFunctionLoader.link(SEGMENT$alSourcePlay, Descriptors.DESCRIPTOR$alSourcePlay);
        SEGMENT$alSourceStop = loader.apply("alSourceStop");
        HANDLE$alSourceStop = RawFunctionLoader.link(SEGMENT$alSourceStop, Descriptors.DESCRIPTOR$alSourceStop);
        SEGMENT$alSourceRewind = loader.apply("alSourceRewind");
        HANDLE$alSourceRewind = RawFunctionLoader.link(SEGMENT$alSourceRewind, Descriptors.DESCRIPTOR$alSourceRewind);
        SEGMENT$alSourcePause = loader.apply("alSourcePause");
        HANDLE$alSourcePause = RawFunctionLoader.link(SEGMENT$alSourcePause, Descriptors.DESCRIPTOR$alSourcePause);
        SEGMENT$alSourcePlayv = loader.apply("alSourcePlayv");
        HANDLE$alSourcePlayv = RawFunctionLoader.link(SEGMENT$alSourcePlayv, Descriptors.DESCRIPTOR$alSourcePlayv);
        SEGMENT$alSourceStopv = loader.apply("alSourceStopv");
        HANDLE$alSourceStopv = RawFunctionLoader.link(SEGMENT$alSourceStopv, Descriptors.DESCRIPTOR$alSourceStopv);
        SEGMENT$alSourceRewindv = loader.apply("alSourceRewindv");
        HANDLE$alSourceRewindv = RawFunctionLoader.link(SEGMENT$alSourceRewindv, Descriptors.DESCRIPTOR$alSourceRewindv);
        SEGMENT$alSourcePausev = loader.apply("alSourcePausev");
        HANDLE$alSourcePausev = RawFunctionLoader.link(SEGMENT$alSourcePausev, Descriptors.DESCRIPTOR$alSourcePausev);
        SEGMENT$alSourceQueueBuffers = loader.apply("alSourceQueueBuffers");
        HANDLE$alSourceQueueBuffers = RawFunctionLoader.link(SEGMENT$alSourceQueueBuffers, Descriptors.DESCRIPTOR$alSourceQueueBuffers);
        SEGMENT$alSourceUnqueueBuffers = loader.apply("alSourceUnqueueBuffers");
        HANDLE$alSourceUnqueueBuffers = RawFunctionLoader.link(SEGMENT$alSourceUnqueueBuffers, Descriptors.DESCRIPTOR$alSourceUnqueueBuffers);
        SEGMENT$alGenBuffers = loader.apply("alGenBuffers");
        HANDLE$alGenBuffers = RawFunctionLoader.link(SEGMENT$alGenBuffers, Descriptors.DESCRIPTOR$alGenBuffers);
        SEGMENT$alDeleteBuffers = loader.apply("alDeleteBuffers");
        HANDLE$alDeleteBuffers = RawFunctionLoader.link(SEGMENT$alDeleteBuffers, Descriptors.DESCRIPTOR$alDeleteBuffers);
        SEGMENT$alIsBuffer = loader.apply("alIsBuffer");
        HANDLE$alIsBuffer = RawFunctionLoader.link(SEGMENT$alIsBuffer, Descriptors.DESCRIPTOR$alIsBuffer);
        SEGMENT$alBufferData = loader.apply("alBufferData");
        HANDLE$alBufferData = RawFunctionLoader.link(SEGMENT$alBufferData, Descriptors.DESCRIPTOR$alBufferData);
        SEGMENT$alBufferf = loader.apply("alBufferf");
        HANDLE$alBufferf = RawFunctionLoader.link(SEGMENT$alBufferf, Descriptors.DESCRIPTOR$alBufferf);
        SEGMENT$alBuffer3f = loader.apply("alBuffer3f");
        HANDLE$alBuffer3f = RawFunctionLoader.link(SEGMENT$alBuffer3f, Descriptors.DESCRIPTOR$alBuffer3f);
        SEGMENT$alBufferfv = loader.apply("alBufferfv");
        HANDLE$alBufferfv = RawFunctionLoader.link(SEGMENT$alBufferfv, Descriptors.DESCRIPTOR$alBufferfv);
        SEGMENT$alBufferi = loader.apply("alBufferi");
        HANDLE$alBufferi = RawFunctionLoader.link(SEGMENT$alBufferi, Descriptors.DESCRIPTOR$alBufferi);
        SEGMENT$alBuffer3i = loader.apply("alBuffer3i");
        HANDLE$alBuffer3i = RawFunctionLoader.link(SEGMENT$alBuffer3i, Descriptors.DESCRIPTOR$alBuffer3i);
        SEGMENT$alBufferiv = loader.apply("alBufferiv");
        HANDLE$alBufferiv = RawFunctionLoader.link(SEGMENT$alBufferiv, Descriptors.DESCRIPTOR$alBufferiv);
        SEGMENT$alGetBufferf = loader.apply("alGetBufferf");
        HANDLE$alGetBufferf = RawFunctionLoader.link(SEGMENT$alGetBufferf, Descriptors.DESCRIPTOR$alGetBufferf);
        SEGMENT$alGetBuffer3f = loader.apply("alGetBuffer3f");
        HANDLE$alGetBuffer3f = RawFunctionLoader.link(SEGMENT$alGetBuffer3f, Descriptors.DESCRIPTOR$alGetBuffer3f);
        SEGMENT$alGetBufferfv = loader.apply("alGetBufferfv");
        HANDLE$alGetBufferfv = RawFunctionLoader.link(SEGMENT$alGetBufferfv, Descriptors.DESCRIPTOR$alGetBufferfv);
        SEGMENT$alGetBufferi = loader.apply("alGetBufferi");
        HANDLE$alGetBufferi = RawFunctionLoader.link(SEGMENT$alGetBufferi, Descriptors.DESCRIPTOR$alGetBufferi);
        SEGMENT$alGetBuffer3i = loader.apply("alGetBuffer3i");
        HANDLE$alGetBuffer3i = RawFunctionLoader.link(SEGMENT$alGetBuffer3i, Descriptors.DESCRIPTOR$alGetBuffer3i);
        SEGMENT$alGetBufferiv = loader.apply("alGetBufferiv");
        HANDLE$alGetBufferiv = RawFunctionLoader.link(SEGMENT$alGetBufferiv, Descriptors.DESCRIPTOR$alGetBufferiv);
        SEGMENT$alSpeedOfSound = loader.apply("alSpeedOfSound");
        HANDLE$alSpeedOfSound = RawFunctionLoader.link(SEGMENT$alSpeedOfSound, Descriptors.DESCRIPTOR$alSpeedOfSound);
        SEGMENT$alBufferDataStatic = loader.apply("alBufferDataStatic");
        HANDLE$alBufferDataStatic = RawFunctionLoader.link(SEGMENT$alBufferDataStatic, Descriptors.DESCRIPTOR$alBufferDataStatic);
        SEGMENT$alBufferSubDataSOFT = loader.apply("alBufferSubDataSOFT");
        HANDLE$alBufferSubDataSOFT = RawFunctionLoader.link(SEGMENT$alBufferSubDataSOFT, Descriptors.DESCRIPTOR$alBufferSubDataSOFT);
        SEGMENT$alRequestFoldbackStart = loader.apply("alRequestFoldbackStart");
        HANDLE$alRequestFoldbackStart = RawFunctionLoader.link(SEGMENT$alRequestFoldbackStart, Descriptors.DESCRIPTOR$alRequestFoldbackStart);
        SEGMENT$alRequestFoldbackStop = loader.apply("alRequestFoldbackStop");
        HANDLE$alRequestFoldbackStop = RawFunctionLoader.link(SEGMENT$alRequestFoldbackStop, Descriptors.DESCRIPTOR$alRequestFoldbackStop);
        SEGMENT$alBufferSamplesSOFT = loader.apply("alBufferSamplesSOFT");
        HANDLE$alBufferSamplesSOFT = RawFunctionLoader.link(SEGMENT$alBufferSamplesSOFT, Descriptors.DESCRIPTOR$alBufferSamplesSOFT);
        SEGMENT$alBufferSubSamplesSOFT = loader.apply("alBufferSubSamplesSOFT");
        HANDLE$alBufferSubSamplesSOFT = RawFunctionLoader.link(SEGMENT$alBufferSubSamplesSOFT, Descriptors.DESCRIPTOR$alBufferSubSamplesSOFT);
        SEGMENT$alGetBufferSamplesSOFT = loader.apply("alGetBufferSamplesSOFT");
        HANDLE$alGetBufferSamplesSOFT = RawFunctionLoader.link(SEGMENT$alGetBufferSamplesSOFT, Descriptors.DESCRIPTOR$alGetBufferSamplesSOFT);
        SEGMENT$alIsBufferFormatSupportedSOFT = loader.apply("alIsBufferFormatSupportedSOFT");
        HANDLE$alIsBufferFormatSupportedSOFT = RawFunctionLoader.link(SEGMENT$alIsBufferFormatSupportedSOFT, Descriptors.DESCRIPTOR$alIsBufferFormatSupportedSOFT);
        SEGMENT$alSourcedSOFT = loader.apply("alSourcedSOFT");
        HANDLE$alSourcedSOFT = RawFunctionLoader.link(SEGMENT$alSourcedSOFT, Descriptors.DESCRIPTOR$alSourcedSOFT);
        SEGMENT$alSource3dSOFT = loader.apply("alSource3dSOFT");
        HANDLE$alSource3dSOFT = RawFunctionLoader.link(SEGMENT$alSource3dSOFT, Descriptors.DESCRIPTOR$alSource3dSOFT);
        SEGMENT$alSourcedvSOFT = loader.apply("alSourcedvSOFT");
        HANDLE$alSourcedvSOFT = RawFunctionLoader.link(SEGMENT$alSourcedvSOFT, Descriptors.DESCRIPTOR$alSourcedvSOFT);
        SEGMENT$alGetSourcedSOFT = loader.apply("alGetSourcedSOFT");
        HANDLE$alGetSourcedSOFT = RawFunctionLoader.link(SEGMENT$alGetSourcedSOFT, Descriptors.DESCRIPTOR$alGetSourcedSOFT);
        SEGMENT$alGetSource3dSOFT = loader.apply("alGetSource3dSOFT");
        HANDLE$alGetSource3dSOFT = RawFunctionLoader.link(SEGMENT$alGetSource3dSOFT, Descriptors.DESCRIPTOR$alGetSource3dSOFT);
        SEGMENT$alGetSourcedvSOFT = loader.apply("alGetSourcedvSOFT");
        HANDLE$alGetSourcedvSOFT = RawFunctionLoader.link(SEGMENT$alGetSourcedvSOFT, Descriptors.DESCRIPTOR$alGetSourcedvSOFT);
        SEGMENT$alSourcei64SOFT = loader.apply("alSourcei64SOFT");
        HANDLE$alSourcei64SOFT = RawFunctionLoader.link(SEGMENT$alSourcei64SOFT, Descriptors.DESCRIPTOR$alSourcei64SOFT);
        SEGMENT$alSource3i64SOFT = loader.apply("alSource3i64SOFT");
        HANDLE$alSource3i64SOFT = RawFunctionLoader.link(SEGMENT$alSource3i64SOFT, Descriptors.DESCRIPTOR$alSource3i64SOFT);
        SEGMENT$alSourcei64vSOFT = loader.apply("alSourcei64vSOFT");
        HANDLE$alSourcei64vSOFT = RawFunctionLoader.link(SEGMENT$alSourcei64vSOFT, Descriptors.DESCRIPTOR$alSourcei64vSOFT);
        SEGMENT$alGetSourcei64SOFT = loader.apply("alGetSourcei64SOFT");
        HANDLE$alGetSourcei64SOFT = RawFunctionLoader.link(SEGMENT$alGetSourcei64SOFT, Descriptors.DESCRIPTOR$alGetSourcei64SOFT);
        SEGMENT$alGetSource3i64SOFT = loader.apply("alGetSource3i64SOFT");
        HANDLE$alGetSource3i64SOFT = RawFunctionLoader.link(SEGMENT$alGetSource3i64SOFT, Descriptors.DESCRIPTOR$alGetSource3i64SOFT);
        SEGMENT$alGetSourcei64vSOFT = loader.apply("alGetSourcei64vSOFT");
        HANDLE$alGetSourcei64vSOFT = RawFunctionLoader.link(SEGMENT$alGetSourcei64vSOFT, Descriptors.DESCRIPTOR$alGetSourcei64vSOFT);
        SEGMENT$alDeferUpdatesSOFT = loader.apply("alDeferUpdatesSOFT");
        HANDLE$alDeferUpdatesSOFT = RawFunctionLoader.link(SEGMENT$alDeferUpdatesSOFT, Descriptors.DESCRIPTOR$alDeferUpdatesSOFT);
        SEGMENT$alProcessUpdatesSOFT = loader.apply("alProcessUpdatesSOFT");
        HANDLE$alProcessUpdatesSOFT = RawFunctionLoader.link(SEGMENT$alProcessUpdatesSOFT, Descriptors.DESCRIPTOR$alProcessUpdatesSOFT);
        SEGMENT$alGetStringiSOFT = loader.apply("alGetStringiSOFT");
        HANDLE$alGetStringiSOFT = RawFunctionLoader.link(SEGMENT$alGetStringiSOFT, Descriptors.DESCRIPTOR$alGetStringiSOFT);
        SEGMENT$alEventControlSOFT = loader.apply("alEventControlSOFT");
        HANDLE$alEventControlSOFT = RawFunctionLoader.link(SEGMENT$alEventControlSOFT, Descriptors.DESCRIPTOR$alEventControlSOFT);
        SEGMENT$alEventCallbackSOFT = loader.apply("alEventCallbackSOFT");
        HANDLE$alEventCallbackSOFT = RawFunctionLoader.link(SEGMENT$alEventCallbackSOFT, Descriptors.DESCRIPTOR$alEventCallbackSOFT);
        SEGMENT$alGetPointerSOFT = loader.apply("alGetPointerSOFT");
        HANDLE$alGetPointerSOFT = RawFunctionLoader.link(SEGMENT$alGetPointerSOFT, Descriptors.DESCRIPTOR$alGetPointerSOFT);
        SEGMENT$alGetPointervSOFT = loader.apply("alGetPointervSOFT");
        HANDLE$alGetPointervSOFT = RawFunctionLoader.link(SEGMENT$alGetPointervSOFT, Descriptors.DESCRIPTOR$alGetPointervSOFT);
        SEGMENT$alBufferCallbackSOFT = loader.apply("alBufferCallbackSOFT");
        HANDLE$alBufferCallbackSOFT = RawFunctionLoader.link(SEGMENT$alBufferCallbackSOFT, Descriptors.DESCRIPTOR$alBufferCallbackSOFT);
        SEGMENT$alGetBufferPtrSOFT = loader.apply("alGetBufferPtrSOFT");
        HANDLE$alGetBufferPtrSOFT = RawFunctionLoader.link(SEGMENT$alGetBufferPtrSOFT, Descriptors.DESCRIPTOR$alGetBufferPtrSOFT);
        SEGMENT$alGetBuffer3PtrSOFT = loader.apply("alGetBuffer3PtrSOFT");
        HANDLE$alGetBuffer3PtrSOFT = RawFunctionLoader.link(SEGMENT$alGetBuffer3PtrSOFT, Descriptors.DESCRIPTOR$alGetBuffer3PtrSOFT);
        SEGMENT$alGetBufferPtrvSOFT = loader.apply("alGetBufferPtrvSOFT");
        HANDLE$alGetBufferPtrvSOFT = RawFunctionLoader.link(SEGMENT$alGetBufferPtrvSOFT, Descriptors.DESCRIPTOR$alGetBufferPtrvSOFT);
        SEGMENT$alSourcePlayAtTimeSOFT = loader.apply("alSourcePlayAtTimeSOFT");
        HANDLE$alSourcePlayAtTimeSOFT = RawFunctionLoader.link(SEGMENT$alSourcePlayAtTimeSOFT, Descriptors.DESCRIPTOR$alSourcePlayAtTimeSOFT);
        SEGMENT$alSourcePlayAtTimevSOFT = loader.apply("alSourcePlayAtTimevSOFT");
        HANDLE$alSourcePlayAtTimevSOFT = RawFunctionLoader.link(SEGMENT$alSourcePlayAtTimevSOFT, Descriptors.DESCRIPTOR$alSourcePlayAtTimevSOFT);
        SEGMENT$alDebugMessageCallbackEXT = loader.apply("alDebugMessageCallbackEXT");
        HANDLE$alDebugMessageCallbackEXT = RawFunctionLoader.link(SEGMENT$alDebugMessageCallbackEXT, Descriptors.DESCRIPTOR$alDebugMessageCallbackEXT);
        SEGMENT$alDebugMessageInsertEXT = loader.apply("alDebugMessageInsertEXT");
        HANDLE$alDebugMessageInsertEXT = RawFunctionLoader.link(SEGMENT$alDebugMessageInsertEXT, Descriptors.DESCRIPTOR$alDebugMessageInsertEXT);
        SEGMENT$alDebugMessageControlEXT = loader.apply("alDebugMessageControlEXT");
        HANDLE$alDebugMessageControlEXT = RawFunctionLoader.link(SEGMENT$alDebugMessageControlEXT, Descriptors.DESCRIPTOR$alDebugMessageControlEXT);
        SEGMENT$alPushDebugGroupEXT = loader.apply("alPushDebugGroupEXT");
        HANDLE$alPushDebugGroupEXT = RawFunctionLoader.link(SEGMENT$alPushDebugGroupEXT, Descriptors.DESCRIPTOR$alPushDebugGroupEXT);
        SEGMENT$alPopDebugGroupEXT = loader.apply("alPopDebugGroupEXT");
        HANDLE$alPopDebugGroupEXT = RawFunctionLoader.link(SEGMENT$alPopDebugGroupEXT, Descriptors.DESCRIPTOR$alPopDebugGroupEXT);
        SEGMENT$alGetDebugMessageLogEXT = loader.apply("alGetDebugMessageLogEXT");
        HANDLE$alGetDebugMessageLogEXT = RawFunctionLoader.link(SEGMENT$alGetDebugMessageLogEXT, Descriptors.DESCRIPTOR$alGetDebugMessageLogEXT);
        SEGMENT$alObjectLabelEXT = loader.apply("alObjectLabelEXT");
        HANDLE$alObjectLabelEXT = RawFunctionLoader.link(SEGMENT$alObjectLabelEXT, Descriptors.DESCRIPTOR$alObjectLabelEXT);
        SEGMENT$alGetObjectLabelEXT = loader.apply("alGetObjectLabelEXT");
        HANDLE$alGetObjectLabelEXT = RawFunctionLoader.link(SEGMENT$alGetObjectLabelEXT, Descriptors.DESCRIPTOR$alGetObjectLabelEXT);
        SEGMENT$alGetPointerEXT = loader.apply("alGetPointerEXT");
        HANDLE$alGetPointerEXT = RawFunctionLoader.link(SEGMENT$alGetPointerEXT, Descriptors.DESCRIPTOR$alGetPointerEXT);
        SEGMENT$alGetPointervEXT = loader.apply("alGetPointervEXT");
        HANDLE$alGetPointervEXT = RawFunctionLoader.link(SEGMENT$alGetPointervEXT, Descriptors.DESCRIPTOR$alGetPointervEXT);
        SEGMENT$alEnableDirect = loader.apply("alEnableDirect");
        HANDLE$alEnableDirect = RawFunctionLoader.link(SEGMENT$alEnableDirect, Descriptors.DESCRIPTOR$alEnableDirect);
        SEGMENT$alDisableDirect = loader.apply("alDisableDirect");
        HANDLE$alDisableDirect = RawFunctionLoader.link(SEGMENT$alDisableDirect, Descriptors.DESCRIPTOR$alDisableDirect);
        SEGMENT$alIsEnabledDirect = loader.apply("alIsEnabledDirect");
        HANDLE$alIsEnabledDirect = RawFunctionLoader.link(SEGMENT$alIsEnabledDirect, Descriptors.DESCRIPTOR$alIsEnabledDirect);
        SEGMENT$alDopplerFactorDirect = loader.apply("alDopplerFactorDirect");
        HANDLE$alDopplerFactorDirect = RawFunctionLoader.link(SEGMENT$alDopplerFactorDirect, Descriptors.DESCRIPTOR$alDopplerFactorDirect);
        SEGMENT$alSpeedOfSoundDirect = loader.apply("alSpeedOfSoundDirect");
        HANDLE$alSpeedOfSoundDirect = RawFunctionLoader.link(SEGMENT$alSpeedOfSoundDirect, Descriptors.DESCRIPTOR$alSpeedOfSoundDirect);
        SEGMENT$alDistanceModelDirect = loader.apply("alDistanceModelDirect");
        HANDLE$alDistanceModelDirect = RawFunctionLoader.link(SEGMENT$alDistanceModelDirect, Descriptors.DESCRIPTOR$alDistanceModelDirect);
        SEGMENT$alGetStringDirect = loader.apply("alGetStringDirect");
        HANDLE$alGetStringDirect = RawFunctionLoader.link(SEGMENT$alGetStringDirect, Descriptors.DESCRIPTOR$alGetStringDirect);
        SEGMENT$alGetBooleanvDirect = loader.apply("alGetBooleanvDirect");
        HANDLE$alGetBooleanvDirect = RawFunctionLoader.link(SEGMENT$alGetBooleanvDirect, Descriptors.DESCRIPTOR$alGetBooleanvDirect);
        SEGMENT$alGetIntegervDirect = loader.apply("alGetIntegervDirect");
        HANDLE$alGetIntegervDirect = RawFunctionLoader.link(SEGMENT$alGetIntegervDirect, Descriptors.DESCRIPTOR$alGetIntegervDirect);
        SEGMENT$alGetFloatvDirect = loader.apply("alGetFloatvDirect");
        HANDLE$alGetFloatvDirect = RawFunctionLoader.link(SEGMENT$alGetFloatvDirect, Descriptors.DESCRIPTOR$alGetFloatvDirect);
        SEGMENT$alGetDoublevDirect = loader.apply("alGetDoublevDirect");
        HANDLE$alGetDoublevDirect = RawFunctionLoader.link(SEGMENT$alGetDoublevDirect, Descriptors.DESCRIPTOR$alGetDoublevDirect);
        SEGMENT$alGetBooleanDirect = loader.apply("alGetBooleanDirect");
        HANDLE$alGetBooleanDirect = RawFunctionLoader.link(SEGMENT$alGetBooleanDirect, Descriptors.DESCRIPTOR$alGetBooleanDirect);
        SEGMENT$alGetIntegerDirect = loader.apply("alGetIntegerDirect");
        HANDLE$alGetIntegerDirect = RawFunctionLoader.link(SEGMENT$alGetIntegerDirect, Descriptors.DESCRIPTOR$alGetIntegerDirect);
        SEGMENT$alGetFloatDirect = loader.apply("alGetFloatDirect");
        HANDLE$alGetFloatDirect = RawFunctionLoader.link(SEGMENT$alGetFloatDirect, Descriptors.DESCRIPTOR$alGetFloatDirect);
        SEGMENT$alGetDoubleDirect = loader.apply("alGetDoubleDirect");
        HANDLE$alGetDoubleDirect = RawFunctionLoader.link(SEGMENT$alGetDoubleDirect, Descriptors.DESCRIPTOR$alGetDoubleDirect);
        SEGMENT$alGetErrorDirect = loader.apply("alGetErrorDirect");
        HANDLE$alGetErrorDirect = RawFunctionLoader.link(SEGMENT$alGetErrorDirect, Descriptors.DESCRIPTOR$alGetErrorDirect);
        SEGMENT$alIsExtensionPresentDirect = loader.apply("alIsExtensionPresentDirect");
        HANDLE$alIsExtensionPresentDirect = RawFunctionLoader.link(SEGMENT$alIsExtensionPresentDirect, Descriptors.DESCRIPTOR$alIsExtensionPresentDirect);
        SEGMENT$alGetProcAddressDirect = loader.apply("alGetProcAddressDirect");
        HANDLE$alGetProcAddressDirect = RawFunctionLoader.link(SEGMENT$alGetProcAddressDirect, Descriptors.DESCRIPTOR$alGetProcAddressDirect);
        SEGMENT$alGetEnumValueDirect = loader.apply("alGetEnumValueDirect");
        HANDLE$alGetEnumValueDirect = RawFunctionLoader.link(SEGMENT$alGetEnumValueDirect, Descriptors.DESCRIPTOR$alGetEnumValueDirect);
        SEGMENT$alListenerfDirect = loader.apply("alListenerfDirect");
        HANDLE$alListenerfDirect = RawFunctionLoader.link(SEGMENT$alListenerfDirect, Descriptors.DESCRIPTOR$alListenerfDirect);
        SEGMENT$alListener3fDirect = loader.apply("alListener3fDirect");
        HANDLE$alListener3fDirect = RawFunctionLoader.link(SEGMENT$alListener3fDirect, Descriptors.DESCRIPTOR$alListener3fDirect);
        SEGMENT$alListenerfvDirect = loader.apply("alListenerfvDirect");
        HANDLE$alListenerfvDirect = RawFunctionLoader.link(SEGMENT$alListenerfvDirect, Descriptors.DESCRIPTOR$alListenerfvDirect);
        SEGMENT$alListeneriDirect = loader.apply("alListeneriDirect");
        HANDLE$alListeneriDirect = RawFunctionLoader.link(SEGMENT$alListeneriDirect, Descriptors.DESCRIPTOR$alListeneriDirect);
        SEGMENT$alListener3iDirect = loader.apply("alListener3iDirect");
        HANDLE$alListener3iDirect = RawFunctionLoader.link(SEGMENT$alListener3iDirect, Descriptors.DESCRIPTOR$alListener3iDirect);
        SEGMENT$alListenerivDirect = loader.apply("alListenerivDirect");
        HANDLE$alListenerivDirect = RawFunctionLoader.link(SEGMENT$alListenerivDirect, Descriptors.DESCRIPTOR$alListenerivDirect);
        SEGMENT$alGetListenerfDirect = loader.apply("alGetListenerfDirect");
        HANDLE$alGetListenerfDirect = RawFunctionLoader.link(SEGMENT$alGetListenerfDirect, Descriptors.DESCRIPTOR$alGetListenerfDirect);
        SEGMENT$alGetListener3fDirect = loader.apply("alGetListener3fDirect");
        HANDLE$alGetListener3fDirect = RawFunctionLoader.link(SEGMENT$alGetListener3fDirect, Descriptors.DESCRIPTOR$alGetListener3fDirect);
        SEGMENT$alGetListenerfvDirect = loader.apply("alGetListenerfvDirect");
        HANDLE$alGetListenerfvDirect = RawFunctionLoader.link(SEGMENT$alGetListenerfvDirect, Descriptors.DESCRIPTOR$alGetListenerfvDirect);
        SEGMENT$alGetListeneriDirect = loader.apply("alGetListeneriDirect");
        HANDLE$alGetListeneriDirect = RawFunctionLoader.link(SEGMENT$alGetListeneriDirect, Descriptors.DESCRIPTOR$alGetListeneriDirect);
        SEGMENT$alGetListener3iDirect = loader.apply("alGetListener3iDirect");
        HANDLE$alGetListener3iDirect = RawFunctionLoader.link(SEGMENT$alGetListener3iDirect, Descriptors.DESCRIPTOR$alGetListener3iDirect);
        SEGMENT$alGetListenerivDirect = loader.apply("alGetListenerivDirect");
        HANDLE$alGetListenerivDirect = RawFunctionLoader.link(SEGMENT$alGetListenerivDirect, Descriptors.DESCRIPTOR$alGetListenerivDirect);
        SEGMENT$alGenSourcesDirect = loader.apply("alGenSourcesDirect");
        HANDLE$alGenSourcesDirect = RawFunctionLoader.link(SEGMENT$alGenSourcesDirect, Descriptors.DESCRIPTOR$alGenSourcesDirect);
        SEGMENT$alDeleteSourcesDirect = loader.apply("alDeleteSourcesDirect");
        HANDLE$alDeleteSourcesDirect = RawFunctionLoader.link(SEGMENT$alDeleteSourcesDirect, Descriptors.DESCRIPTOR$alDeleteSourcesDirect);
        SEGMENT$alIsSourceDirect = loader.apply("alIsSourceDirect");
        HANDLE$alIsSourceDirect = RawFunctionLoader.link(SEGMENT$alIsSourceDirect, Descriptors.DESCRIPTOR$alIsSourceDirect);
        SEGMENT$alSourcefDirect = loader.apply("alSourcefDirect");
        HANDLE$alSourcefDirect = RawFunctionLoader.link(SEGMENT$alSourcefDirect, Descriptors.DESCRIPTOR$alSourcefDirect);
        SEGMENT$alSource3fDirect = loader.apply("alSource3fDirect");
        HANDLE$alSource3fDirect = RawFunctionLoader.link(SEGMENT$alSource3fDirect, Descriptors.DESCRIPTOR$alSource3fDirect);
        SEGMENT$alSourcefvDirect = loader.apply("alSourcefvDirect");
        HANDLE$alSourcefvDirect = RawFunctionLoader.link(SEGMENT$alSourcefvDirect, Descriptors.DESCRIPTOR$alSourcefvDirect);
        SEGMENT$alSourceiDirect = loader.apply("alSourceiDirect");
        HANDLE$alSourceiDirect = RawFunctionLoader.link(SEGMENT$alSourceiDirect, Descriptors.DESCRIPTOR$alSourceiDirect);
        SEGMENT$alSource3iDirect = loader.apply("alSource3iDirect");
        HANDLE$alSource3iDirect = RawFunctionLoader.link(SEGMENT$alSource3iDirect, Descriptors.DESCRIPTOR$alSource3iDirect);
        SEGMENT$alSourceivDirect = loader.apply("alSourceivDirect");
        HANDLE$alSourceivDirect = RawFunctionLoader.link(SEGMENT$alSourceivDirect, Descriptors.DESCRIPTOR$alSourceivDirect);
        SEGMENT$alGetSourcefDirect = loader.apply("alGetSourcefDirect");
        HANDLE$alGetSourcefDirect = RawFunctionLoader.link(SEGMENT$alGetSourcefDirect, Descriptors.DESCRIPTOR$alGetSourcefDirect);
        SEGMENT$alGetSource3fDirect = loader.apply("alGetSource3fDirect");
        HANDLE$alGetSource3fDirect = RawFunctionLoader.link(SEGMENT$alGetSource3fDirect, Descriptors.DESCRIPTOR$alGetSource3fDirect);
        SEGMENT$alGetSourcefvDirect = loader.apply("alGetSourcefvDirect");
        HANDLE$alGetSourcefvDirect = RawFunctionLoader.link(SEGMENT$alGetSourcefvDirect, Descriptors.DESCRIPTOR$alGetSourcefvDirect);
        SEGMENT$alGetSourceiDirect = loader.apply("alGetSourceiDirect");
        HANDLE$alGetSourceiDirect = RawFunctionLoader.link(SEGMENT$alGetSourceiDirect, Descriptors.DESCRIPTOR$alGetSourceiDirect);
        SEGMENT$alGetSource3iDirect = loader.apply("alGetSource3iDirect");
        HANDLE$alGetSource3iDirect = RawFunctionLoader.link(SEGMENT$alGetSource3iDirect, Descriptors.DESCRIPTOR$alGetSource3iDirect);
        SEGMENT$alGetSourceivDirect = loader.apply("alGetSourceivDirect");
        HANDLE$alGetSourceivDirect = RawFunctionLoader.link(SEGMENT$alGetSourceivDirect, Descriptors.DESCRIPTOR$alGetSourceivDirect);
        SEGMENT$alSourcePlayDirect = loader.apply("alSourcePlayDirect");
        HANDLE$alSourcePlayDirect = RawFunctionLoader.link(SEGMENT$alSourcePlayDirect, Descriptors.DESCRIPTOR$alSourcePlayDirect);
        SEGMENT$alSourceStopDirect = loader.apply("alSourceStopDirect");
        HANDLE$alSourceStopDirect = RawFunctionLoader.link(SEGMENT$alSourceStopDirect, Descriptors.DESCRIPTOR$alSourceStopDirect);
        SEGMENT$alSourceRewindDirect = loader.apply("alSourceRewindDirect");
        HANDLE$alSourceRewindDirect = RawFunctionLoader.link(SEGMENT$alSourceRewindDirect, Descriptors.DESCRIPTOR$alSourceRewindDirect);
        SEGMENT$alSourcePauseDirect = loader.apply("alSourcePauseDirect");
        HANDLE$alSourcePauseDirect = RawFunctionLoader.link(SEGMENT$alSourcePauseDirect, Descriptors.DESCRIPTOR$alSourcePauseDirect);
        SEGMENT$alSourcePlayvDirect = loader.apply("alSourcePlayvDirect");
        HANDLE$alSourcePlayvDirect = RawFunctionLoader.link(SEGMENT$alSourcePlayvDirect, Descriptors.DESCRIPTOR$alSourcePlayvDirect);
        SEGMENT$alSourceStopvDirect = loader.apply("alSourceStopvDirect");
        HANDLE$alSourceStopvDirect = RawFunctionLoader.link(SEGMENT$alSourceStopvDirect, Descriptors.DESCRIPTOR$alSourceStopvDirect);
        SEGMENT$alSourceRewindvDirect = loader.apply("alSourceRewindvDirect");
        HANDLE$alSourceRewindvDirect = RawFunctionLoader.link(SEGMENT$alSourceRewindvDirect, Descriptors.DESCRIPTOR$alSourceRewindvDirect);
        SEGMENT$alSourcePausevDirect = loader.apply("alSourcePausevDirect");
        HANDLE$alSourcePausevDirect = RawFunctionLoader.link(SEGMENT$alSourcePausevDirect, Descriptors.DESCRIPTOR$alSourcePausevDirect);
        SEGMENT$alSourceQueueBuffersDirect = loader.apply("alSourceQueueBuffersDirect");
        HANDLE$alSourceQueueBuffersDirect = RawFunctionLoader.link(SEGMENT$alSourceQueueBuffersDirect, Descriptors.DESCRIPTOR$alSourceQueueBuffersDirect);
        SEGMENT$alSourceUnqueueBuffersDirect = loader.apply("alSourceUnqueueBuffersDirect");
        HANDLE$alSourceUnqueueBuffersDirect = RawFunctionLoader.link(SEGMENT$alSourceUnqueueBuffersDirect, Descriptors.DESCRIPTOR$alSourceUnqueueBuffersDirect);
        SEGMENT$alGenBuffersDirect = loader.apply("alGenBuffersDirect");
        HANDLE$alGenBuffersDirect = RawFunctionLoader.link(SEGMENT$alGenBuffersDirect, Descriptors.DESCRIPTOR$alGenBuffersDirect);
        SEGMENT$alDeleteBuffersDirect = loader.apply("alDeleteBuffersDirect");
        HANDLE$alDeleteBuffersDirect = RawFunctionLoader.link(SEGMENT$alDeleteBuffersDirect, Descriptors.DESCRIPTOR$alDeleteBuffersDirect);
        SEGMENT$alIsBufferDirect = loader.apply("alIsBufferDirect");
        HANDLE$alIsBufferDirect = RawFunctionLoader.link(SEGMENT$alIsBufferDirect, Descriptors.DESCRIPTOR$alIsBufferDirect);
        SEGMENT$alBufferDataDirect = loader.apply("alBufferDataDirect");
        HANDLE$alBufferDataDirect = RawFunctionLoader.link(SEGMENT$alBufferDataDirect, Descriptors.DESCRIPTOR$alBufferDataDirect);
        SEGMENT$alBufferfDirect = loader.apply("alBufferfDirect");
        HANDLE$alBufferfDirect = RawFunctionLoader.link(SEGMENT$alBufferfDirect, Descriptors.DESCRIPTOR$alBufferfDirect);
        SEGMENT$alBuffer3fDirect = loader.apply("alBuffer3fDirect");
        HANDLE$alBuffer3fDirect = RawFunctionLoader.link(SEGMENT$alBuffer3fDirect, Descriptors.DESCRIPTOR$alBuffer3fDirect);
        SEGMENT$alBufferfvDirect = loader.apply("alBufferfvDirect");
        HANDLE$alBufferfvDirect = RawFunctionLoader.link(SEGMENT$alBufferfvDirect, Descriptors.DESCRIPTOR$alBufferfvDirect);
        SEGMENT$alBufferiDirect = loader.apply("alBufferiDirect");
        HANDLE$alBufferiDirect = RawFunctionLoader.link(SEGMENT$alBufferiDirect, Descriptors.DESCRIPTOR$alBufferiDirect);
        SEGMENT$alBuffer3iDirect = loader.apply("alBuffer3iDirect");
        HANDLE$alBuffer3iDirect = RawFunctionLoader.link(SEGMENT$alBuffer3iDirect, Descriptors.DESCRIPTOR$alBuffer3iDirect);
        SEGMENT$alBufferivDirect = loader.apply("alBufferivDirect");
        HANDLE$alBufferivDirect = RawFunctionLoader.link(SEGMENT$alBufferivDirect, Descriptors.DESCRIPTOR$alBufferivDirect);
        SEGMENT$alGetBufferfDirect = loader.apply("alGetBufferfDirect");
        HANDLE$alGetBufferfDirect = RawFunctionLoader.link(SEGMENT$alGetBufferfDirect, Descriptors.DESCRIPTOR$alGetBufferfDirect);
        SEGMENT$alGetBuffer3fDirect = loader.apply("alGetBuffer3fDirect");
        HANDLE$alGetBuffer3fDirect = RawFunctionLoader.link(SEGMENT$alGetBuffer3fDirect, Descriptors.DESCRIPTOR$alGetBuffer3fDirect);
        SEGMENT$alGetBufferfvDirect = loader.apply("alGetBufferfvDirect");
        HANDLE$alGetBufferfvDirect = RawFunctionLoader.link(SEGMENT$alGetBufferfvDirect, Descriptors.DESCRIPTOR$alGetBufferfvDirect);
        SEGMENT$alGetBufferiDirect = loader.apply("alGetBufferiDirect");
        HANDLE$alGetBufferiDirect = RawFunctionLoader.link(SEGMENT$alGetBufferiDirect, Descriptors.DESCRIPTOR$alGetBufferiDirect);
        SEGMENT$alGetBuffer3iDirect = loader.apply("alGetBuffer3iDirect");
        HANDLE$alGetBuffer3iDirect = RawFunctionLoader.link(SEGMENT$alGetBuffer3iDirect, Descriptors.DESCRIPTOR$alGetBuffer3iDirect);
        SEGMENT$alGetBufferivDirect = loader.apply("alGetBufferivDirect");
        HANDLE$alGetBufferivDirect = RawFunctionLoader.link(SEGMENT$alGetBufferivDirect, Descriptors.DESCRIPTOR$alGetBufferivDirect);
        SEGMENT$alGenEffectsDirect = loader.apply("alGenEffectsDirect");
        HANDLE$alGenEffectsDirect = RawFunctionLoader.link(SEGMENT$alGenEffectsDirect, Descriptors.DESCRIPTOR$alGenEffectsDirect);
        SEGMENT$alDeleteEffectsDirect = loader.apply("alDeleteEffectsDirect");
        HANDLE$alDeleteEffectsDirect = RawFunctionLoader.link(SEGMENT$alDeleteEffectsDirect, Descriptors.DESCRIPTOR$alDeleteEffectsDirect);
        SEGMENT$alIsEffectDirect = loader.apply("alIsEffectDirect");
        HANDLE$alIsEffectDirect = RawFunctionLoader.link(SEGMENT$alIsEffectDirect, Descriptors.DESCRIPTOR$alIsEffectDirect);
        SEGMENT$alEffectiDirect = loader.apply("alEffectiDirect");
        HANDLE$alEffectiDirect = RawFunctionLoader.link(SEGMENT$alEffectiDirect, Descriptors.DESCRIPTOR$alEffectiDirect);
        SEGMENT$alEffectivDirect = loader.apply("alEffectivDirect");
        HANDLE$alEffectivDirect = RawFunctionLoader.link(SEGMENT$alEffectivDirect, Descriptors.DESCRIPTOR$alEffectivDirect);
        SEGMENT$alEffectfDirect = loader.apply("alEffectfDirect");
        HANDLE$alEffectfDirect = RawFunctionLoader.link(SEGMENT$alEffectfDirect, Descriptors.DESCRIPTOR$alEffectfDirect);
        SEGMENT$alEffectfvDirect = loader.apply("alEffectfvDirect");
        HANDLE$alEffectfvDirect = RawFunctionLoader.link(SEGMENT$alEffectfvDirect, Descriptors.DESCRIPTOR$alEffectfvDirect);
        SEGMENT$alGetEffectiDirect = loader.apply("alGetEffectiDirect");
        HANDLE$alGetEffectiDirect = RawFunctionLoader.link(SEGMENT$alGetEffectiDirect, Descriptors.DESCRIPTOR$alGetEffectiDirect);
        SEGMENT$alGetEffectivDirect = loader.apply("alGetEffectivDirect");
        HANDLE$alGetEffectivDirect = RawFunctionLoader.link(SEGMENT$alGetEffectivDirect, Descriptors.DESCRIPTOR$alGetEffectivDirect);
        SEGMENT$alGetEffectfDirect = loader.apply("alGetEffectfDirect");
        HANDLE$alGetEffectfDirect = RawFunctionLoader.link(SEGMENT$alGetEffectfDirect, Descriptors.DESCRIPTOR$alGetEffectfDirect);
        SEGMENT$alGetEffectfvDirect = loader.apply("alGetEffectfvDirect");
        HANDLE$alGetEffectfvDirect = RawFunctionLoader.link(SEGMENT$alGetEffectfvDirect, Descriptors.DESCRIPTOR$alGetEffectfvDirect);
        SEGMENT$alGenFiltersDirect = loader.apply("alGenFiltersDirect");
        HANDLE$alGenFiltersDirect = RawFunctionLoader.link(SEGMENT$alGenFiltersDirect, Descriptors.DESCRIPTOR$alGenFiltersDirect);
        SEGMENT$alDeleteFiltersDirect = loader.apply("alDeleteFiltersDirect");
        HANDLE$alDeleteFiltersDirect = RawFunctionLoader.link(SEGMENT$alDeleteFiltersDirect, Descriptors.DESCRIPTOR$alDeleteFiltersDirect);
        SEGMENT$alIsFilterDirect = loader.apply("alIsFilterDirect");
        HANDLE$alIsFilterDirect = RawFunctionLoader.link(SEGMENT$alIsFilterDirect, Descriptors.DESCRIPTOR$alIsFilterDirect);
        SEGMENT$alFilteriDirect = loader.apply("alFilteriDirect");
        HANDLE$alFilteriDirect = RawFunctionLoader.link(SEGMENT$alFilteriDirect, Descriptors.DESCRIPTOR$alFilteriDirect);
        SEGMENT$alFilterivDirect = loader.apply("alFilterivDirect");
        HANDLE$alFilterivDirect = RawFunctionLoader.link(SEGMENT$alFilterivDirect, Descriptors.DESCRIPTOR$alFilterivDirect);
        SEGMENT$alFilterfDirect = loader.apply("alFilterfDirect");
        HANDLE$alFilterfDirect = RawFunctionLoader.link(SEGMENT$alFilterfDirect, Descriptors.DESCRIPTOR$alFilterfDirect);
        SEGMENT$alFilterfvDirect = loader.apply("alFilterfvDirect");
        HANDLE$alFilterfvDirect = RawFunctionLoader.link(SEGMENT$alFilterfvDirect, Descriptors.DESCRIPTOR$alFilterfvDirect);
        SEGMENT$alGetFilteriDirect = loader.apply("alGetFilteriDirect");
        HANDLE$alGetFilteriDirect = RawFunctionLoader.link(SEGMENT$alGetFilteriDirect, Descriptors.DESCRIPTOR$alGetFilteriDirect);
        SEGMENT$alGetFilterivDirect = loader.apply("alGetFilterivDirect");
        HANDLE$alGetFilterivDirect = RawFunctionLoader.link(SEGMENT$alGetFilterivDirect, Descriptors.DESCRIPTOR$alGetFilterivDirect);
        SEGMENT$alGetFilterfDirect = loader.apply("alGetFilterfDirect");
        HANDLE$alGetFilterfDirect = RawFunctionLoader.link(SEGMENT$alGetFilterfDirect, Descriptors.DESCRIPTOR$alGetFilterfDirect);
        SEGMENT$alGetFilterfvDirect = loader.apply("alGetFilterfvDirect");
        HANDLE$alGetFilterfvDirect = RawFunctionLoader.link(SEGMENT$alGetFilterfvDirect, Descriptors.DESCRIPTOR$alGetFilterfvDirect);
        SEGMENT$alGenAuxiliaryEffectSlotsDirect = loader.apply("alGenAuxiliaryEffectSlotsDirect");
        HANDLE$alGenAuxiliaryEffectSlotsDirect = RawFunctionLoader.link(SEGMENT$alGenAuxiliaryEffectSlotsDirect, Descriptors.DESCRIPTOR$alGenAuxiliaryEffectSlotsDirect);
        SEGMENT$alDeleteAuxiliaryEffectSlotsDirect = loader.apply("alDeleteAuxiliaryEffectSlotsDirect");
        HANDLE$alDeleteAuxiliaryEffectSlotsDirect = RawFunctionLoader.link(SEGMENT$alDeleteAuxiliaryEffectSlotsDirect, Descriptors.DESCRIPTOR$alDeleteAuxiliaryEffectSlotsDirect);
        SEGMENT$alIsAuxiliaryEffectSlotDirect = loader.apply("alIsAuxiliaryEffectSlotDirect");
        HANDLE$alIsAuxiliaryEffectSlotDirect = RawFunctionLoader.link(SEGMENT$alIsAuxiliaryEffectSlotDirect, Descriptors.DESCRIPTOR$alIsAuxiliaryEffectSlotDirect);
        SEGMENT$alAuxiliaryEffectSlotiDirect = loader.apply("alAuxiliaryEffectSlotiDirect");
        HANDLE$alAuxiliaryEffectSlotiDirect = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSlotiDirect, Descriptors.DESCRIPTOR$alAuxiliaryEffectSlotiDirect);
        SEGMENT$alAuxiliaryEffectSlotivDirect = loader.apply("alAuxiliaryEffectSlotivDirect");
        HANDLE$alAuxiliaryEffectSlotivDirect = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSlotivDirect, Descriptors.DESCRIPTOR$alAuxiliaryEffectSlotivDirect);
        SEGMENT$alAuxiliaryEffectSlotfDirect = loader.apply("alAuxiliaryEffectSlotfDirect");
        HANDLE$alAuxiliaryEffectSlotfDirect = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSlotfDirect, Descriptors.DESCRIPTOR$alAuxiliaryEffectSlotfDirect);
        SEGMENT$alAuxiliaryEffectSlotfvDirect = loader.apply("alAuxiliaryEffectSlotfvDirect");
        HANDLE$alAuxiliaryEffectSlotfvDirect = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSlotfvDirect, Descriptors.DESCRIPTOR$alAuxiliaryEffectSlotfvDirect);
        SEGMENT$alGetAuxiliaryEffectSlotiDirect = loader.apply("alGetAuxiliaryEffectSlotiDirect");
        HANDLE$alGetAuxiliaryEffectSlotiDirect = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSlotiDirect, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSlotiDirect);
        SEGMENT$alGetAuxiliaryEffectSlotivDirect = loader.apply("alGetAuxiliaryEffectSlotivDirect");
        HANDLE$alGetAuxiliaryEffectSlotivDirect = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSlotivDirect, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSlotivDirect);
        SEGMENT$alGetAuxiliaryEffectSlotfDirect = loader.apply("alGetAuxiliaryEffectSlotfDirect");
        HANDLE$alGetAuxiliaryEffectSlotfDirect = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSlotfDirect, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSlotfDirect);
        SEGMENT$alGetAuxiliaryEffectSlotfvDirect = loader.apply("alGetAuxiliaryEffectSlotfvDirect");
        HANDLE$alGetAuxiliaryEffectSlotfvDirect = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSlotfvDirect, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSlotfvDirect);
        SEGMENT$alBufferDataStaticDirect = loader.apply("alBufferDataStaticDirect");
        HANDLE$alBufferDataStaticDirect = RawFunctionLoader.link(SEGMENT$alBufferDataStaticDirect, Descriptors.DESCRIPTOR$alBufferDataStaticDirect);
        SEGMENT$alDebugMessageCallbackDirectEXT = loader.apply("alDebugMessageCallbackDirectEXT");
        HANDLE$alDebugMessageCallbackDirectEXT = RawFunctionLoader.link(SEGMENT$alDebugMessageCallbackDirectEXT, Descriptors.DESCRIPTOR$alDebugMessageCallbackDirectEXT);
        SEGMENT$alDebugMessageInsertDirectEXT = loader.apply("alDebugMessageInsertDirectEXT");
        HANDLE$alDebugMessageInsertDirectEXT = RawFunctionLoader.link(SEGMENT$alDebugMessageInsertDirectEXT, Descriptors.DESCRIPTOR$alDebugMessageInsertDirectEXT);
        SEGMENT$alDebugMessageControlDirectEXT = loader.apply("alDebugMessageControlDirectEXT");
        HANDLE$alDebugMessageControlDirectEXT = RawFunctionLoader.link(SEGMENT$alDebugMessageControlDirectEXT, Descriptors.DESCRIPTOR$alDebugMessageControlDirectEXT);
        SEGMENT$alPushDebugGroupDirectEXT = loader.apply("alPushDebugGroupDirectEXT");
        HANDLE$alPushDebugGroupDirectEXT = RawFunctionLoader.link(SEGMENT$alPushDebugGroupDirectEXT, Descriptors.DESCRIPTOR$alPushDebugGroupDirectEXT);
        SEGMENT$alPopDebugGroupDirectEXT = loader.apply("alPopDebugGroupDirectEXT");
        HANDLE$alPopDebugGroupDirectEXT = RawFunctionLoader.link(SEGMENT$alPopDebugGroupDirectEXT, Descriptors.DESCRIPTOR$alPopDebugGroupDirectEXT);
        SEGMENT$alGetDebugMessageLogDirectEXT = loader.apply("alGetDebugMessageLogDirectEXT");
        HANDLE$alGetDebugMessageLogDirectEXT = RawFunctionLoader.link(SEGMENT$alGetDebugMessageLogDirectEXT, Descriptors.DESCRIPTOR$alGetDebugMessageLogDirectEXT);
        SEGMENT$alObjectLabelDirectEXT = loader.apply("alObjectLabelDirectEXT");
        HANDLE$alObjectLabelDirectEXT = RawFunctionLoader.link(SEGMENT$alObjectLabelDirectEXT, Descriptors.DESCRIPTOR$alObjectLabelDirectEXT);
        SEGMENT$alGetObjectLabelDirectEXT = loader.apply("alGetObjectLabelDirectEXT");
        HANDLE$alGetObjectLabelDirectEXT = RawFunctionLoader.link(SEGMENT$alGetObjectLabelDirectEXT, Descriptors.DESCRIPTOR$alGetObjectLabelDirectEXT);
        SEGMENT$alGetPointerDirectEXT = loader.apply("alGetPointerDirectEXT");
        HANDLE$alGetPointerDirectEXT = RawFunctionLoader.link(SEGMENT$alGetPointerDirectEXT, Descriptors.DESCRIPTOR$alGetPointerDirectEXT);
        SEGMENT$alGetPointervDirectEXT = loader.apply("alGetPointervDirectEXT");
        HANDLE$alGetPointervDirectEXT = RawFunctionLoader.link(SEGMENT$alGetPointervDirectEXT, Descriptors.DESCRIPTOR$alGetPointervDirectEXT);
        SEGMENT$alRequestFoldbackStartDirect = loader.apply("alRequestFoldbackStartDirect");
        HANDLE$alRequestFoldbackStartDirect = RawFunctionLoader.link(SEGMENT$alRequestFoldbackStartDirect, Descriptors.DESCRIPTOR$alRequestFoldbackStartDirect);
        SEGMENT$alRequestFoldbackStopDirect = loader.apply("alRequestFoldbackStopDirect");
        HANDLE$alRequestFoldbackStopDirect = RawFunctionLoader.link(SEGMENT$alRequestFoldbackStopDirect, Descriptors.DESCRIPTOR$alRequestFoldbackStopDirect);
        SEGMENT$alBufferSubDataDirectSOFT = loader.apply("alBufferSubDataDirectSOFT");
        HANDLE$alBufferSubDataDirectSOFT = RawFunctionLoader.link(SEGMENT$alBufferSubDataDirectSOFT, Descriptors.DESCRIPTOR$alBufferSubDataDirectSOFT);
        SEGMENT$alSourcedDirectSOFT = loader.apply("alSourcedDirectSOFT");
        HANDLE$alSourcedDirectSOFT = RawFunctionLoader.link(SEGMENT$alSourcedDirectSOFT, Descriptors.DESCRIPTOR$alSourcedDirectSOFT);
        SEGMENT$alSource3dDirectSOFT = loader.apply("alSource3dDirectSOFT");
        HANDLE$alSource3dDirectSOFT = RawFunctionLoader.link(SEGMENT$alSource3dDirectSOFT, Descriptors.DESCRIPTOR$alSource3dDirectSOFT);
        SEGMENT$alSourcedvDirectSOFT = loader.apply("alSourcedvDirectSOFT");
        HANDLE$alSourcedvDirectSOFT = RawFunctionLoader.link(SEGMENT$alSourcedvDirectSOFT, Descriptors.DESCRIPTOR$alSourcedvDirectSOFT);
        SEGMENT$alGetSourcedDirectSOFT = loader.apply("alGetSourcedDirectSOFT");
        HANDLE$alGetSourcedDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetSourcedDirectSOFT, Descriptors.DESCRIPTOR$alGetSourcedDirectSOFT);
        SEGMENT$alGetSource3dDirectSOFT = loader.apply("alGetSource3dDirectSOFT");
        HANDLE$alGetSource3dDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetSource3dDirectSOFT, Descriptors.DESCRIPTOR$alGetSource3dDirectSOFT);
        SEGMENT$alGetSourcedvDirectSOFT = loader.apply("alGetSourcedvDirectSOFT");
        HANDLE$alGetSourcedvDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetSourcedvDirectSOFT, Descriptors.DESCRIPTOR$alGetSourcedvDirectSOFT);
        SEGMENT$alSourcei64DirectSOFT = loader.apply("alSourcei64DirectSOFT");
        HANDLE$alSourcei64DirectSOFT = RawFunctionLoader.link(SEGMENT$alSourcei64DirectSOFT, Descriptors.DESCRIPTOR$alSourcei64DirectSOFT);
        SEGMENT$alSource3i64DirectSOFT = loader.apply("alSource3i64DirectSOFT");
        HANDLE$alSource3i64DirectSOFT = RawFunctionLoader.link(SEGMENT$alSource3i64DirectSOFT, Descriptors.DESCRIPTOR$alSource3i64DirectSOFT);
        SEGMENT$alSourcei64vDirectSOFT = loader.apply("alSourcei64vDirectSOFT");
        HANDLE$alSourcei64vDirectSOFT = RawFunctionLoader.link(SEGMENT$alSourcei64vDirectSOFT, Descriptors.DESCRIPTOR$alSourcei64vDirectSOFT);
        SEGMENT$alGetSourcei64DirectSOFT = loader.apply("alGetSourcei64DirectSOFT");
        HANDLE$alGetSourcei64DirectSOFT = RawFunctionLoader.link(SEGMENT$alGetSourcei64DirectSOFT, Descriptors.DESCRIPTOR$alGetSourcei64DirectSOFT);
        SEGMENT$alGetSource3i64DirectSOFT = loader.apply("alGetSource3i64DirectSOFT");
        HANDLE$alGetSource3i64DirectSOFT = RawFunctionLoader.link(SEGMENT$alGetSource3i64DirectSOFT, Descriptors.DESCRIPTOR$alGetSource3i64DirectSOFT);
        SEGMENT$alGetSourcei64vDirectSOFT = loader.apply("alGetSourcei64vDirectSOFT");
        HANDLE$alGetSourcei64vDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetSourcei64vDirectSOFT, Descriptors.DESCRIPTOR$alGetSourcei64vDirectSOFT);
        SEGMENT$alDeferUpdatesDirectSOFT = loader.apply("alDeferUpdatesDirectSOFT");
        HANDLE$alDeferUpdatesDirectSOFT = RawFunctionLoader.link(SEGMENT$alDeferUpdatesDirectSOFT, Descriptors.DESCRIPTOR$alDeferUpdatesDirectSOFT);
        SEGMENT$alProcessUpdatesDirectSOFT = loader.apply("alProcessUpdatesDirectSOFT");
        HANDLE$alProcessUpdatesDirectSOFT = RawFunctionLoader.link(SEGMENT$alProcessUpdatesDirectSOFT, Descriptors.DESCRIPTOR$alProcessUpdatesDirectSOFT);
        SEGMENT$alGetStringiDirectSOFT = loader.apply("alGetStringiDirectSOFT");
        HANDLE$alGetStringiDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetStringiDirectSOFT, Descriptors.DESCRIPTOR$alGetStringiDirectSOFT);
        SEGMENT$alEventControlDirectSOFT = loader.apply("alEventControlDirectSOFT");
        HANDLE$alEventControlDirectSOFT = RawFunctionLoader.link(SEGMENT$alEventControlDirectSOFT, Descriptors.DESCRIPTOR$alEventControlDirectSOFT);
        SEGMENT$alEventCallbackDirectSOFT = loader.apply("alEventCallbackDirectSOFT");
        HANDLE$alEventCallbackDirectSOFT = RawFunctionLoader.link(SEGMENT$alEventCallbackDirectSOFT, Descriptors.DESCRIPTOR$alEventCallbackDirectSOFT);
        SEGMENT$alGetPointerDirectSOFT = loader.apply("alGetPointerDirectSOFT");
        HANDLE$alGetPointerDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetPointerDirectSOFT, Descriptors.DESCRIPTOR$alGetPointerDirectSOFT);
        SEGMENT$alGetPointervDirectSOFT = loader.apply("alGetPointervDirectSOFT");
        HANDLE$alGetPointervDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetPointervDirectSOFT, Descriptors.DESCRIPTOR$alGetPointervDirectSOFT);
        SEGMENT$alBufferCallbackDirectSOFT = loader.apply("alBufferCallbackDirectSOFT");
        HANDLE$alBufferCallbackDirectSOFT = RawFunctionLoader.link(SEGMENT$alBufferCallbackDirectSOFT, Descriptors.DESCRIPTOR$alBufferCallbackDirectSOFT);
        SEGMENT$alGetBufferPtrDirectSOFT = loader.apply("alGetBufferPtrDirectSOFT");
        HANDLE$alGetBufferPtrDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetBufferPtrDirectSOFT, Descriptors.DESCRIPTOR$alGetBufferPtrDirectSOFT);
        SEGMENT$alGetBuffer3PtrDirectSOFT = loader.apply("alGetBuffer3PtrDirectSOFT");
        HANDLE$alGetBuffer3PtrDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetBuffer3PtrDirectSOFT, Descriptors.DESCRIPTOR$alGetBuffer3PtrDirectSOFT);
        SEGMENT$alGetBufferPtrvDirectSOFT = loader.apply("alGetBufferPtrvDirectSOFT");
        HANDLE$alGetBufferPtrvDirectSOFT = RawFunctionLoader.link(SEGMENT$alGetBufferPtrvDirectSOFT, Descriptors.DESCRIPTOR$alGetBufferPtrvDirectSOFT);
        SEGMENT$alSourcePlayAtTimeDirectSOFT = loader.apply("alSourcePlayAtTimeDirectSOFT");
        HANDLE$alSourcePlayAtTimeDirectSOFT = RawFunctionLoader.link(SEGMENT$alSourcePlayAtTimeDirectSOFT, Descriptors.DESCRIPTOR$alSourcePlayAtTimeDirectSOFT);
        SEGMENT$alSourcePlayAtTimevDirectSOFT = loader.apply("alSourcePlayAtTimevDirectSOFT");
        HANDLE$alSourcePlayAtTimevDirectSOFT = RawFunctionLoader.link(SEGMENT$alSourcePlayAtTimevDirectSOFT, Descriptors.DESCRIPTOR$alSourcePlayAtTimevDirectSOFT);
        SEGMENT$EAXSetDirect = loader.apply("EAXSetDirect");
        HANDLE$EAXSetDirect = RawFunctionLoader.link(SEGMENT$EAXSetDirect, Descriptors.DESCRIPTOR$EAXSetDirect);
        SEGMENT$EAXGetDirect = loader.apply("EAXGetDirect");
        HANDLE$EAXGetDirect = RawFunctionLoader.link(SEGMENT$EAXGetDirect, Descriptors.DESCRIPTOR$EAXGetDirect);
        SEGMENT$EAXSetBufferModeDirect = loader.apply("EAXSetBufferModeDirect");
        HANDLE$EAXSetBufferModeDirect = RawFunctionLoader.link(SEGMENT$EAXSetBufferModeDirect, Descriptors.DESCRIPTOR$EAXSetBufferModeDirect);
        SEGMENT$EAXGetBufferModeDirect = loader.apply("EAXGetBufferModeDirect");
        HANDLE$EAXGetBufferModeDirect = RawFunctionLoader.link(SEGMENT$EAXGetBufferModeDirect, Descriptors.DESCRIPTOR$EAXGetBufferModeDirect);
        SEGMENT$alGenEffects = loader.apply("alGenEffects");
        HANDLE$alGenEffects = RawFunctionLoader.link(SEGMENT$alGenEffects, Descriptors.DESCRIPTOR$alGenEffects);
        SEGMENT$alDeleteEffects = loader.apply("alDeleteEffects");
        HANDLE$alDeleteEffects = RawFunctionLoader.link(SEGMENT$alDeleteEffects, Descriptors.DESCRIPTOR$alDeleteEffects);
        SEGMENT$alIsEffect = loader.apply("alIsEffect");
        HANDLE$alIsEffect = RawFunctionLoader.link(SEGMENT$alIsEffect, Descriptors.DESCRIPTOR$alIsEffect);
        SEGMENT$alEffecti = loader.apply("alEffecti");
        HANDLE$alEffecti = RawFunctionLoader.link(SEGMENT$alEffecti, Descriptors.DESCRIPTOR$alEffecti);
        SEGMENT$alEffectiv = loader.apply("alEffectiv");
        HANDLE$alEffectiv = RawFunctionLoader.link(SEGMENT$alEffectiv, Descriptors.DESCRIPTOR$alEffectiv);
        SEGMENT$alEffectf = loader.apply("alEffectf");
        HANDLE$alEffectf = RawFunctionLoader.link(SEGMENT$alEffectf, Descriptors.DESCRIPTOR$alEffectf);
        SEGMENT$alEffectfv = loader.apply("alEffectfv");
        HANDLE$alEffectfv = RawFunctionLoader.link(SEGMENT$alEffectfv, Descriptors.DESCRIPTOR$alEffectfv);
        SEGMENT$alGetEffecti = loader.apply("alGetEffecti");
        HANDLE$alGetEffecti = RawFunctionLoader.link(SEGMENT$alGetEffecti, Descriptors.DESCRIPTOR$alGetEffecti);
        SEGMENT$alGetEffectiv = loader.apply("alGetEffectiv");
        HANDLE$alGetEffectiv = RawFunctionLoader.link(SEGMENT$alGetEffectiv, Descriptors.DESCRIPTOR$alGetEffectiv);
        SEGMENT$alGetEffectf = loader.apply("alGetEffectf");
        HANDLE$alGetEffectf = RawFunctionLoader.link(SEGMENT$alGetEffectf, Descriptors.DESCRIPTOR$alGetEffectf);
        SEGMENT$alGetEffectfv = loader.apply("alGetEffectfv");
        HANDLE$alGetEffectfv = RawFunctionLoader.link(SEGMENT$alGetEffectfv, Descriptors.DESCRIPTOR$alGetEffectfv);
        SEGMENT$alGenFilters = loader.apply("alGenFilters");
        HANDLE$alGenFilters = RawFunctionLoader.link(SEGMENT$alGenFilters, Descriptors.DESCRIPTOR$alGenFilters);
        SEGMENT$alDeleteFilters = loader.apply("alDeleteFilters");
        HANDLE$alDeleteFilters = RawFunctionLoader.link(SEGMENT$alDeleteFilters, Descriptors.DESCRIPTOR$alDeleteFilters);
        SEGMENT$alIsFilter = loader.apply("alIsFilter");
        HANDLE$alIsFilter = RawFunctionLoader.link(SEGMENT$alIsFilter, Descriptors.DESCRIPTOR$alIsFilter);
        SEGMENT$alFilteri = loader.apply("alFilteri");
        HANDLE$alFilteri = RawFunctionLoader.link(SEGMENT$alFilteri, Descriptors.DESCRIPTOR$alFilteri);
        SEGMENT$alFilteriv = loader.apply("alFilteriv");
        HANDLE$alFilteriv = RawFunctionLoader.link(SEGMENT$alFilteriv, Descriptors.DESCRIPTOR$alFilteriv);
        SEGMENT$alFilterf = loader.apply("alFilterf");
        HANDLE$alFilterf = RawFunctionLoader.link(SEGMENT$alFilterf, Descriptors.DESCRIPTOR$alFilterf);
        SEGMENT$alFilterfv = loader.apply("alFilterfv");
        HANDLE$alFilterfv = RawFunctionLoader.link(SEGMENT$alFilterfv, Descriptors.DESCRIPTOR$alFilterfv);
        SEGMENT$alGetFilteri = loader.apply("alGetFilteri");
        HANDLE$alGetFilteri = RawFunctionLoader.link(SEGMENT$alGetFilteri, Descriptors.DESCRIPTOR$alGetFilteri);
        SEGMENT$alGetFilteriv = loader.apply("alGetFilteriv");
        HANDLE$alGetFilteriv = RawFunctionLoader.link(SEGMENT$alGetFilteriv, Descriptors.DESCRIPTOR$alGetFilteriv);
        SEGMENT$alGetFilterf = loader.apply("alGetFilterf");
        HANDLE$alGetFilterf = RawFunctionLoader.link(SEGMENT$alGetFilterf, Descriptors.DESCRIPTOR$alGetFilterf);
        SEGMENT$alGetFilterfv = loader.apply("alGetFilterfv");
        HANDLE$alGetFilterfv = RawFunctionLoader.link(SEGMENT$alGetFilterfv, Descriptors.DESCRIPTOR$alGetFilterfv);
        SEGMENT$alGenAuxiliaryEffectSlots = loader.apply("alGenAuxiliaryEffectSlots");
        HANDLE$alGenAuxiliaryEffectSlots = RawFunctionLoader.link(SEGMENT$alGenAuxiliaryEffectSlots, Descriptors.DESCRIPTOR$alGenAuxiliaryEffectSlots);
        SEGMENT$alDeleteAuxiliaryEffectSlots = loader.apply("alDeleteAuxiliaryEffectSlots");
        HANDLE$alDeleteAuxiliaryEffectSlots = RawFunctionLoader.link(SEGMENT$alDeleteAuxiliaryEffectSlots, Descriptors.DESCRIPTOR$alDeleteAuxiliaryEffectSlots);
        SEGMENT$alIsAuxiliaryEffectSlot = loader.apply("alIsAuxiliaryEffectSlot");
        HANDLE$alIsAuxiliaryEffectSlot = RawFunctionLoader.link(SEGMENT$alIsAuxiliaryEffectSlot, Descriptors.DESCRIPTOR$alIsAuxiliaryEffectSlot);
        SEGMENT$alAuxiliaryEffectSloti = loader.apply("alAuxiliaryEffectSloti");
        HANDLE$alAuxiliaryEffectSloti = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSloti, Descriptors.DESCRIPTOR$alAuxiliaryEffectSloti);
        SEGMENT$alAuxiliaryEffectSlotiv = loader.apply("alAuxiliaryEffectSlotiv");
        HANDLE$alAuxiliaryEffectSlotiv = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSlotiv, Descriptors.DESCRIPTOR$alAuxiliaryEffectSlotiv);
        SEGMENT$alAuxiliaryEffectSlotf = loader.apply("alAuxiliaryEffectSlotf");
        HANDLE$alAuxiliaryEffectSlotf = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSlotf, Descriptors.DESCRIPTOR$alAuxiliaryEffectSlotf);
        SEGMENT$alAuxiliaryEffectSlotfv = loader.apply("alAuxiliaryEffectSlotfv");
        HANDLE$alAuxiliaryEffectSlotfv = RawFunctionLoader.link(SEGMENT$alAuxiliaryEffectSlotfv, Descriptors.DESCRIPTOR$alAuxiliaryEffectSlotfv);
        SEGMENT$alGetAuxiliaryEffectSloti = loader.apply("alGetAuxiliaryEffectSloti");
        HANDLE$alGetAuxiliaryEffectSloti = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSloti, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSloti);
        SEGMENT$alGetAuxiliaryEffectSlotiv = loader.apply("alGetAuxiliaryEffectSlotiv");
        HANDLE$alGetAuxiliaryEffectSlotiv = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSlotiv, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSlotiv);
        SEGMENT$alGetAuxiliaryEffectSlotf = loader.apply("alGetAuxiliaryEffectSlotf");
        HANDLE$alGetAuxiliaryEffectSlotf = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSlotf, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSlotf);
        SEGMENT$alGetAuxiliaryEffectSlotfv = loader.apply("alGetAuxiliaryEffectSlotfv");
        HANDLE$alGetAuxiliaryEffectSlotfv = RawFunctionLoader.link(SEGMENT$alGetAuxiliaryEffectSlotfv, Descriptors.DESCRIPTOR$alGetAuxiliaryEffectSlotfv);
    }

    // region command wrappers

    public void enable(
        @NativeType("ALenum") int capability
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEnable);
        try {
            hFunction.invokeExact(
                capability
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void disable(
        @NativeType("ALenum") int capability
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDisable);
        try {
            hFunction.invokeExact(
                capability
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isEnabled(
        @NativeType("ALenum") int capability
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsEnabled);
        try {
            return (byte) hFunction.invokeExact(
                capability
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void dopplerFactor(
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDopplerFactor);
        try {
            hFunction.invokeExact(
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void dopplerVelocity(
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDopplerVelocity);
        try {
            hFunction.invokeExact(
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void distanceModel(
        @NativeType("ALenum") int distanceModel
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDistanceModel);
        try {
            hFunction.invokeExact(
                distanceModel
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable @Pointer(comment="ALchar") BytePtr getString(
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetString);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                param
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBooleanv(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALboolean") BytePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBooleanv);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getIntegerv(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetIntegerv);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFloatv(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFloatv);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getDoublev(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetDoublev);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte getBoolean(
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBoolean);
        try {
            return (byte) hFunction.invokeExact(
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALint") int getInteger(
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetInteger);
        try {
            return (int) hFunction.invokeExact(
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALfloat") float getFloat(
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFloat);
        try {
            return (float) hFunction.invokeExact(
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALdouble") double getDouble(
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetDouble);
        try {
            return (double) hFunction.invokeExact(
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Obtain the first error generated in the AL context since the last call to
    /// this function.
    public @NativeType("ALenum") int getError() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetError);
        try {
            return (int) hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Query for the presence of an extension on the AL context.
    public @NativeType("ALboolean") byte isExtensionPresent(
        @Nullable @Pointer(comment="ALchar") BytePtr extname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsExtensionPresent);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (extname != null ? extname.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Retrieve the address of a function. The returned function may be context-
    /// specific.
    public @Pointer(comment="void*") @NotNull MemorySegment getProcAddress(
        @Nullable @Pointer(comment="ALchar") BytePtr fname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetProcAddress);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (fname != null ? fname.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Retrieve the value of an enum. The returned value may be context-specific.
    public @NativeType("ALenum") int getEnumValue(
        @Nullable @Pointer(comment="ALchar") BytePtr ename
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEnumValue);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (ename != null ? ename.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listenerf(
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListenerf);
        try {
            hFunction.invokeExact(
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listener3f(
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value1,
        @NativeType("ALfloat") float value2,
        @NativeType("ALfloat") float value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListener3f);
        try {
            hFunction.invokeExact(
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listenerfv(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListenerfv);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listeneri(
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListeneri);
        try {
            hFunction.invokeExact(
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listener3i(
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value1,
        @NativeType("ALint") int value2,
        @NativeType("ALint") int value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListener3i);
        try {
            hFunction.invokeExact(
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listeneriv(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListeneriv);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListenerf(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListenerf);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListener3f(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value1,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value2,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListener3f);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListenerfv(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListenerfv);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListeneri(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListeneri);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListener3i(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value1,
        @Nullable @Pointer(comment="ALint") IntPtr value2,
        @Nullable @Pointer(comment="ALint") IntPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListener3i);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListeneriv(
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListeneriv);
        try {
            hFunction.invokeExact(
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Create source objects.
    public void genSources(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenSources);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Delete source objects.
    public void deleteSources(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteSources);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Verify an ID is for a valid source.
    public @NativeType("ALboolean") byte isSource(
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsSource);
        try {
            return (byte) hFunction.invokeExact(
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcef(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcef);
        try {
            hFunction.invokeExact(
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3f(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value1,
        @NativeType("ALfloat") float value2,
        @NativeType("ALfloat") float value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3f);
        try {
            hFunction.invokeExact(
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcefv(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcefv);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcei(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcei);
        try {
            hFunction.invokeExact(
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3i(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value1,
        @NativeType("ALint") int value2,
        @NativeType("ALint") int value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3i);
        try {
            hFunction.invokeExact(
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceiv(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceiv);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcef(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcef);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3f(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value1,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value2,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3f);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcefv(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcefv);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcei(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcei);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3i(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value1,
        @Nullable @Pointer(comment="ALint") IntPtr value2,
        @Nullable @Pointer(comment="ALint") IntPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3i);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourceiv(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourceiv);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Play, restart, or resume a source, setting its state to AL_PLAYING.
    public void sourcePlay(
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlay);
        try {
            hFunction.invokeExact(
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Stop a source, setting its state to AL_STOPPED if playing or paused.
    public void sourceStop(
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceStop);
        try {
            hFunction.invokeExact(
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Rewind a source, setting its state to AL_INITIAL.
    public void sourceRewind(
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceRewind);
        try {
            hFunction.invokeExact(
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Pause a source, setting its state to AL_PAUSED if playing.
    public void sourcePause(
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePause);
        try {
            hFunction.invokeExact(
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Play, restart, or resume a list of sources atomically.
    public void sourcePlayv(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlayv);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Stop a list of sources atomically.
    public void sourceStopv(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceStopv);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Rewind a list of sources atomically.
    public void sourceRewindv(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceRewindv);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Pause a list of sources atomically.
    public void sourcePausev(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePausev);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Queue buffers onto a source
    public void sourceQueueBuffers(
        @NativeType("ALuint") int source,
        @NativeType("ALsizei") int nb,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceQueueBuffers);
        try {
            hFunction.invokeExact(
                source,
                nb,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Unqueue processed buffers from a source
    public void sourceUnqueueBuffers(
        @NativeType("ALuint") int source,
        @NativeType("ALsizei") int nb,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceUnqueueBuffers);
        try {
            hFunction.invokeExact(
                source,
                nb,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Create buffer objects
    public void genBuffers(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenBuffers);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Delete buffer objects
    public void deleteBuffers(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteBuffers);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    ///  Verify an ID is a valid buffer (including the NULL buffer)
    public @NativeType("ALboolean") byte isBuffer(
        @NativeType("ALuint") int buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsBuffer);
        try {
            return (byte) hFunction.invokeExact(
                buffer
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /// Copies data into the buffer, interpreting it using the specified format and
    /// samplerate.
    public void bufferData(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @Pointer(comment="void*") @NotNull MemorySegment data,
        @NativeType("ALsizei") int size,
        @NativeType("ALsizei") int samplerate
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferData);
        try {
            hFunction.invokeExact(
                buffer,
                format,
                data,
                size,
                samplerate
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferf(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferf);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void buffer3f(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value1,
        @NativeType("ALfloat") float value2,
        @NativeType("ALfloat") float value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBuffer3f);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferfv(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferfv);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferi(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferi);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void buffer3i(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value1,
        @NativeType("ALint") int value2,
        @NativeType("ALint") int value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBuffer3i);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferiv(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferiv);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferf(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferf);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBuffer3f(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value1,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value2,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBuffer3f);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferfv(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferfv);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferi(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferi);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBuffer3i(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value1,
        @Nullable @Pointer(comment="ALint") IntPtr value2,
        @Nullable @Pointer(comment="ALint") IntPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBuffer3i);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferiv(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferiv);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void speedOfSound(
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSpeedOfSound);
        try {
            hFunction.invokeExact(
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferDataStatic(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @Pointer(comment="void*") @NotNull MemorySegment data,
        @NativeType("ALsizei") int size,
        @NativeType("ALsizei") int freq
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferDataStatic);
        try {
            hFunction.invokeExact(
                buffer,
                format,
                data,
                size,
                freq
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferSubDataSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @Pointer(comment="void*") @NotNull MemorySegment data,
        @NativeType("ALsizei") int offset,
        @NativeType("ALsizei") int length
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferSubDataSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                format,
                data,
                offset,
                length
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void requestFoldbackStart(
        @NativeType("ALenum") int mode,
        @NativeType("ALsizei") int count,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALfloat") FloatPtr mem,
        @Pointer(comment="LPALFOLDBACKCALLBACK") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alRequestFoldbackStart);
        try {
            hFunction.invokeExact(
                mode,
                count,
                length,
                (MemorySegment) (mem != null ? mem.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void requestFoldbackStart(
        Arena arena,
        @NativeType("ALenum") int mode,
        @NativeType("ALsizei") int count,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALfloat") FloatPtr mem,
        ILPALFOLDBACKCALLBACK callback
    ) {
        requestFoldbackStart(
            mode,
            count,
            length,
            mem,
            ILPALFOLDBACKCALLBACK.ofNative(arena, callback)
        );
    }

    public void requestFoldbackStart(
        @NativeType("ALenum") int mode,
        @NativeType("ALsizei") int count,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALfloat") FloatPtr mem,
        ILPALFOLDBACKCALLBACK callback
    ) {
        requestFoldbackStart(
            Arena.global(),
            mode,
            count,
            length,
            mem,
            callback
        );
    }

    public void requestFoldbackStop() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alRequestFoldbackStop);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferSamplesSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALuint") int samplerate,
        @NativeType("ALenum") int internalformat,
        @NativeType("ALsizei") int samples,
        @NativeType("ALenum") int channels,
        @NativeType("ALenum") int type,
        @Pointer(comment="void*") @NotNull MemorySegment data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferSamplesSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                samplerate,
                internalformat,
                samples,
                channels,
                type,
                data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferSubSamplesSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALsizei") int offset,
        @NativeType("ALsizei") int samples,
        @NativeType("ALenum") int channels,
        @NativeType("ALenum") int type,
        @Pointer(comment="void*") @NotNull MemorySegment data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferSubSamplesSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                offset,
                samples,
                channels,
                type,
                data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferSamplesSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALsizei") int offset,
        @NativeType("ALsizei") int samples,
        @NativeType("ALenum") int channels,
        @NativeType("ALenum") int type,
        @Pointer(comment="void*") @NotNull MemorySegment data
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferSamplesSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                offset,
                samples,
                channels,
                type,
                data
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isBufferFormatSupportedSOFT(
        @NativeType("ALenum") int format
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsBufferFormatSupportedSOFT);
        try {
            return (byte) hFunction.invokeExact(
                format
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcedSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALdouble") double value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcedSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3dSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALdouble") double value1,
        @NativeType("ALdouble") double value2,
        @NativeType("ALdouble") double value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3dSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcedvSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcedvSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcedSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcedSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3dSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value1,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value2,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3dSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcedvSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcedvSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcei64SOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint64SOFT") long value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcei64SOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3i64SOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint64SOFT") long value1,
        @NativeType("ALint64SOFT") long value2,
        @NativeType("ALint64SOFT") long value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3i64SOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcei64vSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcei64vSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcei64SOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcei64SOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3i64SOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value1,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value2,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3i64SOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcei64vSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcei64vSOFT);
        try {
            hFunction.invokeExact(
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deferUpdatesSOFT() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeferUpdatesSOFT);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void processUpdatesSOFT() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alProcessUpdatesSOFT);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable @Pointer(comment="ALchar") BytePtr getStringiSOFT(
        @NativeType("ALenum") int pname,
        @NativeType("ALsizei") int index
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetStringiSOFT);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                pname,
                index
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void eventControlSOFT(
        @NativeType("ALsizei") int count,
        @Nullable @Pointer(comment="ALenum") IntPtr types,
        @NativeType("ALboolean") byte enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEventControlSOFT);
        try {
            hFunction.invokeExact(
                count,
                (MemorySegment) (types != null ? types.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void eventCallbackSOFT(
        @Pointer(comment="ALEVENTPROCSOFT") @NotNull MemorySegment callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEventCallbackSOFT);
        try {
            hFunction.invokeExact(
                callback,
                userParam
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void eventCallbackSOFT(
        Arena arena,
        IALEVENTPROCSOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        eventCallbackSOFT(
            IALEVENTPROCSOFT.ofNative(arena, callback),
            userParam
        );
    }

    public void eventCallbackSOFT(
        IALEVENTPROCSOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        eventCallbackSOFT(
            Arena.global(),
            callback,
            userParam
        );
    }

    public @Pointer(comment="void*") @NotNull MemorySegment getPointerSOFT(
        @NativeType("ALenum") int pname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointerSOFT);
        try {
            return (MemorySegment) hFunction.invokeExact(
                pname
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getPointervSOFT(
        @NativeType("ALenum") int pname,
        @Nullable PointerPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointervSOFT);
        try {
            hFunction.invokeExact(
                pname,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferCallbackSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @NativeType("ALsizei") int freq,
        @Pointer(comment="ALBUFFERCALLBACKTYPESOFT") @NotNull MemorySegment callback,
        @Pointer(comment="void*") @NotNull MemorySegment userptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferCallbackSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                format,
                freq,
                callback,
                userptr
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferCallbackSOFT(
        Arena arena,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @NativeType("ALsizei") int freq,
        IALBUFFERCALLBACKTYPESOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userptr
    ) {
        bufferCallbackSOFT(
            buffer,
            format,
            freq,
            IALBUFFERCALLBACKTYPESOFT.ofNative(arena, callback),
            userptr
        );
    }

    public void bufferCallbackSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @NativeType("ALsizei") int freq,
        IALBUFFERCALLBACKTYPESOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userptr
    ) {
        bufferCallbackSOFT(
            Arena.global(),
            buffer,
            format,
            freq,
            callback,
            userptr
        );
    }

    public void getBufferPtrSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable PointerPtr ptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferPtrSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (ptr != null ? ptr.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBuffer3PtrSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable PointerPtr ptr0,
        @Nullable PointerPtr ptr1,
        @Nullable PointerPtr ptr2
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBuffer3PtrSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (ptr0 != null ? ptr0.segment() : MemorySegment.NULL),
                (MemorySegment) (ptr1 != null ? ptr1.segment() : MemorySegment.NULL),
                (MemorySegment) (ptr2 != null ? ptr2.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferPtrvSOFT(
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable PointerPtr ptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferPtrvSOFT);
        try {
            hFunction.invokeExact(
                buffer,
                param,
                (MemorySegment) (ptr != null ? ptr.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePlayAtTimeSOFT(
        @NativeType("ALuint") int source,
        @NativeType("ALint64SOFT") long start_time
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlayAtTimeSOFT);
        try {
            hFunction.invokeExact(
                source,
                start_time
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePlayAtTimevSOFT(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources,
        @NativeType("ALint64SOFT") long start_time
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlayAtTimevSOFT);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL),
                start_time
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void debugMessageCallbackEXT(
        @Pointer(comment="ALDEBUGPROCEXT") @NotNull MemorySegment callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDebugMessageCallbackEXT);
        try {
            hFunction.invokeExact(
                callback,
                userParam
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void debugMessageCallbackEXT(
        Arena arena,
        IALDEBUGPROCEXT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        debugMessageCallbackEXT(
            IALDEBUGPROCEXT.ofNative(arena, callback),
            userParam
        );
    }

    public void debugMessageCallbackEXT(
        IALDEBUGPROCEXT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        debugMessageCallbackEXT(
            Arena.global(),
            callback,
            userParam
        );
    }

    public void debugMessageInsertEXT(
        @NativeType("ALenum") int source,
        @NativeType("ALenum") int type,
        @NativeType("ALuint") int id,
        @NativeType("ALenum") int severity,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALchar") BytePtr message
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDebugMessageInsertEXT);
        try {
            hFunction.invokeExact(
                source,
                type,
                id,
                severity,
                length,
                (MemorySegment) (message != null ? message.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void debugMessageControlEXT(
        @NativeType("ALenum") int source,
        @NativeType("ALenum") int type,
        @NativeType("ALenum") int severity,
        @NativeType("ALsizei") int count,
        @Nullable @Pointer(comment="ALuint") IntPtr ids,
        @NativeType("ALboolean") byte enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDebugMessageControlEXT);
        try {
            hFunction.invokeExact(
                source,
                type,
                severity,
                count,
                (MemorySegment) (ids != null ? ids.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void pushDebugGroupEXT(
        @NativeType("ALenum") int source,
        @NativeType("ALuint") int id,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALchar") BytePtr message
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alPushDebugGroupEXT);
        try {
            hFunction.invokeExact(
                source,
                id,
                length,
                (MemorySegment) (message != null ? message.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void popDebugGroupEXT() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alPopDebugGroupEXT);
        try {
            hFunction.invokeExact(
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALuint") int getDebugMessageLogEXT(
        @NativeType("ALuint") int count,
        @NativeType("ALsizei") int logBufSize,
        @Nullable @Pointer(comment="ALenum") IntPtr sources,
        @Nullable @Pointer(comment="ALenum") IntPtr types,
        @Nullable @Pointer(comment="ALuint") IntPtr ids,
        @Nullable @Pointer(comment="ALenum") IntPtr severities,
        @Nullable @Pointer(comment="ALsizei") IntPtr lengths,
        @Nullable @Pointer(comment="ALchar") BytePtr logBuf
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetDebugMessageLogEXT);
        try {
            return (int) hFunction.invokeExact(
                count,
                logBufSize,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL),
                (MemorySegment) (types != null ? types.segment() : MemorySegment.NULL),
                (MemorySegment) (ids != null ? ids.segment() : MemorySegment.NULL),
                (MemorySegment) (severities != null ? severities.segment() : MemorySegment.NULL),
                (MemorySegment) (lengths != null ? lengths.segment() : MemorySegment.NULL),
                (MemorySegment) (logBuf != null ? logBuf.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void objectLabelEXT(
        @NativeType("ALenum") int identifier,
        @NativeType("ALuint") int name,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALchar") BytePtr label
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alObjectLabelEXT);
        try {
            hFunction.invokeExact(
                identifier,
                name,
                length,
                (MemorySegment) (label != null ? label.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getObjectLabelEXT(
        @NativeType("ALenum") int identifier,
        @NativeType("ALuint") int name,
        @NativeType("ALsizei") int bufSize,
        @Nullable @Pointer(comment="ALsizei") IntPtr length,
        @Nullable @Pointer(comment="ALchar") BytePtr label
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetObjectLabelEXT);
        try {
            hFunction.invokeExact(
                identifier,
                name,
                bufSize,
                (MemorySegment) (length != null ? length.segment() : MemorySegment.NULL),
                (MemorySegment) (label != null ? label.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="void*") @NotNull MemorySegment getPointerEXT(
        @NativeType("ALenum") int pname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointerEXT);
        try {
            return (MemorySegment) hFunction.invokeExact(
                pname
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getPointervEXT(
        @NativeType("ALenum") int pname,
        @Nullable PointerPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointervEXT);
        try {
            hFunction.invokeExact(
                pname,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void enableDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int capability
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEnableDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                capability
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void disableDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int capability
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDisableDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                capability
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isEnabledDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int capability
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsEnabledDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                capability
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void dopplerFactorDirect(
        @Nullable ALCcontext context,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDopplerFactorDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void speedOfSoundDirect(
        @Nullable ALCcontext context,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSpeedOfSoundDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void distanceModelDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int distanceModel
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDistanceModelDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                distanceModel
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable @Pointer(comment="ALchar") BytePtr getStringDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetStringDirect);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBooleanvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALboolean") BytePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBooleanvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getIntegervDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetIntegervDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFloatvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFloatvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getDoublevDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetDoublevDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte getBooleanDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBooleanDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALint") int getIntegerDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetIntegerDirect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALfloat") float getFloatDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFloatDirect);
        try {
            return (float) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALdouble") double getDoubleDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetDoubleDirect);
        try {
            return (double) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALenum") int getErrorDirect(
        @Nullable ALCcontext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetErrorDirect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isExtensionPresentDirect(
        @Nullable ALCcontext context,
        @Nullable @Pointer(comment="ALchar") BytePtr extname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsExtensionPresentDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (extname != null ? extname.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="void*") @NotNull MemorySegment getProcAddressDirect(
        @Nullable ALCcontext context,
        @Nullable @Pointer(comment="ALchar") BytePtr fname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetProcAddressDirect);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (fname != null ? fname.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALenum") int getEnumValueDirect(
        @Nullable ALCcontext context,
        @Nullable @Pointer(comment="ALchar") BytePtr ename
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEnumValueDirect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (ename != null ? ename.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listenerfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListenerfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listener3fDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value1,
        @NativeType("ALfloat") float value2,
        @NativeType("ALfloat") float value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListener3fDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listenerfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListenerfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listeneriDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListeneriDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listener3iDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value1,
        @NativeType("ALint") int value2,
        @NativeType("ALint") int value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListener3iDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void listenerivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alListenerivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListenerfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListenerfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListener3fDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value1,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value2,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListener3fDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListenerfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListenerfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListeneriDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListeneriDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListener3iDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value1,
        @Nullable @Pointer(comment="ALint") IntPtr value2,
        @Nullable @Pointer(comment="ALint") IntPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListener3iDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getListenerivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetListenerivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genSourcesDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenSourcesDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSourcesDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteSourcesDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isSourceDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsSourceDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcefDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcefDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3fDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value1,
        @NativeType("ALfloat") float value2,
        @NativeType("ALfloat") float value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3fDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcefvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcefvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3iDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value1,
        @NativeType("ALint") int value2,
        @NativeType("ALint") int value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3iDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcefDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcefDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3fDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value1,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value2,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3fDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcefvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcefvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourceiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourceiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3iDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value1,
        @Nullable @Pointer(comment="ALint") IntPtr value2,
        @Nullable @Pointer(comment="ALint") IntPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3iDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourceivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourceivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePlayDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlayDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceStopDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceStopDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceRewindDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceRewindDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePauseDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePauseDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePlayvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlayvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceStopvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceStopvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceRewindvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceRewindvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePausevDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePausevDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceQueueBuffersDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALsizei") int nb,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceQueueBuffersDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                nb,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourceUnqueueBuffersDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALsizei") int nb,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourceUnqueueBuffersDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                nb,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genBuffersDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenBuffersDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBuffersDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteBuffersDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isBufferDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsBufferDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferDataDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @Pointer(comment="void*") @NotNull MemorySegment data,
        @NativeType("ALsizei") int size,
        @NativeType("ALsizei") int samplerate
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferDataDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                format,
                data,
                size,
                samplerate
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void buffer3fDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float value1,
        @NativeType("ALfloat") float value2,
        @NativeType("ALfloat") float value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBuffer3fDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void buffer3iDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int value1,
        @NativeType("ALint") int value2,
        @NativeType("ALint") int value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBuffer3iDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBuffer3fDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value1,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value2,
        @Nullable @Pointer(comment="ALfloat") FloatPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBuffer3fDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBuffer3iDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr value1,
        @Nullable @Pointer(comment="ALint") IntPtr value2,
        @Nullable @Pointer(comment="ALint") IntPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBuffer3iDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genEffectsDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effects
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenEffectsDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (effects != null ? effects.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEffectsDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effects
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteEffectsDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (effects != null ? effects.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isEffectDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsEffectDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effectiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffectiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                iValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effectivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffectivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effectfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffectfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                flValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effectfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffectfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffectiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffectiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                (MemorySegment) (piValue != null ? piValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffectivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffectivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffectfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffectfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                (MemorySegment) (pflValue != null ? pflValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffectfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffectfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effect,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genFiltersDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr filters
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenFiltersDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (filters != null ? filters.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFiltersDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr filters
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteFiltersDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (filters != null ? filters.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isFilterDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsFilterDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filteriDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilteriDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                iValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filterivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilterivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filterfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilterfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                flValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filterfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilterfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilteriDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilteriDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                (MemorySegment) (piValue != null ? piValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilterivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilterivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilterfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilterfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                (MemorySegment) (pflValue != null ? pflValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilterfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilterfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                filter,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genAuxiliaryEffectSlotsDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effectslots
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenAuxiliaryEffectSlotsDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (effectslots != null ? effectslots.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAuxiliaryEffectSlotsDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effectslots
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteAuxiliaryEffectSlotsDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (effectslots != null ? effectslots.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isAuxiliaryEffectSlotDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsAuxiliaryEffectSlotDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSlotiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSlotiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                iValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSlotivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSlotivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSlotfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSlotfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                flValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSlotfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSlotfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSlotiDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSlotiDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                (MemorySegment) (piValue != null ? piValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSlotivDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSlotivDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSlotfDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSlotfDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                (MemorySegment) (pflValue != null ? pflValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSlotfvDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSlotfvDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                effectslot,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferDataStaticDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @Pointer(comment="void*") @NotNull MemorySegment data,
        @NativeType("ALsizei") int size,
        @NativeType("ALsizei") int freq
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferDataStaticDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                format,
                data,
                size,
                freq
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void debugMessageCallbackDirectEXT(
        @Nullable ALCcontext context,
        @Pointer(comment="ALDEBUGPROCEXT") @NotNull MemorySegment callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDebugMessageCallbackDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                callback,
                userParam
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void debugMessageCallbackDirectEXT(
        Arena arena,
        @Nullable ALCcontext context,
        IALDEBUGPROCEXT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        debugMessageCallbackDirectEXT(
            context,
            IALDEBUGPROCEXT.ofNative(arena, callback),
            userParam
        );
    }

    public void debugMessageCallbackDirectEXT(
        @Nullable ALCcontext context,
        IALDEBUGPROCEXT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        debugMessageCallbackDirectEXT(
            Arena.global(),
            context,
            callback,
            userParam
        );
    }

    public void debugMessageInsertDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int source,
        @NativeType("ALenum") int type,
        @NativeType("ALuint") int id,
        @NativeType("ALenum") int severity,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALchar") BytePtr message
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDebugMessageInsertDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                type,
                id,
                severity,
                length,
                (MemorySegment) (message != null ? message.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void debugMessageControlDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int source,
        @NativeType("ALenum") int type,
        @NativeType("ALenum") int severity,
        @NativeType("ALsizei") int count,
        @Nullable @Pointer(comment="ALuint") IntPtr ids,
        @NativeType("ALboolean") byte enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDebugMessageControlDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                type,
                severity,
                count,
                (MemorySegment) (ids != null ? ids.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void pushDebugGroupDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int source,
        @NativeType("ALuint") int id,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALchar") BytePtr message
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alPushDebugGroupDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                id,
                length,
                (MemorySegment) (message != null ? message.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void popDebugGroupDirectEXT(
        @Nullable ALCcontext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alPopDebugGroupDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALuint") int getDebugMessageLogDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int count,
        @NativeType("ALsizei") int logBufSize,
        @Nullable @Pointer(comment="ALenum") IntPtr sources,
        @Nullable @Pointer(comment="ALenum") IntPtr types,
        @Nullable @Pointer(comment="ALuint") IntPtr ids,
        @Nullable @Pointer(comment="ALenum") IntPtr severities,
        @Nullable @Pointer(comment="ALsizei") IntPtr lengths,
        @Nullable @Pointer(comment="ALchar") BytePtr logBuf
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetDebugMessageLogDirectEXT);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                count,
                logBufSize,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL),
                (MemorySegment) (types != null ? types.segment() : MemorySegment.NULL),
                (MemorySegment) (ids != null ? ids.segment() : MemorySegment.NULL),
                (MemorySegment) (severities != null ? severities.segment() : MemorySegment.NULL),
                (MemorySegment) (lengths != null ? lengths.segment() : MemorySegment.NULL),
                (MemorySegment) (logBuf != null ? logBuf.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void objectLabelDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int identifier,
        @NativeType("ALuint") int name,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALchar") BytePtr label
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alObjectLabelDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                identifier,
                name,
                length,
                (MemorySegment) (label != null ? label.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getObjectLabelDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int identifier,
        @NativeType("ALuint") int name,
        @NativeType("ALsizei") int bufSize,
        @Nullable @Pointer(comment="ALsizei") IntPtr length,
        @Nullable @Pointer(comment="ALchar") BytePtr label
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetObjectLabelDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                identifier,
                name,
                bufSize,
                (MemorySegment) (length != null ? length.segment() : MemorySegment.NULL),
                (MemorySegment) (label != null ? label.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Pointer(comment="void*") @NotNull MemorySegment getPointerDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int pname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointerDirectEXT);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                pname
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getPointervDirectEXT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int pname,
        @Nullable PointerPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointervDirectEXT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                pname,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void requestFoldbackStartDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int mode,
        @NativeType("ALsizei") int count,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALfloat") FloatPtr mem,
        @Pointer(comment="LPALFOLDBACKCALLBACK") @NotNull MemorySegment callback
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alRequestFoldbackStartDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                mode,
                count,
                length,
                (MemorySegment) (mem != null ? mem.segment() : MemorySegment.NULL),
                callback
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void requestFoldbackStartDirect(
        Arena arena,
        @Nullable ALCcontext context,
        @NativeType("ALenum") int mode,
        @NativeType("ALsizei") int count,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALfloat") FloatPtr mem,
        ILPALFOLDBACKCALLBACK callback
    ) {
        requestFoldbackStartDirect(
            context,
            mode,
            count,
            length,
            mem,
            ILPALFOLDBACKCALLBACK.ofNative(arena, callback)
        );
    }

    public void requestFoldbackStartDirect(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int mode,
        @NativeType("ALsizei") int count,
        @NativeType("ALsizei") int length,
        @Nullable @Pointer(comment="ALfloat") FloatPtr mem,
        ILPALFOLDBACKCALLBACK callback
    ) {
        requestFoldbackStartDirect(
            Arena.global(),
            context,
            mode,
            count,
            length,
            mem,
            callback
        );
    }

    public void requestFoldbackStopDirect(
        @Nullable ALCcontext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alRequestFoldbackStopDirect);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferSubDataDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @Pointer(comment="void*") @NotNull MemorySegment data,
        @NativeType("ALsizei") int offset,
        @NativeType("ALsizei") int length
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferSubDataDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                format,
                data,
                offset,
                length
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcedDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALdouble") double value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcedDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3dDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALdouble") double value1,
        @NativeType("ALdouble") double value2,
        @NativeType("ALdouble") double value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3dDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcedvDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcedvDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcedDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcedDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3dDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value1,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value2,
        @Nullable @Pointer(comment="ALdouble") DoublePtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3dDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcedvDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALdouble") DoublePtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcedvDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcei64DirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint64SOFT") long value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcei64DirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void source3i64DirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @NativeType("ALint64SOFT") long value1,
        @NativeType("ALint64SOFT") long value2,
        @NativeType("ALint64SOFT") long value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSource3i64DirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                value1,
                value2,
                value3
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcei64vDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcei64vDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcei64DirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcei64DirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSource3i64DirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value1,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value2,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr value3
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSource3i64DirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (value1 != null ? value1.segment() : MemorySegment.NULL),
                (MemorySegment) (value2 != null ? value2.segment() : MemorySegment.NULL),
                (MemorySegment) (value3 != null ? value3.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSourcei64vDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint64SOFT") LongPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetSourcei64vDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                param,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deferUpdatesDirectSOFT(
        @Nullable ALCcontext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeferUpdatesDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void processUpdatesDirectSOFT(
        @Nullable ALCcontext context
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alProcessUpdatesDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable @Pointer(comment="ALchar") BytePtr getStringiDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int pname,
        @NativeType("ALsizei") int index
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetStringiDirectSOFT);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                pname,
                index
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void eventControlDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int count,
        @Nullable @Pointer(comment="ALenum") IntPtr types,
        @NativeType("ALboolean") byte enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEventControlDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                count,
                (MemorySegment) (types != null ? types.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void eventCallbackDirectSOFT(
        @Nullable ALCcontext context,
        @Pointer(comment="ALEVENTPROCSOFT") @NotNull MemorySegment callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEventCallbackDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                callback,
                userParam
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void eventCallbackDirectSOFT(
        Arena arena,
        @Nullable ALCcontext context,
        IALEVENTPROCSOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        eventCallbackDirectSOFT(
            context,
            IALEVENTPROCSOFT.ofNative(arena, callback),
            userParam
        );
    }

    public void eventCallbackDirectSOFT(
        @Nullable ALCcontext context,
        IALEVENTPROCSOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userParam
    ) {
        eventCallbackDirectSOFT(
            Arena.global(),
            context,
            callback,
            userParam
        );
    }

    public @Pointer(comment="void*") @NotNull MemorySegment getPointerDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int pname
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointerDirectSOFT);
        try {
            return (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                pname
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getPointervDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALenum") int pname,
        @Nullable PointerPtr values
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetPointervDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                pname,
                (MemorySegment) (values != null ? values.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferCallbackDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @NativeType("ALsizei") int freq,
        @Pointer(comment="ALBUFFERCALLBACKTYPESOFT") @NotNull MemorySegment callback,
        @Pointer(comment="void*") @NotNull MemorySegment userptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alBufferCallbackDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                format,
                freq,
                callback,
                userptr
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void bufferCallbackDirectSOFT(
        Arena arena,
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @NativeType("ALsizei") int freq,
        IALBUFFERCALLBACKTYPESOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userptr
    ) {
        bufferCallbackDirectSOFT(
            context,
            buffer,
            format,
            freq,
            IALBUFFERCALLBACKTYPESOFT.ofNative(arena, callback),
            userptr
        );
    }

    public void bufferCallbackDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int format,
        @NativeType("ALsizei") int freq,
        IALBUFFERCALLBACKTYPESOFT callback,
        @Pointer(comment="void*") @NotNull MemorySegment userptr
    ) {
        bufferCallbackDirectSOFT(
            Arena.global(),
            context,
            buffer,
            format,
            freq,
            callback,
            userptr
        );
    }

    public void getBufferPtrDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable PointerPtr ptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferPtrDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (ptr != null ? ptr.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBuffer3PtrDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable PointerPtr ptr0,
        @Nullable PointerPtr ptr1,
        @Nullable PointerPtr ptr2
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBuffer3PtrDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (ptr0 != null ? ptr0.segment() : MemorySegment.NULL),
                (MemorySegment) (ptr1 != null ? ptr1.segment() : MemorySegment.NULL),
                (MemorySegment) (ptr2 != null ? ptr2.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getBufferPtrvDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @NativeType("ALenum") int param,
        @Nullable PointerPtr ptr
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetBufferPtrvDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                param,
                (MemorySegment) (ptr != null ? ptr.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePlayAtTimeDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int source,
        @NativeType("ALint64SOFT") long start_time
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlayAtTimeDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                source,
                start_time
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void sourcePlayAtTimevDirectSOFT(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr sources,
        @NativeType("ALint64SOFT") long start_time
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alSourcePlayAtTimevDirectSOFT);
        try {
            hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (sources != null ? sources.segment() : MemorySegment.NULL),
                start_time
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALenum") int EAXSetDirect(
        @Nullable ALCcontext context,
        @Nullable _GUID property_set_id,
        @NativeType("ALuint") int property_id,
        @NativeType("ALuint") int source_id,
        @Pointer(comment="void*") @NotNull MemorySegment value,
        @NativeType("ALuint") int value_size
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$EAXSetDirect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (property_set_id != null ? property_set_id.segment() : MemorySegment.NULL),
                property_id,
                source_id,
                value,
                value_size
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALenum") int EAXGetDirect(
        @Nullable ALCcontext context,
        @Nullable _GUID property_set_id,
        @NativeType("ALuint") int property_id,
        @NativeType("ALuint") int source_id,
        @Pointer(comment="void*") @NotNull MemorySegment value,
        @NativeType("ALuint") int value_size
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$EAXGetDirect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                (MemorySegment) (property_set_id != null ? property_set_id.segment() : MemorySegment.NULL),
                property_id,
                source_id,
                value,
                value_size
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte EAXSetBufferModeDirect(
        @Nullable ALCcontext context,
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr buffers,
        @NativeType("ALint") int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$EAXSetBufferModeDirect);
        try {
            return (byte) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                n,
                (MemorySegment) (buffers != null ? buffers.segment() : MemorySegment.NULL),
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALenum") int EAXGetBufferModeDirect(
        @Nullable ALCcontext context,
        @NativeType("ALuint") int buffer,
        @Nullable @Pointer(comment="ALint") IntPtr pReserved
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$EAXGetBufferModeDirect);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (context != null ? context.segment() : MemorySegment.NULL),
                buffer,
                (MemorySegment) (pReserved != null ? pReserved.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genEffects(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effects
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenEffects);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (effects != null ? effects.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEffects(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effects
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteEffects);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (effects != null ? effects.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isEffect(
        @NativeType("ALuint") int effect
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsEffect);
        try {
            return (byte) hFunction.invokeExact(
                effect
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effecti(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffecti);
        try {
            hFunction.invokeExact(
                effect,
                param,
                iValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effectiv(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffectiv);
        try {
            hFunction.invokeExact(
                effect,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effectf(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffectf);
        try {
            hFunction.invokeExact(
                effect,
                param,
                flValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void effectfv(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alEffectfv);
        try {
            hFunction.invokeExact(
                effect,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffecti(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffecti);
        try {
            hFunction.invokeExact(
                effect,
                param,
                (MemorySegment) (iValue != null ? iValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffectiv(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffectiv);
        try {
            hFunction.invokeExact(
                effect,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffectf(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffectf);
        try {
            hFunction.invokeExact(
                effect,
                param,
                (MemorySegment) (flValue != null ? flValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getEffectfv(
        @NativeType("ALuint") int effect,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetEffectfv);
        try {
            hFunction.invokeExact(
                effect,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genFilters(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr filters
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenFilters);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (filters != null ? filters.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFilters(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr filters
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteFilters);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (filters != null ? filters.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isFilter(
        @NativeType("ALuint") int filter
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsFilter);
        try {
            return (byte) hFunction.invokeExact(
                filter
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filteri(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilteri);
        try {
            hFunction.invokeExact(
                filter,
                param,
                iValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filteriv(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilteriv);
        try {
            hFunction.invokeExact(
                filter,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filterf(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilterf);
        try {
            hFunction.invokeExact(
                filter,
                param,
                flValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void filterfv(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alFilterfv);
        try {
            hFunction.invokeExact(
                filter,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilteri(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilteri);
        try {
            hFunction.invokeExact(
                filter,
                param,
                (MemorySegment) (iValue != null ? iValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilteriv(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilteriv);
        try {
            hFunction.invokeExact(
                filter,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilterf(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilterf);
        try {
            hFunction.invokeExact(
                filter,
                param,
                (MemorySegment) (flValue != null ? flValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getFilterfv(
        @NativeType("ALuint") int filter,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetFilterfv);
        try {
            hFunction.invokeExact(
                filter,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void genAuxiliaryEffectSlots(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effectslots
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGenAuxiliaryEffectSlots);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (effectslots != null ? effectslots.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAuxiliaryEffectSlots(
        @NativeType("ALsizei") int n,
        @Nullable @Pointer(comment="ALuint") IntPtr effectslots
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alDeleteAuxiliaryEffectSlots);
        try {
            hFunction.invokeExact(
                n,
                (MemorySegment) (effectslots != null ? effectslots.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("ALboolean") byte isAuxiliaryEffectSlot(
        @NativeType("ALuint") int effectslot
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alIsAuxiliaryEffectSlot);
        try {
            return (byte) hFunction.invokeExact(
                effectslot
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSloti(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @NativeType("ALint") int iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSloti);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                iValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSlotiv(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSlotiv);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSlotf(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @NativeType("ALfloat") float flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSlotf);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                flValue
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void auxiliaryEffectSlotfv(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alAuxiliaryEffectSlotfv);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSloti(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr iValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSloti);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                (MemorySegment) (iValue != null ? iValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSlotiv(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALint") IntPtr piValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSlotiv);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                (MemorySegment) (piValues != null ? piValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSlotf(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr flValue
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSlotf);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                (MemorySegment) (flValue != null ? flValue.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getAuxiliaryEffectSlotfv(
        @NativeType("ALuint") int effectslot,
        @NativeType("ALenum") int param,
        @Nullable @Pointer(comment="ALfloat") FloatPtr pflValues
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$alGetAuxiliaryEffectSlotfv);
        try {
            hFunction.invokeExact(
                effectslot,
                param,
                (MemorySegment) (pflValues != null ? pflValues.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$alEnable;
    public final @Nullable MemorySegment SEGMENT$alDisable;
    public final @Nullable MemorySegment SEGMENT$alIsEnabled;
    public final @Nullable MemorySegment SEGMENT$alDopplerFactor;
    public final @Nullable MemorySegment SEGMENT$alDopplerVelocity;
    public final @Nullable MemorySegment SEGMENT$alDistanceModel;
    public final @Nullable MemorySegment SEGMENT$alGetString;
    public final @Nullable MemorySegment SEGMENT$alGetBooleanv;
    public final @Nullable MemorySegment SEGMENT$alGetIntegerv;
    public final @Nullable MemorySegment SEGMENT$alGetFloatv;
    public final @Nullable MemorySegment SEGMENT$alGetDoublev;
    public final @Nullable MemorySegment SEGMENT$alGetBoolean;
    public final @Nullable MemorySegment SEGMENT$alGetInteger;
    public final @Nullable MemorySegment SEGMENT$alGetFloat;
    public final @Nullable MemorySegment SEGMENT$alGetDouble;
    public final @Nullable MemorySegment SEGMENT$alGetError;
    public final @Nullable MemorySegment SEGMENT$alIsExtensionPresent;
    public final @Nullable MemorySegment SEGMENT$alGetProcAddress;
    public final @Nullable MemorySegment SEGMENT$alGetEnumValue;
    public final @Nullable MemorySegment SEGMENT$alListenerf;
    public final @Nullable MemorySegment SEGMENT$alListener3f;
    public final @Nullable MemorySegment SEGMENT$alListenerfv;
    public final @Nullable MemorySegment SEGMENT$alListeneri;
    public final @Nullable MemorySegment SEGMENT$alListener3i;
    public final @Nullable MemorySegment SEGMENT$alListeneriv;
    public final @Nullable MemorySegment SEGMENT$alGetListenerf;
    public final @Nullable MemorySegment SEGMENT$alGetListener3f;
    public final @Nullable MemorySegment SEGMENT$alGetListenerfv;
    public final @Nullable MemorySegment SEGMENT$alGetListeneri;
    public final @Nullable MemorySegment SEGMENT$alGetListener3i;
    public final @Nullable MemorySegment SEGMENT$alGetListeneriv;
    public final @Nullable MemorySegment SEGMENT$alGenSources;
    public final @Nullable MemorySegment SEGMENT$alDeleteSources;
    public final @Nullable MemorySegment SEGMENT$alIsSource;
    public final @Nullable MemorySegment SEGMENT$alSourcef;
    public final @Nullable MemorySegment SEGMENT$alSource3f;
    public final @Nullable MemorySegment SEGMENT$alSourcefv;
    public final @Nullable MemorySegment SEGMENT$alSourcei;
    public final @Nullable MemorySegment SEGMENT$alSource3i;
    public final @Nullable MemorySegment SEGMENT$alSourceiv;
    public final @Nullable MemorySegment SEGMENT$alGetSourcef;
    public final @Nullable MemorySegment SEGMENT$alGetSource3f;
    public final @Nullable MemorySegment SEGMENT$alGetSourcefv;
    public final @Nullable MemorySegment SEGMENT$alGetSourcei;
    public final @Nullable MemorySegment SEGMENT$alGetSource3i;
    public final @Nullable MemorySegment SEGMENT$alGetSourceiv;
    public final @Nullable MemorySegment SEGMENT$alSourcePlay;
    public final @Nullable MemorySegment SEGMENT$alSourceStop;
    public final @Nullable MemorySegment SEGMENT$alSourceRewind;
    public final @Nullable MemorySegment SEGMENT$alSourcePause;
    public final @Nullable MemorySegment SEGMENT$alSourcePlayv;
    public final @Nullable MemorySegment SEGMENT$alSourceStopv;
    public final @Nullable MemorySegment SEGMENT$alSourceRewindv;
    public final @Nullable MemorySegment SEGMENT$alSourcePausev;
    public final @Nullable MemorySegment SEGMENT$alSourceQueueBuffers;
    public final @Nullable MemorySegment SEGMENT$alSourceUnqueueBuffers;
    public final @Nullable MemorySegment SEGMENT$alGenBuffers;
    public final @Nullable MemorySegment SEGMENT$alDeleteBuffers;
    public final @Nullable MemorySegment SEGMENT$alIsBuffer;
    public final @Nullable MemorySegment SEGMENT$alBufferData;
    public final @Nullable MemorySegment SEGMENT$alBufferf;
    public final @Nullable MemorySegment SEGMENT$alBuffer3f;
    public final @Nullable MemorySegment SEGMENT$alBufferfv;
    public final @Nullable MemorySegment SEGMENT$alBufferi;
    public final @Nullable MemorySegment SEGMENT$alBuffer3i;
    public final @Nullable MemorySegment SEGMENT$alBufferiv;
    public final @Nullable MemorySegment SEGMENT$alGetBufferf;
    public final @Nullable MemorySegment SEGMENT$alGetBuffer3f;
    public final @Nullable MemorySegment SEGMENT$alGetBufferfv;
    public final @Nullable MemorySegment SEGMENT$alGetBufferi;
    public final @Nullable MemorySegment SEGMENT$alGetBuffer3i;
    public final @Nullable MemorySegment SEGMENT$alGetBufferiv;
    public final @Nullable MemorySegment SEGMENT$alSpeedOfSound;
    public final @Nullable MemorySegment SEGMENT$alBufferDataStatic;
    public final @Nullable MemorySegment SEGMENT$alBufferSubDataSOFT;
    public final @Nullable MemorySegment SEGMENT$alRequestFoldbackStart;
    public final @Nullable MemorySegment SEGMENT$alRequestFoldbackStop;
    public final @Nullable MemorySegment SEGMENT$alBufferSamplesSOFT;
    public final @Nullable MemorySegment SEGMENT$alBufferSubSamplesSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetBufferSamplesSOFT;
    public final @Nullable MemorySegment SEGMENT$alIsBufferFormatSupportedSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcedSOFT;
    public final @Nullable MemorySegment SEGMENT$alSource3dSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcedvSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcedSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSource3dSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcedvSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcei64SOFT;
    public final @Nullable MemorySegment SEGMENT$alSource3i64SOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcei64vSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcei64SOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSource3i64SOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcei64vSOFT;
    public final @Nullable MemorySegment SEGMENT$alDeferUpdatesSOFT;
    public final @Nullable MemorySegment SEGMENT$alProcessUpdatesSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetStringiSOFT;
    public final @Nullable MemorySegment SEGMENT$alEventControlSOFT;
    public final @Nullable MemorySegment SEGMENT$alEventCallbackSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetPointerSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetPointervSOFT;
    public final @Nullable MemorySegment SEGMENT$alBufferCallbackSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetBufferPtrSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetBuffer3PtrSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetBufferPtrvSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcePlayAtTimeSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcePlayAtTimevSOFT;
    public final @Nullable MemorySegment SEGMENT$alDebugMessageCallbackEXT;
    public final @Nullable MemorySegment SEGMENT$alDebugMessageInsertEXT;
    public final @Nullable MemorySegment SEGMENT$alDebugMessageControlEXT;
    public final @Nullable MemorySegment SEGMENT$alPushDebugGroupEXT;
    public final @Nullable MemorySegment SEGMENT$alPopDebugGroupEXT;
    public final @Nullable MemorySegment SEGMENT$alGetDebugMessageLogEXT;
    public final @Nullable MemorySegment SEGMENT$alObjectLabelEXT;
    public final @Nullable MemorySegment SEGMENT$alGetObjectLabelEXT;
    public final @Nullable MemorySegment SEGMENT$alGetPointerEXT;
    public final @Nullable MemorySegment SEGMENT$alGetPointervEXT;
    public final @Nullable MemorySegment SEGMENT$alEnableDirect;
    public final @Nullable MemorySegment SEGMENT$alDisableDirect;
    public final @Nullable MemorySegment SEGMENT$alIsEnabledDirect;
    public final @Nullable MemorySegment SEGMENT$alDopplerFactorDirect;
    public final @Nullable MemorySegment SEGMENT$alSpeedOfSoundDirect;
    public final @Nullable MemorySegment SEGMENT$alDistanceModelDirect;
    public final @Nullable MemorySegment SEGMENT$alGetStringDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBooleanvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetIntegervDirect;
    public final @Nullable MemorySegment SEGMENT$alGetFloatvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetDoublevDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBooleanDirect;
    public final @Nullable MemorySegment SEGMENT$alGetIntegerDirect;
    public final @Nullable MemorySegment SEGMENT$alGetFloatDirect;
    public final @Nullable MemorySegment SEGMENT$alGetDoubleDirect;
    public final @Nullable MemorySegment SEGMENT$alGetErrorDirect;
    public final @Nullable MemorySegment SEGMENT$alIsExtensionPresentDirect;
    public final @Nullable MemorySegment SEGMENT$alGetProcAddressDirect;
    public final @Nullable MemorySegment SEGMENT$alGetEnumValueDirect;
    public final @Nullable MemorySegment SEGMENT$alListenerfDirect;
    public final @Nullable MemorySegment SEGMENT$alListener3fDirect;
    public final @Nullable MemorySegment SEGMENT$alListenerfvDirect;
    public final @Nullable MemorySegment SEGMENT$alListeneriDirect;
    public final @Nullable MemorySegment SEGMENT$alListener3iDirect;
    public final @Nullable MemorySegment SEGMENT$alListenerivDirect;
    public final @Nullable MemorySegment SEGMENT$alGetListenerfDirect;
    public final @Nullable MemorySegment SEGMENT$alGetListener3fDirect;
    public final @Nullable MemorySegment SEGMENT$alGetListenerfvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetListeneriDirect;
    public final @Nullable MemorySegment SEGMENT$alGetListener3iDirect;
    public final @Nullable MemorySegment SEGMENT$alGetListenerivDirect;
    public final @Nullable MemorySegment SEGMENT$alGenSourcesDirect;
    public final @Nullable MemorySegment SEGMENT$alDeleteSourcesDirect;
    public final @Nullable MemorySegment SEGMENT$alIsSourceDirect;
    public final @Nullable MemorySegment SEGMENT$alSourcefDirect;
    public final @Nullable MemorySegment SEGMENT$alSource3fDirect;
    public final @Nullable MemorySegment SEGMENT$alSourcefvDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceiDirect;
    public final @Nullable MemorySegment SEGMENT$alSource3iDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceivDirect;
    public final @Nullable MemorySegment SEGMENT$alGetSourcefDirect;
    public final @Nullable MemorySegment SEGMENT$alGetSource3fDirect;
    public final @Nullable MemorySegment SEGMENT$alGetSourcefvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetSourceiDirect;
    public final @Nullable MemorySegment SEGMENT$alGetSource3iDirect;
    public final @Nullable MemorySegment SEGMENT$alGetSourceivDirect;
    public final @Nullable MemorySegment SEGMENT$alSourcePlayDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceStopDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceRewindDirect;
    public final @Nullable MemorySegment SEGMENT$alSourcePauseDirect;
    public final @Nullable MemorySegment SEGMENT$alSourcePlayvDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceStopvDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceRewindvDirect;
    public final @Nullable MemorySegment SEGMENT$alSourcePausevDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceQueueBuffersDirect;
    public final @Nullable MemorySegment SEGMENT$alSourceUnqueueBuffersDirect;
    public final @Nullable MemorySegment SEGMENT$alGenBuffersDirect;
    public final @Nullable MemorySegment SEGMENT$alDeleteBuffersDirect;
    public final @Nullable MemorySegment SEGMENT$alIsBufferDirect;
    public final @Nullable MemorySegment SEGMENT$alBufferDataDirect;
    public final @Nullable MemorySegment SEGMENT$alBufferfDirect;
    public final @Nullable MemorySegment SEGMENT$alBuffer3fDirect;
    public final @Nullable MemorySegment SEGMENT$alBufferfvDirect;
    public final @Nullable MemorySegment SEGMENT$alBufferiDirect;
    public final @Nullable MemorySegment SEGMENT$alBuffer3iDirect;
    public final @Nullable MemorySegment SEGMENT$alBufferivDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBufferfDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBuffer3fDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBufferfvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBufferiDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBuffer3iDirect;
    public final @Nullable MemorySegment SEGMENT$alGetBufferivDirect;
    public final @Nullable MemorySegment SEGMENT$alGenEffectsDirect;
    public final @Nullable MemorySegment SEGMENT$alDeleteEffectsDirect;
    public final @Nullable MemorySegment SEGMENT$alIsEffectDirect;
    public final @Nullable MemorySegment SEGMENT$alEffectiDirect;
    public final @Nullable MemorySegment SEGMENT$alEffectivDirect;
    public final @Nullable MemorySegment SEGMENT$alEffectfDirect;
    public final @Nullable MemorySegment SEGMENT$alEffectfvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetEffectiDirect;
    public final @Nullable MemorySegment SEGMENT$alGetEffectivDirect;
    public final @Nullable MemorySegment SEGMENT$alGetEffectfDirect;
    public final @Nullable MemorySegment SEGMENT$alGetEffectfvDirect;
    public final @Nullable MemorySegment SEGMENT$alGenFiltersDirect;
    public final @Nullable MemorySegment SEGMENT$alDeleteFiltersDirect;
    public final @Nullable MemorySegment SEGMENT$alIsFilterDirect;
    public final @Nullable MemorySegment SEGMENT$alFilteriDirect;
    public final @Nullable MemorySegment SEGMENT$alFilterivDirect;
    public final @Nullable MemorySegment SEGMENT$alFilterfDirect;
    public final @Nullable MemorySegment SEGMENT$alFilterfvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetFilteriDirect;
    public final @Nullable MemorySegment SEGMENT$alGetFilterivDirect;
    public final @Nullable MemorySegment SEGMENT$alGetFilterfDirect;
    public final @Nullable MemorySegment SEGMENT$alGetFilterfvDirect;
    public final @Nullable MemorySegment SEGMENT$alGenAuxiliaryEffectSlotsDirect;
    public final @Nullable MemorySegment SEGMENT$alDeleteAuxiliaryEffectSlotsDirect;
    public final @Nullable MemorySegment SEGMENT$alIsAuxiliaryEffectSlotDirect;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSlotiDirect;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSlotivDirect;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSlotfDirect;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSlotfvDirect;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSlotiDirect;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSlotivDirect;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSlotfDirect;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSlotfvDirect;
    public final @Nullable MemorySegment SEGMENT$alBufferDataStaticDirect;
    public final @Nullable MemorySegment SEGMENT$alDebugMessageCallbackDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alDebugMessageInsertDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alDebugMessageControlDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alPushDebugGroupDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alPopDebugGroupDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alGetDebugMessageLogDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alObjectLabelDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alGetObjectLabelDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alGetPointerDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alGetPointervDirectEXT;
    public final @Nullable MemorySegment SEGMENT$alRequestFoldbackStartDirect;
    public final @Nullable MemorySegment SEGMENT$alRequestFoldbackStopDirect;
    public final @Nullable MemorySegment SEGMENT$alBufferSubDataDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcedDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSource3dDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcedvDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcedDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSource3dDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcedvDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcei64DirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSource3i64DirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcei64vDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcei64DirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSource3i64DirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetSourcei64vDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alDeferUpdatesDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alProcessUpdatesDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetStringiDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alEventControlDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alEventCallbackDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetPointerDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetPointervDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alBufferCallbackDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetBufferPtrDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetBuffer3PtrDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alGetBufferPtrvDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcePlayAtTimeDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$alSourcePlayAtTimevDirectSOFT;
    public final @Nullable MemorySegment SEGMENT$EAXSetDirect;
    public final @Nullable MemorySegment SEGMENT$EAXGetDirect;
    public final @Nullable MemorySegment SEGMENT$EAXSetBufferModeDirect;
    public final @Nullable MemorySegment SEGMENT$EAXGetBufferModeDirect;
    public final @Nullable MemorySegment SEGMENT$alGenEffects;
    public final @Nullable MemorySegment SEGMENT$alDeleteEffects;
    public final @Nullable MemorySegment SEGMENT$alIsEffect;
    public final @Nullable MemorySegment SEGMENT$alEffecti;
    public final @Nullable MemorySegment SEGMENT$alEffectiv;
    public final @Nullable MemorySegment SEGMENT$alEffectf;
    public final @Nullable MemorySegment SEGMENT$alEffectfv;
    public final @Nullable MemorySegment SEGMENT$alGetEffecti;
    public final @Nullable MemorySegment SEGMENT$alGetEffectiv;
    public final @Nullable MemorySegment SEGMENT$alGetEffectf;
    public final @Nullable MemorySegment SEGMENT$alGetEffectfv;
    public final @Nullable MemorySegment SEGMENT$alGenFilters;
    public final @Nullable MemorySegment SEGMENT$alDeleteFilters;
    public final @Nullable MemorySegment SEGMENT$alIsFilter;
    public final @Nullable MemorySegment SEGMENT$alFilteri;
    public final @Nullable MemorySegment SEGMENT$alFilteriv;
    public final @Nullable MemorySegment SEGMENT$alFilterf;
    public final @Nullable MemorySegment SEGMENT$alFilterfv;
    public final @Nullable MemorySegment SEGMENT$alGetFilteri;
    public final @Nullable MemorySegment SEGMENT$alGetFilteriv;
    public final @Nullable MemorySegment SEGMENT$alGetFilterf;
    public final @Nullable MemorySegment SEGMENT$alGetFilterfv;
    public final @Nullable MemorySegment SEGMENT$alGenAuxiliaryEffectSlots;
    public final @Nullable MemorySegment SEGMENT$alDeleteAuxiliaryEffectSlots;
    public final @Nullable MemorySegment SEGMENT$alIsAuxiliaryEffectSlot;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSloti;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSlotiv;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSlotf;
    public final @Nullable MemorySegment SEGMENT$alAuxiliaryEffectSlotfv;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSloti;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSlotiv;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSlotf;
    public final @Nullable MemorySegment SEGMENT$alGetAuxiliaryEffectSlotfv;
    public final @Nullable MethodHandle HANDLE$alEnable;
    public final @Nullable MethodHandle HANDLE$alDisable;
    public final @Nullable MethodHandle HANDLE$alIsEnabled;
    public final @Nullable MethodHandle HANDLE$alDopplerFactor;
    public final @Nullable MethodHandle HANDLE$alDopplerVelocity;
    public final @Nullable MethodHandle HANDLE$alDistanceModel;
    public final @Nullable MethodHandle HANDLE$alGetString;
    public final @Nullable MethodHandle HANDLE$alGetBooleanv;
    public final @Nullable MethodHandle HANDLE$alGetIntegerv;
    public final @Nullable MethodHandle HANDLE$alGetFloatv;
    public final @Nullable MethodHandle HANDLE$alGetDoublev;
    public final @Nullable MethodHandle HANDLE$alGetBoolean;
    public final @Nullable MethodHandle HANDLE$alGetInteger;
    public final @Nullable MethodHandle HANDLE$alGetFloat;
    public final @Nullable MethodHandle HANDLE$alGetDouble;
    public final @Nullable MethodHandle HANDLE$alGetError;
    public final @Nullable MethodHandle HANDLE$alIsExtensionPresent;
    public final @Nullable MethodHandle HANDLE$alGetProcAddress;
    public final @Nullable MethodHandle HANDLE$alGetEnumValue;
    public final @Nullable MethodHandle HANDLE$alListenerf;
    public final @Nullable MethodHandle HANDLE$alListener3f;
    public final @Nullable MethodHandle HANDLE$alListenerfv;
    public final @Nullable MethodHandle HANDLE$alListeneri;
    public final @Nullable MethodHandle HANDLE$alListener3i;
    public final @Nullable MethodHandle HANDLE$alListeneriv;
    public final @Nullable MethodHandle HANDLE$alGetListenerf;
    public final @Nullable MethodHandle HANDLE$alGetListener3f;
    public final @Nullable MethodHandle HANDLE$alGetListenerfv;
    public final @Nullable MethodHandle HANDLE$alGetListeneri;
    public final @Nullable MethodHandle HANDLE$alGetListener3i;
    public final @Nullable MethodHandle HANDLE$alGetListeneriv;
    public final @Nullable MethodHandle HANDLE$alGenSources;
    public final @Nullable MethodHandle HANDLE$alDeleteSources;
    public final @Nullable MethodHandle HANDLE$alIsSource;
    public final @Nullable MethodHandle HANDLE$alSourcef;
    public final @Nullable MethodHandle HANDLE$alSource3f;
    public final @Nullable MethodHandle HANDLE$alSourcefv;
    public final @Nullable MethodHandle HANDLE$alSourcei;
    public final @Nullable MethodHandle HANDLE$alSource3i;
    public final @Nullable MethodHandle HANDLE$alSourceiv;
    public final @Nullable MethodHandle HANDLE$alGetSourcef;
    public final @Nullable MethodHandle HANDLE$alGetSource3f;
    public final @Nullable MethodHandle HANDLE$alGetSourcefv;
    public final @Nullable MethodHandle HANDLE$alGetSourcei;
    public final @Nullable MethodHandle HANDLE$alGetSource3i;
    public final @Nullable MethodHandle HANDLE$alGetSourceiv;
    public final @Nullable MethodHandle HANDLE$alSourcePlay;
    public final @Nullable MethodHandle HANDLE$alSourceStop;
    public final @Nullable MethodHandle HANDLE$alSourceRewind;
    public final @Nullable MethodHandle HANDLE$alSourcePause;
    public final @Nullable MethodHandle HANDLE$alSourcePlayv;
    public final @Nullable MethodHandle HANDLE$alSourceStopv;
    public final @Nullable MethodHandle HANDLE$alSourceRewindv;
    public final @Nullable MethodHandle HANDLE$alSourcePausev;
    public final @Nullable MethodHandle HANDLE$alSourceQueueBuffers;
    public final @Nullable MethodHandle HANDLE$alSourceUnqueueBuffers;
    public final @Nullable MethodHandle HANDLE$alGenBuffers;
    public final @Nullable MethodHandle HANDLE$alDeleteBuffers;
    public final @Nullable MethodHandle HANDLE$alIsBuffer;
    public final @Nullable MethodHandle HANDLE$alBufferData;
    public final @Nullable MethodHandle HANDLE$alBufferf;
    public final @Nullable MethodHandle HANDLE$alBuffer3f;
    public final @Nullable MethodHandle HANDLE$alBufferfv;
    public final @Nullable MethodHandle HANDLE$alBufferi;
    public final @Nullable MethodHandle HANDLE$alBuffer3i;
    public final @Nullable MethodHandle HANDLE$alBufferiv;
    public final @Nullable MethodHandle HANDLE$alGetBufferf;
    public final @Nullable MethodHandle HANDLE$alGetBuffer3f;
    public final @Nullable MethodHandle HANDLE$alGetBufferfv;
    public final @Nullable MethodHandle HANDLE$alGetBufferi;
    public final @Nullable MethodHandle HANDLE$alGetBuffer3i;
    public final @Nullable MethodHandle HANDLE$alGetBufferiv;
    public final @Nullable MethodHandle HANDLE$alSpeedOfSound;
    public final @Nullable MethodHandle HANDLE$alBufferDataStatic;
    public final @Nullable MethodHandle HANDLE$alBufferSubDataSOFT;
    public final @Nullable MethodHandle HANDLE$alRequestFoldbackStart;
    public final @Nullable MethodHandle HANDLE$alRequestFoldbackStop;
    public final @Nullable MethodHandle HANDLE$alBufferSamplesSOFT;
    public final @Nullable MethodHandle HANDLE$alBufferSubSamplesSOFT;
    public final @Nullable MethodHandle HANDLE$alGetBufferSamplesSOFT;
    public final @Nullable MethodHandle HANDLE$alIsBufferFormatSupportedSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcedSOFT;
    public final @Nullable MethodHandle HANDLE$alSource3dSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcedvSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcedSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSource3dSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcedvSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcei64SOFT;
    public final @Nullable MethodHandle HANDLE$alSource3i64SOFT;
    public final @Nullable MethodHandle HANDLE$alSourcei64vSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcei64SOFT;
    public final @Nullable MethodHandle HANDLE$alGetSource3i64SOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcei64vSOFT;
    public final @Nullable MethodHandle HANDLE$alDeferUpdatesSOFT;
    public final @Nullable MethodHandle HANDLE$alProcessUpdatesSOFT;
    public final @Nullable MethodHandle HANDLE$alGetStringiSOFT;
    public final @Nullable MethodHandle HANDLE$alEventControlSOFT;
    public final @Nullable MethodHandle HANDLE$alEventCallbackSOFT;
    public final @Nullable MethodHandle HANDLE$alGetPointerSOFT;
    public final @Nullable MethodHandle HANDLE$alGetPointervSOFT;
    public final @Nullable MethodHandle HANDLE$alBufferCallbackSOFT;
    public final @Nullable MethodHandle HANDLE$alGetBufferPtrSOFT;
    public final @Nullable MethodHandle HANDLE$alGetBuffer3PtrSOFT;
    public final @Nullable MethodHandle HANDLE$alGetBufferPtrvSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcePlayAtTimeSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcePlayAtTimevSOFT;
    public final @Nullable MethodHandle HANDLE$alDebugMessageCallbackEXT;
    public final @Nullable MethodHandle HANDLE$alDebugMessageInsertEXT;
    public final @Nullable MethodHandle HANDLE$alDebugMessageControlEXT;
    public final @Nullable MethodHandle HANDLE$alPushDebugGroupEXT;
    public final @Nullable MethodHandle HANDLE$alPopDebugGroupEXT;
    public final @Nullable MethodHandle HANDLE$alGetDebugMessageLogEXT;
    public final @Nullable MethodHandle HANDLE$alObjectLabelEXT;
    public final @Nullable MethodHandle HANDLE$alGetObjectLabelEXT;
    public final @Nullable MethodHandle HANDLE$alGetPointerEXT;
    public final @Nullable MethodHandle HANDLE$alGetPointervEXT;
    public final @Nullable MethodHandle HANDLE$alEnableDirect;
    public final @Nullable MethodHandle HANDLE$alDisableDirect;
    public final @Nullable MethodHandle HANDLE$alIsEnabledDirect;
    public final @Nullable MethodHandle HANDLE$alDopplerFactorDirect;
    public final @Nullable MethodHandle HANDLE$alSpeedOfSoundDirect;
    public final @Nullable MethodHandle HANDLE$alDistanceModelDirect;
    public final @Nullable MethodHandle HANDLE$alGetStringDirect;
    public final @Nullable MethodHandle HANDLE$alGetBooleanvDirect;
    public final @Nullable MethodHandle HANDLE$alGetIntegervDirect;
    public final @Nullable MethodHandle HANDLE$alGetFloatvDirect;
    public final @Nullable MethodHandle HANDLE$alGetDoublevDirect;
    public final @Nullable MethodHandle HANDLE$alGetBooleanDirect;
    public final @Nullable MethodHandle HANDLE$alGetIntegerDirect;
    public final @Nullable MethodHandle HANDLE$alGetFloatDirect;
    public final @Nullable MethodHandle HANDLE$alGetDoubleDirect;
    public final @Nullable MethodHandle HANDLE$alGetErrorDirect;
    public final @Nullable MethodHandle HANDLE$alIsExtensionPresentDirect;
    public final @Nullable MethodHandle HANDLE$alGetProcAddressDirect;
    public final @Nullable MethodHandle HANDLE$alGetEnumValueDirect;
    public final @Nullable MethodHandle HANDLE$alListenerfDirect;
    public final @Nullable MethodHandle HANDLE$alListener3fDirect;
    public final @Nullable MethodHandle HANDLE$alListenerfvDirect;
    public final @Nullable MethodHandle HANDLE$alListeneriDirect;
    public final @Nullable MethodHandle HANDLE$alListener3iDirect;
    public final @Nullable MethodHandle HANDLE$alListenerivDirect;
    public final @Nullable MethodHandle HANDLE$alGetListenerfDirect;
    public final @Nullable MethodHandle HANDLE$alGetListener3fDirect;
    public final @Nullable MethodHandle HANDLE$alGetListenerfvDirect;
    public final @Nullable MethodHandle HANDLE$alGetListeneriDirect;
    public final @Nullable MethodHandle HANDLE$alGetListener3iDirect;
    public final @Nullable MethodHandle HANDLE$alGetListenerivDirect;
    public final @Nullable MethodHandle HANDLE$alGenSourcesDirect;
    public final @Nullable MethodHandle HANDLE$alDeleteSourcesDirect;
    public final @Nullable MethodHandle HANDLE$alIsSourceDirect;
    public final @Nullable MethodHandle HANDLE$alSourcefDirect;
    public final @Nullable MethodHandle HANDLE$alSource3fDirect;
    public final @Nullable MethodHandle HANDLE$alSourcefvDirect;
    public final @Nullable MethodHandle HANDLE$alSourceiDirect;
    public final @Nullable MethodHandle HANDLE$alSource3iDirect;
    public final @Nullable MethodHandle HANDLE$alSourceivDirect;
    public final @Nullable MethodHandle HANDLE$alGetSourcefDirect;
    public final @Nullable MethodHandle HANDLE$alGetSource3fDirect;
    public final @Nullable MethodHandle HANDLE$alGetSourcefvDirect;
    public final @Nullable MethodHandle HANDLE$alGetSourceiDirect;
    public final @Nullable MethodHandle HANDLE$alGetSource3iDirect;
    public final @Nullable MethodHandle HANDLE$alGetSourceivDirect;
    public final @Nullable MethodHandle HANDLE$alSourcePlayDirect;
    public final @Nullable MethodHandle HANDLE$alSourceStopDirect;
    public final @Nullable MethodHandle HANDLE$alSourceRewindDirect;
    public final @Nullable MethodHandle HANDLE$alSourcePauseDirect;
    public final @Nullable MethodHandle HANDLE$alSourcePlayvDirect;
    public final @Nullable MethodHandle HANDLE$alSourceStopvDirect;
    public final @Nullable MethodHandle HANDLE$alSourceRewindvDirect;
    public final @Nullable MethodHandle HANDLE$alSourcePausevDirect;
    public final @Nullable MethodHandle HANDLE$alSourceQueueBuffersDirect;
    public final @Nullable MethodHandle HANDLE$alSourceUnqueueBuffersDirect;
    public final @Nullable MethodHandle HANDLE$alGenBuffersDirect;
    public final @Nullable MethodHandle HANDLE$alDeleteBuffersDirect;
    public final @Nullable MethodHandle HANDLE$alIsBufferDirect;
    public final @Nullable MethodHandle HANDLE$alBufferDataDirect;
    public final @Nullable MethodHandle HANDLE$alBufferfDirect;
    public final @Nullable MethodHandle HANDLE$alBuffer3fDirect;
    public final @Nullable MethodHandle HANDLE$alBufferfvDirect;
    public final @Nullable MethodHandle HANDLE$alBufferiDirect;
    public final @Nullable MethodHandle HANDLE$alBuffer3iDirect;
    public final @Nullable MethodHandle HANDLE$alBufferivDirect;
    public final @Nullable MethodHandle HANDLE$alGetBufferfDirect;
    public final @Nullable MethodHandle HANDLE$alGetBuffer3fDirect;
    public final @Nullable MethodHandle HANDLE$alGetBufferfvDirect;
    public final @Nullable MethodHandle HANDLE$alGetBufferiDirect;
    public final @Nullable MethodHandle HANDLE$alGetBuffer3iDirect;
    public final @Nullable MethodHandle HANDLE$alGetBufferivDirect;
    public final @Nullable MethodHandle HANDLE$alGenEffectsDirect;
    public final @Nullable MethodHandle HANDLE$alDeleteEffectsDirect;
    public final @Nullable MethodHandle HANDLE$alIsEffectDirect;
    public final @Nullable MethodHandle HANDLE$alEffectiDirect;
    public final @Nullable MethodHandle HANDLE$alEffectivDirect;
    public final @Nullable MethodHandle HANDLE$alEffectfDirect;
    public final @Nullable MethodHandle HANDLE$alEffectfvDirect;
    public final @Nullable MethodHandle HANDLE$alGetEffectiDirect;
    public final @Nullable MethodHandle HANDLE$alGetEffectivDirect;
    public final @Nullable MethodHandle HANDLE$alGetEffectfDirect;
    public final @Nullable MethodHandle HANDLE$alGetEffectfvDirect;
    public final @Nullable MethodHandle HANDLE$alGenFiltersDirect;
    public final @Nullable MethodHandle HANDLE$alDeleteFiltersDirect;
    public final @Nullable MethodHandle HANDLE$alIsFilterDirect;
    public final @Nullable MethodHandle HANDLE$alFilteriDirect;
    public final @Nullable MethodHandle HANDLE$alFilterivDirect;
    public final @Nullable MethodHandle HANDLE$alFilterfDirect;
    public final @Nullable MethodHandle HANDLE$alFilterfvDirect;
    public final @Nullable MethodHandle HANDLE$alGetFilteriDirect;
    public final @Nullable MethodHandle HANDLE$alGetFilterivDirect;
    public final @Nullable MethodHandle HANDLE$alGetFilterfDirect;
    public final @Nullable MethodHandle HANDLE$alGetFilterfvDirect;
    public final @Nullable MethodHandle HANDLE$alGenAuxiliaryEffectSlotsDirect;
    public final @Nullable MethodHandle HANDLE$alDeleteAuxiliaryEffectSlotsDirect;
    public final @Nullable MethodHandle HANDLE$alIsAuxiliaryEffectSlotDirect;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSlotiDirect;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSlotivDirect;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSlotfDirect;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSlotfvDirect;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSlotiDirect;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSlotivDirect;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSlotfDirect;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSlotfvDirect;
    public final @Nullable MethodHandle HANDLE$alBufferDataStaticDirect;
    public final @Nullable MethodHandle HANDLE$alDebugMessageCallbackDirectEXT;
    public final @Nullable MethodHandle HANDLE$alDebugMessageInsertDirectEXT;
    public final @Nullable MethodHandle HANDLE$alDebugMessageControlDirectEXT;
    public final @Nullable MethodHandle HANDLE$alPushDebugGroupDirectEXT;
    public final @Nullable MethodHandle HANDLE$alPopDebugGroupDirectEXT;
    public final @Nullable MethodHandle HANDLE$alGetDebugMessageLogDirectEXT;
    public final @Nullable MethodHandle HANDLE$alObjectLabelDirectEXT;
    public final @Nullable MethodHandle HANDLE$alGetObjectLabelDirectEXT;
    public final @Nullable MethodHandle HANDLE$alGetPointerDirectEXT;
    public final @Nullable MethodHandle HANDLE$alGetPointervDirectEXT;
    public final @Nullable MethodHandle HANDLE$alRequestFoldbackStartDirect;
    public final @Nullable MethodHandle HANDLE$alRequestFoldbackStopDirect;
    public final @Nullable MethodHandle HANDLE$alBufferSubDataDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcedDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSource3dDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcedvDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcedDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSource3dDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcedvDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcei64DirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSource3i64DirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcei64vDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcei64DirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSource3i64DirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetSourcei64vDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alDeferUpdatesDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alProcessUpdatesDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetStringiDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alEventControlDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alEventCallbackDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetPointerDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetPointervDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alBufferCallbackDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetBufferPtrDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetBuffer3PtrDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alGetBufferPtrvDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcePlayAtTimeDirectSOFT;
    public final @Nullable MethodHandle HANDLE$alSourcePlayAtTimevDirectSOFT;
    public final @Nullable MethodHandle HANDLE$EAXSetDirect;
    public final @Nullable MethodHandle HANDLE$EAXGetDirect;
    public final @Nullable MethodHandle HANDLE$EAXSetBufferModeDirect;
    public final @Nullable MethodHandle HANDLE$EAXGetBufferModeDirect;
    public final @Nullable MethodHandle HANDLE$alGenEffects;
    public final @Nullable MethodHandle HANDLE$alDeleteEffects;
    public final @Nullable MethodHandle HANDLE$alIsEffect;
    public final @Nullable MethodHandle HANDLE$alEffecti;
    public final @Nullable MethodHandle HANDLE$alEffectiv;
    public final @Nullable MethodHandle HANDLE$alEffectf;
    public final @Nullable MethodHandle HANDLE$alEffectfv;
    public final @Nullable MethodHandle HANDLE$alGetEffecti;
    public final @Nullable MethodHandle HANDLE$alGetEffectiv;
    public final @Nullable MethodHandle HANDLE$alGetEffectf;
    public final @Nullable MethodHandle HANDLE$alGetEffectfv;
    public final @Nullable MethodHandle HANDLE$alGenFilters;
    public final @Nullable MethodHandle HANDLE$alDeleteFilters;
    public final @Nullable MethodHandle HANDLE$alIsFilter;
    public final @Nullable MethodHandle HANDLE$alFilteri;
    public final @Nullable MethodHandle HANDLE$alFilteriv;
    public final @Nullable MethodHandle HANDLE$alFilterf;
    public final @Nullable MethodHandle HANDLE$alFilterfv;
    public final @Nullable MethodHandle HANDLE$alGetFilteri;
    public final @Nullable MethodHandle HANDLE$alGetFilteriv;
    public final @Nullable MethodHandle HANDLE$alGetFilterf;
    public final @Nullable MethodHandle HANDLE$alGetFilterfv;
    public final @Nullable MethodHandle HANDLE$alGenAuxiliaryEffectSlots;
    public final @Nullable MethodHandle HANDLE$alDeleteAuxiliaryEffectSlots;
    public final @Nullable MethodHandle HANDLE$alIsAuxiliaryEffectSlot;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSloti;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSlotiv;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSlotf;
    public final @Nullable MethodHandle HANDLE$alAuxiliaryEffectSlotfv;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSloti;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSlotiv;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSlotf;
    public final @Nullable MethodHandle HANDLE$alGetAuxiliaryEffectSlotfv;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$alEnable = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDisable = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsEnabled = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDopplerFactor = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDopplerVelocity = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDistanceModel = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetString = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBooleanv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetIntegerv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFloatv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetDoublev = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBoolean = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetInteger = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFloat = FunctionDescriptor.of(
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetDouble = FunctionDescriptor.of(
            ValueLayout.JAVA_DOUBLE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetError = FunctionDescriptor.of(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsExtensionPresent = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetProcAddress = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEnumValue = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alListenerf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListener3f = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListenerfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alListeneri = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListener3i = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListeneriv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListenerf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListener3f = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListenerfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListeneri = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListener3i = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListeneriv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenSources = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteSources = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsSource = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcef = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3f = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcefv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcei = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3i = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcef = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3f = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcefv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcei = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3i = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourceiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlay = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceStop = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceRewind = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePause = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlayv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceStopv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceRewindv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePausev = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceQueueBuffers = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceUnqueueBuffers = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenBuffers = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteBuffers = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsBuffer = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferData = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBuffer3f = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferi = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBuffer3i = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBuffer3f = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferi = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBuffer3i = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSpeedOfSound = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferDataStatic = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferSubDataSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alRequestFoldbackStart = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alRequestFoldbackStop = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferSamplesSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferSubSamplesSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferSamplesSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsBufferFormatSupportedSOFT = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcedSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3dSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_DOUBLE,
            ValueLayout.JAVA_DOUBLE,
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcedvSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcedSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3dSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcedvSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcei64SOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3i64SOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcei64vSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcei64SOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3i64SOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcei64vSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeferUpdatesSOFT = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$alProcessUpdatesSOFT = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetStringiSOFT = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEventControlSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_BYTE
        );

        public static final FunctionDescriptor DESCRIPTOR$alEventCallbackSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointerSOFT = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointervSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferCallbackSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferPtrSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBuffer3PtrSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferPtrvSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlayAtTimeSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlayAtTimevSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$alDebugMessageCallbackEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alDebugMessageInsertEXT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDebugMessageControlEXT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_BYTE
        );

        public static final FunctionDescriptor DESCRIPTOR$alPushDebugGroupEXT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alPopDebugGroupEXT = FunctionDescriptor.ofVoid(
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetDebugMessageLogEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alObjectLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetObjectLabelEXT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointerEXT = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointervEXT = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alEnableDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDisableDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsEnabledDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDopplerFactorDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSpeedOfSoundDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDistanceModelDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetStringDirect = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBooleanvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetIntegervDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFloatvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetDoublevDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBooleanDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetIntegerDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFloatDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_FLOAT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetDoubleDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_DOUBLE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetErrorDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsExtensionPresentDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetProcAddressDirect = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEnumValueDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alListenerfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListener3fDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListenerfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alListeneriDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListener3iDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alListenerivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListenerfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListener3fDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListenerfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListeneriDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListener3iDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetListenerivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenSourcesDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteSourcesDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsSourceDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcefDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3fDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcefvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3iDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcefDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3fDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcefvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourceiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3iDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourceivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlayDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceStopDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceRewindDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePauseDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlayvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceStopvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceRewindvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePausevDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceQueueBuffersDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourceUnqueueBuffersDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenBuffersDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteBuffersDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsBufferDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferDataDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBuffer3fDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBuffer3iDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBuffer3fDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBuffer3iDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenEffectsDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteEffectsDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsEffectDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffectiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffectivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffectfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffectfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffectiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffectivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffectfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffectfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenFiltersDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteFiltersDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsFilterDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilteriDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilterivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilterfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilterfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilteriDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilterivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilterfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilterfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenAuxiliaryEffectSlotsDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteAuxiliaryEffectSlotsDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsAuxiliaryEffectSlotDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSlotiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSlotivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSlotfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSlotfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSlotiDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSlotivDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSlotfDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSlotfvDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferDataStaticDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alDebugMessageCallbackDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alDebugMessageInsertDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDebugMessageControlDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_BYTE
        );

        public static final FunctionDescriptor DESCRIPTOR$alPushDebugGroupDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alPopDebugGroupDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetDebugMessageLogDirectEXT = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alObjectLabelDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetObjectLabelDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointerDirectEXT = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointervDirectEXT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alRequestFoldbackStartDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alRequestFoldbackStopDirect = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferSubDataDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcedDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3dDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_DOUBLE,
            ValueLayout.JAVA_DOUBLE,
            ValueLayout.JAVA_DOUBLE
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcedvDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcedDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3dDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcedvDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_DOUBLE)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcei64DirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$alSource3i64DirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcei64vDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcei64DirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSource3i64DirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetSourcei64vDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeferUpdatesDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alProcessUpdatesDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetStringiDirectSOFT = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEventControlDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_BYTE
        );

        public static final FunctionDescriptor DESCRIPTOR$alEventCallbackDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointerDirectSOFT = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetPointervDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alBufferCallbackDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferPtrDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBuffer3PtrDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetBufferPtrvDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS)
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlayAtTimeDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$alSourcePlayAtTimevDirectSOFT = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_LONG
        );

        public static final FunctionDescriptor DESCRIPTOR$EAXSetDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$EAXGetDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$EAXSetBufferModeDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$EAXGetBufferModeDirect = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenEffects = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteEffects = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsEffect = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffecti = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffectiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffectf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alEffectfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffecti = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffectiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffectf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetEffectfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenFilters = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteFilters = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsFilter = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilteri = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilteriv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilterf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alFilterfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilteri = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilteriv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilterf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetFilterfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGenAuxiliaryEffectSlots = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alDeleteAuxiliaryEffectSlots = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alIsAuxiliaryEffectSlot = FunctionDescriptor.of(
            ValueLayout.JAVA_BYTE,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSloti = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSlotiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSlotf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_FLOAT
        );

        public static final FunctionDescriptor DESCRIPTOR$alAuxiliaryEffectSlotfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSloti = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSlotiv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSlotf = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        public static final FunctionDescriptor DESCRIPTOR$alGetAuxiliaryEffectSlotfv = FunctionDescriptor.ofVoid(
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT)
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
