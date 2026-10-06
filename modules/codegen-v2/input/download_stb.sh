#!/usr/bin/env bash

STB_URL_PREFIX="https://raw.githubusercontent.com/nothings/stb/2c980bb59875b0d32144a71867fbdebb2f77cd20/"

COMPONENTS=("image" "image_resize2" "image_write")

mkdir -p stb
mkdir -p stb_formatted
for component in "${COMPONENTS[@]}"; do
  curl -o "stb/stb_${component}.h" "${STB_URL_PREFIX}stb_${component}.h";
  cat "stb/stb_${component}.h" | clang-format --style=file:.clang-format > "stb_formatted/stb_${component}.h";
done

C_COMPONENTS=("vorbis")
for c_component in "${C_COMPONENTS[@]}"; do
  if [ ! -f "stb_${c_component}.h" ]; then
    curl -o "stb_${c_component}.h" "${STB_URL_PREFIX}stb_${c_component}.c";
    cat "stb_${c_component}.h" | clang-format --style=file:.clang-format > "stb_formatted/stb_${c_component}.h";
  fi;
done

curl -o "stb/stb_truetype.h" "https://raw.githubusercontent.com/ocornut/imgui/6f8bdb7bf71055efdfed8b88d45899df3e834ef4/imstb_truetype.h";
cat "stb/stb_truetype.h" | clang-format --style=file:.clang-format > "stb_formatted/stb_truetype.h";
