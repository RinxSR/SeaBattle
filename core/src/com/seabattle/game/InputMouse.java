package com.seabattle.game;

import com.badlogic.gdx.Gdx;

public class InputMouse {

    public static int getMouseX() {
        return Gdx.input.getX();
    }

    public static int getMouseY() {
        return Gdx.graphics.getHeight() - Gdx.input.getY();
    }

    public static boolean isClicked() {
        return Gdx.input.isTouched();
    }
}
