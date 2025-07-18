package club.doki7.ffm.library;

import org.jetbrains.annotations.NotNull;

import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

public enum JavaSystemLibrary implements ISharedLibrary {
    INSTANCE;

    @Override
    public @NotNull MemorySegment apply(@NotNull String name) {
        return loaderLookup.find(name)
                .or(() -> stdlibLookup.find(name))
                .orElse(MemorySegment.NULL);
    }

    @Override
    public void close() {}

    private static final Linker nativeLinker = Linker.nativeLinker();
    private static final SymbolLookup stdlibLookup = nativeLinker.defaultLookup();
    private static final SymbolLookup loaderLookup = SymbolLookup.loaderLookup();
}
