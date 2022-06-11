/*
Copyright © Michael Steinmoetzger (ShortPing) 2015 - 2022

Alle Rechte sind für dieses Projekt verbehalten, sofern es nicht
anders in einer Lizenzdatei angegeben ist.

All rights are reserved for this project, unless otherwise
stated in a license file.
*/
package eu.steinmoetzger.platformer.game;

import entity.Entity;
import entity.LivingEntity;
import entity.world.Location;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.awt.*;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.UUID;

@Data
public class Game {


    private GameState state;
    @Getter
    private long windowHandle;
    private ArrayList<Entity> loadedEntities;
    private Entity entity;

    public Game() {
        this.loadedEntities = new ArrayList<>();
    }

    public void createWindow() {
        entity = new Entity(null, new Location(0.5f, 0.5f, 0));
        entity.load();
        entity.show();
        this.initProcedure();
        this.loopProcedure();
        this.exitProcedure();
    }


    private void handleKeyInput(long window, int key, int scancode, int action, int mods) {
        System.out.println(mods);
        if(key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
            glfwSetWindowShouldClose(window, true);
        }
        entity.getLocation().addX(0.01f);
    }


    private void initProcedure() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!GLFW.glfwInit())
            throw new IllegalStateException("Unable to init window");

        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, 0);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, 0);

        this.windowHandle =
                GLFW.glfwCreateWindow(
                        (int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.8),
                        (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.8),
                        "Platformer", NULL, NULL);

        if(this.windowHandle == NULL)
            throw new RuntimeException("Unable to create window");

        glfwSetKeyCallback(this.windowHandle, this::handleKeyInput);

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(this.windowHandle, pWidth, pHeight);

            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos(
                    this.windowHandle,
                    (vidMode.width() - pWidth.get(0)) / 2,
                    (vidMode.height() - pHeight.get(0)) /2
            );

            glfwMakeContextCurrent(this.windowHandle);
            glfwSwapInterval(1);
            glfwShowWindow(this.windowHandle);
        }
    }

    private void loopProcedure() {
        GL.createCapabilities();

        glClearColor(255,255,255,0);
        while(!glfwWindowShouldClose(this.windowHandle)) {


            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            this.loadedEntities.forEach(entity -> {
                System.out.println(entity.toString());
                if(!entity.isVisible())
                    return;
                System.out.println("Spawning...");
                glBegin(GL_QUADS);
                glColor3f(0.7f, 0.3f, 0.4f);
                glVertex2f(entity.getLocation().getX() * -1, entity.getLocation().getY());
                glVertex2f(entity.getLocation().getX(), entity.getLocation().getY());
                glVertex2f(entity.getLocation().getX(), entity.getLocation().getY() * -1);
                glVertex2f(entity.getLocation().getX() * -1, entity.getLocation().getY() * -1);
                glEnd();
            });

            glfwSwapBuffers(this.windowHandle);
            glfwPollEvents();
        }
    }

    private void exitProcedure() {

        Callbacks.glfwFreeCallbacks(this.windowHandle);
        GLFW.glfwDestroyWindow(this.windowHandle);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    public void loadEntity(Entity entity) {
        this.loadedEntities.add(entity);
    }

    public void removeEntity(UUID uuid) {
        this.loadedEntities.removeIf(entity -> entity.getUuid().equals(uuid));
    }

    public void removeEntity(Entity entity) {
        this.loadedEntities.remove(entity);
    }

}
