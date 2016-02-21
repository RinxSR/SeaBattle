package com.seabattle.game;

public class Human extends Player{

    public Human(GameField field) {
        super(field);
    }

    @Override
    public TurnStatus turn(GameField enemyField) {
        return enemyField.mouseHit();
    }

}
