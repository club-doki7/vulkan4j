@file:Suppress("LocalVariableName")

package club.doki7.babel.extract.shaderc

import club.doki7.sennaar.registry.EnumVariant
import club.doki7.sennaar.registry.Enumeration
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.putEntityIfAbsent

internal fun addEnvHeaderItems(registry: Registry) {
    val shaderc_target_env = Enumeration(
        name = "shaderc_target_env",
        variants = mutableListOf(
            EnumVariant("shaderc_target_env_vulkan", 0),
            EnumVariant("shaderc_target_env_opengl", 1),
            EnumVariant("shaderc_target_env_opengl_compat", 2),
            EnumVariant("shaderc_target_env_webgpu", 3),
            EnumVariant("shaderc_target_env_default", listOf("shaderc_target_env_vulkan")),
        )
    )

    val shaderc_env_version = Enumeration(
        name = "shaderc_env_version",
        variants = mutableListOf(
            EnumVariant("shaderc_env_version_vulkan_1_0", 1.shl(22)),
            EnumVariant("shaderc_env_version_vulkan_1_1", 1.shl(22) or 1.shl(12)),
            EnumVariant("shaderc_env_version_vulkan_1_2", 1.shl(22) or 2.shl(12)),
            EnumVariant("shaderc_env_version_vulkan_1_3", 1.shl(22) or 3.shl(12)),
            EnumVariant("shaderc_env_version_vulkan_1_4", 1.shl(22) or 4.shl(12)),
            EnumVariant("shaderc_env_version_opengl_4_5", 450)
        )
    )

    val shaderc_spirv_version = Enumeration(
        name = "shaderc_spirv_version",
        variants = mutableListOf(
            EnumVariant("shaderc_spirv_version_1_0", 0x010000),
            EnumVariant("shaderc_spirv_version_1_1", 0x010100),
            EnumVariant("shaderc_spirv_version_1_2", 0x010200),
            EnumVariant("shaderc_spirv_version_1_3", 0x010300),
            EnumVariant("shaderc_spirv_version_1_4", 0x010400),
            EnumVariant("shaderc_spirv_version_1_5", 0x010500),
            EnumVariant("shaderc_spirv_version_1_6", 0x010600),
        )
    )

    registry.enumerations.putEntityIfAbsent(shaderc_target_env)
    registry.enumerations.putEntityIfAbsent(shaderc_env_version)
    registry.enumerations.putEntityIfAbsent(shaderc_spirv_version)
}
