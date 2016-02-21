package com.seabattle.game;

import java.util.Random;

public class Ai extends Player {

    private Random random = new Random();

    public Ai(GameField field) {
        super(field);
    }

    @Override
    public TurnStatus turn(GameField enemyField) {

        int x = random.nextInt(GameField.getFieldSize());
        int y = random.nextInt(GameField.getFieldSize());

        return enemyField.strike(x, y);
    }
}
