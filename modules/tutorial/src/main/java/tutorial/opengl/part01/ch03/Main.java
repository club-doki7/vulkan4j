package tutorial.opengl.part01.ch03;

import club.doki7.ffm.annotation.Unsigned;
import club.doki7.ffm.library.ISharedLibrary;
import club.doki7.ffm.ptr.BytePtr;
import club.doki7.ffm.ptr.FloatPtr;
import club.doki7.ffm.ptr.IntPtr;
import club.doki7.ffm.ptr.PointerPtr;
import club.doki7.glfw.GLFW;
import club.doki7.glfw.GLFWLoader;
import club.doki7.glfw.handle.GLFWwindow;
import club.doki7.opengl.GL;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

class Application {
    private final GLFW glfw;
    private GL gl;

    public Application(GLFW glfw) {
        this.glfw = glfw;
    }

    public void run() {
        if (glfw.init() != GLFW.TRUE) {
            throw new RuntimeException("Failed to initialize GLFW");
        }

        glfw.windowHint(GLFW.CONTEXT_VERSION_MAJOR, 3);
        glfw.windowHint(GLFW.CONTEXT_VERSION_MINOR, 3);
        glfw.windowHint(GLFW.OPENGL_PROFILE, GLFW.OPENGL_CORE_PROFILE);

        GLFWwindow window = glfw.createWindow(
                800,
                600,
                BytePtr.allocateString(Arena.global(), "LearnOpenGL"),
                null,
                null
        );
        if (window == null) {
            throw new RuntimeException("Failed to create GLFW window");
        }
        glfw.makeContextCurrent(window);

        gl = new GL(name -> {
            try (Arena arena1 = Arena.ofConfined()) {
                return glfw.getProcAddress(BytePtr.allocateString(arena1, name));
            }
        });
        gl.viewport(0, 0, 800, 600);

        glfw.setFramebufferSizeCallback(window, (_, w, h) -> gl.viewport(0, 0, w, h));

        @Unsigned int vao;
        @Unsigned int vbo;
        @Unsigned int shaderProgram;
        try(Arena arena = Arena.ofConfined()) {
            IntPtr pVAO = IntPtr.allocate(arena);
            gl.genVertexArrays(1, pVAO);
            vao = pVAO.read();

            IntPtr pVBO = IntPtr.allocate(arena);
            gl.genBuffers(1, pVBO);
            vbo = pVBO.read();

            gl.bindVertexArray(vao);
            gl.bindBuffer(GL.ARRAY_BUFFER, vbo);
            FloatPtr pVertices = FloatPtr.allocate(arena, VERTICES);
            gl.bufferData(
                    GL.ARRAY_BUFFER,
                    pVertices.segment().byteSize(),
                    pVertices.segment(),
                    GL.STATIC_DRAW
            );
            gl.vertexAttribPointer(
                    0,
                    3,
                    GL.FLOAT,
                    (byte) GLFW.FALSE,
                    3 * Float.BYTES,
                    MemorySegment.NULL
            );
            gl.enableVertexAttribArray(0);

            IntPtr pSuccess = IntPtr.allocate(arena);
            BytePtr pInfoLog = BytePtr.allocate(arena, 512);
            @Unsigned int vertexShader = gl.createShader(GL.VERTEX_SHADER);
            var pVertexShaderSource = PointerPtr.allocateV(arena, BytePtr.allocateString(arena, VERTEX_SHADER_SOURCE));
            gl.shaderSource(vertexShader, 1, pVertexShaderSource, null);
            gl.compileShader(vertexShader);
            gl.getShaderiv(vertexShader, GL.COMPILE_STATUS, pSuccess);
            if (pSuccess.read() == GLFW.FALSE) {
                gl.getShaderInfoLog(vertexShader, 512, null, pInfoLog);
                throw new RuntimeException("Failed to compile vertex shader: " + pInfoLog.readString());
            }

            @Unsigned int fragmentShader = gl.createShader(GL.FRAGMENT_SHADER);
            var pFragmentShaderSource = PointerPtr.allocateV(arena, BytePtr.allocateString(arena, FRAGMENT_SHADER_SOURCE));
            gl.shaderSource(fragmentShader, 1, pFragmentShaderSource, null);
            gl.compileShader(fragmentShader);
            gl.getShaderiv(fragmentShader, GL.COMPILE_STATUS, pSuccess);
            if (pSuccess.read() == GLFW.FALSE) {
                gl.getShaderInfoLog(fragmentShader, 512, null, pInfoLog);
                throw new RuntimeException("Failed to compile fragment shader: " + pInfoLog.readString());
            }

            shaderProgram = gl.createProgram();
            gl.attachShader(shaderProgram, vertexShader);
            gl.attachShader(shaderProgram, fragmentShader);
            gl.linkProgram(shaderProgram);
            gl.getProgramiv(shaderProgram, GL.LINK_STATUS, pSuccess);
            if (pSuccess.read() == GLFW.FALSE) {
                gl.getProgramInfoLog(shaderProgram, 512, null, pInfoLog);
                throw new RuntimeException("Failed to link shader program: " + pInfoLog.readString());
            }

            gl.deleteShader(vertexShader);
            gl.deleteShader(fragmentShader);
        }

        while (glfw.windowShouldClose(window) == GLFW.FALSE) {
            processInput(window);

            gl.clearColor(0.2f, 0.3f, 0.3f, 1.0f);
            gl.clear(GL.COLOR_BUFFER_BIT);

            gl.useProgram(shaderProgram);
            gl.bindVertexArray(vao);
            gl.drawArrays(GL.TRIANGLES, 0, 3);

            glfw.swapBuffers(window);
            glfw.pollEvents();
        }

        glfw.terminate();
    }

    private void processInput(GLFWwindow window) {
        if (glfw.getKey(window, GLFW.KEY_ESCAPE) == GLFW.PRESS) {
            glfw.setWindowShouldClose(window, GLFW.TRUE);
        }
    }

    private static final float[] VERTICES = {
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.0f,  0.5f, 0.0f
    };

    private static final String VERTEX_SHADER_SOURCE =
            """
            #version 330 core
            layout (location = 0) in vec3 aPos;
        
            void main() {
                gl_Position = vec4(aPos, 1.0f);
            }
            """;

    private static final String FRAGMENT_SHADER_SOURCE =
            """
            #version 330 core
            out vec4 FragColor;
            
            void main() {
                FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);
            }
            """;
}

public class Main {
    public static void main(String[] args) {
        try (ISharedLibrary libGLFW = GLFWLoader.loadGLFWLibrary()) {
            GLFW glfw = GLFWLoader.loadGLFW(libGLFW);

            Application application = new Application(glfw);
            application.run();
        }
    }
}
