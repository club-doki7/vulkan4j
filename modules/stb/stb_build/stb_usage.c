#include <stdio.h>
#include <stdlib.h>

void (*g_JavaTrace)(void);

extern void vk4jSetSTBJavaTrace(void (*javaTrace)(void)) {
    g_JavaTrace = javaTrace;
}

static void vk4jStbAssertFail(const char *asserter, const char *condition) {
    fprintf(stderr, "%s failed: %s\n", asserter, condition);
    if (g_JavaTrace) {
        g_JavaTrace();
    }
    abort();
}

extern void vk4jStbFreeMemory(void *ptr) {
    free(ptr);
}

#define VK4J_STB_GENERAL_ASSERT(ASSERTER, CONDITION) \
    ((CONDITION)                                     \
        ? (void)0                                    \
        : vk4jStbAssertFail(ASSERTER, #CONDITION))

#ifndef STBI_ASSERT
#   define STBI_ASSERT(CONDITION) VK4J_STB_GENERAL_ASSERT("STBI_ASSERT", CONDITION)
#endif

#ifndef STBTT_assert
#   define STBTT_assert(CONDITION) VK4J_STB_GENERAL_ASSERT("STBTT_assert", CONDITION)
#endif

#ifndef STBIR_ASSERT
#   define STBIR_ASSERT(CONDITION) VK4J_STB_GENERAL_ASSERT("STBIR_ASSERT", CONDITION)
#endif

#ifndef STBIW_ASSERT
#   define STBIW_ASSERT(CONDITION) VK4J_STB_GENERAL_ASSERT("STBIW_ASSERT", CONDITION)
#endif


#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

#define STB_TRUETYPE_IMPLEMENTATION
#include "stb_truetype.h"

#define STB_IMAGE_RESIZE_IMPLEMENTATION
#define STB_IMAGE_RESIZE2_IMPLEMENTATION
#include "stb_image_resize2.h"

#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "stb_image_write.h"

#ifdef assert
#undef assert
#endif
#define assert(CONDITION) VK4J_STB_GENERAL_ASSERT("assert", CONDITION)
#include "stb_vorbis.h"
#undef assert
