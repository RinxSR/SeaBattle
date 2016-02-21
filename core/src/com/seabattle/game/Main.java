package com.seabattle.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Player player1;
	Player player2;

	enum GameStatus {Turn1Player, Turn2Player, GameOver}

	GameStatus gameStatus;

	public static Random rand = new Random();

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameStatus = GameStatus.Turn1Player;

		player1 = new Human(new GameField(30, 40, true));
		player2 = new Ai(new GameField(370, 40, false));


	}

	@Override
	public void render () {
		update();

		Gdx.gl.glClearColor(0.4f, 0.4f, 0.4f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		player1.getField().render(batch);
		player2.getField().render(batch);

		batch.end();
	}

	public void update() {


		switch (gameStatus) {
			case Turn1Player:
				if (player1.turn(player2.getField()) == TurnStatus.Miss) gameStatus = GameStatus.Turn2Player;
				break;
			case Turn2Player:
				if (player2.turn(player1.getField()) == TurnStatus.Miss) gameStatus = GameStatus.Turn1Player;
		}

		if (gameStatus != GameStatus.GameOver && !player1.getField().isShipsOnField() || !player2.getField().isShipsOnField())
			gameStatus = GameStatus.GameOver;

	}
}
