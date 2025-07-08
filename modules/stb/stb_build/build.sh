#!/usr/bin/env bash

STB_URL_PREFIX="https://raw.githubusercontent.com/nothings/stb/f58f558c120e9b32c217290b80bad1a0729fbb2c/"
COMPONENTS=("image" "image_resize2" "image_write")

for component in "${COMPONENTS[@]}"; do
  if [ ! -f "stb_${component}.h" ]; then
    curl -o "stb_${component}.h" "${STB_URL_PREFIX}stb_${component}.h";
  fi;
done

# See #153
if [ ! -f "stb_truetype.h" ]; then
  curl -o "stb_truetype.h" "https://raw.githubusercontent.com/ocornut/imgui/895bff6524549ccb3fb1136aa23ad130b68d0a3e/imstb_truetype.h";
fi;

# if CC is not set, default to gcc
if [ -z "CC" ]; then
  CC=gcc
  echo Info: CC is not set, defaulting to gcc
fi

$CC -std=c11 -O2 -fPIC -I. -c -o stb.o stb_usage.c

# If the last command failed, exit
if [ $? -ne 0 ]; then
  exit 1
fi

# Generate shared library file according to the platform, using a environment variable WIN32
if [ -n "$WIN32" ] || [ -f windows-indicator.txt ]; then
  $CC -shared -fPIC -static-libgcc -o stb.dll stb.o
else
  if [ -n "$MACOS" ]; then
    $CC -shared -fPIC -o libstb.dylib stb.o
  else
    $CC -shared -fPIC -o libstb.so stb.o
  fi
fi
