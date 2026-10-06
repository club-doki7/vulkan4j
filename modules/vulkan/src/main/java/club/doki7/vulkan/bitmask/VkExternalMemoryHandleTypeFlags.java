package club.doki7.vulkan.bitmask;

import club.doki7.ffm.annotation.*;

import java.util.ArrayList;
import java.util.List;

/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalMemoryHandleTypeFlags.html"><code>VkExternalMemoryHandleTypeFlags</code></a>
public final class VkExternalMemoryHandleTypeFlags {
    public static final int ANDROID_HARDWARE_BUFFER_ANDROID = 0x400;
    public static final int D3D11_TEXTURE = 0x8;
    public static final int D3D11_TEXTURE_KMT = 0x10;
    public static final int D3D12_HEAP = 0x20;
    public static final int D3D12_RESOURCE = 0x40;
    public static final int DMA_BUF_EXT = 0x200;
    public static final int HOST_ALLOCATION_EXT = 0x80;
    public static final int HOST_MAPPED_FOREIGN_MEMORY_EXT = 0x100;
    public static final int MTLBUFFER_EXT = 0x10000;
    public static final int MTLHEAP_EXT = 0x40000;
    public static final int MTLTEXTURE_EXT = 0x20000;
    public static final int OH_NATIVE_BUFFER_OHOS = 0x8000;
    public static final int OPAQUE_FD = 0x1;
    public static final int OPAQUE_WIN32 = 0x2;
    public static final int OPAQUE_WIN32_KMT = 0x4;
    public static final int RDMA_ADDRESS_NV = 0x1000;
    public static final int SCI_BUF_NV = 0x2000;
    public static final int SCREEN_BUFFER_QNX = 0x4000;
    public static final int ZIRCON_VMO_FUCHSIA = 0x800;

    public static String explain(@Bitmask(VkExternalMemoryHandleTypeFlags.class) int flags) {
        List<String> detectedFlagBits = new ArrayList<>();
        if ((flags & ANDROID_HARDWARE_BUFFER_ANDROID) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_ANDROID_HARDWARE_BUFFER_BIT_ANDROID");
        }
        if ((flags & D3D11_TEXTURE) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_BIT");
        }
        if ((flags & D3D11_TEXTURE_KMT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D11_TEXTURE_KMT_BIT");
        }
        if ((flags & D3D12_HEAP) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_HEAP_BIT");
        }
        if ((flags & D3D12_RESOURCE) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_D3D12_RESOURCE_BIT");
        }
        if ((flags & DMA_BUF_EXT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_DMA_BUF_BIT_EXT");
        }
        if ((flags & HOST_ALLOCATION_EXT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_ALLOCATION_BIT_EXT");
        }
        if ((flags & HOST_MAPPED_FOREIGN_MEMORY_EXT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_MAPPED_FOREIGN_MEMORY_BIT_EXT");
        }
        if ((flags & MTLBUFFER_EXT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_MTLBUFFER_BIT_EXT");
        }
        if ((flags & MTLHEAP_EXT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_MTLHEAP_BIT_EXT");
        }
        if ((flags & MTLTEXTURE_EXT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_MTLTEXTURE_BIT_EXT");
        }
        if ((flags & OH_NATIVE_BUFFER_OHOS) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_OH_NATIVE_BUFFER_BIT_OHOS");
        }
        if ((flags & OPAQUE_FD) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_FD_BIT");
        }
        if ((flags & OPAQUE_WIN32) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_BIT");
        }
        if ((flags & OPAQUE_WIN32_KMT) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT");
        }
        if ((flags & RDMA_ADDRESS_NV) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_RDMA_ADDRESS_BIT_NV");
        }
        if ((flags & SCI_BUF_NV) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_SCI_BUF_BIT_NV");
        }
        if ((flags & SCREEN_BUFFER_QNX) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_SCREEN_BUFFER_BIT_QNX");
        }
        if ((flags & ZIRCON_VMO_FUCHSIA) != 0) {
            detectedFlagBits.add("VK_EXTERNAL_MEMORY_HANDLE_TYPE_ZIRCON_VMO_BIT_FUCHSIA");
        }

        if (detectedFlagBits.isEmpty()) {
            return "NONE(" + Integer.toBinaryString(flags) + ")";
        }
        return String.join(" | ", detectedFlagBits);
    }

    /// Constructing this class is nonsense so the constructor is made private.
    private VkExternalMemoryHandleTypeFlags() {}
}
