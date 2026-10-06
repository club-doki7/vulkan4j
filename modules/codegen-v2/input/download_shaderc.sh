#!/usr/bin/env bash

SHADERC_URL_PREFIX="https://raw.githubusercontent.com/google/shaderc/refs/tags/v2026.4/libshaderc/include/shaderc"

curl -o env.h "${SHADERC_URL_PREFIX}/env.h"
curl -o status.h "${SHADERC_URL_PREFIX}/status.h"
curl -o shaderc.h "${SHADERC_URL_PREFIX}/shaderc.h"
