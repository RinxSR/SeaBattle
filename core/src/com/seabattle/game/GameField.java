package com.seabattle.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameField {

    private static final int FIELD_SIZE = 10;
    private static final int CELL_SIZE = 30;
    private static final int FIELD_SIZE_IN_PIXELS = FIELD_SIZE * CELL_SIZE;

    private static Texture fullWater;
    private static Texture aim;
    private static Texture shipsPart;

    private char[][] field;

    private int x;
    private int y;
    private int cellX;
    private int cellY;

    public GameField(int x, int y) {
        this.x = x;
        this.y = y;

        fullWater = new Texture("FullWater.png");
        aim = new Texture("pointer.tga");
        shipsPart = new Texture("Cells.png");

        field = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < 20; i++) {

                field[Main.rand.nextInt(FIELD_SIZE)][Main.rand.nextInt(FIELD_SIZE)] = '*';
            }


    }

    public void render(SpriteBatch batch) {

        update();

        batch.draw(fullWater, x, y);

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[j][i] == 'X')
                    batch.draw(shipsPart, x + i * CELL_SIZE, y + j * CELL_SIZE, 30, 0, 30, 30);
                if (field[j][i] == '*')
                    batch.draw(shipsPart, x + i * CELL_SIZE, y + j * CELL_SIZE, 0, 0, 30, 30);
            }
        }

        if (cellX > -1 && cellY > -1)
            batch.draw(aim, cellX * CELL_SIZE + x, cellY * CELL_SIZE + y);




    }

    public void update() {

        if (InputMouse.getMouseX() < x || InputMouse.getMouseY() < y || InputMouse.getMouseX() > (x + FIELD_SIZE_IN_PIXELS) || InputMouse.getMouseY() > (y + FIELD_SIZE_IN_PIXELS)) {
            cellX = -1;
            cellY = -1;
        } else {
            cellX = (InputMouse.getMouseX() - x) / CELL_SIZE;
            cellY = (InputMouse.getMouseY() - y) / CELL_SIZE;
        }

        if (InputMouse.isClicked() && cellX > -1 && cellY > -1 && field[cellY][cellX] == '*')
            field[cellY][cellX] = 'X';


    }






}
