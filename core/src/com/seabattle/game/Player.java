package com.seabattle.game;

public abstract class Player {

    public GameField getField() {
        return field;
    }

    private GameField field;

    public Player(GameField field) {
        this.field = field;
    }

    public abstract TurnStatus turn(GameField enemyField);

}
