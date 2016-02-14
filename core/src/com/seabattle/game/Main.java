package com.seabattle.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	GameField f1;
	GameField f2;

	@Override
	public void create () {
		batch = new SpriteBatch();
		f1 = new GameField(30, 40);
		f2 = new GameField(370, 40);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.4f, 0.4f, 0.4f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		f1.render(batch);
		f2.render(batch);

		batch.end();
	}
}
